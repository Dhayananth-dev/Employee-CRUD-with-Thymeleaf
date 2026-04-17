FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY target/*.jar  app.jar
EXPOSE 2030
ENTRYPOINT [ "java","-jar","app.jar" ]
