This project contains test cases for global technical interview. Here are the requirements https://github.com/thisisglobal/global-qa-interview.

Java is the language used and the project is with Maven structure. There are source and test directories,
representation of web pages and object models are stored in source folder and test scenarios are implemented in test one.

API test cases
Rest Assured and TestNG annotations are used for implementing test cases.
Using https://api.spacex.land/graphql/ for API.

NB: Test cases are not going to pass, because validation for number of ships to be grater than 0 will fail, due to empty
list of ships in several launch objects.

Web test cases
Selenium is used for automating test cases.
As mentioned pages are extracted in separate classes and every one has its own elements.
Chrome driver is configured to be used for the test.

To initialize and build the project you will need IntelliJ or Eclipse installed on your computer and also Java development kit for running it.
To run WebTests class you need to install selenium server standalone from here https://www.selenium.dev/downloads/ and start it from command line.
Chrome web driver is stored in the project and configured for Chrome version 98.0.4758.82 (Official Build) (64-bit).