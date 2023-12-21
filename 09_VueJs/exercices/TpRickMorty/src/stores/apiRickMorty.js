import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useApiRickMorty = defineStore('apiRickMorty', () => {
  
  const listCharacters = ref([]);

  const charcterForId = computed((charcterId) => listCharacters.value.find(c => c.id === charcterId));

  //fetch la liste des personnages de l'Api
  async function fetchListCharacters(page){

    if (!page) {
      page = 1
    }

    try {
      const response = await axios.get(`https://rickandmortyapi.com/api/character/?page=${page}`);
      listCharacters.value = response.data;
      // console.log(listCharacters.value);
    } catch (err) {
      console.log('Erreur lors de la récupération des données :', err);
    }
  }



  return { listCharacters, charcterForId, fetchListCharacters }
})