# 🚕 TMUber-UI – Console-Based Ride & Delivery System

> **Java console simulation** of an Uber‑style platform with users, drivers, rides, and deliveries, built around a simple city map and a menu‑driven terminal UI. 

[![Java](https://img.shields.io/badge/Java-Console%20App-red?style=for-the-badge&logo=coffeescript)](https://www.oracle.com/java/)  
[![CLI](https://img.shields.io/badge/Interface-Command%20Line-blue?style=for-the-badge&logo=terminal)]()  

---

## 🎯 Overview

TMUber is a Java application that simulates core concepts of a ride‑hailing and delivery platform directly in the terminal. It models **users, drivers, rides, deliveries, and services** and coordinates them through a text‑based UI and a simple in‑memory system manager. 

The project is implemented across multiple classes such as `TMUberSystemManager`, `TMUberService`, `TMUberRide`, `TMUberDelivery`, `User`, `Driver`, `CityMap`, and `TMUberUI`, all written in Java. 

---

## 🏗️ Architecture

```text
┌───────────────────────┐
│       User (CLI)      │
│  - Text menu          │
│  - Console input      │
└───────────┬───────────┘
            │
            ▼
     ┌───────────────┐
     │  TMUberUI     │
     │ (Menus, I/O)  │
     └──────┬────────┘
            │
            ▼
┌──────────────────────────────┐
│      TMUberSystemManager     │
│  - Manages users, drivers    │
│  - Creates rides/deliveries  │
│  - Delegates to services     │
└───────────┬────────────┬─────┘
            │            │
            ▼            ▼
    ┌─────────────┐  ┌─────────────┐
    │ TMUberRide  │  │ TMUberDelivery │
    │  + Service  │  │  + Service     │
    └─────────────┘  └───────────────┘
            │
            ▼
      ┌───────────┐
      │  CityMap  │
      │ Locations │
      └───────────┘
```

- **`TMUberUI`** handles menu rendering and reading user input from the terminal.   
- **`TMUberSystemManager`** is the core orchestrator that coordinates users, drivers, rides, deliveries, and services.   
- **`TMUberRide`, `TMUberDelivery`, and `TMUberService`** represent domain objects for trips, packages, and offerings.   
- **`User`, `Driver`, and `CityMap`** model the people and environment in which the simulation runs. 

---

## 🧩 Key Features

- ✅ **Menu‑driven terminal UI** to interact with the system via `TMUberUI`.   
- ✅ **User and driver modeling** via `User.java` and `Driver.java`.   
- ✅ **Ride and delivery flows** through `TMUberRide.java` and `TMUberDelivery.java`.   
- ✅ **Central system manager** in `TMUberSystemManager.java` that coordinates all entities.   
- ✅ **City map abstraction** via `CityMap.java` for locations and routes in the simulation. 

---

## 🛠️ Tech Stack

| Category     | Details          |
|-------------|------------------|
| Language    | Java             |
| Interface   | Command‑line UI  |
| Structure   | Multiple domain and manager classes  |

---

## 📁 Project Files

```text
TMUber/
├── CityMap.java             # City/location representation 
├── Driver.java              # Driver entity 
├── TMUberDelivery.java      # Delivery flow logic 
├── TMUberRegistered.java    # Registered user / entity logic 
├── TMUberRide.java          # Ride flow logic 
├── TMUberService.java       # Services provided by TMUber 
├── TMUberSystemManager.java # Central system manager 
├── TMUberUI.java            # Console UI and menus 
├── User.java                # User entity 
└── README.md                # Project documentation
```

This layout mirrors a small but complete **object‑oriented Java console application**. 

---

## ⚙️ How to Run

1. **Clone the repository**  
   ```bash
   git clone https://github.com/Neel654/TmUber.git
   cd TmUber
   ```

2. **Compile the Java files** (using `javac`):  
   ```bash
   javac *.java
   ```

3. **Run the main UI class**  
   The entry point is the class that starts the console menu (for example `TMUberUI`):  
   ```bash
   java TMUberUI
   ```

   You’ll see a text menu in your terminal where you can create users, register drivers, and simulate rides/deliveries depending on how the UI is implemented. 

---

## 💡 Suggested Improvements

If you want to evolve this from a course‑style project into a portfolio‑ready 
