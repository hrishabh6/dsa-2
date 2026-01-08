# DSA Solutions in Java

A collection of Data Structures and Algorithms (DSA) solutions implemented in Java, organized by topic and difficulty.

## 🚀 Overview

This repository contains well-documented Java solutions to various competitive programming and technical interview problems. Topics covered include Arrays, Binary Search, Sliding Window, Greedy Algorithms, Linked Lists, Stacks, and more.

## 🛠️ Tech Stack

- **Language:** Java
- **Build System:** IntelliJ IDEA (project configuration included)
- **Automation Scripts:** Shell (Bash), Node.js

## 📁 Project Structure

The project follows a hierarchical structure based on problem categories and difficulty levels:

```text
src/
├── arrays/
│   ├── easy/
│   ├── medium/
│   └── hard/
├── binary_search/
│   ├── bs_on_1d_arrays/
│   ├── bs_on_2d/
│   └── bs_on_answers/
├── greedy/
├── linked_list/
│   ├── basics/
│   ├── medium/
│   └── hard/
├── SlidingWindow/
├── Stack/
│   ├── Basics/
│   ├── Leetcode/
│   ├── Monotonic/
│   └── Postfix/
├── strings/
├── bitwise/
└── SQL/
```

## ⚙️ Setup & Usage

### Prerequisites

- Java Development Kit (JDK) 8 or higher.
- (Optional) Node.js (for automation scripts).
- (Optional) Bash-compatible terminal (for organization scripts).

### Running a Solution

Each Java file contains a `main` method with test cases. To run a specific solution:

1. **Compile:**
   ```bash
   javac src/category/difficulty/ClassName.java
   ```

2. **Run:**
   ```bash
   java -cp src src.category.difficulty.ClassName
   ```

*Note: Replace `category`, `difficulty`, and `ClassName` with the actual path and filename.*

## 📜 Scripts

### 1. Code Organization (`organize_dsa.sh`)
This Bash script automates the creation of the project structure and populates it with template solutions.
- **Usage:** `./organize_dsa.sh`

### 2. Git Automation (`script.js`)
A Node.js utility to quickly stage, commit, and push changes to the remote repository.
- **Usage:**
  ```bash
  node script.js -m "Your commit message"
  ```

## 🧪 Testing

Testing is currently handled via `main` methods within each solution file. These methods include sample test cases and print the results to the console.

## 📝 TODOs

- [ ] Add unit tests using JUnit.
- [ ] Document missing solutions.
- [ ] Add more complex data structures like Trees and Graphs.
- [ ] Determine and add a LICENSE file.

## 📄 License

TODO: Add license information.
