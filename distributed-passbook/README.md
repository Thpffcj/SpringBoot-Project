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

    Thpffcj:~ thpffcj$ docker exec -it mysql1 /bin/bash
    
    bash-4.2# mysql -uroot -p000000

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

<br>

## 4. 项目启动

### 1. 创建HBase表

- 启动HDFS

```
Thpffcj:sbin thpffcj$ ./start-all.sh 
```

- 启动HBase

```
Thpffcj:bin thpffcj$ ./start-hbase.sh 
localhost: starting zookeeper, logging to /Users/thpffcj/Public/software/hbase-1.2.0-cdh5.7.0/bin/../logs/hbase-thpffcj-zookeeper-Thpffcj.local.out
starting master, logging to /Users/thpffcj/Public/software/hbase-1.2.0-cdh5.7.0//logs/hbase-thpffcj-master-Thpffcj.local.out
starting regionserver, logging to /Users/thpffcj/Public/software/hbase-1.2.0-cdh5.7.0//logs/hbase-thpffcj-1-regionserver-Thpffcj.local.out

Thpffcj:bin thpffcj$ jps
12923 HMaster

Thpffcj:bin thpffcj$ ./hbase shell
```

- 在passbook/src/main/resources下有passbook.hsh
- 创建命名空间

```   
hbase(main):002:0> create_namespace 'pb'
0 row(s) in 0.0960 seconds
```

- 依次创建四张表

```
hbase(main):003:0> create 'pb:user', {NAME => 'b', VERSIONS => '3', TTL => '2147483647', 'BLOOMFILTER' => 'ROW'}, {NAME => 'o', VERSIONS => '3', TTL => '2147483647', 'BLOOMFILTER' => 'ROW'}
0 row(s) in 1.3400 seconds

=> Hbase::Table - pb:user
hbase(main):004:0> create 'pb:pass', {NAME => 'i', VERSIONS => '3', TTL => '2147483647', 'BLOOMFILTER' => 'ROW'}
0 row(s) in 1.2410 seconds

=> Hbase::Table - pb:pass
hbase(main):005:0> create 'pb:passtemplate', {NAME => 'b', VERSIONS => '3', TTL => '2147483647', 'BLOOMFILTER' => 'ROW'}, {NAME => 'c', VERSIONS => '3', TTL => '2147483647', 'BLOOMFILTER' => 'ROW'}
0 row(s) in 1.2530 seconds

=> Hbase::Table - pb:passtemplate
hbase(main):006:0> create 'pb:feedback', {NAME => 'i', VERSIONS => '3', TTL => '2147483647', 'BLOOMFILTER' => 'ROW'}
0 row(s) in 1.2470 seconds

=> Hbase::Table - pb:feedback

hbase(main):007:0> list_namespace_tables 'pb'
TABLE                                                                           
feedback                                                                        
pass                                                                            
passtemplate                                                                    
user                                                                            
4 row(s) in 0.0240 seconds
```

### 2. 创建MySQL表

- 执行merchants/src/main/resources下的merchants.sql

### 3. 启动Zookeeper

    Thpffcj:bin thpffcj$ ./zkServer.sh start
    JMX enabled by default
    Using config: /Users/thpffcj/Public/software/zookeeper-3.4.5-cdh5.7.0/bin/../conf/zoo.cfg
    Starting zookeeper ... STARTED

### 3. 启动Kafka

    Thpffcj:bin thpffcj$ kafka-server-start.sh $KAFKA_HOME/config/server.properties

- 启动kafka消费者

```
Thpffcj:bin thpffcj$ ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic merchants-template --from-beginning
```

### 4. 启动Redis

    Thpffcj:redis-5.0.3 thpffcj$ redis-server

## 5. 测试

**需要启动的服务**

- hbase
- mysql
- kafka
- redis

**需要清空的数据**

- hbase 的四张表
    
```  
hbase(main):007:0> truncate 'pb:user'
Truncating 'pb:user' table (it may take a while):
 - Disabling table...
 - Truncating table...
0 row(s) in 3.3910 seconds
```

- mysql 商户数据
- /tmp/token/ 下面的优惠券 token 数据
- redis 中的数据

**使用Postman发送数据**

- 创建商户 - 商户 id 10


```
POST: 127.0.0.1:9527/merchants/create
header: token/passbook-merchants
{
    "name": "我的博客",
    "logoUrl": "www.thpffcj.com",
    "businessLicenseUrl": "www.thpffcj.com",
    "phone": "1234567890",
    "address": "南京市鼓楼区"
}
```

- 查看商户信息

```
GET: 127.0.0.1:9527/merchants/10
header: token/passbook-merchants
```

- 投放优惠券

```
POST: 127.0.0.1:9527/merchants/drop
header: token/passbook-merchants
{
    "background": 1,
    "desc": "淘宝优惠券",
    "end": "2019-06-30",
    "hasToken": false,
    "id": 10,
    "limit": 1000,
    "start": "2018-05-01",
    "summary": "优惠券简介",
    "title": "淘宝优惠券-1"
}
{
    "background": 1,
    "desc": "淘宝优惠券",
    "end": "2019-06-30",
    "hasToken": true,
    "id": 10,
    "limit": 1000,
    "start": "2019-05-01",
    "summary": "优惠券简介",
    "title": "淘宝优惠券-2"
}
```

- 上传优惠券 token
    
```    
GET: 127.0.0.1:9528/upload
merchantsId - 10
PassTemplateId: 0b2d034848f1525132154ddabf9a1a6b
```

- 创建用户 -- 用户 181794
    
```    
POST: 127.0.0.1:9528/passbook/createuser
{
    "baseInfo": {
        "name": "thpffcj",
        "age": 22,
        "sex": "m"
    },
    "otherInfo": {
        "phone": "1234567890",
        "address": "南京市鼓楼区"
    }
}
```

- 库存信息
    
```    
GET: 127.0.0.1:9528/passbook/inventoryinfo?userId=181794
```

- 获取优惠券 -- 获取的是带有 token 的优惠券
    
```    
POST: 127.0.0.1:9528/passbook/gainpasstemplate
{
    "userId": 181794,
    "passTemplate": {
        "id": 10,
        "title": "淘宝优惠券-2",
        "hasToken": true
    }
}
```

- userpassinfo
    
```    
GET: 127.0.0.1:9528/passbook/userpassinfo?userId=181794
```

- userusedpassinfo
    
```    
GET: 127.0.0.1:9528/passbook/userusedpassinfo?userId=181794
```

- userusepass
    
```    
POST: 127.0.0.1:9528/passbook/userusepass
{
    "userId": 181794,
    "templateId": "0b2d034848f1525132154ddabf9a1a6b"
}
```

- 创建评论信息
    
```    
POST: 127.0.0.1:9528/passbook/createfeedback
{
    "userId": 181794,
    "type": "app",
    "templateId": -1,
    "comment": "学习分布式卡包应用"
}
{
    "userId": 181794,
    "type": "pass",
    "templateId": "0b2d034848f1525132154ddabf9a1a6b",
    "comment": "学习分布式卡包应用"
}
```

- 查看评论信息
    
```    
GET: 127.0.0.1:9528/passbook/getfeedback?userId=181794
```

