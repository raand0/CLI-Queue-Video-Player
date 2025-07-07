# CLI-Queue-Video-Player
Command Line Interface video player that plays videos in order of a list you made

## How to use
You need to copy a video url and add it to the script queue. (don't worry it's easy)  
There are 5 commands you can use  
* add //add a video to the queue
* remove //remove a video from the queue
* play //play the videos in order
* view //view the current queue
* exit //exit the program

## Requirements
* Java JRE to run the script

## Installation
You can clone this repo and run the Run.bat file if you have git.  
if you don't have git:  
1-Download Program.java and Run.bat  
2-Double click the Run.bat file

## Note
This script is made for google chrome browser and if you have another browser you need to configure this line in Program.java:  
```
String[] command = {
      "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
      videoUrl
  };
```
for example if you have firefox, you need to find firefox.exe file path and put it there like this:
```
String[] command = {
      "C:\\Program Files\\Mozilla\\FireFox\\Application\\Firefox.exe",
      videoUrl
  };
