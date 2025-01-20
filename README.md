# Secure Digital Transactions with HMAC

This project demonstrates how to secure digital transactions using **HMAC (Hash-Based Message Authentication Code)** in a Spring Boot application. It includes endpoints for generating secret keys, signing transaction data, and verifying digital signatures to ensure the integrity and authenticity of sensitive data.

## Features

- **Generate Secret Keys:** Dynamically generate secure keys for signing data.
- **Sign Transactions:** Create HMAC signatures for transaction details.
- **Verify Signatures:** Validate the authenticity and integrity of signed transactions.
- **REST API Integration:** Expose endpoints to interact with the system.
- **Lightweight Security:** Use cryptography to secure sensitive operations efficiently.

---


## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:
- **Java 17 or later**
- **Maven**
- **Postman** (optional, for testing the APIs)

---

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Karim-Dahmani/Securing-Transactions-HMAC.git
   cd Securing-Transactions-HMAC
   
## Project Structure
src
├── main
│   ├── java
│   │   ├── com.example.digitalsignature
│   │   │   ├── controller
│   │   │   │   └── HMACController.java
│   │   │   ├── dto
│   │   │   │   └── TransactionRequest.java
│   │   │   ├── util
│   │   │   │   └── HMACUtil.java
│   │   │   └── DigitalSignatureApplication.java
│   ├── resources
│   │   └── application.properties
├── test
└── README.md

### Notes:
- https://medium.com/@dahmanimohammedkarim/securing-financial-transactions-with-hmac-implementation-and-api-with-spring-boot-f0fc9c520904.

