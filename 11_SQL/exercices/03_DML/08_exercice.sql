CREATE DATABASE IF NOT EXISTS test_DML;

USE test_DML;

DROP TABLE IF EXISTS students;

CREATE TABLE students(
id_student INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR (50) NOT NULL,
age INT,
grade VARCHAR(10)
);

SHOW TABLES;

-- Partie 1: INSERT INTO

-- Ajoutez trois nouveaux étudiants à la table

INSERT INTO students (first_name, last_name, age, grade)
VALUES 
	('Maria','Rodriguez', 21, 'B'),
	('Ahmed', 'Khan', 19, 'A'),
	('Emily', 'Baker', 22, 'C');
    
SELECT * 
FROM STUDENTS;

-- Partie 2: UPDATE

SET SQL_SAFE_UPDATES = 0;

-- Mettez à jour la note de l'étudiant ayant le prénom "Maria" pour la changer de "B" à "A".

UPDATE students
SET grade = 'A'
WHERE first_name = 'Maria';

SELECT * 
FROM STUDENTS;

-- Augmentez l'âge de tous les étudiants de 1 an.

UPDATE students 
SET age = age + 1;

SELECT * 
FROM STUDENTS;

-- Partie 3: DELETE

-- Supprimez l'étudiant ayant le prénom "Emily" de la table. Supprimez tous les étudiants dont l'âge est inférieur à 20 ans.

DELETE FROM students
WHERE first_name = 'Emily';

SELECT * 
FROM STUDENTS;

DELETE FROM students
WHERE age < 20;

-- Partie 4: TRUNCATE

-- Videz complètement la table "Students" en utilisant la commande TRUNCATE.

TRUNCATE students;