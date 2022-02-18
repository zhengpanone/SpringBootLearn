# 引入镜像
FROM zhengpanone/jdk8:latest
# 声明作者
LABEL AUTHOR=zhengpanone
# 声明一个环境参数用来动态启用配置文件
ENV ACTIVE=dev
# 暴露端口
EXPOSE 8094
# 挂载文件夹
VOLUME ["/tmp/tomcat","/logs"]
COPY 20-springboot-docker.jar /opt
# 复制并修改应用打包后的jar文件名称
# ADD 20-springboot-docker.jar springboot-docker.jar

# 容器启动时第一个运行的命令，用来启动应用 "-Dspring.profiles.active=${ACTIVE}",
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/","-jar","/springboot-docker.jar"]