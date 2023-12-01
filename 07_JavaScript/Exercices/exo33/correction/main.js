// Fonction pour retourner un temps formaté selon le pattern 'hh:mm:ss' à partir des secondes
const toFormattedTime = (seconds) => {
  const hoursText = Math.floor(seconds / 3600)
    .toString()
    .padStart(2, "0"); // padStart nous assure un texte avec des 0 avant le chiffre en cas de valeur inférieure à 10
  const minutesText = Math.floor(seconds / 60 - +hoursText * 60)
    .toString()
    .padStart(2, "0");
  const secondsText = (seconds % 60).toString().padStart(2, "0");

  return `${hoursText}:${minutesText}:${secondsText}`; // On retourne le texte correctement formaté
};

document.addEventListener("DOMContentLoaded", () => {
  // En cas de lancement d'un minuteur par envoi du formulaire
  document.getElementById("minuteur-form").addEventListener("submit", (e) => {
    e.preventDefault();

    // On lit les infos du formulaire
    const hours = +document.getElementById("hours").value;
    const minutes = +document.getElementById("minutes").value;
    const seconds = +document.getElementById("seconds").value;

    // On calcule le temps total en seconde
    let total = hours * 3600 + minutes * 60 + seconds;

    // ON formate le minuteur dés son lancement
    document.getElementById("minuteur-display").textContent =
      toFormattedTime(total);

    // Toutes les secondes, on va mettre à jour le temps qui passe et l'affichage
    let interval = setInterval(() => {
      total--; // On retire une seconde au temps restant
      document.getElementById("minuteur-display").textContent =
        toFormattedTime(total); // On met à jour l'affichage de l'HTML
      if (total <= 0) {
        // Si le temps est écoulé
        clearInterval(interval); // ON stoppe le minuteur
        interval = undefined;
        let audio = new Audio("./assets/ring.mp3"); // On créé un objet audio à partir d'un MP3
        audio.play(); // On joue le son
        setTimeout(() => audio.pause(), 5000); // 5s plus tard, il s'arrête
      }
    }, 1000);
  });

  // Pour le chrono, il faut rendre disponible pour tous les évènements la valeur du chrono, l'interval et le dernier chrono
  let chrono = 0;
  let chronoInterval;
  let lastLap;

  // En cas de lancement du chrono
  document.getElementById("chrono-start").addEventListener("click", () => {
    chronoInterval = setInterval(() => {
      chrono++; // On augmente d'une seconde chaque seconde
      document.getElementById("chrono-display").textContent =
        toFormattedTime(chrono); // On met à jour l'affichage
    }, 1000);
  });

  document.getElementById("chrono-pause").addEventListener("click", () => {
    if (chronoInterval) {
      clearInterval(chronoInterval); // On met en pause le chrono
      chronoInterval = undefined;
    }
  });

  document.getElementById("chrono-lap").addEventListener("click", () => {
    const newLIElement = document.createElement("li"); // On créé une balise <li>

    // On définit son temps par rapport à une comparaison avec le dernier tour en cas de dernier tour, ou à la valeur du chrono si pas encore de dernier tour
    newLIElement.textContent = lastLap
      ? toFormattedTime(chrono - lastLap)
      : toFormattedTime(chrono);
    lastLap = chrono; // Le dernier tour devient le temps actuel
    document.getElementById("chrono-listing").appendChild(newLIElement); // On ajoute le <li> à notre <ol>
  });
});
