说明：参照leakDetection.http中请求顺序执行即可复现漏洞；若需要验证升级后jar包是否有此问题，可直接修改spring-cloud-starter-gateway包版本为3.1.1即可进行验证。
相关逻辑参考
### POST /actuator/gateway/routes/hacktest
org.springframework.cloud.gateway.actuate.AbstractGatewayControllerEndpoint.save

### POST /actuator/gateway/refresh
org.springframework.cloud.endpoint.RefreshEndpoint.refresh

### GET /actuator/gateway/routes/hacktest
org.springframework.cloud.gateway.actuate.GatewayControllerEndpoint.route

### DELETE /actuator/gateway/routes/hacktest
org.springframework.cloud.gateway.actuate.AbstractGatewayControllerEndpoint.delete