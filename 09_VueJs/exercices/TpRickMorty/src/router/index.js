import { createRouter, createWebHistory } from 'vue-router'
import Characters from '../views/Characters.vue';
import LoginView from '../views/LoginView.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/characters',      
      component: Characters
    },
    {
      path: '/',
      name: 'login',
      component: LoginView
    }
  ]
})

export default router
