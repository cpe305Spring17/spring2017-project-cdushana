# Telos - A Goal Tracker
[![Build Status](https://travis-ci.org/cpe305Spring17/spring2017-project-cdushana.svg?branch=master)](https://travis-ci.org/cpe305Spring17/spring2017-project-cdushana)

This application is focused on building customizable goals throughout a person’s daily lifestyle. A user will specify a goal and the date they want this goal to be completed by. The app will send routine notifications alerting the user to rate their success on completing their goal for that day.

## Installation

On your android device, simply search for Telos on the Google Play Store and download it.
  		  
## Implemented Features
- Ability to create and delete goals
- Customizable input for goals
- Multiple different activities/view for application
- Confirmation of completed goal
- Daily Notifications for all created goals

## Architecture Diagram
This application was made using the Model-View-Controller Architecture Pattern. Telos saves your data to the local storage on your Android device.

![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/ArchitectureDiagram.png)

## Class Diagram
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/Class%20Diagram2.png)

## Design Patterns
This application uses Singleton Patterns from the Calendar class. Singleton is useful to quickly and easily recieve an instance of a class.

## Screenshots

After downloading Telos, you will be presented with an empty homepage.
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/HomePage.png)

To add your first goal, tap on the plus button on the top right of the application.
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/AddOption.png)

Fill in all your desired input for your goal.
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/FillInData.png)

Congrats - you've succesfully added your first goal!
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/AddedRun.png)

This Toast feature is activated when the user gently taps on any of the goals on the home screen. This Toast notifies the user of more functionality needed to access information.
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/Toast.png)

Deleting a goal is easy, just swipe and confirm!
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/RemoveItem.png)

My long pressing on a particular goal, the user will be brought to this page. The checkbox will be unchecked until that goal has been fufilled for the day.
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/BeforeCompletingGoal.png)

After completing the goal, the checkbox can be checked. 
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/CheckedGoal.png)

You will recieved daily notifications for each goal that you create based on the time you have set. In this particular demo, I have the notification time set to the time the goal that was created. This will be changed in a later release.
![alt text](https://github.com/cpe305Spring17/spring2017-project-cdushana/blob/gh-pages/docs/Notification.png)

## Key Takeaways
- Managing time is essential for completion of this project
- Start using design patterns earlier on, rather than at the end...
- Continuous Integration is essential for testing purposes!
- Sonarqube is beneficial for understanding how to clean up code
