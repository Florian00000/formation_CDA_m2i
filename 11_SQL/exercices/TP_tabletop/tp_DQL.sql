USE tabletoptreasures_database;

-- Table "Categories" :
-- 1.  Sélectionnez tous les noms de catégories distinctes.
SELECT *
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
