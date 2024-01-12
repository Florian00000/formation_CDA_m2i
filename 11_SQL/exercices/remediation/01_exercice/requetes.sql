USE remediation_01;

--    Obtenir la liste des 10 villes les plus peuplées en 2012
SELECT *
FROM villes_france_free
ORDER BY ville_population_2012 DESC LIMIT 10;

--    Obtenir la liste des 50 villes ayant la plus faible superficie
SELECT *
FROM villes_france_free
ORDER BY ville_surface LIMIT 50;

--    Obtenir la liste des départements d’outres-mer, c’est-à-dire ceux dont le numéro de département commencent par “97”
SELECT *
FROM departement
WHERE departement_code LIKE '97%';

--    Obtenir le nom des 10 villes les plus peuplées en 2012, ainsi que le nom du département associé
SELECT v.ville_nom, d.departement_nom
FROM villes_france_free AS v
INNER JOIN departement AS d
ON v.ville_departement = d.departement_code
ORDER BY ville_population_2012 DESC LIMIT 10;

--    Obtenir la liste du nom de chaque département, associé à son code et du nombre de commune au sein de ces département, en triant afin d’obtenir en priorité les départements qui possèdent le plus de communes
SELECT d.departement_nom, d.departement_code, count(v.ville_id) AS nb_villes
FROM departement AS d
LEFT JOIN villes_france_free AS v
ON v.ville_departement = d.departement_code
GROUP BY d.departement_nom 
ORDER BY nb_villes DESC ;

--    Obtenir la liste des 10 plus grands départements, en terme de superficie
SELECT d.*, sum(v.ville_surface) AS superficie
FROM departement AS d
LEFT JOIN villes_france_free AS v
ON v.ville_departement = d.departement_code
GROUP BY d.departement_nom 
ORDER BY superficie DESC LIMIT 10;

--    Compter le nombre de villes dont le nom commence par “Saint”
SELECT count(ville_id)
FROM villes_france_free
WHERE ville_nom LIKE 'Saint%';

--    Obtenir la liste des villes qui ont un nom existants plusieurs fois, et trier afin d’obtenir en premier celles dont le nom est le plus souvent utilisé par plusieurs communes
SELECT  ville_nom, count(ville_nom) AS repet_nom
FROM villes_france_free
GROUP BY  ville_nom
HAVING repet_nom > 1
ORDER BY repet_nom DESC;

--    Obtenir en une seule requête SQL la liste des villes dont la superficie est supérieur à la superficie moyenne
SELECT ville_nom, ville_surface
FROM villes_france_free
WHERE ville_surface > (
	 SELECT avg(ville_surface) FROM villes_france_free);

--    Obtenir la liste des départements qui possèdent plus de 2 millions d’habitants
--    Remplacez les tirets par un espace vide, pour toutes les villes commençant par “SAINT-” (dans la colonne qui contient les noms en majuscule)