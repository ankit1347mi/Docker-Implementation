FROM openjdk:11-jre-slim

COPY ./target/docker-implementation-0.0.1-SNAPSHOT.jar /user/app/

WORKDIR /user/app

EXPOSE 8080

ENTRYPOINT ["java","-jar","docker-implementation-0.0.1-SNAPSHOT.jar"]