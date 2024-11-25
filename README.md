# KhataBook

## Overview
The **KhataBook** is designed to simplify shopkeepers' daily operations, allowing them to manage users, track transactions, and receive notifications for pending payments. The app is built with a clean and intuitive interface for ease of use.

---

## Features

### **User Management**
- Add new users with:
  - Name
  - Mobile number
  - Address
  - Date & time (auto-captured).
- Perform CRUD operations: View, update, and delete user entries.
- Display a list of all users.

### **Transaction Management**
- Create transactions with:
  - Date & time: Automatically captured.
  - Amount: Input by the user.
  - Title: Short description of the transaction.
  - Detailed description of the transaction.
  - Type: Credit (incoming) or Debit (outgoing).
  - User association: Select the user linked to the transaction.
  - Next payment date: Required for debit transactions.
- Perform CRUD operations: View, update, and delete transaction entries.
- Highlight today's transactions on the home screen:
  - Credit transactions in **green**.
  - Debit transactions in **red**.
- Display total credit and debit amounts on the home screen.

### **Notification Management**
- Notify users with pending debit payments due today.
- Direct options to:
  - Call the user for payment reminders.
  - Send an SMS for recovery.

---

## Tech Stack
- **Frontend**: XML-based UI components
- **Backend**: Kotlin
- **Database**: Room Database for secure local data storage.
- **Build System**: Gradle

---

## Screenshots
Add screenshots to visualize the app's key functionalities:
1. **Home Screen**:
   - Displays today's transactions.
   - Summary of total credit and debit amounts.
2. **User Management Screen**:
   - List of users with options to add, edit, or delete entries.
3. **Transactions Screen**:
   - List of transactions with details and CRUD options.
   - Color-coded transaction types.
4. **Notifications Screen**:
   - Pending payments with call and SMS options.

---

## Usage

### **1. Home Screen**
- View a summary of total credit and debit amounts.
- Check today's highlighted transactions with color indicators.

### **2. User Management**
- Add, edit, or delete user entries.
- View a list of all users and their details.

### **3. Transactions**
- Add, edit, or delete transactions.
- Filter transactions and highlight those occurring today.

### **4. Notifications**
- View users with pending debit payments.
- Call or SMS users directly from the notification screen.
