# File sender and receiver

## General information
Project consist of 2 programs:
- ReceiverApp - application listens on port 9876 and saves file to given localization.
- SenderApp - application sends given file 
Communication is accomplished with sockets.

### Technologies
- Java 8
- JavaFX
- Sockets

## Setup
Requirements:
- Ant 1.8.0 or higher
- Java 8 or higher
To build this project locally open both project directories and run:
```
ant compile 
ant jar
```
Firstly run ReceiverApp: 
```
java -jar ReceiverApp\dist\ReceiverApp.jar
```
Then run SenderApp:
```
java -jar SenderApp\dist\SenderApp.jar
```