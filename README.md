# selenium-functional-tests
This project will help beginners to understand basic framework concepts, and will give a chance to work faster by doing clone and modify according to their project needs.

This is a Sample Selenium-Java and TestNG project to run functional test journies programmatically.

Using webdrivermanager to manage Google Chrome, Firefox browsers, and poi for test data management.

Maven as dependencies and build management tool.

### Setup 
Install jdk 1.7 or above and configure JAVA_HOME & path,
 
Configure Maven latest and M2_HOME & path

### Run
clone this project, go into project folder and run below command 

`mvn clean install`


### Output

Reports will generate under target folder

### Note

Tests running in headless mode, comment `options.addArguments("headless");` in BrowserUtil.java to open browser.


