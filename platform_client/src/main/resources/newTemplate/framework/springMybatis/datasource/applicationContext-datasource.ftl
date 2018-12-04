<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	 xmlns:aop="http://www.springframework.org/schema/aop"
	 xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop.xsd
		http://www.springframework.org/schema/tx  
        http://www.springframework.org/schema/tx/spring-tx.xsd">
	<#if databasePool=="C3P0">
        <bean id="dataSource"
              class="com.mchange.v2.c3p0.ComboPooledDataSource"
              destroy-method="close">
            <property name="driverClass">
                <value>com.mysql.jdbc.Driver</value>
            </property>
            <property name="jdbcUrl">
                <value>jdbc:mysql://localhost:3306/foo?useUnicode=true&amp;characterEncoding=utf8</value>
            </property>
            <!--MySQL数据库的用户名 -->
            <property name="user">
                <value>root</value>
            </property>
            <!--MySQL数据库 密码 -->
            <property name="password">
                <value>root</value>
            </property>
            <!--连接池中保留的最小连接数。-->
            <property name="minPoolSize">
                <value>5</value>
            </property>
            <!--连接池中保留的最大连接数。Default: 15 -->
            <property name="maxPoolSize">
                <value>200</value>
            </property>
            <!--初始化时获取的连接数，取值应在minPoolSize与maxPoolSize之间。Default: 3 -->
            <property name="initialPoolSize">
                <value>10</value>
            </property>
            <!--最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0 -->
            <property name="maxIdleTime">
                <value>60</value>
            </property>
            <!--当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3 -->
            <property name="acquireIncrement">
                <value>5</value>
            </property>
            <!--JDBC的标准参数，用以控制数据源内加载的PreparedStatements数量。但由于预缓存的
            statements属于单个connection而不是整个连接池。所以设置这个参数需要考虑到多方面
            的因素。如果maxStatements与maxStatementsPerConnection均为0，则缓存被关闭。Default: 0-->
            <property name="maxStatements">
                <value>0</value>
            </property>
            <!--每60秒检查所有连接池中的空闲连接。Default: 0 -->
            <property name="idleConnectionTestPeriod">
                <value>60</value>
            </property>
            <!--定义在从数据库获取新连接失败后重复尝试的次数。Default: 30 -->
            <property name="acquireRetryAttempts">
                <value>30</value>
            </property>
            <!--获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常。但是数据源仍有效
            保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试
            获取连接失败后该数据源将申明已断开并永久关闭。Default: false-->
            <property name="breakAfterAcquireFailure">
                <value>true</value>
            </property>
            <!--因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的
                    时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable
                    等方法来提升连接测试的性能。Default: false -->
            <property name="testConnectionOnCheckout">
                <value>false</value>
            </property>
        </bean>
	<#elseif databasePool=="DBCP">
        <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
            <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://localhost:3306/foo?useUnicode=true&amp;characterEncoding=utf8"/>
            <property name="username" value="root"/>
            <property name="password" value="root"/>
            <!--maxActive: 最大连接数量-->
            <property name="maxActive" value="150"/>
            <!--minIdle: 最小空闲连接-->
            <property name="minIdle" value="5"/>
            <!--maxIdle: 最大空闲连接-->
            <property name="maxIdle" value="20"/>
            <!--initialSize: 初始化连接-->
            <property name="initialSize" value="30"/>
            <!-- 连接被泄露时是否打印 -->
            <property name="logAbandoned" value="true"/>
            <!--removeAbandoned: 是否自动回收超时连接-->
            <property name="removeAbandoned"  value="true"/>
            <!--removeAbandonedTimeout: 超时时间(以秒数为单位)-->
            <property name="removeAbandonedTimeout" value="10"/>
            <!--maxWait: 超时等待时间以毫秒为单位 1000等于60秒-->
            <property name="maxWait" value="1000"/>
            <!-- 在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位. -->
            <property name="timeBetweenEvictionRunsMillis" value="10000"/>
            <!--  在每次空闲连接回收器线程(如果有)运行时检查的连接数量 -->
            <property name="numTestsPerEvictionRun" value="10"/>
            <!-- 1000 * 60 * 30  连接在池中保持空闲而不被空闲连接回收器线程-->
            <property name="minEvictableIdleTimeMillis" value="10000"/>
            <property name="validationQuery" value="SELECT NOW() FROM DUAL"/>
        </bean>
	<#elseif databasePool=="Proxool">
        <bean id="proxoolDataSource" class="org.logicalcobwebs.proxool.ProxoolDataSource">
            <property name="alias">
                <value>tenement</value>
            </property>
            <property name="driver">
                <value>com.mysql.jdbc.Driver</value>
            </property>
            <property name="driverUrl">
                <value>jdbc:mysql://localhost:3306/foo?useUnicode=true&amp;characterEncoding=utf8</value>
            </property>
            <property name="user">
                <value>root</value>
            </property>
            <property name="password">
                <value>root</value>
            </property>
            <!-- 最大连接数（默认5个）,超过了这个连接数,再有请求时,就排在队列中等候 -->
            <property name="maximumConnectionCount">
                <value>20</value>
            </property>
            <!-- 最小连接数（默认2个） -->
            <property name="minimumConnectionCount">
                <value>3</value>
            </property>
            <!-- 最少保持的空闲连接数（默认2个） -->
            <property name="prototypeCount">
                <value>3</value>
            </property>
            <!-- 是否记录数据库的每一步操作 -->
            <property name="trace">
                <value>true</value>
            </property>
            <!-- 是否同时记录多个STUFF，会产生多个日志 -->
            <property name="verbose">
                <value>true</value>
            </property>
            <!-- proxool自动侦察各个连接状态的时间间隔（毫秒）,侦察到空闲的连接就马上回收,超时的销毁 默认30秒 -->
            <property name="houseKeepingSleepTime">
                <value>90000</value>
            </property>
            <!-- 保持数据库连接所使用的SQL语句 -->
            <property name="houseKeepingTestSql">
                <value>SELECT CURRENT_DATE</value>
            </property>
        </bean>
	<#elseif databasePool=="Bonecp">
        <bean id="datasource" class="com.jolbox.bonecp.BoneCPDataSource" destroy-method="close">
            <property name="driverClass" value="com.mysql.jdbc.Driver" />
            <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/foo?useUnicode=true&amp;characterEncoding=utf8" />
            <property name="username"    value="TEST"/>
            <property name="password"    value="TEST"/>
            <property name="idleConnectionTestPeriod"    value="60"/>
            <property name="idleMaxAge" value="240"/>
            <property name="maxConnectionsPerPartition" value="30"/>
            <property name="minConnectionsPerPartition" value="10"/>
            <property name="partitionCount"       value="3"/>
            <property name="acquireIncrement" value="5"/>
            <property name="statementsCacheSize" value="100"/>
            <property name="releaseHelperThreads" value="3"/>
        </bean>
    <#elseif databasePool=="Druid">
        <!-- 阿里 druid 数据库连接池 -->
        <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
              init-method="init" destroy-method="close">
            <property name="driverClassName" value="com.mysql.jdbc.Driver" />
            <property name="url" value="jdbc:mysql://localhost:3306/foo?useUnicode=true&amp;characterEncoding=utf8" />
            <property name="username" value="root" />
            <property name="password" value="root" />
            <!-- 配置初始化大小、最小、最大 -->
            <property name="initialSize" value="1" />
            <property name="minIdle" value="1" />
            <property name="maxActive" value="10" />

            <!-- 配置获取连接等待超时的时间 -->
            <property name="maxWait" value="10000" />

            <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
            <property name="timeBetweenEvictionRunsMillis" value="60000" />

            <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
            <property name="minEvictableIdleTimeMillis" value="300000" />

            <property name="testWhileIdle" value="true" />

            <!-- 这里建议配置为TRUE，防止取到的连接不可用 -->
            <property name="testOnBorrow" value="true" />
            <property name="testOnReturn" value="false" />

            <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
            <property name="poolPreparedStatements" value="true" />
            <property name="maxPoolPreparedStatementPerConnectionSize"
                      value="20" />

            <!-- 这里配置提交方式，默认就是TRUE，可以不用配置 -->

            <property name="defaultAutoCommit" value="true" />

            <!-- 验证连接有效与否的SQL，不同的数据配置不同 -->
            <property name="validationQuery" value="select 1 " />
            <property name="filters" value="stat" />
        </bean>
    </#if>
        <#if ormFramework=="hibernate">
            <bean id="txManager"
                  class="org.springframework.orm.hibernate5.HibernateTransactionManager">
                <property name="sessionFactory" ref="sessionFactory" />
            </bean>
        <#else>
	<!-- spring管理事务 -->
	<bean id="txManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>
        </#if>
	<!-- Spring的声明式事务管理 -->
	<!-- 设置与事务有关的各种属性 -->
	<tx:advice id="txAdvice" transaction-manager="txManager">
		<tx:attributes>
			<tx:method name="insert*" propagation="REQUIRED"
				rollback-for="Exception" />
			<tx:method name="add*" propagation="REQUIRED" rollback-for="Exception" />
			<tx:method name="update*" propagation="REQUIRED"
				rollback-for="Exception" />
			<tx:method name="del*" propagation="REQUIRED" rollback-for="Exception" />
			<tx:method name="*" read-only="false" />
		</tx:attributes>
	</tx:advice>

	<!-- 声明切入点 -->
	<aop:config>
		<aop:pointcut id="txPointCuts"
			expression="execution(* ${packageName}.dao.*.*(..))" />
		<aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCuts" />
	</aop:config>
</beans>