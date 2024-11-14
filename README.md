# literalura_challenge, proyecto de Gestión de Libros y Autores

**Idiomas**: [Español](#español) | [English](#english)

## Español
(Este proyecto fue desarrollado como parte de un desafío técnico para demostrar habilidades en la integración de APIs, procesamiento de datos, y gestión de bases de datos relacionales con relaciones complejas. El proyecto consume datos desde una API externa, los filtra según necesidades específicas, y los almacena en una base de datos relacional utilizando relaciones many-to-many para modelar las conexiones entre libros, autores y sus idiomas. Este README describe los pasos y decisiones técnicas del proyecto.

Tecnologías utilizadas
Java 17: Lenguaje principal del proyecto.
Spring Boot: Framework para el desarrollo de la API y la conexión a la base de datos.
JPA (Java Persistence API): Manejador de persistencia para definir y gestionar las entidades y relaciones en la base de datos.
Hibernate: Implementación de JPA para realizar el mapeo objeto-relacional.
PostgreSQL: Base de datos relacional utilizada para almacenar los libros, autores e idiomas.
Maven: Herramienta de gestión de dependencias.
Arquitectura y diseño
Modelo de datos
Este proyecto define tres entidades principales:

Book: Representa un libro y contiene atributos como título, conteo de descargas, y el idioma.
Author: Representa a un autor e incluye información como su nombre, año de nacimiento y año de muerte.
Languages: Representa los idiomas en los que se ha publicado un libro.
Estas entidades están relacionadas mediante una relación many-to-many entre libros y autores, así como entre libros e idiomas. Esta relación se modela en tablas intermedias:

book_authors: Relaciona cada libro con sus autores.
book_languages: Relaciona cada libro con los idiomas en los que está disponible.
Conexión con la API y procesamiento de datos
El proyecto se conecta a una API externa para obtener información sobre libros y autores. La información obtenida se procesa de la siguiente manera:

Se extraen los datos de los libros, incluyendo sus autores y sus idiomas.
Se revisa si cada autor ya existe en la base de datos para evitar duplicados. Si el autor no está en la base de datos, se almacena; en caso contrario, se actualizan los datos existentes.
Se filtran los libros por atributos como idioma o años de vida del autor antes de guardarlos en la base de datos.
Ejemplo de uso
Guardar libros y autores en la base de datos
El proyecto incluye un servicio que, al llamar a la API, obtiene la lista de libros y autores. Este servicio filtra y guarda solo la información relevante, verificando que cada libro, autor e idioma esté correctamente relacionado. Esta implementación asegura la integridad de la base de datos, especialmente al trabajar con relaciones many-to-many.

Filtrar autores vivos en un año determinado
Para un año dado, el sistema permite obtener una lista de autores que estaban vivos en dicho año. Este filtro se realiza a través de un método en el repositorio AuthorRepository, que permite evaluar el rango de fechas de nacimiento y muerte de cada autor.

Filtrar libros por idioma
El proyecto incluye un método en el repositorio BooksRepository que permite filtrar libros por el idioma en el que están disponibles. Esto es útil para usuarios interesados en libros en idiomas específicos.

Estructura del proyecto
graphql
Copiar código
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.alura.literatura_challenge
│   │   │   │   ├── model            # Entidades principales: Book, Author, Languages
│   │   │   │   ├── repository       # Repositorios JPA para manejar la persistencia
│   │   │   │   ├── service          # Lógica de negocios y procesamiento de datos
│   │   │   │   └── main             # Punto de entrada de la aplicación
│   │   └── resources
│   │       ├── application.yml      # Configuración de la base de datos y propiedades de la API
└── pom.xml                           # Configuración de dependencias de Maven
Ejecución del proyecto
Requisitos previos
Java 17
PostgreSQL configurado y en ejecución
Maven para la gestión de dependencias
Pasos para ejecutar
Configurar la base de datos: Crear una base de datos en PostgreSQL y actualizar las credenciales en application.yml.
Instalar dependencias: Ejecutar mvn install para instalar las dependencias.
Correr la aplicación: Iniciar la aplicación ejecutando mvn spring-boot:run.
Desafíos y soluciones
Desafío: Configuración de relaciones many-to-many
Para reflejar correctamente las relaciones many-to-many entre libros, autores e idiomas, el proyecto utiliza tablas intermedias gestionadas por @ManyToMany y @ElementCollection. Para asegurar que las relaciones estén correctamente representadas, la configuración incluye:

La anotación @ManyToMany en la entidad Book para conectar con Author.
@ElementCollection para manejar los idiomas sin necesidad de crear una entidad separada para cada idioma.
Desafío: Evitar duplicados en la base de datos
Para evitar la duplicación de datos, el proyecto realiza verificaciones previas de existencia para autores y libros en la base de datos. Si un autor o libro ya existe, se omite o actualiza la entrada correspondiente, utilizando Optional y findByName o findByTitle según la entidad.

Futuras mejoras
Optimización de consultas: Para mejorar el rendimiento, se pueden optimizar las consultas JPQL y aplicar caché en consultas de datos.
Validación de datos: Implementar una capa adicional de validación para asegurar la integridad de los datos obtenidos desde la API.)

## English
(This project was developed as part of a technical challenge to demonstrate skills in API integration, data processing, and management of relational databases with complex relationships. The project consumes data from an external API, filters it according to specific needs, and stores it in a relational database using many-to-many relationships to model the connections between books, authors, and their languages. This README describes the project’s steps and technical decisions.

Technologies Used

Java 17: The project’s primary language.
Spring Boot: Framework for API development and database connection.
JPA (Java Persistence API): Persistence manager to define and manage entities and relationships in the database.
Hibernate: JPA implementation to perform object-relational mapping.
PostgreSQL: Relational database used to store books, authors, and languages.
Maven: Dependency management tool.
Architecture and Design

Data Model This project defines three main entities:

Book: Represents a book and contains attributes such as title, download count, and language.
Author: Represents an author and includes information such as their name, birth year, and death year.
Languages: Represents the languages in which a book has been published.
These entities are related through many-to-many relationships between books and authors, as well as between books and languages. This relationship is modeled in intermediate tables:

book_authors: Relates each book with its authors.
book_languages: Relates each book with the languages in which it is available.
API Connection and Data Processing The project connects to an external API to retrieve information about books and authors. The obtained information is processed as follows:

Data is extracted for books, including their authors and languages.
Each author is checked for existing entries in the database to avoid duplicates. If the author does not exist, they are stored; if they do, existing data is updated.
Books are filtered by attributes such as language or the author’s life span before saving them to the database.
Usage Example

Save Books and Authors to the Database The project includes a service that, when calling the API, obtains a list of books and authors. This service filters and saves only the relevant information, verifying that each book, author, and language is correctly related. This implementation ensures database integrity, especially when working with many-to-many relationships.

Filter Authors Alive in a Given Year For a given year, the system allows obtaining a list of authors who were alive during that year. This filter is implemented through a method in the AuthorRepository repository, which evaluates the birth and death date range of each author.

Filter Books by Language The project includes a method in the BooksRepository repository that allows filtering books by the language in which they are available. This is useful for users interested in books in specific languages.

Project Structure

graphql
Copiar código
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.alura.literature_challenge
│   │   │   │   ├── model            # Main entities: Book, Author, Languages
│   │   │   │   ├── repository       # JPA repositories for handling persistence
│   │   │   │   ├── service          # Business logic and data processing
│   │   │   │   └── main             # Application entry point
│   │   └── resources
│   │       ├── application.yml      # Database configuration and API properties
└── pom.xml                           # Maven dependency configuration
Running the Project

Prerequisites

Java 17
PostgreSQL configured and running
Maven for dependency management
Steps to Run

Configure the Database: Create a database in PostgreSQL and update credentials in application.yml.
Install Dependencies: Run mvn install to install dependencies.
Run the Application: Start the application by running mvn spring-boot:run.
Challenges and Solutions

Challenge: Configuring Many-to-Many Relationships To correctly represent many-to-many relationships between books, authors, and languages, the project uses intermediate tables managed by @ManyToMany and @ElementCollection. To ensure that relationships are accurately represented, the configuration includes:

The @ManyToMany annotation in the Book entity to connect with Author.
@ElementCollection to handle languages without the need to create a separate entity for each language.
Challenge: Avoiding Duplicates in the Database To prevent data duplication, the project performs pre-existence checks for authors and books in the database. If an author or book already exists, the corresponding entry is either skipped or updated, using Optional and findByName or findByTitle, depending on the entity.

Future Improvements

Query Optimization: To enhance performance, JPQL queries can be optimized, and caching can be applied to data queries.
Data Validation: Implement an additional validation layer to ensure data integrity from the API.)