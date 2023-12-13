<script setup>

import {inject} from 'vue'

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
        <button type="button" class="btn btn-primary">
            <RouterLink :to="`/customer/${customer.id - 1}`"></RouterLink> Cliquez pour plus de détails
        </button>
    </div>
</section>
</template>

<style scoped>

</style>