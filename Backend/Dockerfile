# Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# Definir el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR en el contenedor
COPY out/artifacts/crudbackend_jar/crudbackend.jar app.jar

# Exponer el puerto que utiliza tu aplicación (cambia el 8080 si es necesario)
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
