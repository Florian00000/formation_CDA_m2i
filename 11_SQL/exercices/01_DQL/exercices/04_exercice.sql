USE test_bdd;

-- Affichez toutes les colonnes de la table "Users" pour tous les utilisateurs.
SELECT * 
FROM users;

-- Sélectionnez les noms et prénoms des utilisateurs nés à New York ou à Paris.
SELECT first_name, last_name
FROM users
WHERE birth_location IN ('New York', 'Paris');

-- Affichez les utilisateurs dont le travail est "Developer" ou "Designer".
SELECT * 
FROM users
WHERE job IN ('Developer', 'Designer');

-- Sélectionnez les utilisateurs dont l'âge est supérieur à 30 ans.
SELECT *
FROM users
WHERE age > 30;

-- Affichez les utilisateurs dont le salaire est compris entre 2500 et 3000.
SELECT * 
FROM users
WHERE salary BETWEEN 2500 AND 3000;

-- Sélectionnez les utilisateurs dont le travail n'est ni "Developer" ni "Designer".
SELECT * 
FROM users
WHERE job NOT IN ('Developer', 'Designer');

-- Affichez les utilisateurs triés par ordre alphabétique du nom de famille, puis du prénom.
SELECT * 
FROM users
ORDER BY last_name, first_name;

-- Sélectionnez les utilisateurs nés avant l'année 1990.
SELECT *
FROM users 
WHERE birth_date < '1990-01-01';

-- Affichez les utilisateurs dont le lieu de naissance est "London" ou "Berlin" et dont le travail est "Designer".
SELECT *
FROM users
WHERE birth_location IN ('London', 'Berlin') AND job = 'Designer';

-- Sélectionnez les 10 utilisateurs avec les salaires les plus élevés.
SELECT * 
FROM users
ORDER BY salary 
LIMIT 10; 

-- Affichez les noms, prénoms et âges des utilisateurs nés entre 1980 et 1990.
SELECT last_name, first_name, age
FROM users
WHERE YEAR(birth_date) BETWEEN 1980 AND 1990;

-- Sélectionnez les utilisateurs par ordre décroissant d'âge.
SELECT *
FROM users
ORDER BY age DESC;

-- Sélectionnez les utilisateurs dont le travail est "Doctor" et dont le salaire est supérieur à 3000.
SELECT * 
FROM users
WHERE job = 'Doctor' AND salary > 3000;

-- Affichez les utilisateurs triés par lieu de naissance, puis par salaire.
SELECT *
FROM users 
ORDER BY birth_location, salary;

-- Sélectionnez les utilisateurs nés à Paris et dont le travail est "Lawyer".
SELECT *
FROM users
WHERE birth_location = 'Paris' AND job = 'Lawyer';

-- Affichez le salaire le plus bas de tout les utilisateurs en utilisant un alias.
-- SELECT salary AS salary_min
-- FROM users
-- ORDER BY salary LIMIT 1;
SELECT MIN(salary) AS salary_min
FROM users;

-- Sélectionnez les utilisateurs nés après l'année 1985 et dont le travail est "Engineer".
SELECT * 
FROM users
WHERE YEAR(birth_date) > 1985 AND job = 'Engineer';

-- Affichez les utilisateurs dont le prénom est "John" et le nom de famille est "Doe".
SELECT * 
FROM users
WHERE first_name = 'John' AND last_name = 'Doe';

-- Sélectionnez les 6 utilisateurs dont le salaire est le plus bas en omettant les trois premiers résultats.
SELECT *
FROM users 
ORDER BY salary LIMIT 6 OFFSET 3;

-- Affichez les utilisateurs par ordre croissant d'âge, limités aux 5 premiers.
SELECT *
FROM users
ORDER BY age 
LIMIT 5;