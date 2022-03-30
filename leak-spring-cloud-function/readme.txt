1、application启动后，访问方式如下：
curl -H "Content-Type: text/plain" localhost:9999/upperCase -d '{"value": "hello foobar"}'


curl -H "Content-Type: text/plain" localhost:8080/upperCaseMessage -d '{"value": "hello foobar"}'


2、直接跑单测漏洞即可复现