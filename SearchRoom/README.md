## 1. 项目启动

### 1. 修改application.properties中的配置

- qiniu 注意替换成自己申请的配置
  - qiniu.AccessKey=XXXXXXXXXX
  - qiniu.SecretKey=XXXXXXXXXX
  - qiniu.Bucket=XXXXXXXXXX
  - qiniu.cdn.prefix=XXXXXXXXXX
- 阿里云短信配置 注意替换自己申请的配置
  - aliyun.sms.accessKey=XXXXXXXXXX
  - aliyun.sms.accessKeySecret=XXXXXXXXXX
  - aliyun.sms.template.code=XXXXXXXXXX
- email 注意替换成自己邮箱的配置
  - spring.mail.host=144XXXXXXX.qq.com
  - spring.mail.username=144XXXXXXX.qq.com
- 发送邮件的密码
  - spring.mail.password=XXXXXXX

### 2. 修改application-dev.properties中的配置

- 这里主要是一些工具的基本信息配置
  - 修改MySQL配置
  - 修改Redis配置
  - 修改Kafka配置
  - 修改Elasticsearch配置

### 3. 修改application-test.properties中的配置

- 基本同上

### 4. 将代码中TODO标记的内容换成自己的配置

### 5. 启动Redis

- 我这里是使用Windows版本
- 版本号：3.2.10
- 启动：redis-server.exe

### 6. 启动Elasticsearch

- 同样使用Windows版本
- 版本号：5.6.1
- 启动：bin/elasticsearch.bat

### 7. 启动Elasticsearch-head-master(非必选)

- 这个主要是一个图形化监控界面


    $ npm run start

- 访问localhost:9100可以查看节点信息

### 8. 启动Kafka(非必选)

- 这里主要是管理员上架和下架房源时采用异步处理的方法，进行这个操作时需要启动kafka
- 启动zookeeper


    [thpffcj@thpffcj kafka_2.11-1.0.0]$ nohup ./bin/zookeeper-server-start.sh config/zookeeper.properties &

- 启动kafka


    [thpffcj@thpffcj kafka_2.11-1.0.0]$ nohup ./bin/kafka-server-start.sh config/server.properties &

***

## 2. 普通用户

### 寻屋首页

- 主要可以通过城市来查找自己心仪的房源

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E5%AF%BB%E5%B1%8B%E9%A6%96%E9%A1%B5.png)

### 寻屋租房

- 通过多重查询条件搜索房源，关键词查询主要使用了elasticsearch

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E5%AF%BB%E5%B1%8B%E7%A7%9F%E6%88%BF.png)

### 房源详情

- 房源详情可以查看房源的相信信息，同时可以预约看房

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E6%88%BF%E6%BA%90%E8%AF%A6%E6%83%85.png)

### 地图找房

- 地图找房主要是可以通过地图查询自己想寻找的房源

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E5%9C%B0%E5%9B%BE%E6%89%BE%E6%88%BF.png)

### 个人中心

- 个人中心可以查看自己的待看清单，预约记录，看房记录和编辑个人信息

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83.png)

***

## 3. 网站管理员

### 新增房源

- 管理员可以通过填写必要信息添加网站房源

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E6%B7%BB%E5%8A%A0%E6%88%BF%E6%BA%90.png)

### 房源管理

- 管理员可以下架，修改和删除房源

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E6%88%BF%E6%BA%90%E7%AE%A1%E7%90%86.png)

### 预约管理

- 用户预约看房后，管理员可以查看用户信息。经纪人线下带领客户看房后，管理员可以确定带看完成

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E9%A2%84%E7%BA%A6%E7%AE%A1%E7%90%86.png)