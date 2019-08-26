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

## 2. 模块介绍

### 1. ad-eureka

**核心功能**

- ServiceRegistry（服务注册）
- ServiceDiscovery（服务发现）

**基本架构**

- EurekaServer，提供服务注册与发现
- ServiceProvider，服务提供方，将自身服务注册到EurekaServer上，从而让EurekaServer持有服务的元信息，让其他的服务消费方能够找到当前服务
- ServiceConsumer，服务消费方，从EurekaServer上获取注册服务列表，从而能够消费服务
- ServiceProvider/Consumer相对于Server，都叫做EurekaClient

**Eureka的基本架构如下图所示**

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/Eureka%E7%9A%84%E5%9F%BA%E6%9C%AC%E6%9E%B6%E6%9E%84.png)

**Eureka Server的高可用**

- 问题说明：单节点的Eureka Server虽然能够实现基础功能，但是存在单点故障的问题，不能实现高可用。
- 因为Eureka Server中存储了整个系统中所有的微服务的元数据信息，单节点一旦挂了，所有的服务信息都会丢失，造成整个系统的瘫痪。
- 解决办法：搭建Eureka Server集群，让各个Server节点之间互相注册，从而实现微服务元数据的复制/备份，即使单个节点失效，其他的Server节点仍可以继续提供服务

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/Eureka-Server%E9%9B%86%E7%BE%A4.png)

### 2. ad-gateway

**Zuul介绍**

- 微服务系统中往往包含很多个功能不同的子系统或微服务，那么，外部应用怎样去访问各种各样的微服务呢？
- 这也是Zuul所要解决的一个主要问题。在微服务架构中，后端服务往往不直接开放给调用端，而是通过一个服务网关根据请求的url，路由到相应的服务，即实现请求转发，效果如下图所示。

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/Zuul%E4%BB%8B%E7%BB%8D.png)

- Zuul提供了服务网关的功能，可以实现负载均衡、反向代理、动态路由、请求转发等功能。
- Zuul大部分功能都是通过过滤器实现的，Zuul中定义了四种标准的过滤器类型，同时，还支持自定义过滤器。这些过滤器的类型也对应于请求的典型生命周期，如下图所示。

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/Zuul%E8%BF%87%E6%BB%A4%E5%99%A8%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F.png)

- pre：在请求被路由之前调用
- route：在路由请求时被调用
- post：在route和error过滤器之后被调用
- error：处理请求时发生错误时被调用

### 3. ad-common

**设计思想**

- 通用的代码、配置不应该散落在各个业务模块中，不利于维护与更新
- 一个大的系统，响应对象需要统一外层格式
- 各种业务设计与实现，可能会抛出各种各样的异常，异常信息的收集也应该做到统一

**统一响应的格式**

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/%E7%BB%9F%E4%B8%80%E5%93%8D%E5%BA%94%E7%9A%84%E6%A0%BC%E5%BC%8F.png)

**统一的异常处理**

![](https://raw.githubusercontent.com/Thpffcj/SpringBoot-Project/master/advertising-system/pic/%E7%BB%9F%E4%B8%80%E7%9A%84%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86.png)

### 4. ad-sponsor

**Spring IOC原理拆解**

![]()

**Spring MVC模块解析**

![]()

**广告投放子系统数据库设计**

![]()

![]()

**数据表设计**

![]()

![]()

![]()

### 5. ad-dashboard

### 6. ad-search

























