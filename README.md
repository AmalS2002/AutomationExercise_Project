Automation Exercise Project
 Project Overview

This project is an automated testing framework developed to test the website:

🔗 https://automationexercise.com

The framework is built using Selenium WebDriver, TestNG, and Maven, following the Page Object Model (POM) design pattern to ensure scalability and maintainability.

 ->Tech Stack

Java

Selenium WebDriver

TestNG

Maven

Allure Reports

->Project Structure
AutomationExercise_Project
│── src/main/java
│── src/test/java
│── pom.xml
│── testng.xml
│── README.md

pages → Contains Page Object classes

tests → Contains Test Classes

utils → Contains reusable utilities

base → WebDriver setup & configuration

 How to Run the Project

->Clone the repository:

git clone https://github.com/YourUsername/AutomationExercise_Project.git

Open the project in IntelliJ IDEA

Run using:

testng.xml
or

mvn clean test

 ->Reporting

Allure Report is integrated to generate detailed execution reports.

To generate report:

allure serve allure-results
 ->Test Scenarios Covered

User Registration

Login / Logout

Product Search

Add to Cart

Checkout Process

Form Validation

 ->Author

 Amal Sayed
QA Engineer
Faculty of Engineering – Communications & Electronics

