# JavaScript Function Finder

This is a project made in JSP (JaveServer Pages) that will analyze your JavaScript code and print the lines where a function has been found

This is the first of three (3) different projects that I've made for the Advanced Programming course at the Polytechnic University of Puerto Rico, San Juan Campus.

This project creates files on a folder of your choice to store the account files as well as the analyzed codes, results, and history.

To change the directory where the files are located, please change the `FileDir` variable in the following files:

* history.jsp
* results.jsp
* checkUserLogin.java
* codeAnalyzer.java

You'll also need to edit the variable `DomainName` in the `checkUserLogin.java` file as this is sent on the account validation email.

Also, in that same file, be sure to change the email address and SMTP Relay in the following lines:

```
String from = "user@domain.com";
String host = "smtp-relay.gmail.com";
```

You'll need to have Tomcat installed in your system to run this project.

