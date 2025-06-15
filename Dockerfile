FROM eclipse-temurin:17

WORKDIR /app

COPY . /app

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
