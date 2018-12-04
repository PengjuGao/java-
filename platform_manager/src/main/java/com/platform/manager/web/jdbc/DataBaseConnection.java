package com.platform.manager.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseConnection {
	
	private String databasename = "platform";

	private Connection connec;

	private String driverName = "com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/platform?useUnicode=true&characterEncoding=utf-8";

	private Statement state;

	private ResultSet rs;
	
	private String userName = "root";
	
	private String password = "root";
	
	private String sql = "select TABLE_NAME, GROUP_CONCAT(column_name) from information_schema.columns t  where t.TABLE_SCHEMA = '"+this.getDatabasename()+"' GROUP BY TABLE_NAME ";

	public Connection getConnec() {
		return connec;
	}

	public void setConnec(Connection connec) {
		this.connec = connec;
	}

	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDatabasename() {
		return databasename;
	}

	public void setDatabasename(String databasename) {
		this.databasename = databasename;
	}

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	/**
	 * 测试连接，并赋值conncetion
	 * @return
	 */
	public boolean testConnection(){
		
		try{   
			//加载MySql的驱动类   
			Class.forName("com.mysql.jdbc.Driver") ;   
		}catch(ClassNotFoundException e){   
			System.out.println("找不到驱动程序类 ，加载驱动失败！");   
			e.printStackTrace() ;   
			return false;
		}  

		try{   
			this.connec =    
					DriverManager.getConnection(url , userName , password ) ;   
		}catch(SQLException se){   
			System.out.println("数据库连接失败！");   
			se.printStackTrace() ;   
			return false;
		}   


		return true;
	}


	/**
	 * 执行sql
	 * @param sql
	 * @throws SQLException
	 */
	public void excute(String sql) throws SQLException{

		if(connec == null){
			testConnection();
		}

		state =  this.connec.createStatement();

		boolean flag = state.execute(sql);

		if(flag){

			rs = state.getResultSet();


		}

		this.close();
	}


	/**
	 * 查询
	 * @param sql
	 * @throws SQLException
	 */
	public List<TableAndColumns> excuteQuery(String sql) throws SQLException{
		
		if(sql == null){
			sql = this.sql;
		}
		
		List<TableAndColumns> tcList = new ArrayList<TableAndColumns>();

		if(connec == null){
			testConnection();
		}

	    state =  this.connec.createStatement();

		rs = state.executeQuery(sql);
		
		ResultSetMetaData  m = rs.getMetaData();
		   
		   int columns=m.getColumnCount();
		   //显示列,表格的表头
		   for(int i=1;i<=columns;i++)
		   {
		    System.out.print(m.getColumnName(i));
		    System.out.print("\t\t");
		   }
		   
		   System.out.println();
		   //显示表格内容
		   while(rs.next())
		   {
			TableAndColumns tableAcolumn = new TableAndColumns();
		   
			for(int i=1;i<=columns;i++)
		    {
		     if(i==1){
		    	 tableAcolumn.setTableName(rs.getString(i));
		     }else if(i==2){
		    	String[] columnstr = rs.getString(i).split(",");
		    	List<String> list = Arrays.asList(columnstr);
		    	tableAcolumn.setColumns(list);
		     }
		     
		    }
			tcList.add(tableAcolumn);
		    System.out.println();
		   }

		this.close();
		
		return tcList;
	}

	@SuppressWarnings("unused")
	public void excuteUpdate(final String sql) throws SQLException{

		if(connec == null){
			testConnection();
		}

		state =  this.connec.createStatement();

		int num = state.executeUpdate(sql);

		this.close();
	}

	private void close(){

		if(rs != null){   // 关闭记录集   
			try{   
				rs.close() ;   
			}catch(SQLException e){   
				e.printStackTrace() ;   
			}   
		}   
		if(state != null){   // 关闭声明   
			try{   
				state.close() ;   
			}catch(SQLException e){   
				e.printStackTrace() ;   
			}   
		}   
		if(connec != null){  // 关闭连接对象   
			try{   
				connec.close() ;   
			}catch(SQLException e){   
				e.printStackTrace() ;   
			}   
		}  
	}

	
	public static void main(String[] args) {
		
		DataBaseConnection con = new DataBaseConnection();
		
		con.setDriverName("com.mysql.jdbc.Driver");
		
		con.setPassword("");
		
		con.setUserName("root");
		
		con.setUrl("jdbc:mysql://localhost:3306/platform?useUnicode=true&characterEncoding=utf-8");
		
		con.setDatabasename("platform");
		
		boolean flag = con.testConnection();
		
		System.out.println(flag);
		
		String sql = "select TABLE_NAME, GROUP_CONCAT(column_name) from information_schema.columns t  where t.TABLE_SCHEMA = '"+con.getDatabasename()+"' GROUP BY TABLE_NAME ";
		
		try {
			con.excuteQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
