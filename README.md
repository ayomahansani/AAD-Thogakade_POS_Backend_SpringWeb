
# THOGAKADE  POS  BACKEND  API - (Spring version)

This project is a backend API for a Point of Sale (POS) system for a retail shop(thogakade). It enables the management of customers, items, orders and order details. Built with Spring and utilizing a MySQL database for data storage, this API provides a robust solution for retail environments.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [API Documentation](#api-documentation)
- [Database Structure](#database-structure)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- **User Management**: Users can sign up and sign in to the system using username and password.
- **Customer Management**: Create(add), read(view), update, and delete (CRUD) operations for customers.
- **Item Management**: Create(add), read(view), update, and delete (CRUD) operations for items.
- **Order Management**: Create(add), read(view), and delete orders.

## Technologies Used

- **Java EE (Jakarta EE)**
- **Spring Framework**
- **MySQL Database**
- **Hibernate**
- **Spring Data JPA**
- **Log4j for logging**

## Setup

1. Clone the repository
- Frontend - https://github.com/ayomahansani/AAD-Thogakade_POS_Frontend_SpringWeb.git
- Backend - https://github.com/ayomahansani/AAD-Thogakade_POS_Backend_SpringWeb.git
2. Set up the MySQL database and configure the application properties for database connection.
3. Run the Spring  application.

## API Documentation

For comprehensive API documentation, please refer to the following link:

[API Documentation](https://documenter.getpostman.com/view/36195888/2sAXxTcB6o)

## Database Structure

The system includes the following main entities:

- **customer**: Stores customer's information.
- **item**: Stores item's information.
- **orders**: Stores details of customer and orders .
- **orderDetails**: Stores details of orders and associated items.

## Usage

- **Users**: Handle user accounts (create(signup), login(signin)).
- **Customers**: Manage customer information.
- **Items**: Add, view, update, and delete items.
- **Orders**: Add, view and delete orders made by customers.

## Contributing

Feel free to contribute to this project by submitting a pull request or opening an issue.

## License

This project is licensed under the MIT License.
