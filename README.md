# E-Commerce Automation Framework

A Selenium WebDriver automation project developed in Java to automate an e-commerce shopping workflow on the Reliance Digital website.

## Overview

This project automates the complete shopping workflow of an e-commerce website, including product search, filtering, product selection, adding the product to the cart, and validating the product details in the shopping cart.

## Features

- Product search automation
- Product filtering
- Product selection
- Multi-window handling
- Add product to cart
- Cart validation
- Explicit waits
- Maven project structure

## Technologies Used

- Java
- Selenium WebDriver
- Maven
- ChromeDriver
- IntelliJ IDEA

## Project Structure

```
RelianceDigitalAutomationProject
│
├── src
│   └── main
│       └── java
│           └── org
│               └── example
│                   └── pages
│                       └── Selenium.java
│
├── pom.xml
├── .gitignore
└── README.md
```

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or Eclipse.
3. Install Maven dependencies.
4. Ensure Google Chrome is installed.
5. Run `Selenium.java`.

## Automated Workflow

1. Open the Reliance Digital website.
2. Search for "Laptop".
3. Apply the minimum price filter.
4. Open the first product.
5. Switch to the product window.
6. Add the product to the cart.
7. Navigate to the cart.
8. Validate the product name and price.

## Note

This project automates a live website. Since website elements and locators may change over time, some locators may require updates for successful execution.

## Author

Datta Nanduri
