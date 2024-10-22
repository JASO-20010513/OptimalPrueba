# Proyecto Fullstack con Docker

Este es un proyecto fullstack que incluye un backend desarrollado en Spring Boot (Java) y un frontend en React. Ambos servicios están contenedorizados utilizando Docker y orquestados con Docker Compose.

## Autor
**Jorge Armando Solarte Ordóñez**

---

## Requisitos Previos

Asegúrate de tener instalados los siguientes software en tu sistema:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Estructura del Proyecto

La estructura del proyecto es la siguiente:

    proyectoOptimal/
    │
    ├── BACKEND-FULLSTACK-001/  # Directorio del backend (Spring Boot)
    │   ├── src/                # Código fuente del backend
    │   └── out/                # Artefacto generado (archivo JAR)
    │
    ├── FRONTEND-PATH/          # Directorio del frontend (React)
    │   ├── src/                # Código fuente del frontend
    │   └── build/              # Archivos generados después de la compilación
    │
    └── docker-compose.yml      # Archivo de orquestación Docker

---

## Construir y Ejecutar el Proyecto

Sigue estos pasos para construir y ejecutar tanto el backend como el frontend en contenedores Docker.

1. **Clona el Repositorio**

    Clona el repositorio a tu máquina local (si aún no lo has hecho).

    ```bash
    git clone https://github.com/tu-repositorio/proyectoOptimal.git
    cd proyectoOptimal

2. **Construir las Imágenes de Docker**
   
    Utiliza el comando docker-compose para construir las imágenes de Docker para el backend y el frontend. Asegúrate de estar en la carpeta raíz del proyecto, donde está ubicado el archivo docker-compose.yml.

    docker-compose up --build

    Esto construirá las imágenes del backend y frontend, y levantará ambos servicios en contenedores.

3. Acceder a la Aplicación

    Backend
    El backend estará disponible en http://localhost:8080.

    Frontend
    El frontend estará disponible en http://localhost:80.

4. Detener los Contenedores
   Para detener los contenedores en ejecución, puedes usar el siguiente comando:

    ```bash
    docker-compose down
   
---

## Dockerfiles

### Backend (Spring Boot - Java

El Dockerfile para el backend se encuentra en el directorio BACKEND-FULLSTACK-001 y está configurado para crear la imagen de un servicio Spring Boot usando el archivo JAR generado.

    # Usa una imagen base de OpenJDK
    FROM openjdk:17-jdk-slim
    
    # Establece el directorio de trabajo dentro del contenedor
    WORKDIR /app
    
    # Copia el archivo JAR generado al contenedor
    COPY out/artifacts/crudbackend_jar/crudbackend.jar app.jar
    
    # Exponer el puerto del backend
    EXPOSE 8080
    
    # Comando para ejecutar la aplicación
    ENTRYPOINT ["java", "-jar", "app.jar"]

### Frontend (React)
El Dockerfile para el frontend está en el directorio FRONTEND-PATH y utiliza Nginx para servir la aplicación de React.

    # Usa una imagen base de Node.js para construir la aplicación
    FROM node:16 AS build
    
    WORKDIR /app
    
    COPY package*.json ./
    RUN npm install
    
    COPY . .
    RUN npm run build
    
    FROM nginx:alpine
    COPY --from=build /app/build /usr/share/nginx/html
    EXPOSE 80
    CMD ["nginx", "-g", "daemon off;"]

---

## Docker Compose

El archivo docker-compose.yml orquesta ambos contenedores (backend y frontend) para que trabajen juntos. Aquí está el contenido:

    version: '3.8'
    
    services:
        backend:
            image: crudbackend
            build:
                context: ./BACKEND-FULLSTACK-001
                dockerfile: Dockerfile
            ports:
                - "8080:8080"
            networks:
                - mynetwork
    
        frontend:
            build:
                context: ./FRONTEND-PATH
                dockerfile: Dockerfile
            ports:
                - "80:80"
            networks:
                - mynetwork
    
    networks:
        mynetwork:
            driver: bridge

---

## Notas Adicionales

- Asegúrate de que el archivo JAR del backend se haya generado correctamente en out/artifacts/crudbackend_jar/ antes de ejecutar docker-compose.
- Puedes modificar las rutas y configuraciones de puertos en el archivo docker-compose.yml si es necesario.

---

## Contacto
Si tienes alguna pregunta o comentario sobre este proyecto, no dudes en contactarme.

---

Este archivo `README.md` proporciona una guía completa sobre cómo construir y ejecutar el proyecto utilizando Docker. Si necesitas hacer algún ajuste específico, como cambiar las rutas o agregar más información, no dudes en hacerlo.
