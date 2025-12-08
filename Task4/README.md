## Currency Converter (Java + API)

A simple beginner-friendly currency converter program written in Java.
This program allows users to convert money between USD, INR, and EUR using real-time exchange rates fetched from an online API.

## Features

✔ Menu-based program (easy for beginners)
✔ Converts between:

USD → INR

INR → USD

EUR → INR

INR → EUR

✔ Fetches live exchange rates using Frankfurter API
✔ Simple and readable code
✔ No external libraries required
✔ Internet connection required for API call

## How It Works

User selects a conversion option from the menu

User enters the amount

Program sends a request to the API:

https://api.frankfurter.app/latest?amount=VALUE&from=CURRENCY1&to=CURRENCY2


API responds with real-time conversion value

Program displays the converted amount

Example API response:

{"amount":10,"base":"USD","date":"2025-01-01","rates":{"INR":830.20}}

## Code Explanation 
✔ Scanner

Used to get user input (choice, amount).

✔ if-else

Used for choosing the correct conversion type.

✔ convertUsingAPI()

This method:

Builds the API URL

Connects to the API

Reads the response

Extracts the converted amount

Returns the value

This keeps the main program clean and easy to understand.

## How to Run the Program

Install Java JDK (if not installed)

Save the file as:

currency_converter.java


Open Terminal / CMD in the file location

## Compile the program:

javac currency_converter.java


## Run the program:

java currency_converter

## Output 

<img width="1594" height="680" alt="Screenshot 2025-12-08 132507" src="https://github.com/user-attachments/assets/fccde4d9-4447-4db6-ab93-54904dfb342c" />


Make sure your internet is ON ⚡
The program needs internet to fetch real-time exchange rates.
