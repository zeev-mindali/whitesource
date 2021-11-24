FROM openjdk:17-alpine
COPY ./target/question-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch question-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","question-0.0.1-SNAPSHOT.jar"]

