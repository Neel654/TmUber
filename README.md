# 🚕 TMUber-UI – Console-Based Ride & Delivery System

A Java-based command-line simulation of an Uber-style ride and delivery platform featuring users, drivers, rides, deliveries, and a city map system managed through a menu-driven terminal interface.

[![Java](https://img.shields.io/badge/Java-Console%20Application-red?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/) [![CLI](https://img.shields.io/badge/Interface-Command%20Line-blue?style=for-the-badge&logo=gnubash)]() [![OOP](https://img.shields.io/badge/Architecture-Object%20Oriented-green?style=for-the-badge)]() [![Simulation](https://img.shields.io/badge/System-Ride%20Simulation-orange?style=for-the-badge)]()

---

## 🎯 Project Overview

TMUber-UI is a console-based Java application that simulates the core workflow of a ride-sharing and delivery platform similar to Uber.

The system models:
- Users
- Drivers
- Ride requests
- Delivery services
- City map locations
- Service management workflows

The project demonstrates object-oriented software design using multiple interacting Java classes coordinated through a centralized system manager and a terminal-based user interface.

---

## ✨ Key Capabilities

- ✅ **Menu-driven command-line interface** for interacting with the system
- ✅ **Ride request simulation** with users and drivers
- ✅ **Delivery service workflows** for package transportation
- ✅ **Centralized system management** using a dedicated manager class
- ✅ **Object-oriented architecture** with reusable domain entities
- ✅ **City map abstraction** for location and routing simulation

---

## 🏗️ Architecture

```text
┌────────────────────────┐
│      User (CLI)        │
│   Terminal Commands    │
└────────────┬───────────┘
             │
             ▼
┌────────────────────────┐
│       TMUberUI         │
│   Menu & Input Layer   │
└────────────┬───────────┘
             │
             ▼
┌──────────────────────────────┐
│    TMUberSystemManager       │
│------------------------------│
│ • User Management            │
│ • Driver Management          │
│ • Ride Coordination          │
│ • Delivery Coordination      │
└───────┬───────────────┬──────┘
        │               │
        ▼               ▼
┌──────────────┐ ┌────────────────┐
│ TMUberRide   │ │ TMUberDelivery │
│ Ride Logic   │ │ Delivery Logic │
└──────┬───────┘ └────────┬───────┘
       │                  │
       └────────┬─────────┘
                ▼
        ┌──────────────┐
        │   CityMap    │
        │ Locations &  │
        │ Route Logic  │
        └──────────────┘
```

The application follows a layered object-oriented structure where the UI communicates with the central system manager, which coordinates ride and delivery services across the simulation.

---

## 🛠️ Technology Stack

| Layer | Technology |
|---|---|
| **Language** | Java |
| **Architecture** | Object-Oriented Programming |
| **Interface** | Command-Line Interface (CLI) |
| **Execution** | Java Runtime Environment |
| **Design Style** | Multi-class modular application |

---

## 📁 Project Structure

```text
TMUber/
├── CityMap.java              # City and location representation
├── Driver.java               # Driver entity model
├── TMUberDelivery.java       # Delivery service logic
├── TMUberRegistered.java     # Registered entity handling
├── TMUberRide.java           # Ride service logic
├── TMUberService.java        # Shared service abstraction
├── TMUberSystemManager.java  # Central application manager
├── TMUberUI.java             # Console UI and menus
├── User.java                 # User entity model
└── README.md                 # Project documentation
```

### Core Components

- **`TMUberUI`** — Handles terminal menus and user interaction
- **`TMUberSystemManager`** — Coordinates all platform operations
- **`TMUberRide`** — Manages ride simulation workflows
- **`TMUberDelivery`** — Handles delivery request workflows
- **`User` & `Driver`** — Domain entities for participants
- **`CityMap`** — Represents locations and movement logic

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 17+
- Terminal or command prompt

### Installation & Setup

1. **Clone the repository**
```bash
git clone https://github.com/Neel654/TmUber.git
cd TmUber
```

2. **Compile the Java source files**
```bash
javac *.java
```

3. **Run the application**
```bash
java TMUberUI
```

4. **Interact through the terminal**
- Create users
- Register drivers
- Simulate rides
- Simulate deliveries
- Manage platform operations

---

## 🔄 System Workflow

### Ride & Delivery Lifecycle

1. User interacts with the terminal menu
2. `TMUberUI` captures commands and input
3. `TMUberSystemManager` processes requests
4. Ride or delivery services are created
5. Drivers and users are coordinated
6. City map logic manages simulated movement

---

## 📌 Project Highlights

### Software Engineering Focus
- Object-oriented design principles
- Multi-class Java application structure
- Centralized system orchestration
- Reusable service abstractions

### Simulation Features
- Ride request workflows
- Delivery request workflows
- Driver-user coordination
- Location-based simulation

### Development Skills Demonstrated
- Java class design
- CLI application development
- State and entity management
- System coordination architecture

---

## 💡 Why This Project Stands Out

Unlike a small single-file console application, TMUber-UI demonstrates:
- Structured object-oriented architecture
- Domain-driven modeling
- Multi-entity coordination
- Real-world inspired simulation logic

The project reflects practical understanding of how larger Java systems organize services, entities, and interaction layers.

---

## 🧠 Learning Outcomes

This project demonstrates practical experience with:
- Object-oriented programming in Java
- Multi-class application architecture
- Console-based UI development
- Entity and workflow modeling
- System coordination and abstraction
- Java application compilation and execution

---

## 🚀 Suggested Improvements

Potential future enhancements:
- GUI-based interface using JavaFX or Swing
- Persistent storage with SQL databases
- Real route calculation algorithms
- Driver matching optimization
- Authentication and account systems
- REST API backend integration

---

## 📄 Resume-Ready Description

- Built a Java-based Uber-style ride and delivery simulation system featuring object-oriented architecture, terminal-based UI workflows, centralized service management, and city-map-based ride coordination.

---

## 👤 Author

**Neel Prajapati**  
Computer Science Student @ Toronto Metropolitan University

---

⭐ Feel free to explore the repository, contribute improvements, or fork the project!
