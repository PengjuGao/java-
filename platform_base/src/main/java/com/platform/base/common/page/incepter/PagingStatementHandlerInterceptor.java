package com.platform.base.common.page.incepter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.platform.base.common.page.PageBean;
import com.platform.base.common.page.dialect.DBDialect;
import com.platform.base.common.page.dialect.MyBatisSql;
import com.platform.base.common.page.dialect.MySql5Dialect;
import com.platform.base.common.page.dialect.OracleDialect;



/**
 * 数据库分页拦截实现
 * @version 1.0
 * @since 1.0
 * */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PagingStatementHandlerInterceptor implements Interceptor{
	/** 日志记录对象 */
	protected final Logger log = Logger.getLogger(getClass());
	/** mapper.xml中需要拦截的ID(正则匹配) **/
	private final static String PAGESQL_ID = "pageSqlId";
	private String pageSqlId;
	
	@SuppressWarnings({"unchecked" })
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler routingStatementHandler = (RoutingStatementHandler) invocation.getTarget();
		BaseStatementHandler delegate = (BaseStatementHandler) ReflectionUtils.getFieldValue(routingStatementHandler, "delegate" , null);
		MappedStatement mappedStatement = (MappedStatement) ReflectionUtils.getFieldValue(delegate, "mappedStatement",BaseStatementHandler.class);
		if (mappedStatement.getId().matches(pageSqlId)) {
			StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
			MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, mappedStatement.getConfiguration().getObjectFactory(), mappedStatement.getConfiguration().getObjectWrapperFactory());
			Configuration configuration = (Configuration)metaStatementHandler.getValue("delegate.configuration");
			BoundSql boundSql = delegate.getBoundSql();
			
			Object parameterObject = boundSql.getParameterObject();
			if(parameterObject == null){
				log.error("参数对象尚未实例化！");
				throw new NullPointerException("参数对象尚未实例化！");
			}
			Map<String, Object> parameterMap = (Map<String, Object>) parameterObject;
			PageBean pageBean = (PageBean) parameterMap.get("pageBean");
			if(pageBean == null){
				log.error("分页对象不存在！");
				throw new NullPointerException("分页对象不存在！");
			}
			String querySql = boundSql.getSql();
			
			// 取得连接 
			Connection connection = (Connection) invocation.getArgs()[0];
			DBDialect.Type databaseType  = null;
			try{
				databaseType = DBDialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
			} catch(Exception e){
				connection.close();
				e.printStackTrace();
			}
			if(databaseType == null){
				connection.close();
				throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : " + configuration.getVariables().getProperty("dialect"));
			}
			DBDialect dialect = null;
			switch(databaseType){
				case MYSQL:
					dialect = new MySql5Dialect();break;
				case ORACLE:
					dialect = new OracleDialect();break;
			}
			String countSql = dialect.getCountString(querySql);
			log.debug("查询总记录SQL:" + countSql);
			BoundSql newBoundSql = new BoundSql(mappedStatement
					.getConfiguration(), countSql, boundSql
					.getParameterMappings(), parameterObject);
			//新生成的BoundSql 会把之前绑定过的key,value清空,现在需要加上,利用反射机制获取additionalParameters
			Map<String,Object> map = (Map<String,Object>)ReflectionUtils.getFieldValue(boundSql,"additionalParameters",BoundSql.class);
			
			for (String key : map.keySet()) {
				newBoundSql.setAdditionalParameter(key, map.get(key));
			}
			
			DefaultParameterHandler parameterHandler = new DefaultParameterHandler(
					mappedStatement, parameterObject, newBoundSql);
			PreparedStatement ps = null;
			ResultSet rs = null;
			int count = 0;
			try{
				ps = connection.prepareStatement(countSql);
				parameterHandler.setParameters(ps);
				rs = ps.executeQuery();
				count = (rs.next()) ? rs.getInt("count") : 0;
				
			}catch(SQLException e){
				throw new Exception("执行记录总数SQL时发生异常",e);
			}finally{
				try {
					if(rs != null){
						rs.close();
					}
					if (ps != null){
						ps.close();
					}
					/*if(connection != null){
						connection.close();
					}error:Could not roll back JDBC transaction*/
				} catch (SQLException e) {
					throw new Exception("关闭状态时发生异常", e);
				}
			}
			// 把记录总数放入对象pageBean中
			pageBean.setTotalItems(count);
			String originalSql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");
			metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, pageBean.getOffset(), pageBean.getPageSize()) );
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET );
			metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT );
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		pageSqlId = properties.getProperty(PAGESQL_ID);
		if (pageSqlId == null || pageSqlId.length() < 1) {
			log.error("pageSqlId property is not found!");
		}
	}
	
	/**
	 * 
	 * @param id xml 中sql的id ，如 <select id="XXX">中的"XXX"
	 * @param parameterObject 传给这条sql的参数
	 * @return
	 */
	public MyBatisSql getIbatisSql(BoundSql boundSql,MappedStatement ms) {
		MyBatisSql myBatisSql = new MyBatisSql();
		String querySql = boundSql.getSql().replace("\r"," ").replace("\n"," ").replace("\t"," ").replaceAll(" {2,}"," "); 
		myBatisSql.setSql(querySql);
		Object parameterObject = boundSql.getParameterObject();
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
	    if (parameterMappings != null) {
			Object[] parameterArray = new Object[parameterMappings.size()];
	        MetaObject metaObject = parameterObject == null ? null : MetaObject.forObject(parameterObject,ms.getConfiguration().getObjectFactory(),ms.getConfiguration().getObjectWrapperFactory());
	        for (int i = 0; i < parameterMappings.size(); i++) {
	        	ParameterMapping parameterMapping = parameterMappings.get(i);
	        	if (parameterMapping.getMode() != ParameterMode.OUT) {
	        		
	        		Object value;
	        		String propertyName = parameterMapping.getProperty();
	        		PropertyTokenizer prop = new PropertyTokenizer(propertyName);
	        		if (parameterObject == null) {
	        			value = null;
	        		} else if (ms.getConfiguration().getTypeHandlerRegistry().hasTypeHandler(parameterObject.getClass())) {
	        			value = parameterObject;
	        		} else if (boundSql.hasAdditionalParameter(propertyName)) {
	        			value = boundSql.getAdditionalParameter(propertyName);
	        		} else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)&& boundSql.hasAdditionalParameter(prop.getName())) {
	        			value = boundSql.getAdditionalParameter(prop.getName());
	        			if (value != null) {
	        				value = MetaObject.forObject(value,ms.getConfiguration().getObjectFactory(),ms.getConfiguration().getObjectWrapperFactory()).getValue(propertyName.substring(prop.getName().length()));
	        			}
	        		} else {
	        			value = metaObject == null ? null : metaObject.getValue(propertyName);
	        		}
	        		parameterArray[i] = value;
	        	}
	        }
	        myBatisSql.setParameters(parameterArray);
	    }
		return myBatisSql;
	}


}
