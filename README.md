# RedBus Selenium UI Automation Framework

## Project Overview

This project is a robust end-to-end UI automation framework for the RedBus platform built using Selenium WebDriver, Java, TestNG, and Cucumber (BDD).

The framework automates multiple real-world functionalities of the RedBus application including:

* Bus Ticket Booking
* Train Ticket Booking
* Food Ordering
* Hotel Booking
* User Account Management

It is designed using Page Object Model (POM) for scalability and maintainability, along with data-driven testing using Excel.

---

## Tech Stack

* Programming Language: Java
* Automation Tool: Selenium WebDriver
* Test Framework: TestNG
* BDD Framework: Cucumber
* Build Tool: Maven
* Design Pattern: Page Object Model (POM)
* Data Handling: Apache POI (Excel integration)

---

## Project Structure

```
Redbus_Selenium_UI_Framework
│
├── src/main/java
│   ├── pages
│   │   └── Page Object Model classes (UI interactions)
│   │
│   └── utilities
│       └── Reusable utilities (Excel reader, waits, helpers)
│
├── src/test/java
│   ├── stepdefinition
│   │   └── Cucumber step definitions
│   │
│   ├── featurefile
│   │   └── Feature files (BDD scenarios)
│   │
│   └── runner
│       └── Test runner classes
│
├── testng.xml
│   └── TestNG suite configuration
│
└── pom.xml
    └── Maven dependencies
```

---

## Modules and Test Coverage

### Bus Booking Module

This module automates the complete bus booking workflow:

* Search buses using source, destination, and date
* Swap source and destination functionality
* Validate negative scenarios:

  * Empty search fields
  * Same source and destination
* Select bus from search results
* Seat selection with handling of:

  * Available seats
  * Gender-reserved seats (male/female)
* Select boarding and dropping points
* Enter passenger details
* Navigate to payment page

---

### Train Ticket Booking Module

Covers train booking and validations:

* Search trains using valid journey details
* Validate invalid scenarios (same source and destination)
* View train route details
* Re-search with updated journey details
* Select train and enter passenger information
* Validate free cancellation popup

---

### Food Ordering Module

Automates food ordering features:

* Search restaurants using dynamic suggestions
* Validate auto-suggestions while typing
* Navigate to restaurant page
* Verify restaurant name and menu
* Search via popular food categories
* Train-based food ordering:

  * Enter train number
  * Select train and boarding details
* Validate dish availability in menu
* Handle invalid inputs and no-results scenarios

---

### Hotel Booking Module

Validates hotel booking functionality:

* Navigate to Hotels section
* Search hotels using Excel-driven data
* Select check-in and check-out dates
* Configure rooms, adults, and children
* Validate mandatory child age selection
* Apply filters:

  * Price range
  * Customer rating
  * Meal preference
* Verify filtered results and hotel count
* Validate Flash Deals interaction and popup behavior

---

### Accounts Module

Focuses on user account-related features:

* Login using saved session (cookies handling)
* Navigate to bookings and profile
* Edit profile details:

  * Name
  * Email
  * Gender
* Verify profile updates
* Navigate to Offers and validate offer details
* Help section validation:

  * FAQ navigation
  * Category and query selection
* Ticket rescheduling using Excel data
* Ticket cancellation:

  * Valid input
  * Invalid mobile number validation
* Ticket search and RedBuddy chat interaction

---

## Data-Driven Testing

The framework supports data-driven testing using Excel files:

* Hotel booking inputs
* Ticket rescheduling details
* Ticket search data

Handled using Apache POI for reading Excel sheets dynamically.

---

## Key Features

* End-to-End automation across multiple modules
* BDD implementation using Cucumber feature files
* Page Object Model for clean and maintainable code
* Reusable utilities for common operations
* Explicit waits for dynamic web elements
* Handling complex UI interactions:

  * Seat layouts
  * Popups
  * Auto-suggestions
* Negative scenario validation
* Data-driven testing support

---

## How to Run the Project

### 1. Clone the Repository

```
git clone https://github.com/TsTamil5/Redbus_Selenium_UI_Framework.git
```

### 2. Import the Project

* Open in Eclipse or IntelliJ IDEA
* Import as a Maven Project

### 3. Install Dependencies

```
mvn clean install
```

### 4. Execute Tests

* Run using TestNG (testng.xml)
* Or run Cucumber Runner classes

---

## Highlights

* Covers multiple domains in one automation framework
* Combines BDD, POM, and Data-Driven Testing
* Handles real-world UI complexities
* Demonstrates strong automation architecture
* Includes both positive and negative scenarios

---

## Future Enhancements

* Integration with Extent Reports or Allure Reports
* Cross-browser execution
* CI/CD integration (GitHub Actions or Jenkins)
* Parallel test execution

---

## Contributors

* Tamizhselvi
* Mohammed Afreeth
* Pravallika
* Naveen Kumar
* Keerthi

---

## Support

If you found this project useful, consider giving it a star on GitHub.
