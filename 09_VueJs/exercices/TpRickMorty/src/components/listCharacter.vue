<script setup>
import { useApiRickMorty } from '@/stores/apiRickMorty.js'
import { onMounted } from 'vue'
import { useRoute } from "vue-router";

//Partie relatif à la route
const route = useRoute();
const { pageId } = route.params;


//Store Api Rick et Morty
const apiRickMorty = useApiRickMorty()

onMounted(async () => {
  await apiRickMorty.fetchListCharacters(pageId)
  console.log(apiRickMorty.listCharacters)
})
</script>

<template>
  <section>
      <div v-for="character in apiRickMorty.listCharacters.results" class="cards">
          <img :src=character.image alt="" width="225px">      
        <h3>{{ character.name }}</h3>
        <p>Species: {{ character.species }}</p>
      </div>
      
  </section>
  
</template>

<style scoped>

.cards{
    border: 1px solid black;
    border-radius: 1rem;
    width: 20%;
    margin: 2%;
    text-align: center;
    box-shadow: 8px 4px 4px rgba(175, 175, 175, 0.832);

    & img{
        margin: auto;
        padding-top: 0.5rem;
        border-radius: 1rem;
    }
}

section{
    display: flex;
    flex-wrap: wrap; 
}

</style>
