<script setup>
import { inject } from "vue";
import { useRoute, useRouter } from "vue-router";

const { customers } = inject("customers");
// équivalent à
// const customers = inject('customers').customers;

const route = useRoute();
const router = useRouter();

const { customerId } = route.params;

const customerFound = customers.value.find(
  (c) => c.id === parseInt(customerId)
);

if(!customerFound){
  router.push('/not-found')
}
</script>

<template>
  <h1>Details Clients</h1>

  <h3>{{ customerFound?.name }}</h3>

  <p>Nom: {{ customerFound?.name }}</p>
  <p>Courriel: {{ customerFound?.email }}</p>
  <p>téléphone cellulaire: {{ customerFound?.phone }}</p>
  <p>Commune: {{ customerFound?.city }}</p>
  <p>Département: {{ customerFound?.state }}</p>
  <p>Nationalité: {{ customerFound?.country }}</p>
  <p>Société: {{ customerFound?.organization }}</p>
  <p>Profession: {{ customerFound?.jobProfile }}</p>
  <p>Complément d'information: {{ customerFound?.additionalInfo }}</p>

  <RouterLink :to="`/`" class="btn btn-primary"
    >Retour à la page précédente</RouterLink
  >
</template>

<style scoped></style>
