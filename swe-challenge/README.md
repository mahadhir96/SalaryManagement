# Swe Challange - backend

## Overview

This project was generated with Spring Boot version 2.7.0

## Getting Started 
SweChallange
To run the project go to the src/main/java, com.cts.SweChallange package , run the SweChallange.java file as Java Application.

## User Story 1 

- To upload csv file containing list of employees details 

- Using postman POST localhost:8002/api/csv/upload and add in the csv file manually to check if the csv upload successfully **(image below)**

![Capture](https://user-images.githubusercontent.com/71129999/174008245-5fd0b790-dc75-45bc-828f-f723925189fd.PNG)


- To confirm the employees details there is two ways to check 

- 1st method by checking the localhost:8002/h2 and SELECT * FROM EMPLOYEES **(image below)**

![11](https://user-images.githubusercontent.com/71129999/174016479-b1c4435a-6792-4801-8433-74a61b4c4b93.PNG)

- 2nd method by checking the postman GET localhost:8002/api/csv/employees **(image below)**

![dasdsada](https://user-images.githubusercontent.com/71129999/174016788-bd98f240-a1e6-469a-887f-2b16775cbe9d.PNG)

## User Story 2 

- To get the max and min salary range of the employees, using the @Getmapping method and @Pathvariable under the file employeee.Controller.java
- Sorting of columns are done by frontend 

## User Story 3 

In the employeeController.java able
- To view individual employees details 
- To edit and update the list of the employees 
- Able to delete individual employees details

## Test cases 

