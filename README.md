# Sorting Algorithms Performance Analysis and Efficient k-Most Viewed Videos Finder

## Overview
This repository contains the Java code and report for **Assessed Exercise 1** from the Algorithms and Data Structures (ADS2) course. The project consists of two parts:

1. **Empirical Performance Study of Sorting Algorithms**
2. **Implementation of an Efficient Algorithm to Find the k Most Viewed Videos**

## Part 1: Sorting Algorithm Performance Study

### Implemented Algorithms
The following sorting algorithms were implemented and tested:
- **Insertion Sort**
- **Selection Sort**
- **Shell Sort**
- **Merge Sort** (including variants like Hybrid Merge Sort and Bottom-Up Merge Sort)
- **Quicksort** (including variants such as Median of Three, Dutch National Flag, and Hybrid Quicksort)

### Experiment Setup
- **Datasets**: The provided datasets (`int10.txt` to `intBig.txt`, `dutch.txt`, and `bad.txt`) were used for benchmarking.
- **Metrics**:
  - Running time was measured for each algorithm.
  - Experiments were repeated 10 times, and the average running time was reported.

### Results
- **Plot**: A plot comparing the performance of all sorting algorithms on datasets (`int10.txt` to `intBig.txt`).
- **Tables**:
  - Running times for each algorithm on `dutch.txt`.
  - Running times for each algorithm on `bad.txt`.

### Findings
- Slower algorithms (like Insertion Sort) exhibited exponential growth in running time for larger datasets.
- Efficient algorithms (like Quicksort and Merge Sort) performed consistently better, especially with larger datasets.
- Specific optimizations (e.g., Median of Three in Quicksort) significantly improved performance on certain datasets.

## Part 2: Efficient k-Most Viewed Videos Finder

### Problem
Implement an efficient algorithm to find the **k most viewed videos** from a daily list of views, where \( k << n \) (i.e., the number of videos of interest is much smaller than the total number of videos).

### Solution
- **Approach**: A **min-heap** (priority queue) was used to maintain the top k most viewed videos.
- **Algorithm**:
  1. Iterate through the list of videos.
  2. For each video:
     - If the heap size is less than k, add the video to the heap.
     - Otherwise, if the current video's views exceed the smallest views in the heap, replace the smallest element.
- **Time Complexity**:
  - Building and maintaining the heap takes \( O(n \log k) \), where n is the number of videos.
  - This is efficient since \( k \ll n \).

### Output
The algorithm outputs the k most viewed videos in descending order of views.

## How to Run
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```
2. **Compile the Code**:
   ```bash
   javac *.java
   ```
3. **Run the Sorting Experiments**:
   ```bash
   java SortingExperiment
   ```
4. **Run the k-Most Viewed Videos Finder**:
   ```bash
   java TopKVideosFinder
   ```

## Files
- `SortingExperiment.java`: Contains the implementation and benchmarking of sorting algorithms.
- `TopKVideosFinder.java`: Implements the efficient algorithm to find the k most viewed videos.
- `datasets/`: Contains the input datasets used for the experiments.
- `results/`: Contains the output tables and plot generated from the experiments.

## Contact
For any questions or clarifications, please contact: [Your Name] ([Your Email]).
