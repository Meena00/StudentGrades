
# StudentGrades Project

## Overview
The StudentGrades project is designed to manage and calculate grades for students based on various weighted components such as participation, readings, labs, exercises, projects, midterm, and final exam scores. It provides functionalities to add scores, compute total scores, determine letter grades, and compare student grades within a gradebook.

## Classes

### StudentGrades Class
The `StudentGrades` class represents a student's grades and includes methods to:
- **Calculate Scores**: Methods like `totalScore()` compute the weighted total score using participation, readings, labs, exercises, projects, midterm, and final exam scores.
- **Letter Grade Calculation**: Uses conditional statements to assign letter grades based on the total score.
- **Data Storage**: Utilizes collections (`ArrayList`, `List`) to store scores and weights, ensuring efficient data management.

### Gradebook Class
The `Gradebook` class manages a collection of `StudentGrades` instances and provides methods to:
- **Aggregate Data**: Computes statistics such as average, minimum, maximum, and median scores using methods like `average()`, `min()`, `max()`, and `median()`.
- **Comparison**: Implements the `Comparator` interface to facilitate comparisons between `StudentGrades` objects based on their total scores.
- **Iteration and Sorting**: Utilizes iteration over collections (`Collection`, `ArrayList`) and sorting (`Collections.sort()`) for data analysis.

### GradeChecker Class
The `GradeChecker` class serves as a driver program to test functionalities of the `StudentGrades` class, providing:
- **User Interaction**: Uses `Scanner` for user input, allowing users to enter scores interactively or from a file.
- **Exception Handling**: Implements error handling with `try-catch` blocks to manage input errors gracefully.
- **Default Values**: Initializes default weights for different grade components (`defaultWeights`) to standardize grade calculations.

## Key Methods

### StudentGrades Class
- **totalScore()**: Calculates the total weighted score by summing up individual scores multiplied by respective weights.
- **letterGrade()**: Assigns a letter grade based on the calculated total score, using conditional statements for grading thresholds.
- **Collections Usage**: Utilizes `ArrayList` and `List` for managing scores and `Collections.sort()` for sorting.

### Gradebook Class
- **average()**: Computes the average total score of all `StudentGrades` instances in the gradebook.
- **min()**, **max()**: Determines the minimum and maximum total scores among the students, employing iteration and comparison.
- **Comparator Interface**: Implements `compare()` method to compare `StudentGrades` objects based on total scores, showcasing proficiency in object-oriented programming principles.

### GradeChecker Class
- **User Input Handling**: Uses `Scanner` for user input and `File` for reading from a file, demonstrating input/output handling skills.
- **Exception Handling**: Implements `try-catch` blocks to catch and handle runtime exceptions, ensuring robust program execution.
- **Documentation**: Provides clear instructions and examples in comments to guide users on how to interact with the program.

## Skills Highlighted
- **Object-Oriented Programming (OOP)**: Classes, objects, encapsulation, and inheritance are utilized to organize and manage student grades.
- **Data Structures**: Utilizes collections (`ArrayList`, `List`) for efficient data storage and manipulation.
- **Algorithm Design**: Implements algorithms for calculating weighted scores, sorting, and statistical computations.
- **Input/Output Handling**: Uses `Scanner` for user input and file reading, demonstrating proficiency in handling input/output operations.
- **Exception Handling**: Implements error handling strategies (`try-catch` blocks) to ensure program robustness and reliability.
- **Documentation**: Provides clear and concise documentation (README, comments) to enhance code readability and usability.

This project showcases fundamental skills in software development and demonstrates proficiency in key technical areas relevant to entry-level software engineering positions.



-------------------------
