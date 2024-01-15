### Exercice : Application de Liste de Tâches en Mode Console avec Redis et Node.js

**Objectif** : Créer une application de gestion de liste de tâches en mode console. Les utilisateurs pourront interagir avec l'application via la ligne de commande pour ajouter, afficher et supprimer des tâches. Les tâches seront stockées dans une base de données Redis.

**Prérequis** :
- Node.js et Redis installés sur votre machine.
- Créer un nouveau projet Node.js (`npm init`).
- Installer le package Redis (`npm install redis`).
- Installer un package pour la gestion des entrées en ligne de commande, comme `readline` (`npm install readline`).

**Fonctionnalités à Implémenter** :
1. **Ajouter une Tâche** : Permet aux utilisateurs d'ajouter une nouvelle tâche à la liste.
2. **Afficher les Tâches** : Permet aux utilisateurs de voir toutes les tâches enregistrées.
3. **Supprimer une Tâche** : Permet aux utilisateurs de supprimer une tâche spécifique.