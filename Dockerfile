# FROM eclipse-temurin:21-jdk as build

# COPY . /app
# WORKDIR /app

# RUN chmod +x mvnw
# RUN ./mvnw package -DskipTests
# RUN mv -f target/*.jar app.jar

# FROM eclipse-temurin:21-jre

# ARG PORT
# ENV PORT=8000

# # Expone el puerto en el corre tu app
# EXPOSE 8000

# COPY --from=build /app/app.jar .

# RUN useradd runtime
# USER runtime

# ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]

####

# # Imagen base de Java para correr la aplicación
# FROM openjdk:21-jdk-slim

# # Configurar el directorio de trabajo dentro del contenedor
# WORKDIR /app

# # Copiar el archivo JAR generado por Spring Boot al contenedor
# COPY target/apirest-0.0.1-SNAPSHOT.jar app.jar

# # Exponer el puerto que utiliza tu aplicación (por defecto, 8080 en Spring Boot)
# EXPOSE 8000

# # Comando para ejecutar la aplicación
# ENTRYPOINT ["java", "-jar", "app.jar"]

# Imagen base de Maven para construir la aplicación
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y las dependencias para resolverlas primero
COPY pom.xml .

# Descargar las dependencias de Maven (se almacenan en caché si no hay cambios en el pom.xml)
RUN mvn dependency:go-offline -B

# Copiar el resto del código fuente
COPY src ./src

# Construir el archivo JAR
RUN mvn clean package -DskipTests

# ----------------------------
# Imagen final para ejecutar la aplicación
# ----------------------------

# Usar una imagen base más ligera para ejecutar el JAR
FROM openjdk:21-jdk-slim

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado al contenedor final
COPY --from=build /app/target/apirest-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que utiliza tu aplicación
EXPOSE 8000

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
