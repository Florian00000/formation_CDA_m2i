USE tabletoptreasures_database;

-- Table "Categories" :
-- 1.  Sélectionnez tous les noms de catégories distinctes.
SELECT DISTINCT *
FROM categories;

-- 2.  Montrez les catégories avec des noms commençant par "A" ou "S".
SELECT *
FROM categories
WHERE nom LIKE 'A%' OR nom LIKE 'S%';

-- 3.  Quelles catégories ont un ID entre 2 et 5 inclus ?
SELECT *
FROM categories
WHERE id BETWEEN 2 AND 5;

-- 4.  Combien de catégories différentes existent ?
SELECT count(id) AS nb_categories
FROM categories;

-- 5.  Quelle est la catégorie ayant le nom le plus long ?
SELECT nom, length(nom) AS longueur_nom
FROM categories
ORDER BY longueur_nom DESC LIMIT 1 ;

-- 6.  Montrez le nombre de jeux dans chaque catégorie.
SELECT count(jeux.id), categories.nom 
FROM jeux
LEFT JOIN categories ON jeux.id_categorie = categories.id 
GROUP BY categories.nom;

-- 7.  Affichez les catégories triées par ordre alphabétique inversé.
SELECT * 
FROM categories
ORDER BY nom DESC ;


-- Table "Jeux" :
-- 1.  Sélectionnez tous les noms de jeux distincts.
SELECT DISTINCT nom
FROM jeux;
 
-- 2.  Montrez les jeux avec un prix entre 25 et 40.
SELECT *
FROM jeux
WHERE prix BETWEEN 25 AND 40;

-- 3.  Quels jeux appartiennent à la catégorie avec l'ID 3 ?
SELECT *
FROM jeux
WHERE id_categorie = 3;

-- 4.  Combien de jeux ont une description contenant le mot "aventure" ?
SELECT count(id) AS nb_jeux
FROM jeux
WHERE description LIKE '%aventure%';

-- 5.  Quel est le jeu le moins cher ?
SELECT *
FROM jeux
ORDER BY prix LIMIT 1;

-- 6.  Montrez la somme totale des prix de tous les jeux.
SELECT sum(prix) 
FROM jeux;

-- 7.  Affichez les jeux triés par ordre alphabétique des noms en limitant les résultats à 5.
SELECT *
FROM jeux 
ORDER BY nom LIMIT 5;


-- Table "Clients" :
-- 1.  Sélectionnez tous les prénoms des clients distincts.
SELECT DISTINCT prenom
FROM clients;

-- 2.  Montrez les clients dont l'adresse contient "Rue" et dont le numéro de téléphone commence par "+1".
SELECT *
FROM clients
WHERE adresse_de_livraison LIKE '%Rue%' AND telephone LIKE '+1%';

-- 3.  Quels clients ont un nom commençant par "M" ou "R" ?
SELECT *
FROM clients
WHERE nom LIKE 'M%' OR nom LIKE 'R%';

-- 4.  Combien de clients ont une adresse e-mail valide (contenant "@") ?
SELECT count(id) AS mail_valide
FROM clients
WHERE adresse_mail LIKE '%@%';

-- 5.  Quel est le prénom le plus court parmi les clients ?
SELECT prenom
FROM clients
ORDER BY length(prenom) LIMIT 1;

-- 6.  Montrez le nombre total de clients enregistrés.
SELECT count(id) AS total_clients
FROM clients;

-- 7.  Affichez les clients triés par ordre alphabétique des noms de famille, mais en excluant les premiers 3.
SELECT *
FROM clients
ORDER BY nom LIMIT 99999999999999 OFFSET 3;


-- Étape 4 : Requêtes SQL avancées

-- 1.  Sélectionnez les noms des clients, noms de jeux et date de commande pour chaque commande passée.
SELECT cl.nom AS nom_client, j.nom AS nom_jeux, co.date_de_commande 
FROM commandes AS co
JOIN clients AS cl ON co.id_client = cl.id
JOIN commandes_jeux AS cj ON co.id = cj.id_commande
JOIN jeux AS j ON j.id = cj.id_jeu;

-- 2.  Sélectionnez les noms des clients et le montant total dépensé par chaque client. Triez les résultats par montant total décroissant.
SELECT cl.nom, sum(j.prix) AS total_depense
FROM clients AS cl
JOIN commandes as co ON cl.id = co.id_client
JOIN commandes_jeux AS cj ON co.id = cj.id_commande
JOIN jeux AS j ON j.id = cj.id_jeu
GROUP BY cl.nom
ORDER BY total_depense DESC;

-- 3.  Sélectionnez les noms des jeux, noms de catégories et prix de chaque jeu.
SELECT j.nom AS nom_jeux, c.nom AS nom_categories, j.prix
FROM jeux AS j
INNER JOIN categories AS c
ON j.id_categorie = c.id;

-- 4.  Sélectionnez les noms des clients, date de commande et noms de jeux pour toutes les commandes passées.
SELECT cl.nom AS nom_client, co.date_de_commande, j.nom AS nom_jeu
FROM clients AS cl
JOIN commandes as co ON cl.id = co.id_client
JOIN commandes_jeux AS cj ON co.id = cj.id_commande
JOIN jeux AS j ON j.id = cj.id_jeu;


-- 5.  Sélectionnez les noms des clients, nombre total de commandes par client et montant total dépensé par client. Incluez uniquement les clients ayant effectué au moins une commande.
SELECT cl.nom AS nom_client, count(DISTINCT co.id) AS nb_commandes, sum(j.prix) AS total_commandes
FROM clients AS cl
JOIN commandes as co ON cl.id = co.id_client
JOIN commandes_jeux AS cj ON co.id = cj.id_commande
JOIN jeux AS j ON j.id = cj.id_jeu
GROUP BY cl.id ; 
