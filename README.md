# User / Employee Management API

## 📌 Project Overview
This is a Spring Boot backend application to manage Users/Employees with CRUD operations, pagination, and sorting.

---

## 🚀 Features
- Create User
- Get All Users (Pagination & Sorting)
- Get User by ID
- Update User
- Delete User
- DTO Mapping (Entity → DTO)
- Pagination using Pageable
- Sorting support

---

## 🛠️ Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 📂 API Endpoints

### 🔹 Get All Users (Pagination)--GET /user?page=0&size=5&sort=name,asc

### 🔹 Get User by ID --GET /user/{id}

### 🔹 Create User --POST /user

### 🔹 Update User --PUT /user/{id}

### 🔹 Delete User --DELETE /user/{id}

---

## 📊 Pagination Example Response
```json
{
  "content": [
    {
      "name": "Harshini",
      "email": "harshini@gmail.com"
    }
  ],
  "totalElements": 7,
  "totalPages": 2,
  "size": 5,
  "number": 0
}
```
## 📌 Example Request
GET /user?page=0&size=5&sort=name,desc

Author 
Harshini A.

