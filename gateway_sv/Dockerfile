FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/gateway-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_gateway.app
ENTRYPOINT ["java", "-jar","app_eureka.jar"]