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
