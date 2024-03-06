# Spring Security Application

This is a simple web application demonstrating authentication and authorization functionalities built with Spring Boot and Spring Security.

## Overview

The project implements authentication and authorization using Spring Security. It includes features like user authentication with username and password, authorization based on user roles, access control to certain endpoints, custom user details service implementation, and a user registration endpoint.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven

## How to Clone and Run

To clone and run this application locally, follow these steps:

1. Open your preferred IDE (such as IntelliJ IDEA).

2. Go to the "Get From Version Control" section or similar in your IDE.

3. Paste the repository URL:
   - HTTPS: `https://github.com/MaksymChalyi/spring-security-app-authentication-authorization.git`
   - SSH: `git@github.com:MaksymChalyi/spring-security-app-authentication-authorization.git`
   - GitHub CLI: `gh repo clone MaksymChalyi/spring-security-app-authentication-authorization`

4. Follow the instructions in your IDE to clone the repository.

5. Navigate to the project directory in your IDE.

6. Configure the PostgreSQL database settings in the `application.properties` file located in the `src/main/resources` directory.

7. Build the project using Maven:
   ```bash
   mvn clean install
   ```

8. Run the application:
   ```bash
   mvn spring-boot:run
   ```

9. Access the application in your browser at `http://localhost:8081`.

## Endpoints

- **POST /api/v1/apps/new-user:** Endpoint for registering a new user.
  - Example:
    - Request:
      ```json
      POST /api/v1/apps/new-user
      {
        "name": "newuser",
        "password": "password123",
        "roles": "ROLE_USER"
      }
      ```
    - Response:
      ```plaintext
      User is saved
      ```

- **GET /api/v1/apps/welcome:** Public endpoint to welcome users.
  - Example:
    - Request:
      ```http
      GET /api/v1/apps/welcome
      ```
    - Response:
      ```html
      Welcome to the unprotected page
      ```

- **GET /api/v1/apps/all-app:** Endpoint to retrieve all applications. Requires ROLE_USER.
  - Example:
    - Request:
      ```http
      GET /api/v1/apps/all-app
      ```
    - Response:
      ```json
      [
        {
          "name": "Application 1",
          "author": "Author 1",
          "version": "1.0"
        },
        {
          "name": "Application 2",
          "author": "Author 2",
          "version": "2.0"
        },
        ...
      ]
      ```

- **GET /api/v1/apps/{id}:** Endpoint to retrieve application details by ID. Requires ROLE_ADMIN.
  - Example:
    - Request:
      ```http
      GET /api/v1/apps/1
      ```
    - Response:
      ```json
      {
        "name": "Application 1",
        "author": "Author 1",
        "version": "1.0"
      }
      ```

## Acknowledgements

This application was developed with guidance from the tutorial video available on YouTube by Antosha Korsakov. The tutorial provided invaluable insights and instructions on implementing Spring Security in the project. You can find the tutorial video [here](https://youtu.be/U1y8GsJ8CQs).

```
