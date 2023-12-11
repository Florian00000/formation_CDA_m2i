<script setup>
import {defineProps, ref} from 'vue';

const props = defineProps({
  todo: {
    type: Object,
    required: true,
  },
  index: {
    type: Number,
    required: true
  }
})

let updateTodoText = ref(props.todo.text)

</script>

<template>
  
 <li class="d-flex flex-row justify-content-between my-2">
  <div>
{{ todo.text }}
  </div>  
  <div>
    <input type="text" placeholder="changer le todo" class="form-control mx-2" v-model="updateTodoText">
    <button class="btn btn-primary mx-2" @click="$emit('edit-todo', index, updateTodoText)">Update</button>
    <button class="btn btn-danger mx-2" @click="$emit('remove-todo', index)">Remove</button>
  </div>
 </li>
</template>

<style scoped>

</style>
