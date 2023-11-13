# les formulaires en HTML

Pour ouvir et fermer un formulaire, on applique les balises `<form></form>`. Cette balise contiendra beaucoup d'attributs important pour notre JavaScript. Mais nous allons d'abord voir le placement des inputs en HTML:

## Les Inputs

En HTML, les éléments `<input>` sont utilisés pour collecter des données entrées par les utilisateurs. Il existe plusieurs types d'input courament utilisés pour différents types de données et d'intéractions.  
Si je veux rendre l'un de mes inputs **obligatoire**, j'utilise l'attribut `required`.

1. **Texte (`text`):** Ce type d'input permet aux utilisateurs de saisir du texte libre, comme des noms, des adresses, des commentaires, etc.

```html
<input type="text" placeholder="exemple" name="nom_input">
```

2. **Mot de passe (`password`):** utilisé pour collecter des mots de passe, ce type masque les caractères saisis

```html
<input type="password" placeholder="Votre mdp" name="mdp">
```

3. **Cases à cocher (`checkbox`):** Les cases à cocher permettent aux utilisateurs de sélectionner plusieurs options parmi un groupe d'éléments.

```html
<input type="checkbox" name="sports" value="football"> Football
<input type="checkbox" name="sports" value ="basketball"> Basketball
```

Le name servira à regroupera des checkbox autour d'une thématique commune. C'est l'attribut value qui nous retournera la valeur de nos checkboxes indépendantes.

4. **Boutons radio (`radio`):** Les boutons radio permettent aux utilisateurs de ne sélectionner qu'une seule option parmi un groupe d'éléments. C'est là aussi l'attribut `name` qui permet de rattacher des éléments entres eux.

```html
<input type="radio" name="sports" value="football"> Football
<input type="radio" name="sports" value ="basketball"> Basketball
```

5. **E-mail (email):** Utilisé pour collecter des adresses e-mail, il vérifie également la validité de la syntaxe de l'adresse saisie.

```html
<input type="email" name="email">
```

6. **Date (`date`):** utilisé pour collecter des dates.

```html
<input type="date" name="date">
```

7. **Numérique(`number`):** Ce type d'input permet aux utilisateurs de saisir des valeurs numériques.

```html
<input type="number" name="quantite" min="0" max="10" step="2">
```

8. **URL (`url`):** Utilisé pour collecter des URL (adresse de site web), il vérifie également la validité de la syntaxe HTML

```html
<input type="url" placeholder="Votre lien" name="URL_web" >
```

9. **Téléphone (`tel`):** Utilisé pour récolter des numéros de téléphone.

```html
<input type="tel" placeholder="Votre num de tel" name="tel_number" >
```

10. **Fichier(`file`):** Les inputs de type `file` permettent aux utilisateurs de sélectionner et de téléverser des fichiers à partir de leur ordinateur.   
Grâce à l'attribut `multiple`, je peux permettre à l'utilisateur de choisir plusieurs fichiers.

```html
<input type="file"  name="user_file" multiple>
```

11. **Bouton(`button`):** Cet élément créé un bouton personnalisable qui peut être utilisé pour déclancher des actions JavaScript ou des soumissions de formulaire. Il peut également vous permettre de reset le formulaire.

```html
<input type="button"  value="Cliquez ici" name="bouton">
<!-- Envoyer un formulaire -->
<input type="submit"  value="Envoyez">
<!-- Réinitialiser un formulaire -->
<input type="reset"  value="reset">
```

### Les labels

Les balises `<label>` en HTML sont utilisées pour associer un libelé des criptif à un élément de formulaire. Les balises `<label>` sont essentielles pour éaméliorer l'accessibilité des formulaires web, car elles permettent aux utilisateurs de comprendre facilement ce que chaque champ de formulaire représente.

```html
<label for="id_de_l_input">Texte du libellé:</label>
<input type="text" id="id_de_l_input"/>
```

L'attribut for de la balise `<label>` est associé à l'attribut id de l'élément de formulaire que vous souhaitez étiqueter. cela indiquera au navigateur que le label est lié à cet élément. Lorsque l'utilisateur clique sur le libellé, le champ de formulaire correspondant reçoit le focus de l'action associée.

### Autres attributts commun

`autofocus` : Place directement l'utilisateur dans un champ au chragement de la page
`pattern` : Permet de spécifier une expression régulière à un input (utile pour la sécurité)
`maxlenght` : Définit un nombre max de caractères utilisés dans l'input (utile pour la sécurité)
`size` : Modifie le nombre de caractères visibles dans un input
`readonly` : Affiche une valeur qui ne peut pas être modifié par l'utilisateur
`value` : Pré-remplit un champ

### La liste de sélections `select`

Pour afficher une liste déroulant en HTML, j'utiliserai la balise selct. Je délimiterai chacun des options de mon sélecteur à l'aide de la balise `<option>`

```html
<label>Pays:</label>
<select name="pays">
    <option value="France">France</option>
    <option value="Boshland">Boshland</option>
    <option value="Gelbique">Gelbique</option>
</select>
```

### La boîte de texte `textarea`

Un élément `textarea` est utlisé pour créer une zone de texte multiligne. Je peux définir la taille de ma boîte grâce aux attributs `rows` et `cols`.

```html
<textarea name="description" rows="4" cols="20">
    Saisissez cotre commentaire içi
</textarea>
```

### Action et la méthode

Une fois que mon formulaire est complété, je demanderai à l'utilisateur de l'envoyer via un input submit ou un bouton. A ce moment-là, la méthode et l'action se déclancheront. Méthodes et actions se configurent à traver leurs **attributs** au sein de la balise `form`.

L'attribut `action` définit le fichier où les données du formulaire seront envoyés. On le remplit donc généralement avec un lien vers une page du serveur.

La méthode, elle, définit **le type d'envoi** de ces données. On le trouve sous deux formes :  
**La méthode GET:** On transmet les données directement via l'URL en y stockant no paires name/valeurs. Attention, notre URl est limité à 2048 caractères, ce n'est donc pas une méthode viable pour un gros formulaire. Toutes les informations s'affichent en clair dans cet URL, on peut donc pas y passer des données sensibles. C'est la méthode recommandée pour des données neutres ou non personnalisées.

**La méthode POST:** Avec cette méthode on envoie les données à travers une requête HTTP. Les données sont donc masquées et il n'y a pas de limitation de taille. C'est la méthode recommandée pour tous les formulaires qui concernent diirectement les informations pesonneles d'un utilisateur par exemple.

### Le groupement de champs

Si on veut regrouper manuellement un ensemble de champs d'un formulaire, on en a la possibilité grâce à la balise `fieldset`. Par défaut, elle encadrera les différents champs regroupés. On peut nommer ces différents groupements en utilisant à l'intérieur de mon `fieldset` la balise `legend`.

