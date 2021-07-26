FROM adoptopenjdk/openjdk14
WORKDIR /app
COPY target/billingservice-*.jar /billingservice.jar
ENTRYPOINT exec java -jar $DEF_JAVA_OPTIONS /billingservice.jar
