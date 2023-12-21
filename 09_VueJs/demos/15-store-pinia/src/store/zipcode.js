import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

export const useZipCodeStore = defineStore('zipcode', () => {
  const zipData = ref([]);

  // Fonction pour trouver des données par code postal
  const dataForZipCode = computed(() => (zipCode) => {
    return zipData.value.find(data => data['post code'] === zipCode);
  });

  // Action pour charger les données depuis l'API
  async function fetchZipCodeData(zipCode) {
    try {
      const response = await fetch(`https://api.zippopotam.us/fr/${zipCode}`);
      if (!response.ok) {
        throw new Error('Erreur lors de la récupération des données');
      }
      const data = await response.json();
      zipData.value.push(data);
    } catch (err) {
      console.error(err);
    }
  }

  // Action pour supprimer des données du store
  function removeZipCodeData(zipCode) {
    zipData.value = zipData.value.filter(data => data['post code'] !== zipCode);
  }

  return { zipData, dataForZipCode, fetchZipCodeData, removeZipCodeData };
});
