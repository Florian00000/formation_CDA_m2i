USE test_bdd;

SELECT min(salary) AS salary_min
FROM users;

SELECT max(age) AS age_max_engineer
FROM users
WHERE job = 'Engineer';

 SELECT round(avg(salary), 2) AS salary_avg_teacher
 FROM users
 WHERE job = 'Teacher';
 
 SELECT sum(salary) AS salary_sum
 FROM users ;
 
 SELECT *
 FROM users
 WHERE first_name LIKE 'D%';
 
 SELECT * 
 FROM users
 WHERE last_name LIKE '%son';
 
 SELECT * 
 FROM users 
 WHERE first_name LIKE '_____';
 
 SELECT *
 FROM users
 WHERE job LIKE '%Doctor%';
 
-- Exercice SQL - GROUP BY et HAVING avec la table "Users"

-- **Instructions :** Utilisez les clauses GROUP BY et HAVING pour répondre aux questions suivantes.

-- 1. **Affichez le nombre d'utilisateurs par lieu de naissance, mais ne montrez que les lieux avec plus d'un' utilisateur.**
SELECT count(id) AS users_by_birth_location, birth_location 
FROM users
GROUP BY birth_location
HAVING count(id) > 1;

-- 2. **Sélectionnez la profession et la moyenne des salaires pour chaque profession, mais ne montrez que celles avec une moyenne de salaire supérieure à 2500.**
SELECT job, round(avg(salary), 2) AS avg_salary_by_job
FROM users
GROUP BY job 
HAVING avg_salary_by_job > 2500;


-- 3. **Affichez la somme des salaires pour chaque lieu de naissance, mais ne montrez que les lieux dont la somme des salaires est supérieure à 5000.**
SELECT sum(salary) AS sum_salary_by_birth_location, birth_location
FROM users
GROUP BY birth_location
HAVING sum_salary_by_birth_location > 5000;

-- 4. **Sélectionnez la date de naissance et le nombre d'utilisateurs nés à chaque date, mais ne montrez que les dates où il y a plus d'un utilisateur né.**
SELECT birth_date, count(id) AS users_by_birth_date
FROM users
GROUP BY birth_date
HAVING users_by_birth_date > 1;

-- 5. **Affichez la profession, le lieu de naissance, et le salaire maximum pour chaque profession et lieu, mais ne montrez que les résultats où le salaire maximum est supérieur à 3000.**
SELECT job, birth_location, max(salary)
FROM users
GROUP BY job, birth_location
HAVING max(salary) > 3000;

-- ## Exercice SQL - Subqueries avec la table "Users" (Partie 2)

-- **Instructions :** Utilisez des subqueries pour répondre aux questions suivantes.

-- 1. **Affichez les utilisateurs nés dans le même lieu que celui du plus jeune utilisateur.**
SELECT *
FROM users 
WHERE birth_location = (SELECT birth_location FROM users ORDER BY age LIMIT 1); 

-- 2. **Sélectionnez les utilisateurs dont le salaire est inférieur à la moyenne des salaires des "Developers".**
SELECT *
FROM users 
WHERE salary < (SELECT avg(salary) FROM users WHERE job = 'Developer');

-- 3. **Affichez les utilisateurs dont le salaire est supérieur à la moyenne des salaires des utilisateurs nés dans la même ville que "John Doe".**
SELECT *
FROM users 
WHERE salary > (
	SELECT avg(salary)
    FROM users
    WHERE birth_location = (
		SELECT birth_location
        FROM users
        WHERE first_name = 'John' AND last_name = 'Doe'
    )
);