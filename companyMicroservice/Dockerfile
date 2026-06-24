FROM eclipse-temurin:21-jdk

COPY target/companyMicroservice-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=docker"]