# Linear Algebra Project

A comprehensive Java implementation of linear algebra concepts, created as a learning project combining the study of linear algebra (TMA4115) with object-oriented programming in Java (TDT4100).

## Purpose

This project was created to combine learning linear algebra from the course TMA4115 with learning object-oriented programming in Java from the course TDT4100. The approach taken was to hard-code every little step of the mathematics course, implementing the fundamental concepts and operations of linear algebra as Java classes and methods.

By implementing each mathematical concept and operation step-by-step, this project serves as both a practical application of linear algebra theory and a comprehensive exercise in Java OOP principles.

## Features

- **Matrix Operations**: Addition, multiplication, inversion, and transformation
- **Vector Operations**: Vector arithmetic, dot product, scalar multiplication, and vector space calculations
- **Gaussian Elimination**: Complete implementation with row operations for solving linear systems
- **Equation Solving**: Solve systems of linear equations
- **Vector Projections**: Project vectors onto vector spaces
- **Interactive Game**: Matrix inversion game with timing and leaderboard
- **Comprehensive Testing**: Unit tests for core functionality

## Technologies

- **Java 21**: Core programming language
- **JavaFX 23**: User interface framework
- **Maven**: Build tool and dependency management
- **JUnit 5**: Testing framework

## Repository Structure

```
Linear-algebra-Project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── App/                    # User interface and game logic
│   │   │   │   ├── FileHandler.java
│   │   │   │   ├── Leaderboard.java
│   │   │   │   ├── MatrixBank.java
│   │   │   │   ├── StopWatch.java
│   │   │   │   ├── Task.java
│   │   │   │   └── TaskGenerator.java
│   │   │   ├── fundament/              # Core linear algebra structures
│   │   │   │   ├── AbstractMatrix.java
│   │   │   │   ├── AbstractRow.java
│   │   │   │   ├── Matrix.java
│   │   │   │   ├── RealMatrix.java
│   │   │   │   ├── RealRow.java
│   │   │   │   ├── Row.java
│   │   │   │   ├── Vektor.java
│   │   │   │   ├── VektorRom.java
│   │   │   │   ├── Kompleks.java
│   │   │   │   └── C.java
│   │   │   ├── gausseliminasjon/       # Gaussian elimination algorithms
│   │   │   │   ├── Gausser.java
│   │   │   │   └── RadOperasjoner.java
│   │   │   ├── kalkulasjoner/          # High-level calculations
│   │   │   │   ├── EquationSolver.java
│   │   │   │   ├── InverseMatrixCalculator.java
│   │   │   │   └── ProjectionCalculator.java
│   │   │   ├── operators/              # Supporting operators
│   │   │   │   ├── PivotComperator.java
│   │   │   │   ├── RealMatrixOperator.java
│   │   │   │   ├── RealToolMatrix.java
│   │   │   │   └── VektorOperator.java
│   │   │   ├── validators/             # Matrix form validators
│   │   │   │   ├── RedusertTrappeformPredicate.java
│   │   │   │   └── TrappeformPredicate.java
│   │   │   └── exampleproject/         # Example JavaFX application
│   │   └── resources/
│   └── test/
│       └── java/                        # Unit tests
│           ├── fundament/
│           ├── gausseliminasjon/
│           ├── kalkulasjoner/
│           ├── operators/
│           └── validators/
├── pom.xml                              # Maven configuration
├── LICENSE                              # MIT License
└── README.md                            # This file
```

## Installation

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Setup

1. Clone the repository:
```bash
git clone <repository-url>
cd Linear-algebra-Project
```

2. Build the project:
```bash
mvn clean compile
```

3. Run tests:
```bash
mvn test
```

4. Run the application:
```bash
mvn javafx:run
```

## Usage

### Running the Application

The main application entry point is configured in `pom.xml`. Run using:

```bash
mvn javafx:run
```

### Using the Library

You can use the linear algebra classes in your own code:

```java
import fundament.Vektor;
import fundament.RealMatrix;
import kalkulasjoner.InverseMatrixCalculator;

// Create a matrix
RealMatrix matrix = new RealMatrix(...);

// Calculate inverse
RealMatrix inverse = InverseMatrixCalculator.getInverse(matrix);

// Create a vector
Vektor vector = new Vektor(...);
```

### Interactive Game

The application includes an interactive matrix inversion game:
- You are presented with a 3×3 matrix with an integer inverse
- Calculate and input the inverse matrix as quickly as possible
- Your time is recorded and saved to the leaderboard

## Project Structure Overview

### Core Packages

- **`fundament`**: Core mathematical structures (vectors, matrices, vector spaces)
  - See [fundament/README.md](src/main/java/fundament/README.md) for details

- **`gausseliminasjon`**: Gaussian elimination implementation
  - See [gausseliminasjon/README.md](src/main/java/gausseliminasjon/README.md) for details

- **`kalkulasjoner`**: High-level calculation wrappers
  - See [kalkulasjoner/README.md](src/main/java/kalkulasjoner/README.md) for details

- **`operators`**: Supporting operator classes
  - See [operators/README.md](src/main/java/operators/README.md) for details

- **`validators`**: Matrix form validation predicates
  - See [validators/README.md](src/main/java/validators/README.md) for details

- **`App`**: User interface and game application
  - See [App/README.md](src/main/java/App/README.md) for details

## Testing

The project includes comprehensive unit tests using JUnit 5. Tests are located in `src/test/java/` and cover:

- Core fundamental classes (vectors, matrices)
- Gaussian elimination operations
- Calculation algorithms
- Operator utilities
- Validator predicates

Run all tests with:
```bash
mvn test
```

## Design Notes

- The implementation uses inheritance from `ArrayList` for rows and matrices to leverage built-in collection functionality
- The `Matrix` interface is designed to support both real and complex matrices (though complex matrix implementation is not yet complete)
- The project follows a Model-View-Controller (MVC) architecture pattern

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

Axel Filseth

## Acknowledgments

Created as part of coursework for:
- **TMA4115**: Linear Algebra
- **TDT4100**: Object-Oriented Programming
