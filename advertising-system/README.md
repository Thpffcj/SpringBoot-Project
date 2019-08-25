## 1. 广告系统概览

### 1. 广告系统概览

**广告系统实现了什么样的功能**

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/%E5%B9%BF%E5%91%8A%E7%B3%BB%E7%BB%9F%E6%A6%82%E8%A7%88.png)

**一个完整的广告系统包含哪些子系统**

- 广告投放系统：既然是广告系统，一定得有广告数据，数据当然是由广告主或代理商投放，那么，也就需要有个投放广告的平台，这就是广告投放系统
- 广告检索系统：媒体方对广告系统发起请求，广告系统能够检索符合要求的广告数据，这就是广告检索系统的核心功能
- 曝光检测系统：监测广告数据的曝光记录
- 扣费系统：广告的每一次曝光都是需要扣费的，且这个系统里面负责了将广告数据置位的功能
- 报表系统：构建广告数据报表，比如广告A在地域B中一共曝光了多少次，主要是OLAP的过程
- ...

**广告投放与检索系统使用了哪些技术**

- SpringCloud
- MySQL
- Kafka
- ...

**可以怎样扩展当前实现的广告系统**

- 更多维度
- 用户画像
- AI
- ...

### 2. 广告系统架构

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/%E5%B9%BF%E5%91%8A%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84.png)

### 3. 系统目录结构

- advertising system
  - ad-eureka：实现服务注册于服务发现
  - ad-gateway：利用Zuul组件实现路由转发与请求信息记录(自定义过滤器)
  - ad-service：广告系统服务实现子模块
    - ad-common：通用代码，通用配置
    - ad-dashboard：Hystrix监控
    - ad-search：广告检索子系统
    - ad-sponsor：广告投放子系统

<br>
***

## 2. 模块介绍

### 1. ad-eureka

### 2. ad-gateway

### 3. ad-common

### 4. ad-dashboard

### 5. ad-search

### 6. ad-sponsor























