acgfan
======================

项目介绍
======================

一个动漫主题的视频网站,支持视频播放、评论、弹幕、收藏等操作;
并提供画板、商城、游戏等其他附属板块

使用技术
======================

**前端**

+ UI框架: Bootstrap3

+ 前段MV*框架: Angular1

+ 数据可视化处理库: D3.js

**后端**

+ Web MVC框架: Struts2

+ ORM框架: Hibernate for JPA

+ IOC与AOP框架: Spring

+ 安全框架: Shiro

起步
======================

1. 下载并安装MySQL,创建数据库名字为acg,导入acgfan/WebContent/WEB-INF/public/acg.sql

2. 下载并安装Tomcat服务器

3. 使用Java主流IDE,导入项目后配置Tomcat服务器后即可运行

4. 普通用户的账号名为root,密码为root;管理员用户的账号名为admin,密码为root

功能介绍
======================

该系统分为前后台两部分: 用户通过前台程序可以进行正常的功能操作;
管理员通过后台程序对前台信息进行查询与修改,在用户登录的用户名表单中输入"$admin"即可打开后台登录入口

前台视频主站
----------------------

+ 网站首页
![index](./WebContent/photo/readme/index.png)

+ 登录页面
![login](./WebContent/photo/readme/login.png)

+ 个人中心
![myself](./WebContent/photo/readme/myself.png)

+ 视频播放
![play](./WebContent/photo/readme/play.png)

+ 画板页面
![palette](./WebContent/photo/readme/palette.png)

+ 游戏页面
![game](./WebContent/photo/readme/game.png)

后台管理程序
----------------------

+ 后台管理首页
![admin_adminer](./WebContent/photo/readme/admin_adminer.png)

+ 管理员登录
![admin_login](./WebContent/photo/readme/admin_login.png)

+ 用户信息
![admin_index](./WebContent/photo/readme/admin_index.png)

+ 视频相关操作
![admin_video](./WebContent/photo/readme/admin_video.png)

+ ...



