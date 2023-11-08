# Les tableaux et les boutons en HTML

## Les tableaux

Pour construire un tableau, il me faut avant tout une balise `<table></table>`. A l'intérieur de cette balise, je spécifie le nombre de lignes que comporte mon tableau à l'aide de `<tr></tr>` (table-row). 

```html
<table>
    <tr></tr>
    <tr></tr>
    <tr></tr>    
</table>
```

A l'intérieur de ces lignes, je peux placer des en-têtes (headers) avec `<th></th>` (table-header) ou des données avec des `<td></td>` (table-data)

```html
<table>
    <tr>
        <th>header1</th>
        <th>header2</th>        
    </tr>
    <tr>
        <td>data1</td>
        <td>data2</td>        
    </tr> 
    <tr>
        <td>data1</td>
        <td>data2</td>        
    </tr>  
</table>
```

Pour le référencement et pour un code plus solide et lisible, je précise grâce aux balises `<thead></thead>`, `<tbody></tbody>` et `<tfoot></tfoot>` l'organisation de mon tableau.

```html
<table>
    <thead>
        <tr>
            <th>header1</th>
            <th>header2</th>           
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>data1</td>
            <td>data2</td>        
        </tr> 
        <tr>
            <td>data1</td>
            <td>data2</td>        
        </tr>
    </tbody>  
</table
```

On peut rajouter un titre à sont tableau grâce à la balise `<caption></caption>`  
Au niveau des attributs, on peut rajouter des attributs de style à notre tableau, mais on évitera de le faire si on utilise du CSS:  
`border= taille_en_px` la taille en pixels des bordures  
`width= taille_en_px` la longueur en pixels de notre tableau  
`height= taille_en_px` la largeur en pixels de notre tableau  
`align= left, right ou center` L'alignement vertical des données.

Si on veut que l'une de nos données prenne plus d'un ligne ou colonne, on lui appliquera l'attribut `rowspan="nombre"` ou `colspan="nombre"`

## Les boutons

Pour créer un bouton en HTML, j'utiliserai une balise `<button></button>`  
Il est cependant intéressant de spécifier le type de bouton, grâce à l'attribut `type`: 
- `<button type="button">`: Il s'agit d'un bouton classique. C'est le choix par défaut si le type n'est pas scpécifié.  
- `<button type="submit">`: Utile unquement au sein d'un formulaire, il envoie le formulaire.  
- `<button type="reset">` : Utile également au sein d'un formulaire, il réinitialise les champs de ce formulaire.

Si on veut désactiver un bouton, on lui met l'attribut `disabled`