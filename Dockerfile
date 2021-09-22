FROM openjdk:11

RUN mkdir app

ARG JAR_FILE

ADD /target/${JAR_FILE} /app/passwordvalidation.jar

WORKDIR /app

ENTRYPOINT java -jar passwordvalidation.jar
