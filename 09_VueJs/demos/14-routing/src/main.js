import { createApp, ref } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import {v4 as uuid} from 'uuid'


const contacts = ref([
  {
    id: uuid(),
    firstName: "John",
    lastName: "Cena"
  },
  {
    id: uuid(),
    firstName: "Elton",
    lastName: "Musk"
  },

]);

const user = ref(null);

function updateUser(newUser){
  user.value = newUser;

}


const app = createApp(App);
app.provide("contacts",{
  contacts
});
app.provide("user",{
  user,
  updateUser,
});
app.use(router);
app.mount("#app");

