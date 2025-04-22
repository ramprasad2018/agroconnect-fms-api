
# agroconnect-fms-api
# 🌾 AgroConnect – FMS REST API

This is the **Farm Management System (FMS)** backend service of the **AgroConnect** platform, designed using **Spring Boot**, **Redis OM**, **RabbitMQ**, and **PostgreSQL**. It exposes a set of RESTful APIs to manage farmers, plots, crops, and farming activities.

---

## 📦 Tech Stack

- **Spring Boot 3.x**
- **Spring Data JPA + PostgreSQL**
- **Redis OM for Java** (Document-based caching and search)
- **RabbitMQ** (for async messaging/events)
- **OpenAPI/Swagger** (API documentation)
- **Maven** (build tool)
- **RedisInsight** or **Redis Cloud** (to visualize Redis data)

---

## 🗂️ Project Structure

```
fms-api/
├── src/
│   ├── main/
│   │   ├── java/com/agroconnect/fms_api/
│   │   │   ├── controller/        <-- REST APIs
│   │   │   ├── service/           <-- Business logic interfaces
│   │   │   ├── service/impl/      <-- Implementation logic
│   │   │   ├── repository/        <-- Spring Data JPA + Redis OM Repositories
│   │   │   ├── model/             <-- JPA & Redis OM Entities
│   │   │   ├── dto/               <-- API request/response DTOs
│   │   │   ├── mapper/            <-- (Optional) DTO/entity mappers
│   │   │   ├── config/            <-- App, Redis, RabbitMQ, Swagger config
│   │   │   ├── messaging/         <-- RabbitMQ producers & consumers
│   │   │   ├── cache/             <-- Redis OM integration services
│   │   │   ├── event/             <-- Event models / domain events
│   │   │   ├── exception/         <-- Exception handling
│   │   │   └── FmsApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── rabbitmq-config.json (optional)
│   └── test/java/com/agroconnect/fms_api/
│       ├── integration/
│       ├── controller/
│       └── service/
└── pom.xml
```

---

## ⚙️ How to Run

### 📌 Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL database
- Redis Stack or Redis Cloud
- RabbitMQ instance

### 🛠️ Steps

```bash
# Clone the repo
git clone https://github.com/your-org/agroconnect-fms-api.git
cd agroconnect-fms-api

# Set environment variables or edit application.properties

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

---

## 🚀 Features

- Farmer onboarding & crop planning
- Plot & land mapping
- Integration with Redis for caching/search
- Publish events to RabbitMQ for decoupled workflows
- Swagger documentation for all endpoints
- Modular, testable architecture
- Supports Spring Profiles (e.g., `dev`, `prod`)

---

## 📚 API Documentation

Swagger UI:  
- http://localhost:8080/swagger-ui.html  
- http://localhost:8080/swagger-ui/index.html

---

## 📂 Modules Coming Next

- Integration with Warehouse & Buyer subsystem
- Audit & activity logs
- Role-based authentication (JWT)
- API Gateway routing

---

## 🤝 Contributing

1. Fork this repo
2. Create a new branch `feature/your-feature-name`
3. Submit a PR

---

## 📜 License

MIT License – © 2025 AgroConnect Dev Team
