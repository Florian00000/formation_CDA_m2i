<script setup>
import { ref, computed } from "vue";
import { useRouter } from "vue-router";
import { useGamesStore } from "../../stores/games";
import { v4 as uuid } from "uuid";

const router = useRouter();
const gamesStore = useGamesStore();

const { addGame } = gamesStore


const newGame = ref({
  title: "",
  releaseDate: new Date(),
  score: 0,
  description: "",
  pictureURL: "",
});

const buttonDisabled = computed(() => {
  const { title, score, description, pictureURL } = newGame.value;

  let img = new Image()
  img.src = pictureURL;

  return !(
    !!title.trim() &&
    score >= 0 &&
    score <= 5 &&
    !!description.trim() &&
    img.height > 0
  );
});

function submitHandler() {
  addGame({ id: uuid(), ...newGame.value });

  newGame.value = {
    title: "",
    releaseDate: new Date(),
    score: 0,
    description: "",
    pictureURL: "",
  };

  router.push("/games");
}
</script>

<template>
  <h1>Add a Game</h1>
  <form action="#" @submit.prevent="submitHandler">
    <div>
      <label for="title">Title: </label>
      <input type="text" id="title" v-model="newGame.title" required />
    </div>
    <div>
      <label for="releaseDate">releaseDate: </label>
      <input
        type="date"
        id="releaseDate"
        :valueAsDate="newGame.releaseDate"
        @input="newGame.releaseDate = $event.target.valueAsDate"
        required
      />
    </div>
    <div>
      <label for="score">Score: </label>
      <input
        type="number"
        id="score"
        min="0"
        max="5"
        v-model.number="newGame.score"
        required
      />
    </div>
    <div>
      <label for="pictureURL">Picture URL: </label>
      <input
        type="text"
        id="pictureURL"
        v-model="newGame.pictureURL"
        required
      />
    </div>
    <div>
      <label for="description">Description: </label>
      <textarea
        rows="4"
        id="description"
        v-model.number="newGame.description"
        style="resize: none"
        required
      ></textarea>
    </div>
    <div>
      <button :disabled="buttonDisabled">Submit</button>
    </div>
  </form>
</template>

<style scoped>
form {
  width: min(100%, 600px);
}
form div:not(:has(button)) {
  margin-block: 5px;
  display: flex;
  flex-direction: column;
  gap: 2px;
}

form div button {
  display: block;
  margin-left: auto;
  background-color: rgb(94, 23, 23);
  color: white;
  border: none;
  padding: 0.5ch 2ch;
  font-size: 1rem;
  border-radius: 1ch;
  transition: transform 200ms ease, background-color 200ms ease;
}

form div button[disabled] {
  cursor: not-allowed;
  background-color: gray;
}

form div button:not([disabled]):hover {
  cursor: pointer;
  background-color: rgb(146, 48, 28);
  transform: scale(1.05);
}
</style>
