<script setup>
import { defineEmits, ref } from 'vue';

const emit = defineEmits(['ajouter-utilisateur']);

const nomUtilisateur = ref('');
const mailUtilisateur = ref('');

function emitAjouterUtilisateur() {
    if (validationEmail(mailUtilisateur.value) === true) {        

        //on créer un utilisateur à partir des inputs et on l'envoi à la liste
        emit('ajouter-utilisateur', {
            nom: nomUtilisateur.value,
            email:  mailUtilisateur.value,
            afficherInputEditer: false
        });       
        
            //On réinitialise les champs
            nomUtilisateur.value = '';
            mailUtilisateur.value = '';
        
    } else {
        console.log('test ca marche pas');
    }

       
}

function validationEmail(mail) {
    return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\.[a-zA-Z]{2,}$/.test(mail.toLowerCase());
}

</script>

<template>
    <form v-on:submit.prevent="emitAjouterUtilisateur" class="d-flex flex-row">
        <div>
            
            <label for="nom" class="">Nom</label>
            <input type="text" class="form-control mx-2" id="nom" v-model="nomUtilisateur" @keyup.enter="emitAjouterUtilisateur">

        

        
            <label for="email" class="">Email</label>
            <input type="email" class="form-control mx-2" id="email" v-model="mailUtilisateur" @keyup.enter="emitAjouterUtilisateur">
        </div>
        
        
        
        <button class="btn btn-primary" >Ajouter</button>
    </form>

    <!-- à faire plus tard ;) -->
    <!-- <div class="alert alert-danger" role="alert">
  This is a danger alert—check it out! 
    </div> -->

  
</template>

<style scoped>

</style>
