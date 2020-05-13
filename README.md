# springcloud-fresh

1. springcloud-fres-pom工程： 这个工程是一个pom工程，也就是pom.xml的父类工程，
	我把这个项目所需要的这些依赖包全部配置在这个父类pom.xml中
2. springcloud-fresh-config工程：这个工程主要用来放配置文件，并且交个Git服务器管理
3. springcloud-fresh-config-server工程：主要用来从Git服务器中读取配置文件
4. springcloud-fresh-eureka-server工程：Eureka服务器配置
5. springcloud-fresh-user工程：提供天天生鲜用户登录登录、注册的服务
6. springcloud-fresh-goods工程；提供商品信息浏览、加入购物车
7. springcloud-fresh-order工程：提供下单、支付
8. springcloud-fresh-manager工程：提供后台数据管理
9. springcloud-fresh-zuul工程；配置路由
