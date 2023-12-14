import {createRouter, createWebHistory} from 'vue-router';
import HomeView from '../views/HomeView.vue';
import NotFoundView from '../views/NotFoundView.vue';
import FirstAboutView from '../views/about/FirstAboutView.vue';
import SecondAboutView from '../views/about/SecondAboutView.vue';
import ContactView from '../views/ContactView.vue';
import ContactDetails from '../views/ContactDetails.vue';
import AboutView from '../views/AboutView.vue';
import PrivateView from '../views/PrivateView.vue';
import {inject} from 'vue';


const router = createRouter({
  history : createWebHistory(),
  routes : [
    {path: '/', component : HomeView},
    {path: '/:pathMatch(.*)', redirect  : '/not-found' },
    {path: '/not-found' , component : NotFoundView},
    {path: '/contact' , component : ContactView},
    {path: '/contact/:contactId' , component : ContactDetails},
    {path : "/about",
    component : AboutView,
    children: [
      {path: "first", component: FirstAboutView},
      {path: "second", component: SecondAboutView}
    ]
  },
  {path: '/private' , component : PrivateView},
  ]
}
);
router.beforeEach((to,from)=>{
  if(to.path.startsWith("/private")){
    const {user} = inject("user");
    if(user.value) return true;
    else return "/";
  }else return true;
});
export default router;