# Gaussian Elimination Package

This package implements Gaussian elimination, a fundamental algorithm in linear algebra for solving systems of linear equations and finding matrix inverses.

## Overview

Gaussian elimination is a systematic method for transforming a matrix into row echelon form (or reduced row echelon form) through elementary row operations.

## Key Classes

- **`Gausser.java`**: Main class that performs Gaussian elimination on matrices
- **`RadOperasjoner.java`**: Provides elementary row operations:
  - Swapping rows
  - Multiplying a row by a scalar
  - Adding a multiple of one row to another

## Usage

These classes are used internally by calculation classes like `InverseMatrixCalculator` and `EquationSolver` to perform the core matrix transformations needed for solving linear algebra problems.

