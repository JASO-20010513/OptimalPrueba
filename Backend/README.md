# CRUD Backend Application

## Descripción

Esta es una aplicación CRUD (Create, Read, Update, Delete) desarrollada con Spring Boot y Maven. La aplicación permite manejar un inventario de elementos (items), y está conectada a una base de datos H2 en memoria.

## Autor

**Jorge Armando Solarte Ordóñez**

---

## Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3.x](https://maven.apache.org/install.html)
- [Postman](https://www.postman.com/downloads/) (opcional, para probar los endpoints)
- Un editor de texto, como [IntelliJ IDEA](https://www.jetbrains.com/idea/) o [Eclipse](https://www.eclipse.org/ide/)

## Estructura de carpetas

La estructura de carpetas del proyecto sigue buenas prácticas de desarrollo en Spring Boot:

   my-crud-app/
   │
   ├── public/
   │   ├── index.html
   │   └── favicon.ico
   │
   ├── src/
   │   ├── assets/
   │   │   ├── images/
   │   │   └── styles/
   │   │       └── App.css
   │   │
   │   ├── components/
   │   │   ├── Form/
   │   │   │   ├── Form.js
   │   │   │   └── Form.css
   │   │   ├── ItemList/
   │   │   │   ├── ItemList.js
   │   │   │   └── ItemList.css
   │   │   └── Button/
   │   │       ├── Button.js
   │   │       └── Button.css
   │   │
   │   ├── services/
   │   │   └── api.js
   │   │
   │   │
   │   ├── utils/
   │   │   └── helpers.js
   │   │
   │   │
   │   ├── App.js
   │   ├── index.js
   │   │
   │   └── App.css
   │
   ├── .gitignore
   │
   ├── package.json
   └── README.md

---

## Configuración del Proyecto

1. **Clonar el repositorio:** Clona este repositorio en tu máquina local.

   ```bash
   git clone https://github.com/tu-usuario/crudbackend.git

2. **Importar el proyecto en tu IDE:**

- Abre tu IDE y selecciona "Import Project" o "Open".
- Navega hasta la carpeta donde clonaste el repositorio y selecciona el archivo pom.xml.
- Tu IDE debería configurar automáticamente el proyecto con Maven.

3. **Configurar la base de datos:** El proyecto utiliza una base de datos H2 en memoria por defecto. Puedes acceder a la consola H2 desde http://localhost:8080/h2-console con las siguientes credenciales (según el archivo application.properties):

- **JDBC URL:** jdbc:h2:mem:testdb
- **User:** sa
- **Password:** password (o dejarlo vacío si no configuraste ninguna contraseña)

   Si deseas utilizar otra base de datos (por ejemplo, MySQL), puedes modificar las propiedades en src/main/resources/application.properties.

4. **Compilar y ejecutar el proyecto:** Abre una terminal en la carpeta del proyecto y ejecuta el siguiente comando:

   ```bash
   mvn spring-boot:run

Esto iniciará el servidor Spring Boot en http://localhost:8080.

## Endpoints de la API

Los endpoints REST para el CRUD de items están documentados a continuación:

- GET /items: Obtiene todos los items.
- GET /items/{id}: Obtiene un item por ID.
- POST /items: Crea un nuevo item.
- PUT /items/{id}: Actualiza un item existente.
- DELETE /items/{id}: Elimina un item por ID.

### Ejemplo de uso en Postman

1. GET Todos los items:

- URL: http://localhost:8080/items
- Método: GET

2. POST Crear un nuevo item:

- URL: http://localhost:8080/items
- Método: POST
- Body (JSON)

   ```bash
   {
      "name": "Nuevo Item",
      "description": "Descripción del nuevo item"
   }

4. DELETE Eliminar un item:

- URL: http://localhost:8080/items/{id}
- Método: DELETE

---

## Pruebas

Para ejecutar las pruebas, usa el siguiente comando:

   
mvn test
   
Esto ejecutará todas las pruebas unitarias definidas en el proyecto.

---

## Licencia

Este proyecto no tiene una licencia específica.