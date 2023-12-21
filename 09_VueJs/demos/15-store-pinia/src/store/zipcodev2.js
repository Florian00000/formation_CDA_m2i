import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useZipCodeStore = defineStore('zipcode', () => {
  const zipData = ref([]);

  // Fonction pour trouver des données par code postal
  const dataForZipCode = computed(() => (zipCode) => {
    return zipData.value.find(data => data['post code'] === zipCode);
  });

  // Action pour charger les données depuis l'API avec Axios
  async function fetchZipCodeData(zipCode) {
    try {
      const response = await axios.get(`https://api.zippopotam.us/fr/${zipCode}`);
      zipData.value.push(response.data);
    } catch (err) {
      console.error('Erreur lors de la récupération des données :', err);
    }
  }

  // Action pour supprimer des données du store
  function removeZipCodeData(zipCode) {
    zipData.value = zipData.value.filter(data => data['post code'] !== zipCode);
  }

  return { zipData, dataForZipCode, fetchZipCodeData, removeZipCodeData };
});
