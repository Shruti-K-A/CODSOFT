🌟 ATM Machine – Java Console Application

This project is a simple, beginner-friendly ATM Machine simulation created using Java.
It follows clean Object-Oriented Programming (OOP) concepts and works entirely through a console menu — just like a mini real-world ATM.

The goal of this project is to understand how different classes interact with each other and how everyday banking operations can be coded in an easy, readable manner.

✨ What This ATM Can Do

This ATM program lets the user:

🏦 Check their account balance

➕ Deposit money

➖ Withdraw money (only if enough balance is available!)

❌ Exit safely with a goodbye message

Everything works through a simple number-based menu so even someone new to Java can use it easily.

🧱 Project Structure 

This project uses 3 classes:

🔹 1. ATM Class

The main controller of the program.
It shows the menu, takes user input, and calls the bank operations.

🔹 2. BankAccount Class

Stores the balance and contains the actual deposit and withdrawal logic.

🔹 3. ATMApplication (Main Class)

Creates the ATM object and starts the whole system.

This structure keeps the code clean, modular, and easy to understand.

💡 How the Program Works 

When the program starts, an ATM object is created with a starting balance (₹4000).

The menu appears with options:
Check Balance / Deposit / Withdraw / Exit.

User selects an option.

Based on the choice, ATM calls the corresponding method in the BankAccount class.

Program keeps running until the user chooses to exit.

▶️ How to Run the Program

Make sure Java (JDK) is installed.

Save the file as ATMApplication.java

Open your terminal (or command prompt).

Compile the program:

javac ATMApplication.java


Run it:

java ATMApplication


Enjoy your mini ATM! 
