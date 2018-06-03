# Web-Scrapper-using-Java
Used to display the schedule of trains.

## Basic Requirements:

* You should have java installed on your computer.
* You should have a terminal frorm where you will be able to run the application.

## How to use this application?

Here the _TrainSchedule_ folder is the root folder. Go inside the folder and follow the given steps:

* Open Terminal and enter: `javac -d bin -sourcepath src -cp lib/json-simple-1.1.1.jar:lib/jsoup-1.11.3.jar:lib/org.apache.sling.commons.json-2.0.20.jar src/TrainSchedule.java` . This command will generate a `.class` file in `bin/`.
* After this in the same terminal window, enter `java -cp bin:lib/json-simple-1.1.1.jar:lib/jsoup-1.11.3.jar:lib/org.apache.sling.commons.json-2.0.20.jar TrainSchedule`. After this command executes, enter the train number in the command line.
* Once you enter the train number, a series of messages will be displayed and `.json' file will be found in the root folder, displaying various info. about the train.

# Jars used.

This typically uses 3 external jars:

1. json-simple-1.1.1.jar
2. jsoup-1.11.3.jar
3. org.apache.sling.commons.json-2.0.20.jar

These can be manually imported but I have specified them in lib/ folder. :)

**Note**: Some of the apis used here might be deprecated!
