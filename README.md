# Mini Banking App
This project provides the backend APIs for a mini banking application.

The project is developed using Java and Spring Boot. You can download the project files and open them in a Java IDE. Before running the project, you should create a PostgreSQL database and configure your database connection details in the application.properties file.

You can start the PostgreSQL database using Docker with the following command:
# Running Container

1. `./gradlew clean build`
2. Run: `docker-compose up`
3. Create container just first : `docker run -d --name postgres1 -p 5455:5432 -e POSTGRES_PASSWORD=postgres postgres`
4. Exec container : `docker start postgres`
5. Run app : `./gradlew bootRun`

## AUTH APIs

### Login

**Endpoint:** `/api/users/login`

**Method:** POST

**Description:** This endpoint allows users to log in with their username and password.

### Register

**Endpoint:** `/api/users/register`

**Method:** POST

**Description:** This endpoint allows users to register with their username, password, and email.
