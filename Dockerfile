# Сборка jar
FROM maven:3.8-openjdk-16 as maven
WORKDIR /app
COPY . /app
RUN mvn install

# Запуск
FROM openjdk:16.0.2-jdk
WORKDIR /app
COPY --from=maven /app/target/job4j_forum-1.0-SNAPSHOT.war app.war
CMD java -jar app.war
