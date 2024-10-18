FROM  openjdk:17-alpine

COPY . /App

WORKDIR /app

RUN javac ./src/main/java/or/example/App .java

CMD ["java","or.example.App"]