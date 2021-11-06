# Project #: Project 1

* Author: Rich Boundji
* Class: CS321 Section #3
* Semester: Fall 2021

## Overview

This program simulates a cash system, it takes in a text file and parses through its word by word
it saves each word in the first and second level of cash when there is one. 
Every time a word that is in the cash is read again the program counts that as a hit 
and moves the word to the front of the list when the cash reaches its limit the program deletes the last word in the list.


##INCLUDED FILES:

 * Cache.java - source file
 * CacheTest.java - source file
 * CacheInterface - source file
 * README - this file


## Reflection

at first, I was confused because I did not understand what I needed to do and I also over thought
what I needed to do because linked list is something that I do not have a lot of experience with 
but with the help of the tutors and the professor I was able to grasp the project, 
ones I had a good idea of what I was doing the project went a lot smoother.

The issue that I ran into was that the output would be a little off,
but I was able to resolve it by changing the order of things.
I made it so that the word would be added and after that the code would check if the list was too long.


## Compiling and Using

 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac CacheTest.java
 
 Run the compiled class file with the command:
 $ java CacheTest 1 <cache size> <input text file name> 
 or
 $ java CacheTest 2 <1st-level cache size> <2nd-level cache size> <input text file name>
  
 Console output will give the results after the program finishes.


## Results 

The program is capable of outputting the correct value for the number of references
and hits the output of the program takes a lot longer to get the outputs then the 
time that the result text files expect because of the use of a linked list.


## Sources used

I used some of my previous projects to remind myself how a linked list worked 

