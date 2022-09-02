CREATE TABLE CUSTOMER_DETAILS (CUSTOMER_ID int, CUSTOMER_NAME VARCHAR2(20) );
CREATE TABLE TRANSACTION_DETAILS (TRANSACTION_ID int,CUSTOMER_ID int ,TRANSACTION_DATE DATE,AMOUNT int);
INSERT INTO CUSTOMER_DETAILS(CUSTOMER_ID,CUSTOMER_NAME) values (101,'ALEX');
INSERT INTO CUSTOMER_DETAILS(CUSTOMER_ID,CUSTOMER_NAME) values (102,'BOB');
INSERT INTO CUSTOMER_DETAILS(CUSTOMER_ID,CUSTOMER_NAME) values (103,'CHARLIE');
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1,101,'2022-08-20',120);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (3,101,'2022-07-21',60);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (2,101,'2022-06-21',70);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (5,102,'2022-08-19',1400);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (7,102,'2022-07-18',900);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (8,102,'2022-06-18',70);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (2,103,'2022-08-16',120);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (4,103,'2022-07-15',80);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (10,103,'2022-06-15',90);
INSERT INTO TRANSACTION_DETAILS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (11,103,'2022-06-15',100);
COMMIT;