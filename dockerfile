FROM amazoncorretto:17
WORKDIR /app
COPY build/libs/TafUserService-0.0.1-SNAPSHOT.jar TafUserService.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "TafUserService.jar"]
