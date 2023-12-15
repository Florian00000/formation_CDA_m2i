<script setup>
import GameCardComponent from "../../components/games/GameCardComponent.vue";
import { useGamesStore } from "../../stores/games";
import { useAuthStore } from "../../stores/auth";

const gamesStore = useGamesStore();
const authStore = useAuthStore()

</script>

<template>
  <h1>GamesListView</h1>
  <template v-if="gamesStore.games.length > 0">
    <hr />
    <div class="game-cards-container">
      <GameCardComponent v-for="g of gamesStore.games" :gameId="g.id" />
    </div>
    <hr />
  </template>
  <div class="links">
    <RouterLink v-if="authStore.isLoggedIn" to="/games/add">Add a Game</RouterLink>
  </div>
</template>

<style scoped>
.game-cards-container {
  display: flex;
  flex-wrap: wrap;
  height: 650px;
  padding-block: 2.5%;
  box-sizing: border-box;
  overflow-y: scroll;
}

.game-cards-container::-webkit-scrollbar {
  width: 10px;
}

.game-cards-container::-webkit-scrollbar-track {
  background: transparent;
}

.game-cards-container::-webkit-scrollbar-thumb {
  background: rgb(155, 24, 24);
  border-radius: 5px;
}

.game-cards-container::-webkit-scrollbar-thumb:hover {
  background: rgb(155, 57, 24);
  cursor: pointer;
}

.game-cards-container > * {
  flex-basis: 18%;
  margin: 1%;
  box-sizing: border-box;
}

.game-card {
  height: 300px;
}

.links {
  display: flex;
  justify-content: end;
}

.links > a {
  padding: 0.5ch 2ch;
  background-color: rgb(155, 24, 24);
  border-radius: 1ch;
  text-decoration: none;
  color: white;
  font-size: 1.1rem;
  transition: transform 200ms ease, background-color 200ms ease;
}

.links > a:hover {
  background-color: rgb(155, 57, 24);
  transform: scale(1.05);
}
</style>
