<script setup>
import { useApiRickMorty } from '@/stores/apiRickMorty.js'
import { ref, onMounted, computed } from 'vue';


//Store Api Rick et Morty
const apiRickMorty = useApiRickMorty();

onMounted( async() => {
  console.log(`the component is now mounted.`)
 //console.log(test);
})

/* const test = computed(() => {
  return apiRickMorty.listCharacters.value.info?.pages
})
 */
let page = ref(1);
// let pageInput = ref(page);

function pagePrecedente(){
    page.value--;
    apiRickMorty.fetchListCharacters(page.value)
}

function inputPage(){ 
    if (page.value > 42) {
        page.value = 42
    }      
    apiRickMorty.fetchListCharacters(page.value)    
}
function pageSuivante(){
    page.value++;
  apiRickMorty.fetchListCharacters(page.value)
}
console.log("ici");


</script>

<template>

    <button v-on:click.prevent="pagePrecedente" class="btn btn-outline-secondary" :disabled="page<=1">{{ '<' }}</button>
    <input @keyup.enter="inputPage" v-model="page" type="number" class="btn btn-outline-secondary" min="1"
      :max="apiRickMorty.listCharacters?.info?.pages"
      required >
    <button v-on:click.prevent="pageSuivante" class="btn btn-outline-secondary" :disabled="page>= apiRickMorty.listCharacters?.info?.pages">></button>   

  
</template>

<style scoped>

input[type=number] {
    appearance: textfield;
}

</style>
