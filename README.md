# ProgEksamenProgTest
# Exam for ITP2200
This is system for managing exercises for a home workout program. 
# Requirements

1. Exercises are grouped into Programs

- Each program keeps an account of the overall intensity (the highest intensity
among the included exercises).

- Each program keeps account of whether or not it is balanced. A balanced
program has at least one exercise of each type.

-  Each program has the exercises sorted in order of increasing intensity. 

-  Each program has an overall duration. The duration of an exercise is the twice
the sum of the durations of all the exercises it includes (to account for rest).


2. Each person has a level of intensity they find appropriate, and a type of exercise they
prefer. For each person, suggest an exercise program that is of the type they prefer,
and has a level of intensity +/- 10% of the person’s preferred intensity level. 

3. The ExerciseManager should have

-  Methods for deciding if a Program is appropriate for a given Person

-  Methods for building new Programs

- method for recommending, from a given collection of Programs, which is
most appropriate for a given Person. 
