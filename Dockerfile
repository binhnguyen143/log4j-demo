FROM maven:3.8.6-jdk-18 AS builder
COPY --chown=maven:maven src /home/maven/src
COPY --chowm=maven:maven pom.xml /home/maven
WORKDIR /home/maven/src
RUN mvn -f /home/maven/pom.xml clean package

FROM openjdk:8u181-jdk-alpine
EXPOSE 8080
COPY --from=builder /home/maven/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
CMD ["java", "-jar", "/usr/local/lib/demo.jar"]