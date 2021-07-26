FROM adoptopenjdk/openjdk14
WORKDIR /app
COPY target/userservice-*.jar /userservice.jar
ENTRYPOINT exec java -jar $DEF_JAVA_OPTIONS /userservice.jar
