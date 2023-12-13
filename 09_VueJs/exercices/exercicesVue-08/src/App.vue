<script setup>
import { provide, ref } from 'vue';
import { RouterView } from 'vue-router';
import customerlist from './assets/json/customerlist.json';
import customer1 from './assets/json/customer1.json';
import customer2 from './assets/json/customer2.json';
import customer3 from './assets/json/customer3.json';

const customers = ref([customer1, customer2, customer3]);

provide ('customerlist', {customerlist});
provide ('customers', {customers});

console.log(customers);


</script>

<template>

  <RouterView/>
  
</template>

<style scoped>

</style>
