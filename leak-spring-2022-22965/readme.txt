bug复现前提：
1、JDK9 及以上版本
2、使用Tomcat作为servlet容器
3、WAR包启动
4、使用spring-mvc 或者spring-webflux
5、spring版本[ 5.3.0 ~  5.3.17 ]、[ 5.2.0  ~  5.2.19 ]、较旧的、不受支持的版本也会受到影响

笔者当前采用JDK8 + 内嵌tomcat + springmvc 5.3.13并未成功复现，有兴趣的同学可自行尝试。

参考文档：
https://www.lunasec.io/docs/blog/spring-rce-vulnerabilities/
https://tanzu.vmware.com/security/cve-2022-22965

可能的导致被攻击的源码位置参考图片Cheese_Wed-30Mar22_14.30.png：
### org.springframework.beans.BeanWrapperImpl.getLocalPropertyHandler