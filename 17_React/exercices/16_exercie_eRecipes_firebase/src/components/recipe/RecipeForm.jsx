import React, { useRef, useState } from "react";
import { ingredients } from "../../data/ingredients";
import axios from 'axios';
import { BASE_DB_URL } from "../../firebaseConfig";
import { useDispatch, useSelector } from "react-redux";
import { addRecipe } from "./recipeSlice";

const RecipeForm = () => {
    const titleRef = useRef();
    const instructionRef = useRef();
    const cookTimeRef = useRef();
    const prepTimeRef = useRef();

    const dispatch = useDispatch();
    
    const [ingredientsRecipe, setIngredientsRecipe] = useState([])

    const handleChecke = (event, ingredient) => {
        if (event.target.checked) {
            setIngredientsRecipe([...ingredientsRecipe, ingredient])            
        }else {
            setIngredientsRecipe(ingredientsRecipe.filter(i => i.id != ingredient.id) )            
        }
    }

    const token = useSelector(state => state.auth.user?.idToken)

    const formSbmit = (e) => {
        e.preventDefault();
        
        const newRecipe = {
            id: Date.now(),
            title: titleRef.current.value,
            instructions: instructionRef.current.value,
            cookTime: +cookTimeRef.current.value,
            prepTime: +prepTimeRef.current.value,
            ingredients: ingredientsRecipe
        }

        axios.post(`${BASE_DB_URL}recipes.json?auth=${token}`, newRecipe)
        .then((response) => {
            console.log(response.data);
            dispatch(addRecipe(newRecipe))
        })
        .catch(error => console.error(error.config))
        
    }

    

  return (
    <>
      <form onSubmit={formSbmit}>
        <div>
            <label htmlFor="title"> Nom de la recette:</label>
            <input type="text" id="title" ref={titleRef}/>
        </div>
        <div>
            <label htmlFor="instruction"> Instructions:</label>
            <input type="text" id="instruction" ref={instructionRef}/>
        </div>
        <div>
            <label htmlFor="cookTime"> Temps de cuisson:</label>
            <input type="number" id="cookTime" ref={cookTimeRef}/>
        </div>
        <div>
            <label htmlFor="prepTime"> Temps de préparation</label>
            <input type="number" id="prepTime" ref={prepTimeRef}/>
        </div>
        <div>
            {ingredients.map((ingredient, index) => (
                <>
                <input key={index} type="checkbox" id={ingredient.name} onChange={(event) => handleChecke(event, ingredient)}/>
                <label key={index + 100} htmlFor={ingredient.name}> {ingredient.name} </label>
                
                </>
            ))}
        </div>
        <button type="submit">Ajouter</button>
      </form>
    </>
  );
};

export default RecipeForm;
