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

![alt text](https://user-images.githubusercontent.com/14967281/26964892-54a33c5c-4ca8-11e7-8409-f471267c7844.png)

## Class Diagram
![alt text](https://user-images.githubusercontent.com/14967281/26964893-54bb53d2-4ca8-11e7-8e14-1ae50aec1e10.png)

## Design Patterns
- Single Pattern: used to retrive Calendar instances. Singleton is useful to quickly and easily recieve an instance of a class.
- Adapter Pattern: RecyclerView/RecycleAdapter for list of goals on main activity. 

## Screenshots

After downloading Telos, you will be presented with an empty homepage.
![alt text](https://user-images.githubusercontent.com/14967281/26964808-1a4110de-4ca8-11e7-9bb7-ec527adee8b5.png)

To add your first goal, tap on the plus button on the top right of the application.
![alt text](https://user-images.githubusercontent.com/14967281/26964817-2112e43c-4ca8-11e7-9eb6-46145e18b2c5.png)

Fill in all your desired input for your goal.
![alt text](https://user-images.githubusercontent.com/14967281/26964826-26be5dda-4ca8-11e7-9993-d48f588ff629.png)

Congrats - you've succesfully added your first goal!
![alt text](https://user-images.githubusercontent.com/14967281/26964833-2cc3d2fa-4ca8-11e7-97af-2fcab36d3a18.png)

This Toast feature is activated when the user gently taps on any of the goals on the home screen. This Toast notifies the user of more functionality needed to access information.
![alt text](https://user-images.githubusercontent.com/14967281/26964740-cb2c5e0e-4ca7-11e7-90ff-5ba5cff97de8.png)

Deleting a goal is easy, just swipe and confirm!
![alt text](https://user-images.githubusercontent.com/14967281/26964878-490f64ce-4ca8-11e7-8ab3-4bca46d6e13e.png)

My long pressing on a particular goal, the user will be brought to this page. The checkbox will be unchecked until that goal has been fufilled for the day.
![alt text](https://user-images.githubusercontent.com/14967281/26964861-3e954d42-4ca8-11e7-8094-93fcaedd886b.png)

After completing the goal, the checkbox can be checked. 
![alt text](https://user-images.githubusercontent.com/14967281/26964849-38e018a0-4ca8-11e7-906d-72dc621070aa.png)

You will recieved daily notifications for each goal that you create based on the time you have set. In this particular demo, I have the notification time set to the time the goal that was created. This will be changed in a later release.
![alt text](https://user-images.githubusercontent.com/14967281/26964845-33127206-4ca8-11e7-88d5-ea27b126175a.png)

## Key Takeaways
- Managing time is essential for completion of this project
- Start using design patterns earlier on, rather than at the end...
- Continuous Integration is essential for testing purposes!
- Sonarqube is beneficial for understanding how to clean up code
