# Etapa 1: Construcción del proyecto
FROM maven:3.9.9-eclipse-temurin-17-alpine AS builder
WORKDIR /app
# Copiar primero pom.xml para cachear dependencias
COPY pom.xml .
COPY mvnw .
COPY .mvn ./.mvn
# Asegurar permisos de ejecución para mvnw
RUN chmod +x ./mvnw
# Descargar dependencias para aprovechar cache
RUN ./mvnw dependency:go-offline
# Copiar código fuente y construir
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final
FROM openjdk:17-jdk-alpine
WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/target/products-0.0.1-SNAPSHOT.jar .
# Exponer puerto 8080 (o 8081 si lo usas)
EXPOSE 8081
ENV PORT=8081
ENTRYPOINT ["java", "-jar", "products-0.0.1-SNAPSHOT.jar"]
