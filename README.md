# Java Game Project

This Java project is a game that employs various design patterns to ensure a robust and maintainable codebase. The game involves heroes, arenas, coins, and walls.

## Project Structure

- **Application.java**: The main entry point of the application.
- **Arena.java**: Represents the game arena where the action takes place.
- **Coin.java**: Represents a coin in the game.
- **Game.java**: Manages the game logic.
- **Hero.java**: Represents a hero character in the game.
- **Position.java**: Represents the position of objects within the game arena.
- **Wall.java**: Represents a wall within the game arena.

## Design Patterns Used

### Singleton Pattern
The Singleton pattern is used to ensure that certain classes have only one instance throughout the application's lifecycle. This pattern is used for managing shared resources or configurations. In this project, the `Game` class might use the Singleton pattern to ensure there is only one game instance managing the game logic.

### Factory Pattern
The Factory pattern is used to create objects without specifying the exact class of object that will be created. This is useful for managing different types of game objects like `Hero`, `Coin`, and `Wall` without changing the client code.

### Strategy Pattern
The Strategy pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable. This pattern allows the algorithm to vary independently from clients that use it. In this project, different movement strategies for the `Hero` character might be implemented using the Strategy pattern.

### Observer Pattern
The Observer pattern is used to create a subscription mechanism to allow multiple objects to listen and react to events or changes in state. This can be used in the game to notify different parts of the program when certain events happen, such as when a coin is collected or a hero collides with a wall.

## Prerequisites

- JDK 8 or higher

## Getting Started

### Compile
- javac *.java
### Run 
- java Application.java
