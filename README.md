# 🧠 Faintness Project – Microservices-Based Health Monitoring System

A distributed **Microservices-based Health Monitoring Application** designed to detect and manage faintness or dizziness-related activities using modern cloud-native technologies. This project is built using **Spring Boot**, **Spring Cloud**, and **Java 17**, with asynchronous communication powered by **RabbitMQ**, and includes a basic AI-driven suggestion service.

---

## ⚙️ Architecture Overview

This project follows a modular **Microservices Architecture** pattern with independent deployable units for each business capability. Key design patterns used include **Service Registry**, **API Gateway**, and **Circuit Breaker** for fault tolerance.

### 🔧 Core Microservices

| Service Name         | Description                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| 🧍‍♂️ `user-service`        | Manages users, authentication, profile and health data                    |
| 🏃 `activity-service`    | Records user activities, physical movements, and vital stats               |
| 💡 `ai-suggestion-service` | Provides AI-based health tips or actions based on user activity/faintness |
| 📬 `notification-service`  | Sends real-time alerts and messages using RabbitMQ                        |

---

### 📡 Supporting Services

| Service Name        | Description                                                              |
|---------------------|--------------------------------------------------------------------------|
| 🧭 `eureka-server`      | Acts as a **Service Discovery Registry** for dynamic lookup              |
| 🔐 `api-gateway`        | Entry point for all client requests, includes routing and filtering       |
| 🛠️ `config-server`      | Centralized configuration management for all services                   |

---

## 🛠️ Tech Stack

- **Language**: Java 17
- **Frameworks**: Spring Boot 3.5, Spring Cloud
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Configuration**: Spring Cloud Config Server
- **Messaging**: RabbitMQ (asynchronous message queue)
- **Database**: Oracle / MongoDB (depending on the service)
- **Resilience**: Resilience4j Circuit Breaker

---

## 🔁 Key Features

- 📡 **Service Registry**: Eureka Server for discovery and load balancing
- 📬 **Asynchronous Messaging**: Using RabbitMQ for service-to-service communication
- 🧠 **AI Suggestion Engine**: Basic AI logic for detecting abnormal activity and suggesting actions
- 🛑 **Circuit Breaker**: Resilience4j for handling service downtime gracefully
- 🌐 **API Gateway**: Routing, filtering, and external exposure
- 🔐 **Secure Communication** (Optional): JWT-based authentication (planned)

---

## 📁 Project Structure
faintness-project/

│

├── api-gateway/

├── config-server/

├── eureka-server/

├── user-service/

├── activity-service/

├── ai-suggestion-service/

├── notification-service/

├── common-libraries/ (optional shared DTOs or utilities)

└── README.md


---

## 🧪 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven / Gradle
- RabbitMQ running locally or in Docker
- Oracle / MongoDB databases
- (Optional) Docker & Docker Compose

### 🔧 Run Order

1. Start **Eureka Server**
2. Start **Config Server**
3. Start **API Gateway**
4. Start microservices: `user-service`, `activity-service`, `ai-suggestion-service`, `notification-service`
5. Ensure **RabbitMQ** and databases are active
6. Test endpoints via Swagger/Postman

---

## 📬 Messaging Flow (RabbitMQ)

- `activity-service` → publishes activity data
- `ai-suggestion-service` → consumes activity data → processes & suggests tips
- `notification-service` → listens to AI alerts → sends notifications

---

## 🧱 Circuit Breaker Example (Resilience4j)

Used in:
- `api-gateway` and `ai-suggestion-service`  
  Fallbacks and error handling are logged and returned with proper status codes.

---

## 👥 Contribution

1. Fork this repository
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes
4. Push to the branch
5. Open a pull request

---

## 🙋‍♂️ Contact

For queries or contributions, feel free to reach out via [GitHub Issues](https://github.com/your-username/faintness-project/issues).

## To Create or Get Project on your local Plz flow the below instructions 
### 📥 To Create or Get Project on Your Local Machine
Please follow the instructions below to create or clone the repository.

---

### 🔧 Create a New Repository on the Command Line

```bash
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Aman-kumar-1999/FintnessMicroserviceProject.git
git push -u origin main
```
### 🔧 Or Push an Existing Repository from the Command Line

```bash
git remote add origin https://github.com/Aman-kumar-1999/FintnessMicroserviceProject.git
git branch -M main
git push -u origin main

```
