# Contact App

## Objective
Console based Java application to manage contacts stored in a text file, using advanced exception-handling techniques.

## Features
- Add contacts to a file.
- Prevent adding duplicate contacts with meaningful error messages
- Displays all saved contacts.
- Find a contact by name.

## Technical Highlights
- Uses Unchecked Exceptions for data validation.
- Implements custom checked exceptions for business rules.
- Applies Try-with-Resources for safe file I/O operations.
- Implements a Centralized Exception Handler for clean error management.


# MVC 
MVC (Model-View-Controller) is a software design pattern that separates an application into three main components: Model, View, and Controller.

This separation makes the application easier to manage, maintain and extend (adding new features).

## Components
1. Model

    Represents the data and the business logic of the application. 

    It is responsible for managing data, applying rules, and maintaining the application state.
2. View

   Displays the data from the Model to the user and sends user input to the Controller.
3. Controller

    It acts as an intermediary between the Model and the View. 

    It processes user input, invokes operations on the Model, and updates the View.

## Pros
- Keeps the code organized and structured.
- Improves maintainability and readability.
- Makes it easier to add new features.
- Simplifies testing.
- Enables better separation of concerns for user interfaces

## MVC Workflow

User → View → Controller → Model → View
                