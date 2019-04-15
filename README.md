News Management System (Sample Task #1)
Main Requirements
1)  Code should be easy to read and contain comments. 
2)  Templates and logic should be in separate files. 
3) Please use Spring Web MVC & Hibernate frameworks if you can. It will be better if you will use plain Spring Web MVC with annotation based configuration instead of spring boot.
If you know Angularjs Framework or React Lib / Redux Framework you can create frontend for your app using this technologies. However requirements above are not obligatory.
4) Use MySQL as a DB.
5) As a result there should be 3 files: war-file with compiled project, zip-file with source code, sql-file with DB scheme and testing data. Upload these files to file share hosting (like dropbox, google docs, etc.) and provide a link.

6) Please include build automation tool configuration file (build.gradle, pom.xml or other) if you are not using build automation tool please provide all required libraries/dependencies as .jar files at src/lib directory.  

In case you are not following requirement #6 your task will never be checked.

Functional requirements

There are 3 pages in the application:
●	news list page
●	add and edit new page
●	view new page 
List Page
In list page you should implement list of all news with pagination (5 news per page). Pages should be in format: 1 2 [3] 4 5 N. In this case 3 means current page.
Add / Edit Pages
All actions on these pages should use AJAX via XMLHttpRequest. Here is the list of fields:
-       Title. News title, input type=text, max length = 255
-       Date. News date. 
-       Text. News text, textarea
View Page / comments page
On this page show news title and news text. There should be a form below for adding comments (addition should use AJAX via XMLHttpRequest) and a list of comments related to this news.
Testing data
Please, add testing data to check the task. Add 20 news and 10 comments related to each news. 
