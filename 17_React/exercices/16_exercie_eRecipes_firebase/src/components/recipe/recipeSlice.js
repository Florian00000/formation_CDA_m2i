import {createSlice} from "@reduxjs/toolkit"

const recipeSlice = createSlice({
    name: "recipe",
    initialState: {
        recipes : []
    },
    reducers: {
        addRecipe: (state, action) => {
            state.recipes.push(action.payload)
        },
        setRecipe: (state, action) => {
            state.recipes = action.payload
        },
        deleteRecipe: (state, action) => {
            state.recipes = state.recipes.filter((recipe) => { recipe.key !== action.payload })
        }
    }
});

export const { addRecipe, setRecipe, deleteRecipe} = recipeSlice.actions;
export default recipeSlice.reducer;