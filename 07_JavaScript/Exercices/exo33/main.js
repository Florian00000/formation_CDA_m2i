document.addEventListener("DOMContentLoaded", () => {

    let tempsMinuteur;
    let decompte;

    //On écoute le démarrage du minuteur
    document.getElementById("form-minuteur").addEventListener("submit", (event) => {
        event.preventDefault();
        //On récuppère les valeurs des inputs
        const tempsHeures = (document.getElementById("temps-heures").value) * 3600;
        const tempsMinutes = (document.getElementById("temps-minutes").value) * 60;
        const tempsSecondes = parseInt(document.getElementById("temps").value);
        tempsMinuteur = tempsHeures + tempsMinutes + tempsSecondes;

        
        let son = new Audio("./assets/ring.mp3");
        decompte = setInterval(() => {
            if (tempsMinuteur <= 0) { 
                document.getElementById("minuteur").textContent = "00:00:00";                               
                son.play();
                clearInterval(decompte);
                decompte = undefined;
            }else {
                //Sinon on met à jour le minuteur
                tempsMinuteur--;
                //Partie pour afficher en hh:mm:ss
                let hour = Math.floor(tempsMinuteur / 3600);
                (hour < 10) ? hour = `0${hour}` : hour = hour;
                let minute = Math.floor((tempsMinuteur - hour * 3600) / 60);
                (minute < 10) ? minute = `0${minute}` : minute = minute;
                let seconds = tempsMinuteur - (hour * 3600 + minute * 60);                
                (seconds < 10) ? seconds = `0${seconds}` : seconds = seconds;
                document.getElementById("minuteur").textContent = `${hour}:${minute}:${seconds}`;               
            }
        }, 1000);

        //On écoute le reset
        document.getElementById("reset").addEventListener("click", () => {
            son.pause();       
            clearInterval(decompte);
            decompte = undefined;
            document.getElementById("minuteur").textContent = tempsMinuteur = 0;
        })
    })

});