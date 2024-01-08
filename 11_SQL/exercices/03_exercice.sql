SHOW databases;
USE test_bdd;
SHOW TABLES;

SELECT * 
FROM users;

SELECT first_name, last_name, job 
FROM users;

SELECT * 
FROM users
WHERE job != 'Developer';

SELECT * 
FROM users
WHERE first_name = 'John';

SELECT * 
FROM users
WHERE salary >= 3000;

SELECT * 
FROM users
WHERE age < 30 OR age >= 35;

SELECT * 
FROM users
WHERE job = 'Teacher' AND salary > 2600;

SELECT * 
FROM users
WHERE birth_location = 'New York' AND (salary >= 3000 AND salary <= 3500) AND NOT (job = 'Doctor' OR job = 'Lawyer');

SELECT * 
FROM users
WHERE job IN ('Engineer');

SELECT first_name, last_name
FROM users
WHERE birth_location IN ('London', 'Paris', 'Berlin');

SELECT * 
FROM users
WHERE age BETWEEN 25 AND 35 ;

SELECT *
FROM users
WHERE salary > 2500 AND job IN ('Developer');

SELECT *
FROM users
ORDER BY age DESC 
LIMIT 5;

SELECT *
FROM users 
ORDER BY first_name
LIMIT 5 OFFSET 5; 

SELECT *
FROM users 
ORDER BY salary DESC
LIMIT 3;