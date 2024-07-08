
---

# Literalura

Literalura es una aplicación de consola para la gestión de libros que permite interactuar con una API externa, almacenar datos en una base de datos PostgreSQL y realizar diversas consultas. La aplicación está construida con Spring Boot, usando JPA y JPQL.

## Funcionalidades

La aplicación ofrece las siguientes opciones:

1. **Buscar un libro por título**: Consulta la API externa para obtener información sobre un libro por su título y guarda la información en la base de datos.
2. **Listar todos los libros**: Muestra una lista de todos los libros almacenados en la base de datos.
3. **Listar todos los autores**: Muestra una lista de todos los autores almacenados en la base de datos.
4. **Buscar autores vivos en un año determinado**: Busca y muestra autores que estaban vivos en el año especificado.
5. **Buscar libros por idioma**: Busca y muestra libros en un idioma especificado.

## Requisitos Previos

Antes de empezar, asegúrate de tener instalados los siguientes componentes:

- Java 21 
- Maven 3.6.0  
- PostgreSQL 13 

## Configuración

### Base de Datos

1. Crea una base de datos en PostgreSQL:

   ```sql
   CREATE DATABASE literalura;
   ```

2. Configura las credenciales de la base de datos en el archivo `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
   ```

### Dependencias

Asegúrate de que tu archivo `pom.xml` contiene las dependencias necesarias:

```xml
<dependencies>
    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    <!-- Other dependencies -->
</dependencies>
```

## Ejecución

Para ejecutar la aplicación, utiliza el siguiente comando:

```bash
mvn spring-boot:run
```

## Uso

Al iniciar la aplicación, se presentará un menú con las siguientes opciones:

1. **Buscar un libro por título**:
   - Ingresa el título del libro.
   - La aplicación consultará la API externa y guardará la información del libro en la base de datos.

2. **Listar todos los libros**:
   - La aplicación mostrará una lista de todos los libros almacenados en la base de datos.

3. **Listar todos los autores**:
   - La aplicación mostrará una lista de todos los autores almacenados en la base de datos.

4. **Buscar autores vivos en un año determinado**:
   - Ingresa el año.
   - La aplicación mostrará una lista de autores que estaban vivos en el año especificado.

5. **Buscar libros por idioma**:
   - Ingresa el idioma.
   - La aplicación mostrará una lista de libros en el idioma especificado almacenados en la base de datos.



---





