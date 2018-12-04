<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>${project}</groupId>
    <artifactId>${project}</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging><#if mavenType == "web">war<#elseif mavenType=="jar">jar</#if></packaging>
    <name>${project}</name>
    <!--统一配置jar包版本-->
    <properties>
    <#if webFramework=="springMVC" || frameworkType=="ssm"||frameworkType=="ssh">
        <springmvc-version>4.3.0.RELEASE</springmvc-version>
    </#if>
    <#if ormFramework == "hibernate">
        <hibernate.version>5.2.4.Final</hibernate.version>
    </#if>
        <#if webFramework == "structs2">
            <struct2>2.5.5</struct2>
        </#if>
    </properties>
    <!--项目所需jar包-->
    <dependencies>
        <!--单元测试依赖包-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <#if mavenType=="web">
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
                <version>1.2</version>
            </dependency>
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
                <version>3.0.1</version>
                <scope>provided</scope>
            </dependency>
        </#if>
    <#if webFramework=="springMVC">
        <!--spring mvc depend jars begin -->
        <dependency>
            <groupId>aopalliance</groupId>
            <artifactId>aopalliance</artifactId>
            <version>1.0</version>
        </dependency>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-instrument</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-instrument-tomcat</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-messaging</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-oxm</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-websocket</artifactId>
            <version>${r"${springmvc-version}"}</version>
        </dependency>
        <#if mavenType=="web">
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-webmvc</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-webmvc-portlet</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
       </#if>
        <!--spring mvc depend jars end -->
    </#if>

        <!-- ssm or ssh need spring jar -->
        <#if frameworkType == "ssh" || frameworkType == "ssm">
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-orm</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context-support</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-core</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-tx</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-beans</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jdbc</artifactId>
                <version>${r"${springmvc-version}"}</version>
            </dependency>
            <dependency>
                <groupId>org.aspectj</groupId>
                <artifactId>aspectjweaver</artifactId>
                <version>1.8.9</version>
            </dependency>
        </#if>

        <#if frameworkType=="ssh" || webFramework=="structs2" || frameworkType=="ssm">
            <!-- Struts2的核心包 -->
                     <dependency>
                         <groupId>org.apache.struts</groupId>
                         <artifactId>struts2-core</artifactId>
                         <version>${r'${struct2}'}</version>
                         <#if ormFramework=="hibernate">
                         <!-- 这里的 exclusions 是排除包，因为 Struts2中有javassist，Hibernate中也有javassist,
                         所以如果要整合Hibernate，一定要排除掉Struts2中的javassist，否则就冲突了。 -->
                         <exclusions>
                             <exclusion>
                                 <groupId>javassist</groupId>
                                 <artifactId>javassist</artifactId>
                             </exclusion>
                         </exclusions>
                         </#if>
                     </dependency>
                     <!-- convention-plugin插件，使用了这个插件之后，就可以采用注解的方式配置Action -->
                     <dependency>
                         <groupId>org.apache.struts</groupId>
                         <artifactId>struts2-convention-plugin</artifactId>
                         <version>${r'${struct2}'}</version>
                     </dependency>
                     <!--config-browser-plugin插件，使用了这个插件之后，就可以很方便的浏览项目中的所有action及其与 jsp view的映射 -->
                     <dependency>
                         <groupId>org.apache.struts</groupId>
                         <artifactId>struts2-config-browser-plugin</artifactId>
                         <version>${r'${struct2}'}</version>
                     </dependency>
                     <#if frameworkType=="ssh" || frameworkType="ssm">
                     <!-- Struts2和Spring整合插件 -->
                         <dependency>
                             <groupId>org.apache.struts</groupId>
                             <artifactId>struts2-spring-plugin</artifactId>
                             <version>${r'${struct2}'}</version>
                         </dependency>
                     </#if>
        </#if>
    <#if ormFramework=="mybatis">
        <!-- 添加mybatis的核心包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.3.0</version>
        </dependency>
        <!-- 添加mybatis与Spring整合的核心包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.2</version>
        </dependency>
    </#if>
        <#if databaseType=="mysql">
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.8</version>
            </dependency>
        </#if>
      <#if databasePool=="C3P0">
          <dependency>
              <groupId>c3p0</groupId>
              <artifactId>c3p0</artifactId>
              <version>0.9.1.2</version>
          </dependency>
          <#elseif databasePool == "DBCP">
              <dependency>
              <groupId>commons-dbcp</groupId>
              <artifactId>commons-dbcp</artifactId>
              <version>1.4</version>
              </dependency>
              <dependency>
                  <groupId>commons-pool</groupId>
                  <artifactId>commons-pool</artifactId>
                  <version>1.6</version>
              </dependency>
      <#elseif databasePool == "Druid">
              <dependency>
                  <groupId>com.alibaba</groupId>
                  <artifactId>druid</artifactId>
                  <version>1.0.7</version>
              </dependency>
      </#if>
        <#if ormFramework == "hibernate">
            <!-- hibernate -->
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-core</artifactId>
                <version>${r"${hibernate.version}"}</version>
                <exclusions>
                    <exclusion>
                        <artifactId>el-api</artifactId>
                        <groupId>javax.el</groupId>
                    </exclusion>
                </exclusions>
            </dependency>
        </#if>
        <#if cache=="ehcache">
            <dependency>
                <groupId>net.sf.ehcache</groupId>
                <artifactId>ehcache-core</artifactId>
                <version>2.5.3</version>
            </dependency>
        <#elseif cache=="memcached">
            <!-- Memcached begin -->
            <dependency>
                <groupId>net.spy</groupId>
                <artifactId>spymemcached</artifactId>
                <version>2.11.4</version>
            </dependency>
        <#elseif cache=="redis">
            <dependency>
                <groupId>redis.clients</groupId>
                <artifactId>jedis</artifactId>
                <version>2.7.3</version>
                <type>jar</type>
                <scope>compile</scope>
            </dependency>
            <!-- spring-redis -->
            <dependency>
                <groupId>org.springframework.data</groupId>
                <artifactId>spring-data-redis</artifactId>
                <version>1.6.0.RELEASE</version>
            </dependency>
        </#if>
        <#if template=="velocity">
            <!-- Velocity -->
            <dependency>
                <groupId>org.apache.velocity</groupId>
                <artifactId>velocity</artifactId>
                <version>1.7</version>
                <#if webFramework=="structs2">
                <optional>true</optional>
                </#if>
            </dependency>

            <dependency>
                <groupId>org.apache.velocity</groupId>
                <artifactId>velocity-tools</artifactId>
                <version>2.0</version>
             <#if webFramework=="structs2">
                <exclusions>
                    <exclusion>
                        <groupId>javax.servlet</groupId>
                        <artifactId>servlet-api</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>struts</groupId>
                        <artifactId>struts</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>velocity</groupId>
                        <artifactId>velocity</artifactId>
                    </exclusion>
                </exclusions>
             </#if>
            </dependency>
        <#elseif template=="freemaker">
            <dependency>
                <groupId>org.freemarker</groupId>
                <artifactId>freemarker</artifactId>
                <version>2.3.23</version>
            </dependency>
        </#if>
        <#if sitemesh=="yes">
            <!---sitemesh pom-->
            <dependency>
                <groupId>org.sitemesh</groupId>
                <artifactId>sitemesh</artifactId>
                <version>3.0.0</version>
            </dependency>
        </#if>
        <#if frameworkType == "structs2Hibernate" && databasePool == "Proxool" >
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-proxool</artifactId>
                <version>5.2.3.Final</version>
            </dependency>
        <#elseif databasePool=="proxool">
            <dependency>
                <groupId>proxool</groupId>
                <artifactId>proxool</artifactId>
                <version>0.8.3</version>
            </dependency>
        </#if>
    <#if frameworkType == "structs2Hibernate" && databasePool == "C3P0" >
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-c3p0</artifactId>
            <version>5.2.3.Final</version>
        </dependency>
    </#if>
    </dependencies>
    <!--项目构建-->
    <build>
        <!--项目打包之后的名称-->
        <finalName>${project}</finalName>
        <!--构建需要的插件-->
        <plugins>
            <!--编译插件-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>
                    1.7</source>
                    <target>1.7</target>
                </configuration>
            </plugin>

            <!-- 本地tomcat7插件 -->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <path>/</path>
                    <uriEncoding>UTF-8</uriEncoding>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>