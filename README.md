# Job Application Tracker

## Overview

Job Application Tracker is a full-stack web application built using
React.js, Spring Boot, and MySQL. It allows users to register, log in,
and manage their job applications by adding, editing, deleting,
searching, and filtering jobs.

------------------------------------------------------------------------

# Tech Stack

## Frontend

-   React.js
-   Vite
-   Axios
-   Bootstrap
-   React Router
-   React Toastify

## Backend

-   Java
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   Maven

## Database

-   MySQL

## Tools

-   Git
-   GitHub
-   IntelliJ IDEA
-   VS Code
-   Postman
-   Railway
-   Render

------------------------------------------------------------------------

## System Architecture

```mermaid
flowchart LR

A["React Frontend"]
B["Spring Boot REST API"]
C["Controller Layer"]
D["Service Layer"]
E["Repository Layer"]
F["Hibernate / JPA"]
G["MySQL Database"]

A --> B
B --> C
C --> D
D --> E
E --> F
F --> G

G --> F
F --> E
E --> D
D --> C
C --> A
```

------------------------------------------------------------------------

# Complete Application Workflow

``` mermaid
flowchart TD
A[Open Application] --> B{Registered User?}
B -- No --> C[Register]
C --> D[(Users Table)]
D --> E[Login]
B -- Yes --> E
E --> F{Credentials Valid?}
F -- No --> G[Show Login Error]
F -- Yes --> H[Dashboard]
H --> I[Load Jobs]
I --> J[(Jobs Table)]
J --> K[Display Jobs]
K --> L[Add Job]
K --> M[Edit Job]
K --> N[Delete Job]
K --> O[Search Jobs]
K --> P[Filter Jobs]
L --> J
M --> J
N --> J
O --> K
P --> K
```

------------------------------------------------------------------------

# Login Flow

``` mermaid
sequenceDiagram
participant User
participant React
participant Controller
participant Service
participant Repository
participant DB

User->>React: Enter Email & Password
React->>Controller: POST /auth/login
Controller->>Service: login()
Service->>Repository: findByEmail()
Repository->>DB: SELECT User
DB-->>Repository: User
Repository-->>Service: User
Service-->>Controller: Success / Failure
Controller-->>React: HTTP Response
React-->>User: Dashboard / Error
```

------------------------------------------------------------------------

# Add Job Flow

``` mermaid
sequenceDiagram
participant User
participant React
participant Controller
participant Service
participant Repository
participant DB

User->>React: Submit Job Form
React->>Controller: POST /jobs
Controller->>Service: saveJob()
Service->>Repository: save()
Repository->>DB: INSERT
DB-->>Repository: Success
Repository-->>Service: Saved
Service-->>Controller: Success
Controller-->>React: HTTP 200
React-->>User: Refresh Dashboard
```

------------------------------------------------------------------------

## Edit Job Flow

```mermaid
flowchart TD
    A[User Clicks Edit]
    B[Load Existing Job]
    C[Modify Job Details]
    D[Send Update Request]
    E[Controller]
    F[Service]
    G[Repository]
    H[(MySQL Database)]
    I[Update Successful]
    J[Refresh Dashboard]

    A --> B
    B --> C
    C --> D
    D --> E
    E --> F
    F --> G
    G --> H
    H --> I
    I --> J
```

------------------------------------------------------------------------

## Delete Job Flow

```mermaid
flowchart TD
    A[User Clicks Delete]
    B[Send Delete Request]
    C[Controller]
    D[Service]
    E[Repository]
    F[(MySQL Database)]
    G[Delete Job Record]
    H[Refresh Dashboard]

    A --> B
    B --> C
    C --> D
    D --> E
    E --> F
    F --> G
    G --> H
```
------------------------------------------------------------------------

# Search Flow

``` mermaid
flowchart LR
A[Enter Company Name]
--> B[React Updates State]
--> C[Filter Jobs]
--> D[Display Results]
```

------------------------------------------------------------------------

# Filter Flow

``` mermaid
flowchart LR
A[Select Status]
--> B[Applied / Interview / Offer / Rejected]
--> C[Filter Jobs]
--> D[Display Results]
```

------------------------------------------------------------------------

# Dashboard Statistics

``` mermaid
flowchart TD
A[(Jobs)]
A --> B[Total Jobs]
A --> C[Applied]
A --> D[Interview]
A --> E[Offer]
B --> F[Dashboard]
C --> F
D --> F
E --> F
```

------------------------------------------------------------------------

# Backend Request Lifecycle

``` mermaid
flowchart TD
A[React] --> B[Axios]
B --> C[Controller]
C --> D[Service]
D --> E[Repository]
E --> F[Hibernate]
F --> G[(MySQL)]
G --> F
F --> E
E --> D
D --> C
C --> H[JSON Response]
H --> A
```

------------------------------------------------------------------------

# Folder Structure

``` text
Frontend
src/
 ├── components
 ├── pages
 ├── App.jsx
 └── main.jsx

Backend
src/main/java
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── security
 └── config
```

------------------------------------------------------------------------

# Database

## users

-   id
-   name
-   email
-   password

## jobs

-   id
-   companyName
-   jobTitle
-   location
-   status
-   appliedDate

------------------------------------------------------------------------

# REST APIs

  Method   Endpoint                Purpose
  -------- ----------------------- ----------------
  POST     /auth/register          Register
  POST     /auth/login             Login
  POST     /auth/forgot-password   Reset Password
  GET      /jobs                   Get Jobs
  POST     /jobs                   Add Job
  PUT      /jobs/{id}              Update Job
  DELETE   /jobs/{id}              Delete Job

------------------------------------------------------------------------

# Future Enhancements

-   JWT Authentication
-   BCrypt Password Encryption
-   Resume Upload
-   Email Notifications
-   Interview Reminders
-   Charts & Analytics
-   Role-Based Access Control

------------------------------------------------------------------------

# Author

**Navya Chandrika**
