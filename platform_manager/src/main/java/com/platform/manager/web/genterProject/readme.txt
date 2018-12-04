快速搭建基于maven的web框架
一:生成maven骨架:pom,jar,war 三种形式
二:选择web框架:springMvc,structs(支持撤销动作)
三:选择关系型orm框架:jpa,mybatis,hibernate,other(支持注解,xml配置,注解+xml配置)
四:选择使用的数据库:mysql,oracle,sqlServer(支持变更动作)
五:其他辅助框架选用:
   js:jquery框架,easyUi框架,bootstrap框架
   sitemesh框架
   freemaker框架
   缓存:memcache,ehcache,redis
   日志文件选用:log4j
六:代码生成
pom.xml:
    gav选填(默认为项目名称,快照版本)
    spring jar包整合
    structs jar包整合
    各种数据库jar包整合
    辅助框架需要的jar包整合

    maven自带插件选择:例如:tomcat-plugin,jetty,jboss
java:
    接口生成(实现)
    enums(枚举类)
    aop生成(xml配置,注解)
    spring 拦截器(生成xml片段,注解)
    spring 各种过滤器(日期,jsonConvert)
    spring 各项可能需要的配置片段(xml,注解)

功能:
检索功能,微信功能,交易功能,shiro sso 功能,购物车功能,交易功能 都以插件的形式安装到项目里

