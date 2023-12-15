import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useTodoStore = defineStore('todo', () => {
  
  const todos = ref([]);

  const todoForId = computed((todoId) => todos.value.find(t => t.id === todoId));

  function addTodo(todo){
    todos.value.push(todo)
  }

  function removeTodo(todo){
    todos.value = todos.value.filter(t => t!== todo)
  }

  return { todos, todoForId, addTodo, removeTodo }
})
