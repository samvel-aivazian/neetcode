# NeetCode Solutions in Java 21

## Project Description

This repository contains solutions to NeetCode problems implemented in Java 21.
The main goal of this repository is to provide a comprehensive collection of solutions for various data structures, 
algorithms, sorting techniques, and design patterns, showcasing clean code and thorough testing practices.

## Structure

The repository is organized into multiple subprojects, each representing a different problem or topic.
Each subproject contains its own `README.md` with specific details about the implementation and testing.

### Subprojects

- **Design Patterns**: Implementation of design patterns.
- **Graphs**: Solutions to graph-related problems.
- **Data Structures**: Implementation of data structures.
- **Sorting**: Implementation of sorting algorithms.

## Features

- Solutions to various NeetCode problems.
- Implementation of data structures, algorithms, and design patterns in clean Java code.
- Comprehensive test cases for each implementation.
- Detailed documentation for each subproject.
- Full test coverage for all implementations.

## Requirements

- Java 21

## Usage

Clone the repository and navigate to the specific subproject directory. 
Follow the instructions in the subproject's `README.md` to compile and run the code.

```bash
git clone https://github.com/samvel-aivazian/neetcode.git
cd neetcode
```

### Running a Specific Subproject

1. Navigate to the subproject directory:

    ```bash
    cd <subproject_directory>
    ```

   Replace `<subproject_directory>` with the path to the specific subproject you want to run. For example:

    ```bash
    cd core_skills/implement_data_structures/design_singly_linked_list
    ```

2. Compile the Java files:

    ```bash
    javac -cp . org/samvelaivazian/<subproject>/*.java
    ```

   Replace `<subproject>` with the package name specific to the subproject. For example:

    ```bash
    javac -cp . org/samvelaivazian/linkedlist/*.java
    ```

3. Run the test class:

    ```bash
    java -ea org/samvelaivazian/<subproject>/<TestClassName>
    ```

   Replace `<subproject>` with the package name and `<TestClassName>` with the name of the test class 
   specific to the subproject. For example:

    ```bash
    java -ea org.samvelaivazian.linkedlist.LinkedListTest
    ```

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgements
This project was inspired by the problem description on [NeetCode](https://neetcode.io/).
The implementations and testing were done to deepen the understanding of 
data structures, algorithms, and design patterns in Java.
