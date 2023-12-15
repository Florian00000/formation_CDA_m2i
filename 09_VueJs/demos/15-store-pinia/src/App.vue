<script setup>
import { RouterLink, RouterView, useRouter, useRoute } from "vue-router";
import { useAuthStore } from "./stores/auth";

const authStore = useAuthStore()

const route = useRoute()
const router = useRouter()

function switchSign() {
  if (authStore.isLoggedIn) {
    authStore.logout()
    if (route.fullPath.startsWith('/games/add')) router.push('/')
  } else {
    authStore.login({ username: 'User', password: "password"})
  }
}
</script>

<template>
  <header>
    <nav>
      <ul>
        <li>
          <RouterLink to="/">Home</RouterLink>
        </li>
        <li>
          <RouterLink to="/games">Games</RouterLink>
        </li>
        <li style="margin-left: auto;"><button @click="switchSign">{{ authStore.isLoggedIn ? 'Sign Out' : 'Sign In' }}</button></li>
      </ul>
    </nav>
  </header>

  <main>
    <RouterView />
  </main>

  <footer>
    ©️ Utopios
  </footer>
</template>

<style>
body,
html {
  margin: 0;
}

#app {
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template: auto 1fr auto / 1fr;
}

#app * {
  font-family: monospace;
}
</style>

<style scoped>
header,
footer {
  padding-block: 1vh;
  padding-inline: 2%;
  background-color: rgb(125, 23, 23);
  color: white;
}

main {
  margin-inline: 2%;
}

nav ul {
  padding-left: 0;
  list-style: none;
  display: flex;
  gap: 0 1%;
  align-items: center;
}

nav ul li a {
  color: hsl(0, 0%, 90%);
  font-size: 0.9rem;
  text-decoration: none;
  position: relative;
  transition: transform 200ms ease,
              color 200ms ease;
}

nav ul li a::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 0;
  width: 0%;
  border-bottom: white solid 1px;
  transition: width 200ms ease,
              border-color 200ms ease;
}

nav ul li a:hover {
  transform: scale(1.2);
  color: orange;
}

nav ul li a:hover::after {
  width: 100%;
  border-color: orange;
}

nav ul li a.router-link-exact-active {
  color: yellow;
}

nav ul li a.router-link-exact-active::after {
  border-color: yellow;
  width: 100%;
}
</style>
