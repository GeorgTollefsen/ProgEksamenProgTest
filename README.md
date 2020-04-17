# ProgEksamenProgTest
# Exam for ITP2200
This is system for managing exercises for a home workout program. 
# Requirements

**1. Exercises are grouped into Programs**

- Each program keeps an account of the overall intensity (the highest intensity
among the included exercises).

- Each program keeps account of whether or not it is balanced. A balanced
program has at least one exercise of each type.

-  Each program has the exercises sorted in order of increasing intensity. 

-  Each program has an overall duration. The duration of an exercise is the twice
the sum of the durations of all the exercises it includes (to account for rest).


**2. Each person has a level of intensity they find appropriate, and a type of exercise they
prefer. For each person, suggest an exercise program that is of the type they prefer,
and has a level of intensity +/- 10% of the person’s preferred intensity level.**

**3. The ExerciseManager should have**

-  Methods for deciding if a Program is appropriate for a given Person

-  Methods for building new Programs

- method for recommending, from a given collection of Programs, which is
most appropriate for a given Person. 

# Assignment

**1.** 
Write a set of test criteria that evaluate if the requirements are met or not. If you feel
that the requirements are not clear or specific enough, motivate why and make a
justified assumption for your plan.

**2.** 
Write a test plan for the system, and update it as needed.

**3.**
Implement the System Under Test (SUT) and the tests. Make sure to include unit
tests, integration tests, acceptance tests. You can use TDD or any other techniques,
but try to write the tests (especially unit tests) either before or as you are writing the
code (rather than long after). 

**4.**
Pick a method (one that has interesting behavior) and discuss how the different tests
you have written follow different paths through that method. 
