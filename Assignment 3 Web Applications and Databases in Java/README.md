# Lab 3

## Scenario

Code&Code is a small company dedicated to Software Development. Their engineering team, to which you belong, is working on writing a Web Application as an MVP for a new customer.

The code name for this App is “Loggy”, which is meant to offer functionality for a personal journal where users can log their daily activities through text, voice and video.

The first step will be to write the main functionality, which is essentially a Micro-blogging System where all the posts are automatically annotated with voice, video or text.

As part of the first iteration you have to create a web application that will be the foundation for the Microblogging System under the following assumptions:

a. Users submit their logging activity through a web page to a single thread in the same way Twitter users submit their posts. A form containing an input box and submit button is shown at the top and under that, a list with all the previous submissions ordered by the timestamp in descending order.

b. A short title (60chars) and a short content description (120 chars) is required. After that, the user attaches the actual content, which can be a picture, audio, video or text file.

c. The file is processed in the server and a thumbnail is shown right below the description.


## Tasks

### Part I:

### Web Application

1. Start by creating a web application based on a Dynamic Web Project.

2. Create a class that will represent the basic Log. The minimum attributes required include:

a. An ID
b. Title
c. The Log Content
d. A Timestamp of creation

3. This class can be based on the ones created as part of the Assignment 1. Although for this case, only one type of Log will be used, and this will not include an attachment. Therefore, it can be seen as a lightweight of the previous model. For this reason the class TextLog may be the best fit for this exercise.

### Servlet Class

1. Once you have created the web application, you will then create a Servlet Class that responds to a GET request with a HTML form where a user can submit the Title and the Log Content.

2. Extend the Servlet Class for receiving a POST request with the submission.

a. Create a Log object with the data received
b. Store the object created in memory and respond to the user with a message of success or error in a HTML page.

3. Extend the response so the HTML page rendered includes the message at the top, the form right below, and a list with all the submissions ordered by the timestamp at the bottom.

4. Extend the HTML page so the user has a link per Log for deleting it.

5. Extend the Servlet so it can process the new request for deleting the object and as a response will render the HTML page updated.

6. Extend the HTML page so the user has a link per Log for editing it.

7. Extend the Servlet so it can process the new request for editing the object and as a response will render the HTML page with the form populated with the Log selected.

8. Extend the Servlet so it can now process a new request for updating the object and as a response will render the HTML page updated.


### Part II:

### Data Persistence
1. Part II of this assignment is to create a database and a table for persisting the Logs on HSQLDB (or MySQL).

2. Create a class that will represent the Log as the data object persisted in the database.

3. Create a service class that will function as intermediator between the servlet and the database.

4. Implement in the service class the methods for creating, reading, updating and deleting (CRUD operations) Data Objects on the Database using a JDBC connection.


Remember that although the scenario and resulting model may be used for future activities, the main goal is to practice what you have learned in this module, so do not be worried about finding the perfect solution for this case. And keep in mind that System.out.println() will be enough for the purposes of illustrating your model.
