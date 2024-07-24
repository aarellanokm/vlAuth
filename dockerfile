# Crea el contenedor a partir de una imagen con java 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el proyecto al contenedor
COPY target/vlauth-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8081
EXPOSE 8081

# Configura el punto de entrada a la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]