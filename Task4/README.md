## Currency Converter (Java + API)

This is a small Java project I made to understand how APIs work.
The program basically converts money between USD, INR, and EUR using live exchange rates from the Frankfurter API. Nothing complicated — just a simple console-based tool.

## What the Program Does

Shows a basic menu to choose the type of conversion

Supports USD ⇄ INR and EUR ⇄ INR

Fetches the latest currency rate from the internet

Works using plain Java (no extra libraries)

I mainly built it to practice user input, API calls, and basic Java logic.

## How It Works (in simple words)

You choose the conversion option.

You enter the amount you want to convert.

The program sends a request to this API:

https://api.frankfurter.app/latest?amount=VALUE&from=CURRENCY1&to=CURRENCY2


The API sends back the converted amount.

The program prints the final result.

That’s literally it — nothing fancy.

## Example API Response

This is what the API returns (just for understanding):

{"amount":10,"base":"USD","date":"2025-01-01","rates":{"INR":830.20}}


The program only picks the converted value from this.

## What’s Inside the Code

Scanner → to take user input

If-else conditions → handle different conversion options

convertUsingAPI() method → sends the API request and reads the result

I kept the code as clean and simple as possible so it’s easy to follow.

## How to Run It

Install Java (JDK).

Save the file as currency_converter.java.

Open Terminal/Command Prompt in that folder.

## Run:

javac currency_converter.java
java currency_converter


The converter starts running in the console.

## Output 

<img width="1594" height="680" alt="Screenshot 2025-12-08 132507" src="https://github.com/user-attachments/assets/fccde4d9-4447-4db6-ab93-54904dfb342c" />


Make sure your internet is ON ⚡
The program needs internet to fetch real-time exchange rates.
