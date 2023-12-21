<template>
    <div>
      <button @click="loadData">Charger les données pour Bordeaux</button>
      <div v-if="zipCodeData">
        {{ zipCodeData }}
      </div>
      <div v-if="error">
        Erreur : {{ error }}
      </div>
    </div>
  </template>
  
  <script setup>
  import { useZipCodeStore } from '../stores/zipcodev2';
  import { ref, watchEffect } from 'vue';
  
  const zipCodeStore = useZipCodeStore();
  
  const zipCodeData = ref(null);
  const error = ref(null);
  
  const loadData = async () => {
    try {
      await zipCodeStore.fetchZipCodeData('33000');
      zipCodeData.value = zipCodeStore.zipData.find(data => data['post code'] === '33000');
    } catch (err) {
      error.value = err.message;
    }
  };
  
  watchEffect(() => {
    zipCodeData.value = zipCodeStore.zipData.find(data => data['post code'] === '33000');
  });
  </script>
  