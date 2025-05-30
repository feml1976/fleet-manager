# Fleet Manager
## Descripción del Proyecto
Fleet Manager es un sistema de gestión de flota de vehículos desarrollado con Spring Boot. El proyecto está estructurado como una aplicación de microservicios que permite el control y seguimiento de solicitudes relacionadas con la gestión de flotas de vehículos.

En este directorio se encuentra el archivo Bootcamp de Microservicios con JAVA.pdf en el cual pueden encontrar mas información, tambien esta el archivo Fleet-Manager.postman_collection.json en el cual pueden encontrar las pruebas de los diferentes End Points

En el directorio imagenes estan las pantallas que evidencian las pruebas realizadas a los diferentes End Points

## Estructura del Proyecto
El proyecto está organizado como una aplicación multi-módulo Maven con los siguientes componentes:

- Módulo Principal (fleet-manager) : Actúa como el contenedor principal del proyecto.
- Módulo Control-Flota : Gestiona el control y seguimiento de la flota de vehículos.
- Módulo MSVC-Requets : Maneja las solicitudes y peticiones relacionadas con la flota.
## Tecnologías Utilizadas
- Java 21 : Lenguaje de programación principal.
- Spring Boot 3.4.5 : Framework para el desarrollo de aplicaciones Java.
- Spring Data JPA : Para la persistencia de datos.
- Spring Cloud : Para la implementación de microservicios.
- PostgreSQL : Base de datos relacional.
- Maven : Herramienta de gestión de dependencias y construcción.
- MapStruct : Para el mapeo entre entidades y DTOs.
## Módulos
### Control-Flota
Este módulo se encarga de la gestión y control de la flota de vehículos. Sus principales características son:

- Gestión de controles de flota y sus detalles.
- API REST para operaciones CRUD sobre controles de flota.
- Validación de datos y manejo de errores.
- Persistencia en base de datos PostgreSQL. Entidades Principales
- ControlFlota : Entidad principal para el control de flota.
- DetalleControlFlota : Detalles asociados a cada control de flota. Servicios
- ControlFlotaService : Implementa la lógica de negocio para la gestión de controles de flota.
### MSVC-Requets
Este módulo gestiona las solicitudes relacionadas con la flota. Sus principales características son:

- Gestión del ciclo de vida de las solicitudes (creación, asignación, activación, actualización, finalización y cancelación).
- API REST para operaciones CRUD sobre solicitudes.
- Persistencia en base de datos PostgreSQL. Entidades Principales
- Request : Entidad principal para las solicitudes. Servicios
- RequestService : Implementa la lógica de negocio para la gestión de solicitudes.
## Configuración
Ambos módulos están configurados para conectarse a una base de datos PostgreSQL local:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/mylocaldb
spring.datasource.username=Postgres
spring.datasource.password=Postgres
```
Los puertos de los servicios están configurados de la siguiente manera:

- Control-Flota : Puerto 8001
- MSVC-Requets : Puerto 8002
## Cómo Ejecutar
1. Asegúrate de tener instalado Java 21 y Maven.
2. Configura una base de datos PostgreSQL con el nombre "mylocaldb".
3. Clona el repositorio.
4. Ejecuta mvn clean install en el directorio raíz para compilar todos los módulos.
5. Ejecuta cada módulo con mvn spring-boot:run o mediante los scripts proporcionados.
## Desarrollo
El proyecto sigue una arquitectura de microservicios con las siguientes capas:

- Controladores : Manejan las peticiones HTTP y definen los endpoints REST.
- Servicios : Implementan la lógica de negocio.
- Repositorios : Gestionan el acceso a datos mediante Spring Data JPA.
- Modelos : Definen las entidades y DTOs utilizados en la aplicación.
## Contribución
Para contribuir al proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad ( git checkout -b feature/nueva-funcionalidad ).
3. Realiza tus cambios y haz commit ( git commit -am 'Añadir nueva funcionalidad' ).
4. Haz push a la rama ( git push origin feature/nueva-funcionalidad ).
5. Crea un Pull Request.
## Licencia
Este proyecto está licenciado bajo los términos especificados en el archivo de licencia incluido en el repositorio.
