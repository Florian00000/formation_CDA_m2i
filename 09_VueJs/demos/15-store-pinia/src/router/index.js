import { createRouter, createWebHistory } from "vue-router";
import { useAuthStore } from '../stores/auth';

import HomeView from "../views/HomeView.vue";
import GamesListView from "../views/games/GamesListView.vue";
import GameDetailsView from "../views/games/GameDetailsView.vue";
import GameFormView from "../views/games/GameFormView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", component: HomeView },
    { path: "/games", component: GamesListView },
    { path: "/games/add", component: GameFormView },
    { path: "/games/details/:gameId", component: GameDetailsView },
  ],
});

router.beforeEach((to, from) => {
  const authStore = useAuthStore()
  if (authStore.isLoggedIn) {
    return true
  } else if (to.fullPath.startsWith('/games/add')) return '/'
  return true
})

export default router;
