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

### 3. 修改application-test.properties中的配置

### 4. 将代码中TODO标记的内容换成自己的配置

### 5. 启动redis

### 6. 启动elasticsearch

### 7. 启动elasticsearch-head-master

    $ npm run start

## 2. 普通用户

- 寻屋首页

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E5%AF%BB%E5%B1%8B%E9%A6%96%E9%A1%B5.png)

- 寻屋租房

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E5%AF%BB%E5%B1%8B%E7%A7%9F%E6%88%BF.png)

- 房源详情

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E6%88%BF%E6%BA%90%E8%AF%A6%E6%83%85.png)

- 地图找房

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E5%9C%B0%E5%9B%BE%E6%89%BE%E6%88%BF.png)

- 个人中心

![](https://github.com/Thpffcj/SpringBoot-Project/blob/master/SearchRoom/readme-pic/%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83.png)

## 3. 网站管理员
