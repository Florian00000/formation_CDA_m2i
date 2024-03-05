import { configureStore } from "@reduxjs/toolkit"
import recipeSlice from "./components/recipe/recipeSlice"
import authSlice from "./components/auth/authSlice"

export default configureStore({
    reducer: {
        recipe: recipeSlice,
        auth: authSlice,
    }
})