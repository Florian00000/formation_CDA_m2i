<script setup>
import { useGamesStore } from "../../stores/games";

const gamesStore = useGamesStore();

const props = defineProps(["gameId"]);

const gameFound = gamesStore.games.find((g) => g.id === props.gameId);

</script>

<template>
    <RouterLink :to="`/games/details/${gameFound.id}`" class="game-card">
      <div class="card-picture">
        <img :src="gameFound ? gameFound.pictureURL : 'http://random.imagecdn.app/500/500'" alt="">
      </div>
      <div class="card-title">
        <span>{{ gameFound ? gameFound.title : "Unknown" }}</span>
      </div>
  
    </RouterLink>
</template>

<style scoped>
  .game-card {
    text-decoration: none;
    border: solid 1px black;
    border-radius: 10px;
    overflow: hidden;

    display: grid;
    grid-template: 8fr 1fr / 1fr;

    background-color: black;
  }

  .card-title {
    display: block;
    color: transparent;
    padding: 1ch 2ch;
    position: relative;
    left: 120%;
    transition: left 400ms ease,
                color 400ms ease;
  }

  .game-card:hover >.card-title {
    left: 0;
    color: yellowgreen
  }

  .card-picture > img {
    height: 100%;
    width: 100%;
    object-fit: cover;
    transition: filter 200ms ease;
    filter: grayscale(1);
  }

  .game-card:hover > .card-picture > img {
    filter: grayscale(0);
  }

</style>
