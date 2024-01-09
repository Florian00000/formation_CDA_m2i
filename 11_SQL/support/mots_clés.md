# Môts clés du SQL

## Where 

- filtre les résultats du SELECT

## Distinct 

- supprimme les doublons 
- se met après le select 

```sql
SELECT DISTINCT
```

## IN et BETWEEN

```sql
WHERE job IN ('Developer');
```

## ORDER BY 

- DESC pour mettre en ordre décroissant
- quand plusieur ORDER BY, le deuxième tri ne se fait que si le premier n'est pas perturbé. La priorité est le 1e tri.

## LIMIT 

- Limite le nombre de résultats affichés 
- se place après l'ORDER BY

    - ###  OFFSET 
        - Décale le résultat du LIMIT 
        ```sql
        LIMIT 5 OFFSET 3
        ```
        Ici prend les 5 premiers mais en démarrant du 4e.

## Fonctions d'agrégations

- MIN()
- MAX()
- COUNT()
- SUM()
- ROUND()
- AVG() (calcule la valeur moyenne de la colonne)

exemple 
```sql
SELECT MIN(age) FROM users;
```

Le WHERE s'applique avant les fonctions d'agrégations.

## Les alias

- AS 

```sql
SELECT MIN(age) as developer_min_age
FROM users
WHER job = 'Devloper';
```
Ici le résultat est renommé en developer_min_age.

## GROUP BY

- sert surtout à aplliquer des fonctions d'agrégations sur des groupes prédéfinis.

## HAVING

- filtre dédié au `GROUP BY` 
- filtre après un `WHERE`

## LIKE

- filtre en utilisant des patterns de texte 
    - exemple `p%` commence par un p
    - exemple `_o%` a un o en 2e lettre