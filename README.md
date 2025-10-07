# MAD204-ASSIGNMENT1-PARTA-IshmeetSingh
Assignment 1 - People Management System by Ishmeet Singh (A00202436)

# MAD204 – Assignment 1 (Part A)  
**Java OOP Console Application**  
**Author:** Ishmeet Singh  
**Student ID:** A00202436  
**Course:** F2025 MAD204-01 Java Development for MA  
**Professor:** Nevin James  
**Date:** October 2025  

---

## Project Overview
This project is a **People Management System** developed in Java.  
It demonstrates the use of **Object-Oriented Programming (OOP)** concepts such as inheritance, polymorphism, abstraction, and interfaces.  
The program provides a **menu-driven console interface** that allows users to manage and evaluate information about Students, Professors, and Teaching Assistants.

---

## Object-Oriented Design

| Class / Interface | Description |
|--------------------|-------------|
| **Person (abstract)** | Base class containing `id`, `name`, `age`, and methods like `introduce()` and `celebrateBirthday()`. |
| **Student** | Subclass of Person with additional fields `program`, `year`, and `GPA`; overrides `introduce()`. |
| **Professor** | Subclass of Person with fields `department` and `title`; overrides `introduce()`. |
| **TeachingAssistant** | Extends Student and adds `assignedCourse`; overrides `introduce()` and implements evaluation. |
| **Evaluable (interface)** | Defines `evaluatePerformance()` method implemented by subclasses. |
| **Main.java** | Contains menu logic, user interaction, file I/O, validation, and recursion examples. |

---

## Features
- Add new people (Student, Professor, Teaching Assistant)  
- Display list of all people  
- Search by ID or Name (using method overloading)  
- Remove person by ID  
- Celebrate birthday (increment age)  
- Evaluate performance (`Evaluable` interface)  
- Demonstrate recursion (e.g., factorial or countdown)  
- File I/O for saving and loading data  
- Input validation and exception handling  
