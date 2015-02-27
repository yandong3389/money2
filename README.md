# money
奖金管理


# 项目地址
https://github.com/yandong3389/money.git


# 关于框架
Spring-webmvc-3.1.0、Spring-3.1.0、MyBatis-3.2.2

# 代码生成工具
mybatis-generator-core
  配置文件：/project/src/main/resources/generatorConfig.xml
      
mybatis生成代码(需要有pom.xml文件,注意.bak重命名)：
org.mybatis.generator:mybatis-generator-maven-plugin:1.3.2:generate

# 日志
logback框架 
 配置文件：/project/src/main/resources/logback.xml


# generate_version工程
1、压缩js、css文件
2、为jsp中引用的js、css文件追加版本号(svn)


# 另：
所有java文件放在/project/src/main/java目录下
所有配置文件放在/project/src/main/resources目录下

数据库连接配置：/project/src/main/resources/mybatis/jdbc.properties


# 删除目录下所有的.svn文件bat脚本
<p>
@echo On
@Rem 删除.svn版本控制目录
@PROMPT [Com]#

@for /r . %%a in (.) do @if exist "%%a\.svn" rd /s /q "%%a\.svn"
@Rem for /r . %%a in (.) do @if exist "%%a\.svn" @echo "%%a\.svn"

@echo Mission Completed.
@pause
</p>