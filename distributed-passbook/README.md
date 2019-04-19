## 1. 基础知识

### 1. 目标

- 服务端应用的开发步骤
- 服务端应用的开发技术
- 测试用例
- 完整的应用上线

### 2. 技术分析

**应用技术分层**

- 框架层
- 存储层
- 消息队列

### 3. 基础工具介绍

**Maven**

- POM代表工程对象模型，它是使用Maven工作时的基本组建，是一个xml文件。它被放在工程根目录下，文件命名为pom.xml
- POM包含了关于工程和各种配置细节的信息，Maven使用这些信息构建工程

**PostMan**

- 允许用户发送任何类型的HTTP请求，例如GET，POST，HEAD，PUT，DELETE等，并且可以允许任意的参数和Headers
- 支持不同的认证机制，包括Basic Auth，Digest Auth，OAuth 1.0，OAuth 2.0等
- 响应数据是自动按照语法格式高亮的，包括HTML，JSON和XML

**TextLab**

- 代码/文本验证，格式化工具

### 4. MySQL

- 基于行列存储的数据库
- 关系型数据库系统

**MySQL特点**

- 索引
- 事务隔离级别
  - 未提交读
  - 提交读
  - 可重复读
  - 串行读
  
**docker安装的MySQL编码有一些问题**

    mysql> SHOW VARIABLES LIKE 'character_set_%';
    +--------------------------+----------------------------+
    | Variable_name            | Value                      |
    +--------------------------+----------------------------+
    | character_set_client     | latin1                     |
    | character_set_connection | latin1                     |
    | character_set_database   | utf8                       |
    | character_set_filesystem | binary                     |
    | character_set_results    | latin1                     |
    | character_set_server     | utf8mb4                    |
    | character_set_system     | utf8                       |
    | character_sets_dir       | /usr/share/mysql/charsets/ |
    +--------------------------+----------------------------+
    8 rows in set (0.00 sec)
    
    mysql> SET NAMES 'utf8';
    Query OK, 0 rows affected (0.00 sec)
    
    mysql> SHOW VARIABLES LIKE 'character_set_%';
    +--------------------------+----------------------------+
    | Variable_name            | Value                      |
    +--------------------------+----------------------------+
    | character_set_client     | utf8                       |
    | character_set_connection | utf8                       |
    | character_set_database   | utf8                       |
    | character_set_filesystem | binary                     |
    | character_set_results    | utf8                       |
    | character_set_server     | utf8mb4                    |
    | character_set_system     | utf8                       |
    | character_sets_dir       | /usr/share/mysql/charsets/ |
    +--------------------------+----------------------------+
    8 rows in set (0.00 sec)
    
    mysql> SHOW VARIABLES LIKE 'collation_%';
    +----------------------+--------------------+
    | Variable_name        | Value              |
    +----------------------+--------------------+
    | collation_connection | utf8_general_ci    |
    | collation_database   | utf8_general_ci    |
    | collation_server     | utf8mb4_unicode_ci |
    +----------------------+--------------------+
    3 rows in set (0.00 sec)

### 5. Redis

- K - V 缓存系统
- 支持多种数据类型

**Redis特点**

- 原子概念
  - 原子性
  - 原子操作
- 过期机制

### 6. HBase

- HBase的列族式存储

**HBase Table的组成**

- Table = RowKey + Family + Column + Timestamp + Value

**数据存储模式**

- (Table, RowKey, Family, Column, Timestamp) -> Value

### 7. Kafka

**消息系统**

- 点对点消息系统
- 发布订阅消息系统

**Kafka特点**

- 可靠性
- 可扩展性
- 高性能

### 8. SpringBoot

<br>

## 2. 需求分析

### 1. 卡包应用概览

- 卡券收集，聚合类应用

**包含哪些子系统**

- 商户投放子系统：商户开放平台
- 用户使用子系统：用户使用入口

**优惠券使用方法**

- 展示型
- 兑换型
- token核销型

**卡包应用的扩展**

- 纪念性卡券
- 身份证件信息
- 银行卡
- 荣誉勋章

<br>

## 3. 技术架构

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/distributed-passbook/pic/%E5%BA%94%E7%94%A8%E6%9E%B6%E6%9E%84%E8%AE%BE%E8%AE%A1.png?raw=true)

### 1. 缓存层设计

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/distributed-passbook/pic/%E7%BC%93%E5%AD%98%E5%B1%82%E8%AE%BE%E8%AE%A1.png?raw=true)

### 2. 常用工具介绍

- Apache DigestUtils
- Apcahe RandomStringUtils
- Apache DaeteUtils
- Google Guava Enums
- starter-hbase

### 3. 日志处理设计

- 记录日志
- 分析日志
  - action
  - userId
  - timestamp
  - remoteIp
  - info

### 4. 异常处理设计

**统一的异常处理**

- @ControllerAdvice
- @ExceptionHandler
- Restful Api

### 5. 表结构设计

**商户投放子系统**

- 商户信息
- 优惠券信息
- 优惠券Token信息

**用户应用子系统**

- Pass
- Feedback

**id生成器**

- user表















































