INSERT INTO CATEGORIES (NAME, CREATION_TIMESTAMP, UPDATE_TIMESTAMP)
VALUES('Car', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO CATEGORIES (NAME, CREATION_TIMESTAMP, UPDATE_TIMESTAMP)
VALUES('Food', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO CATEGORIES (NAME, CREATION_TIMESTAMP, UPDATE_TIMESTAMP)
VALUES('Sport', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO EXPENSE (DESCRIPTION, AMOUNT, EXPENSE_DATE, UPDATE_TIMESTAMP)
VALUES('Hesburger', 10, '2021-12-10', CURRENT_TIMESTAMP());

INSERT INTO USERS (ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES(1, 'email@email.com', 'Patrik', 'cat', 'password')