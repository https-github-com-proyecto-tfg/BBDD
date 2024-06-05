# Proyecto de Backend en Spring Boot para Gestión de Imágenes

**Ciclo**: Desarrollo de Aplicaciones Web (DAW)  
**Alumno**: [Noelia Tinajero Ortiz]

## Índice

1. [Introducción](#introducción)
2. [Funcionalidades del Proyecto y Tecnologías Utilizadas](#funcionalidades-del-proyecto-y-tecnologías-utilizadas)
3. [Guía de Instalación](#guía-de-instalación)
4. [Guía de Uso](#guía-de-uso)
5. [Enlace a la Documentación](#enlace-a-la-documentación)
6. [Enlace a Figma de la Interfaz](#enlace-a-figma-de-la-interfaz)
7. [Conclusión](#conclusión)
8. [Contribuciones, Agradecimientos y Referencias](#contribuciones-agradecimientos-y-referencias)
9. [Licencias](#licencias)
10. [Contacto](#contacto)

## Introducción

**Descripción del Proyecto**: Este proyecto es un backend desarrollado en Spring Boot que permite la gestión de imágenes para una aplicación frontend en React. Proporciona endpoints para guardar datos de usuarios, obtener imágenes de usuarios y procesar pagos de imágenes seleccionadas.

**Justificación**: Proveer un backend robusto y escalable que soporte las funcionalidades de gestión de imágenes y autenticación de usuarios.

**Objetivos**:

- Proveer un backend seguro y eficiente para la gestión de imágenes.
- Implementar un sistema de almacenamiento y recuperación de datos de usuarios.
- Proveer endpoints para la integración con un frontend en React.

**Motivación**: Crear una solución completa para la gestión de imágenes que pueda ser utilizada en diversos proyectos y aplicaciones.

## Funcionalidades del Proyecto y Tecnologías Utilizadas

### Funcionalidades

- Guardar datos de usuarios y sus imágenes seleccionadas.
- Obtener imágenes guardadas por los usuarios.
- Procesar pagos por imágenes seleccionadas.

### Tecnologías Utilizadas

- **Spring Boot**: Framework para la construcción del backend.
- **JPA/Hibernate**: Para la gestión de la persistencia de datos.
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **Maven**: Gestión de dependencias y construcción del proyecto.

## Guía de Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/https-github-com-proyecto-tfg/BBDD.git
   cd tu-repositorio-backend
   ```

2. Construye el proyecto usando Maven:

   ```bash
   mvn clean install
   ```

3. Configura el archivo `application.properties` en `src/main/resources` con los parámetros necesarios:

   ```properties
   spring.application.name=BBDD
   ```

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/tfg
    spring.datasource.username=root
    spring.datasource.password=root
    spring.jpa.show-sql=true

    server.port=8081
```

## Guía de Uso

Para iniciar la aplicación, ejecuta:

    ```bash
    mvn spring-boot:run
    ```

La aplicación estará disponible en [http://localhost:8081](http://localhost:8081).

### Endpoints disponibles:

- **POST /saveUserData**: Guarda los datos del usuario y la imagen seleccionada.

  - **Request Body**: `{ "name": "string", "email": "string", "option": "string", "imageUrl": "string", "date": "string" }`
  - **Response**: `Data saved successfully`

- **GET /getUserImages**: Obtiene las imágenes guardadas del usuario.

  - **Request Param**: `email=string`
  - **Response**: `["imageUrl1", "imageUrl2", ...]`

- **POST /payForImages**: Procesa el pago de las imágenes seleccionadas.
  - **Request Body**: `{ "email": "string" }`
  - **Response**: `Images paid successfully`

## Enlace a la Documentación

[Documentación del Proyecto](CatApi.pdf)

## Enlace a Figma de la Interfaz

[Diseño de Interfaz en Figma](https://www.figma.com/design/nVoF7Y4tbyNGQYX8rg9EpD/CatApi?node-id=0-1&t=yL39z6aUv5cEn1WC-0)

## Conclusión

Este proyecto backend en Spring Boot proporciona una API robusta y segura para la gestión de imágenes y usuarios. Facilita la integración con un frontend en React y asegura una experiencia de usuario fluida.

## Contribuciones, Agradecimientos y Referencias

Agradecimientos especiales a mis profesores y compañeros que ayudaron en la realización de este proyecto.

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/5.4/)

## Licencias

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Contacto

**Nombre**: Noelia Tinajero Ortiz  
**Email**: noelia.tinajero@a.vedrunasevillasj.es  
**GitHub**: [NoeliaTinajeroOrtiz](https://github.com/NoeliaTinajeroOrtiz)
