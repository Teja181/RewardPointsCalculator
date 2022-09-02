### **CUSTOMER REWARD POINT CALCULATOR :**

A retailer offers a rewards program to its
customers, awarding points based on each
recorded purchase.
A customer receives 2 points for every dollar
spent over $100 in each transaction, plus 1
point for every dollar spent over $50 in each
transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90
points).
Given a record of every transaction during a
three month period, calculate the reward
points earned for each customer per month
and total.

This application used Gradle build tool.

**H2 database installation and run:**

Run the installed H2 database jar file and connect via credentials :

<img width="432" alt="Screenshot 2022-09-02 at 11 43 23 PM" src="https://user-images.githubusercontent.com/112639460/188218549-4d15029b-df5d-4000-bef8-430f3037e269.png">



Create table and insert data by using createData.sql

Change the DB credentials in the application.properties file.

**Postman :** 
Use this below URL to fetch customer rewards :

GET  :  http://localhost:8080/rewards/{customer_id}

