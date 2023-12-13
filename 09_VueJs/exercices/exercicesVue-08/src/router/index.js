import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CustomerDetail from '../views/CustomerDetail.vue'


const router = createRouter({
  history: createWebHistory(),
  routes: [       
    {path: '/', component: HomeView},
    {path: '/customer/:customerId', component: CustomerDetail}
  ]
})

export default router
