FROM adoptopenjdk/openjdk14
WORKDIR /app
COPY target/orderservice-*.jar /orderservice.jar
ENTRYPOINT exec java -jar $DEF_JAVA_OPTIONS /orderservice.jar
