// import ring from "./assets/ring.mp3";

let nb = 10;

document.addEventListener("DOMContentLoaded", () => {
  /* Pour définir des actions qui auront lieu toutes les XXX millisecondes, on peut utiliser setInterval()
   * Cette fonction prend en premier paramètre la fonction à répéter
   * et en second paramètre la valeur en milliseconde pour l'interval de temps
   */
  let compte;

  // Quand on appuie sur play, on doit pouvoir lancer le compteur
  document.querySelector("#play-count").addEventListener("click", () => {
    compte = setInterval(() => {
      if (nb <= 0) {
        const son = new Audio("./assets/ring.mp3");
        son.play();
        console.log("Fini");
        clearInterval(compte);
        compte = undefined;
      } else {
        document.querySelector("#count-value").textContent = nb--;
      }
    }, 1000);
  });

  // Quand on appuie sur stop, on doit pouvoir stopper le compteur
  document.querySelector("#stop-count").addEventListener("click", () => {
    clearInterval(compte);
    compte = undefined;
    document.querySelector("#count-value").textContent = nb = 10;
  });

  // let resultat;

  // setTimeout(() => {
  //   console.log("On a récupéré la valeur !");
  //   resultat = "Texte";
  // }, 5000);
  // console.log(resultat);

  let interval; // Cette variable servira à stocker notre futur mécanisme

  // ADV: Pour éviter de faire une vérification de contenu d'un input à chaque lettre saisie, on va faire un mécanisme de 'debouncing'
  document.querySelector("#mon-input").addEventListener("input", (e) => {
    // Si on a déjà une vérification en attente...
    if (interval) {
      // On supprime le mécanisme en attente
      clearTimeout(interval);
      // On libère la mémoire pour éviter de stocker un interval ne causant plus aucune fonctionnalité
      interval = undefined;
    }

    // Dans tous les cas, on va créer une vérification différée

    // ON stocke l'interval (la vérification différée de notre input)
    interval = setTimeout(() => {
      // On récupère la valeur de l'input
      const valeur = e.target.value;

      // ON vérifie la valeur de l'input
      if (valeur === "Blabla") {
        console.log("C'est bon!");
      } else {
        console.log("Mauvaise valeur!");
      }
    }, 1000); // Ce mécanisme aura lieu au bout de 1s
  });
});
