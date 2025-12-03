# App Package

This package contains the user interface application and game logic.

## Overview

The `App` package implements an interactive matrix inversion game where users compete to solve matrix inversion problems as quickly as possible.

## Key Classes

- **`TaskGenerator.java`**: Generates random matrix inversion tasks from a bank of matrices
- **`Task.java`**: Represents a single matrix inversion task
- **`Leaderboard.java`**: Manages the high score leaderboard
- **`FileHandler.java`**: Handles file I/O for the matrix bank and leaderboard
- **`StopWatch.java`**: Tracks time for timing user performance
- **`MatrixBank.java`**: Manages the collection of matrices used for generating tasks

## Game Mechanics

The game presents users with a 3×3 matrix that has an integer inverse. Users must calculate and input the inverse matrix as quickly as possible. Their time is recorded and saved to a leaderboard file.

## Data Files

- `matrixBank.txt`: Contains the collection of matrices used for task generation
- `liste.txt`: Contains the leaderboard data

