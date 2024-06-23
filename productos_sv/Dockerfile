FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/productos_sv-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_productos.jar
ENTRYPOINT ["java","-jar","app_productos.jar"]