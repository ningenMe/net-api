FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
COPY ./build/libs/*.jar /

CMD ["java","-jar","api-0.0.1-SNAPSHOT.jar"]