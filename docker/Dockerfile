FROM openjdk:17

ARG APP_JAR=*.jar

COPY ${APP_JAR} Application.jar

ENTRYPOINT ["java", "-jar", "Application.jar"]

EXPOSE 8080