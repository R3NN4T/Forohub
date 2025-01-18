# 📚 ForoHub

La siguiente aplicación es una API REST para gestionar un foro donde los usuarios pueden realizar aportes y comentarios sobre diversos temas. Este proyecto está diseñado pensando en una comunidad educativa, permitiendo a los usuarios compartir conocimientos y resolver dudas en un entorno seguro.
## ✨ Funcionalidades de la API

Nuestra API se centra específicamente en los tópicos y permite a los usuarios:

- 🗒️ **Crear un nuevo tópico:** Los usuarios pueden crear tópicos sobre diferentes temas.
- 📄 **Listar todos los tópicos creados:** Se pueden consultar todos los tópicos disponibles en el foro.
- 🔍 **Visualizar un tópico específico:** Los usuarios pueden ver los detalles de un tópico en particular.
- ✏️ **Actualizar un tópico existente:** Es posible editar un tópico previamente creado.
- 🗑️ **Eliminar un tópico:** Los tópicos obsoletos o incorrectos pueden ser eliminados.


## 🎯 Objetivos del Proyecto

### 🎯 Objetivo General
Crear una API REST que permita realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) en un foro de discusión, implementando autenticación y autorización mediante Spring Security y JWT para garantizar un espacio seguro y estructurado.

### 📌 Objetivos Específicos

- Configurar un entorno de desarrollo basado en Java 17.
- Construir y gestionar una base de datos con MySQL.
- Implementar endpoints para la creación, listado, actualización y eliminación de tópicos.
- Gestionar la autenticación y autorización de usuarios con Spring Security y JWT.
- Integrar validaciones para los datos ingresados mediante Spring Validation.

## 🛠️ Tecnologías Utilizadas

- **Backend**: Spring Boot, Java, JPA.
- **Base de Datos**: MySQL.
- **Herramientas de Desarrollo**: IntelliJ IDEA, Insomnia (para pruebas API).

## ✨ Funcionalidades Principales

- **Registro y autenticación de usuarios**.
- **Creación y gestión de foros**: Organización de tópicos y comentarios.

## 🔧 Instalación y Configuración

### ⚙️ Requisitos Previos

- Java [versión 17]
- Base de datos MySQL [versión 8.1]
- Gestor de paquetes (Maven)
- Spring Boot 3

### 📦 Dependencias Necesarias

- MySQL
- Spring Boot Starter JPA
- Spring Boot Starter Validation
- Spring Boot Starter Web
- Flyway Core
- Flyway-mysql
- Spring Boot DevTools
- Lombok
- Spring Security
- Java-jwt

### 📋 Configuración del Proyecto

Para comenzar, se utilizó el Spring Initializr: [Spring Initializr](https://start.spring.io/), y se agregaron las dependencias mencionadas.

### 🗄️ Configuración de la Base de Datos

1. Crear una base de datos llamada foro en MySQL:
   ```bash
    CREATE DATABASE forohub;

2. Configurar las credenciales de la base de datos en el archivo application.properties o application.yml:   ```bash
   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/foro
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=validate
    spring.flyway.enabled=true
   
3. Ejecuta los scripts de migración en el directorio `db/migrations` utilizando Flyway:
   ```bash
   flyway migrate
   
## 🚀 Uso de la Aplicación

### 🔐 Registro de Usuario con Login y Contraseña

- **Método**: POST
- **URL**: `/usuarios`
- **Descripción**: Registra un nuevo usuario con email y contraseña.
- **Insomnia**: Registrar usuarios

![Captura de pantalla 2025-01-18 132236](https://github.com/user-attachments/assets/eaa2ef98-3869-47f1-a534-dcedf0482f0a)


### 📝 Registro de un Nuevo Tópico

- **Método**: POST
- **URL**: `/topicos`
- **Descripción**: Crea un nuevo tópico con título, mensaje, estado, y el email del autor.
- **Insomnia**: Registrar tópicos

![Captura de pantalla 2025-01-18 132251](https://github.com/user-attachments/assets/10bb7746-8c96-4109-a83d-6334d3072aa9)

### 📄 Listado de Tópicos Existentes

- **Método**: GET
- **URL**: `/topicos`
- **Descripción**: Retorna una lista de todos los tópicos creados.
- **Insomnia**: Listar tópicos

![Captura de pantalla 2025-01-18 132311](https://github.com/user-attachments/assets/4b8e8905-4b6b-470b-a305-3d7b60ec99a3)


### 🔍 Detalle de un Tópico

- **Método**: GET
- **URL**: `/topicos/{id}`
- **Descripción**: Retorna los detalles de un tópico específico.
- **Insomnia**: Detallando tópicos

![Captura de pantalla 2025-01-18 132330](https://github.com/user-attachments/assets/cc6677f1-842e-4681-bb71-bb3c3208c6b5)


### ✏️ Actualizar un Tópico

- **Método**: PUT
- **URL**: `/topicos/{id}`
- **Descripción**:  Actualiza los detalles de un tópico existente.
- **Insomnia**: Actualizar tópicos

![Captura de pantalla 2025-01-18 132347](https://github.com/user-attachments/assets/e56d09b7-707a-4f76-be7f-02a4b08d46b5)


### 🗑️ Eliminar un Tópico Existente

- **Método**: DELETE
- **URL**: `/topicos/{id}`
- **Descripción**: Elimina un tópico por su ID.
- **Insomnia**: Eliminar tópicos

![Captura de pantalla 2025-01-18 132405](https://github.com/user-attachments/assets/0183eed8-c09b-4d2d-8711-77881872d490)


### ✨ Contribuciones
Si deseas contribuir a este proyecto, siéntete libre de realizar un fork del repositorio y enviar tus sugerencias o mejoras a través de un pull request.



### 📌 Notas Finales
Este proyecto fue desarrollado con fines educativos y como una herramienta para fomentar el aprendizaje colaborativo en comunidades académicas. ¡Esperamos que te sea útil! 😊


