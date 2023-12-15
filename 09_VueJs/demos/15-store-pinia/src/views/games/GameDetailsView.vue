<script setup>
import { useGamesStore } from "../../stores/games";
import { useRoute, useRouter } from "vue-router";

const gamesStore = useGamesStore();

const route = useRoute();
const router = useRouter();

const gameFound = gamesStore.games.find((g) => g.id === route.params.gameId);

if (!gameFound) router.push("/not-found");

console.log(gameFound);
</script>

<template>
  <div class="view">
    <h1>{{ gameFound.title }}</h1>
    <img class="game-picture" :src="gameFound.pictureURL" alt="Game poster" />
    <ul>
      <li>
        Score: <b>{{ gameFound.score + "/5" }}</b>
      </li>
      <li>
        Release date:
        <b>{{
          gameFound.releaseDate.toLocaleString("fr-Fr").substring(0, 10)
        }}</b>
      </li>
      <li>
        Description: <b>{{ gameFound.description }}</b>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.view {
  padding: 4% 0;
  display: grid;
  grid-template: 2fr 8fr / 4fr 6fr;
}

.view h1 {
  grid-row: 1;
  grid-column: 1 / span 2;
}
.game-picture {
  grid-row: 2;
  grid-column: 1;
  
  height: 100%;
  width: 100%;
  object-fit: cover;
}
</style>
