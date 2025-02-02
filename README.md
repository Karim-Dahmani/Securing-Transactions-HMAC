# 🚀 Cryptographic Signature API - Spring Boot

## 📌 Description
Cette API REST permet la **signature et la vérification de messages** en utilisant **trois algorithmes cryptographiques** :
- **EdDSA (Ed25519)** – Rapide et sécurisé.
- **ECDSA (secp256r1)** – Utilisé en blockchain et certificats TLS.
- **RSA (2048-bit)** – Compatibilité avec les systèmes existants.

L’API suit une **architecture modulaire** avec les **design patterns Factory, Strategy et Dependency Injection**, respectant les **principes SOLID**.

## 🛠 Technologies utilisées
- **Java 17** + **Spring Boot**
- **Bouncy Castle** (Cryptographie)
- **JUnit & Mockito** (Tests unitaires)
- **Redis** (Optimisation des performances)
- **Docker** (Déploiement)

## 📖 Endpoints API
### 🔹 1. Signer un message
**POST** `/crypto/sign`
```json
{
  "algorithm": "EdDSA",
  "message": "HelloWorld"
}
```
📌 **Réponse :** Signature du message en Base64.

### 🔹 2. Vérifier une signature
**POST** `/crypto/verify`
```json
{
  "algorithm": "EdDSA",
  "message": "HelloWorld",
  "signature": "Base64EncodedSignature"
}
```
📌 **Réponse :** `true` si la signature est valide, sinon `false`.

## 🏗️ Architecture et Design Patterns
- **Factory Pattern** → Sélection dynamique de l’algorithme de signature.
- **Strategy Pattern** → Implémentation de chaque algorithme comme une stratégie indépendante.
- **Dependency Injection (DIP)** → Gestion des services via Spring.

## ✅ Installation et Exécution
1. **Cloner le projet** :
   ```sh
   git clone https://github.com/ton-repo/crypto-api.git
   cd crypto-api
   ```
2. **Construire et exécuter l’API** :
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. **Tester avec Postman** ou `curl`.

## 📌 Améliorations possibles
- 🔹 **Ajout d’un stockage sécurisé pour les clés privées.**
- 🔹 **Support d’autres algorithmes (DSA, ChaCha20).**
- 🔹 **Ajout d’un cache Redis pour optimiser les performances.**

🚀 **Contribuez ou testez l’API et améliorez votre sécurité numérique !**