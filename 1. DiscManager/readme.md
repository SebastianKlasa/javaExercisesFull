# Disc Manager

## General information
Disk manager in console

## Description:
Simple disc manager in console. Program display files structure inside taken directory.
Arguments (args):
-  DiscManager <path> - display disk content
- -h - display help
- -r <path> - display reccurent disk content
- -s <path> - display sorted disk content
- -w <path> <path to save> <file name> - save reccurent disk content to file
- -z <path> - display serialized content from file

## Technologies
- Java 8

## Setup
Requirements:
- Ant 1.8.0 or higher
- Java 8 or higher
To build this project locally open project directory and run:
```
ant compile jar run
```
To run program from Command Prompt run follow: 
```
java -jar dist\DiscManager.jar <args>
```