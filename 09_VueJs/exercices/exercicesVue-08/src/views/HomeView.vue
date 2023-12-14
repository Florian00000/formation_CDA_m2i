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
            <!-- à la place du router link je peux utiliser un bouton qui renvoie une fonction où il y a un router.push('/customer/customer.id'); Je dois tout de même affecter mon router avant ca avec : const router = useRouter();-->
        
    </div>
</section>
</template>

<style scoped>

</style>