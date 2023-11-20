let rayon, hauteur, r;

rayon = parseFloat(prompt("Entrez la valeur du rayon en cm"));

hauteur = parseFloat(prompt("Entrez la valeur de la hauteur en cm"));

r = (Math.PI * (rayon**2) * hauteur ) / 3;

alert(`Le volume du cône est de ` + r + " cm³");