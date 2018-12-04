<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "mybatis-3-config.dtd">

<configuration>
    <!--数据库配置-->
    <properties>
        <property name="dialect" value="mysql" />
    </properties>
    <!-- - - - - - - 数据库环境配置- - - - - - - - - -->
    <environments default="environments">
        <environment id="local">
            <transactionManager type="MANAGED">
                <property name="closeConnection" value="false"/>
            </transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/foo"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>
    <!-- - - - - - - -映射文件路径- - - - - - -->
    <mappers>
        <mapper resource="mapper/BookDAOMapper.xml"/>
    </mappers>
</configuration>