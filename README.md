# 🗳️ VoteGuard – Secure & Reliable E-Voting Platform

## 📌 Technologies
Java 17 · JSP · Servlets · MySQL · Bootstrap 5 · Tomcat 10

---

## 🚀 Project Overview

**VoteGuard** is a secure and resilient e-voting web application that:

- Verifies voter's identity using **Aadhaar** and **Voter ID**
- Performs **biometric thumb verification**
- Prevents **duplicate voting**
- Records votes securely in a **MySQL** database

Built using **Java Servlets**, **JSP**, and **Bootstrap 5**, it provides a complete flow from user verification to vote submission and result display.

---

## 🔐 Key Features

- ✅ Dual verification using Aadhaar & Voter ID  
- ✅ Biometric (Thumb) verification simulation  
- ✅ Duplicate voting prevention via VoteLog  
- ✅ Live vote result tracking  
- ✅ Clean, responsive UI using Bootstrap 5  
- ✅ Full MySQL integration with Java backend  

---

## 🧩 Project Modules

| Component                     | Description                                      |
|------------------------------|--------------------------------------------------|
| `index.jsp`                  | Entry page for Aadhaar & Voter ID input         |
| `VerificationServlet.java`   | Validates user identity from DB                 |
| `verifyThumb.jsp`            | Simulates thumb verification                    |
| `ThumbVerificationServlet.java` | Processes thumb verification                  |
| `voterDetails.jsp`           | Displays user info before voting                |
| `vote.jsp`                   | Voting interface with candidate list            |
| `VoteServlet.java`           | Records the vote & prevents duplicates          |
| `results.jsp`                | Displays real-time voting results               |
| `ResultServlet.java`         | Fetches and updates result from DB              |
| `DBUtil.java`                | Database utility class (connectivity & queries) |

---

## 🗃️ Database Schema

**Database:** `VoteGuardDB`

### Tables:
- `AadharCard` – Stores Aadhaar details with thumb info  
- `VoterCard` – Links Aadhaar to Voter ID with name, DOB, gender  
- `VoteLog` – Tracks voter ID or Aadhaar to prevent duplicates  

---

## ⚙️ Installation & Setup

### 🔧 Clone the Repository

```bash
git clone https://github.com/omkarsnagre/VoteGuard.git
cd VoteGuard
```
🧱 Prerequisites
- Java 17
- Apache Tomcat 10
- MySQL 8+
- Maven

⚙️ Build & Deploy
1. Open the project in VS Code or Eclipse as a Maven Web Project.
2. Update `DBUtil.java` with your MySQL database credentials.
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Deploy the generated WAR file to your Tomcat server.
5. Start Tomcat and access the app at:
   ```
   http://localhost:8080/VoteGuard/
   ```

🧪 Testing Scenarios
| Scenario                          | Expected Outcome                      |
|----------------------------------|----------------------------------------|
| ✅ Valid Aadhaar + Voter ID + Thumb | Voter proceeds to cast vote           |
| ❌ Invalid Aadhaar or Voter ID     | Access denied with error              |
| ❌ Already voted user              | Vote denied (duplicate prevention)    |

👁️ Real-time Results
- Cast multiple votes (with different IDs)
- Visit `results.jsp` to see live tally of votes per candidate

🗂️ Folder Structure
```
VoteGuard/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/voteguard/
│       │       ├── model/               # Aadhar.java, Voter.java, Vote.java
│       │       ├── dao/                 # DBUtil.java
│       │       ├── servlet/             # ThumbVerificationServlet, VoteServlet, ResultServlet
│       │       └── auth/                # VerificationServlet.java
│       └── webapp/
│           ├── index.jsp
│           ├── verifyThumb.jsp
│           ├── vote.jsp
│           ├── voterDetails.jsp
│           ├── results.jsp
│           └── WEB-INF/
│               └── web.xml
├── pom.xml
```

📩 Contact
- 💻 Developed by: **Omkar Nagre**
- 📧 Email: omkarnagre777@gmail.com
- 🔗 GitHub: [omkarsnagre](https://github.com/omkarsnagre)

📜 License
This project is **open-source** and available for **academic, educational, and non-commercial** use.

