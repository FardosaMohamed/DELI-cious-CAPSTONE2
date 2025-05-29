# 🥪 DELI-cious Sandwich Ordering App

A fun and interactive Java console application that lets users create custom sandwich orders or choose from delicious signature sandwiches like the **BLT** or **Philly Cheese Steak**. Generate receipts and customize your toppings — all from your terminal!

---

## 🚀 Features

- 🥪 Build-your-own or select from **signature sandwiches**
- 🧀 Add/remove/view toppings interactively
- 🥤 Add drinks and 🍟 chips to your order
- 💰 Calculate total order cost
- 🧾 Save receipt to a `receipts/` folder with timestamp
- 🌐 Case-insensitive menu options

---

## 📸 Screenshots

### 🏠 Home Screen
![image](https://github.com/user-attachments/assets/4c04ccad-987a-4b68-a58a-8a5bfab98076)

### 🥪 Order Builder
![image](https://github.com/user-attachments/assets/2a350dec-e95f-49a9-8bbc-571649766600)

![image](https://github.com/user-attachments/assets/905f6314-c3c4-4dcc-97a8-57665d9a3e95)

![image](https://github.com/user-attachments/assets/8a7e14b0-382e-4b00-9326-e6bead5b718b)

### 📋 Checkout & Receipt
![image](https://github.com/user-attachments/assets/1274b161-aeab-4d5c-a169-27fb436e6668)

![image](https://github.com/user-attachments/assets/e7c91aba-2116-491f-8cb6-242e5012b20c)

## 📈 Diagrams

This project began with the following initial class diagram, which helped guide the early design and structure of the application:

> 🛠️ This diagram was used as a foundation in the early stages. Over time, some classes were added, modified, or removed as the project evolved to support new features and better code organization.

![image](https://github.com/user-attachments/assets/75c7fa2f-b1f8-4004-8b06-8215e1752348)

### 🧭 Flowchart: Build Your Sandwich Journey

To better visualize the user experience, this flowchart was created to outline the sandwich-building process step-by-step — from selecting the sandwich size and bread type, to customizing toppings, adding drinks or chips, and finalizing the order.

![image](https://github.com/user-attachments/assets/f1fc3fad-b475-4abf-8c7f-0176c5720a3f)


## 💡 Interesting Code Highlight

One interesting feature of the app is the ability to customize signature sandwiches using a method that removes specific toppings dynamically by name, even without hardcoding indexes:

```java
// In Sandwich.java
public void removeToppingByName(String name) {
    toppings.removeIf(t -> t.getName().equalsIgnoreCase(name));
}
