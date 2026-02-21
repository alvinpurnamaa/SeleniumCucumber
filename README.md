# Web UI Automation Framework  
Automation testing framework menggunakan **Cucumber (BDD)**, **Selenium WebDriver**, **Java**, dan **Gradle**.

---

## 📌 Overview

Project ini merupakan implementasi framework automation testing untuk pengujian UI Web dengan pendekatan **Behavior Driven Development (BDD)** menggunakan Cucumber.

Framework ini menggunakan:
- Java sebagai bahasa pemrograman
- Selenium WebDriver untuk otomasi browser
- Cucumber untuk penulisan test berbasis Gherkin
- JUnit 5 sebagai test runner
- Gradle sebagai build tool

Framework ini menerapkan **Page Object Model (POM)** untuk menjaga struktur kode tetap rapi, modular, dan mudah dirawat.

## 🏗️ Project Structure

project-root
├── build.gradle
├── README.md
└── src
└── test
├── java
│ └── com/alvin
│ ├── pages
│ ├── stepdef
│ └── CucumberTest.java
└── resources
└── features
└── login.feature
