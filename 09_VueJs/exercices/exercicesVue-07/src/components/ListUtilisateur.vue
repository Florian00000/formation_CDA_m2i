<script setup>
import { ref } from 'vue'
import AjoutUtilisateur from './AjoutUtilisateur.vue'

const utilisateurs = ref([])
const nomUtilisateur = ref('')
const mailUtilisateur = ref('')


//fonctions
const ajouterUtilisateur = (utilisateur) => {
    utilisateurs.value.push(utilisateur)
    console.log(utilisateurs)
}

const supprimerUtilisateur = (index) => {
    utilisateurs.value.splice(index, 1)
}

function sauvegarderEdition(index) {
    utilisateurs.value[index].nom = nomUtilisateur.value
    utilisateurs.value[index].email = mailUtilisateur.value
    utilisateurs.value[index].afficherInputEditer = false;
    nomUtilisateur.value = '';
    mailUtilisateur.value = '';
}
</script>

<template>
    <AjoutUtilisateur @ajouter-utilisateur="ajouterUtilisateur" />

    <table class="table">
        <thead>
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Email</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(utilisateur, index) in utilisateurs">
                <!-- Nom utilisateur -->
                <td v-if="utilisateur.afficherInputEditer === false">{{ utilisateur.nom }}</td>
                <td v-if="utilisateur.afficherInputEditer === true">
                    <input type="text" class="form-control mx-2" :placeholder="utilisateur.nom" v-model="nomUtilisateur" />
                </td>

                <!-- Email Utilisateur -->
                <td v-if="utilisateur.afficherInputEditer === false">{{ utilisateur.email }}</td>
                <td v-if="utilisateur.afficherInputEditer === true">
                    <input type="text" class="form-control mx-2" :placeholder="utilisateur.email"
                        v-model="mailUtilisateur" />
                </td>

                <!-- Actions -->
                <td>
                    <button v-if="utilisateur.afficherInputEditer === false" class="btn btn-warning mx-2"
                        v-on:click="utilisateur.afficherInputEditer = !utilisateur.afficherInputEditer">
                        Editer
                    </button>
                    <button v-if="utilisateur.afficherInputEditer === true" class="btn btn-primary mx-2"
                        v-on:click="sauvegarderEdition(index)">
                        Editer
                    </button>

                    <button v-if="utilisateur.afficherInputEditer === false" class="btn btn-danger mx-2"
                        v-on:click="supprimerUtilisateur(index)">
                        Supprimer
                    </button>
                    <button v-if="utilisateur.afficherInputEditer === true" class="btn btn-secondary mx-2"
                        v-on:click="utilisateur.afficherInputEditer = !utilisateur.afficherInputEditer">
                        Annuler
                    </button>
                </td>
            </tr>
        </tbody>
    </table>
</template>

<style scoped></style>
