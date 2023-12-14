<script setup>

import {inject} from 'vue';
import { RouterLink } from 'vue-router';

const customerlist = inject('customerlist').customerlist;

console.log(customerlist);
</script>

<template>
<h1>Cette page affiche la liste des clients</h1>

<p>Cliquez sur une carte affiche le nom en dessous</p>
<p>Cliquer sur 'Plus de détails' redirige vers une nouvelle page qui affiche les informations du client</p>

<section>
    <div v-for="customer in customerlist">
        <h3> {{ customer.name }}</h3>
        <p>{{ customer.email }}</p>
        <p>{{ customer.phone }}</p>
        
            <RouterLink :to="`/customer/${customer.id}`" class="btn btn-primary">Cliquez pour plus de détails</RouterLink> 
        
    </div>
</section>
</template>

<style scoped>

</style>