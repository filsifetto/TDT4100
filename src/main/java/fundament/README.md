# Fundament Package

This package contains the core foundational classes that define the fundamental structures in linear algebra.

## Overview

The `fundament` package implements the basic mathematical objects used throughout the project:
- **Vectors** (`Vektor.java`) - Mathematical vectors with operations like addition, subtraction, dot product, and scalar multiplication
- **Matrices** (`RealMatrix.java`, `AbstractMatrix.java`) - Matrix representations with support for real numbers
- **Vector Spaces** (`VektorRom.java`) - Vector space structures
- **Complex Numbers** (`Kompleks.java`, `C.java`) - Support for complex number operations
- **Matrix Elements** (`MatrixElement.java`) - Generic matrix element interface
- **Rows** (`Row.java`, `RealRow.java`, `AbstractRow.java`) - Row representations used in matrix structures

## Key Classes

- `Vektor`: Extends `RealMatrix` to represent vectors as column matrices
- `RealMatrix`: Concrete implementation of matrices with real number entries
- `AbstractMatrix`: Abstract base class providing common matrix functionality
- `Matrix`: Interface for matrix operations, designed to support both real and complex matrices

## Design Notes

The implementation uses inheritance from `ArrayList` for both rows and matrices, which provides built-in collection functionality but requires careful control over which inherited methods are appropriate for mathematical operations.

