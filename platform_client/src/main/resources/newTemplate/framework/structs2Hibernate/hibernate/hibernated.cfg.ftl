<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD //EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>
        <#if databasePool=="Proxool">
            <property name="hibernate.connection.provider_class">
                org.hibernate.proxool.internal.ProxoolConnectionProvider
            </property>
            <property name="hibernate.proxool.pool_alias">DBPool</property>
            <property name="hibernate.proxool.xml">proxool.xml</property>
        <#else>
            <!-- 数据库连接配置 -->
            <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
            <property name="connection.url">jdbc:mysql://localhost:3306/foo</property>
            <property name="connection.username">root</property>
            <property name="connection.password">root</property>
            <!-- 数据库连接池的大小 -->
            <property name="connection.pool_size">5</property>
            <!-- 每次从数据库中取出并放到JDBC的Statement中的记录条数。Fetch Size设的越大，读数据库的次数越少，速度越快，Fetch Size越小，读数据库的次数越多，速度越慢-->
            <property name="jdbc.fetch_size">50 </property>
            <!--批量插入,删除和更新时每次操作的记录数。Batch Size越大，批量操作的向数据库发送Sql的次数越少，速度就越快，同样耗用内存就越大-->
            <property name="jdbc.batch_size">23 </property>
            <!-- SQL 方言 -->
            <property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>
            <!-- Enable Hibernate's automatic session context management -->
            <property name="current_session_context_class">thread</property>
            <!-- 在控制台输出sql语句 -->
            <property name="show_sql">true</property>
            <!-- 在启动时根据配置更新数据库 -->
            <property name="hbm2ddl.auto">update</property>
            <!-- C3P0连接池设定-->
            <property name="hibernate.connection.provider_class">
                org.hibernate.c3p0.internal.C3P0ConnectionProvider
            </property>
            <property name="hibernate.c3p0.max_size">20</property>
            <property name="hibernate.c3p0.min_size">5</property>
            <property name="hibernate.c3p0.timeout">120</property>
            <property name="hibernate.c3p0.max_statements">100</property>
            <property name="hibernate.c3p0.idle_test_period">120</property>
            <property name="hibernate.c3p0.acquire_increment">2</property>
        </#if>
            <mapping class="${packageName}.po.Book"/><!-- 注册我们的实体映射类-->
    </session-factory>
</hibernate-configuration>