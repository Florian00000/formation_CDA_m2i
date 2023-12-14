import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CustomerDetail from '../views/CustomerDetail.vue';
import PageNotFound from '../views/PageNotFound.vue'


const router = createRouter({
  history: createWebHistory(),
  routes: [       
    {path: '/', component: HomeView},
    {path: '/customer/:customerId', component: CustomerDetail},
    {path: '/:pathMatch(.*)', redirect  : '/not-found' },
    {path: '/not-found' , component : PageNotFound}
  ]
})

export default router
