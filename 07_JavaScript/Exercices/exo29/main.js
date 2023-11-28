document.addEventListener("DOMContentLoaded", () =>{
  //On récuppère les éléments du formulaire
  const form = document.getElementById("form");
  const pseudoElement = document.getElementById('pseudo')
  const mdpElement = document.getElementById("mdp");
  const submitBtnElement = document.getElementById('submit')

  //validation de champs
  const validationChamps = function (element) {
    element.addEventListener("input", (event) => {
      const inputElement = event.target;
  
      if (!inputElement.value) {
        inputElement.style.backgroundColor = "red";
      }else{
        inputElement.style.backgroundColor = "white";
      }
      
      //Activation du bouton d'envoi
      if (!pseudoElement.value || !mdpElement.value) {
        submitBtnElement.setAttribute('disabled', '');    
      } else {    
        submitBtnElement.removeAttribute('disabled');
      }

    })
  }; 
  
  
  validationChamps(pseudoElement);
  validationChamps(mdpElement);
  

  // On écoute l'envoie du formulaire
  form.addEventListener("submit", (event) => {
    event.preventDefault();    

    if (pseudoElement.value && mdpElement.value) {
      form.style.backgroundColor = "chartreuse";
      const userDetails = {
        username: pseudoElement.value,
        password: mdpElement.value
      };
      console.log(userDetails);
    }
  });
});
