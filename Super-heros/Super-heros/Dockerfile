FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY ./target/*.war super-heros-boot.war

CMD [ "java", "-jar", "super-heros-boot.war" ]

EXPOSE 8080
