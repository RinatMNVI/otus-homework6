FROM adoptopenjdk/openjdk14
WORKDIR /app
COPY target/notification-*.jar /notification.jar
ENTRYPOINT exec java -jar $DEF_JAVA_OPTIONS /notification.jar
