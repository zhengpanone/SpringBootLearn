启动provider模块会报错，需要添加jvm参数：
```shell
--add-opens java.base/java.lang=ALL-UNNAMED
```