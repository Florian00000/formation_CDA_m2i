import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import Modal from "../modal/Modal";
import RecipeForm from "./RecipeForm";
import axios from "axios";
import { BASE_DB_URL } from "../../firebaseConfig";
import { setRecipe, deleteRecipe } from "./recipeSlice";
import { ingredients } from "../../data/ingredients";

const RecipeList = () => {
  const recipes = useSelector((state) => state.recipe.recipes);
  const user = useSelector((state) => state.auth.user);
//   const user = localStorage.getItem("token")

  const dispatch = useDispatch();

  const [modalForm, setModalForm] = useState(false);

  const changeModal = () => {
    setModalForm(!modalForm);
  };

  //Fetcher la liste si le store est vide
  useEffect(() => {
    if (!recipes.length) {
      axios
        .get(`${BASE_DB_URL}recipes.json`)
        .then((response) => {
          // console.log(response.data);
          const resList = [];
          for (const key in response.data) {
            resList.push({ ...response.data[key], key: key });
          }
        //   console.log(resList);
          dispatch(setRecipe(resList));
        })
        .catch((error) => console.error(error));
    }
  }, [recipes]);

  //Suppression d'un ingrédient
  const removeRecipe = (recipe) => {
      axios.delete(`${BASE_DB_URL}recipes/${recipe.key}.json?auth=${user.idToken}`)
      .then((response) => {
          console.log(response.data);
          dispatch(deleteRecipe(recipe));
    })
    .catch(error => console.error(error))
  }

  return (
    <>
      <section>
        <h1>List de Recettes</h1>
        {user && <button onClick={changeModal}>Ajouter</button>}
        {!recipes.length && <p>Pas de recettes enregistrés pour le moments</p>}
        {recipes.length && (
          <>
            {recipes.map((recipe, index) => (
              <article key={index}>
                <h3> {recipe.title} </h3>
                <div>
                  <h4>Instructions:</h4>
                  <p>{recipe.instructions}</p>
                </div>
                <div>
                  <h4>Ingrédients:</h4>
                  <ul>
                    {recipe.ingredients.map((ingredient, index) => (
                      <li key={index}>{ingredient.name}</li>
                    ))}
                  </ul>
                </div>
                {user && <button onClick={() => removeRecipe(recipe)}>Supprimer</button> }
                
              </article>
            ))}
          </>
        )}
      </section>

      {modalForm && (
        <Modal changeModal={changeModal}>
          {" "}
          <RecipeForm />{" "}
        </Modal>
      )}
    </>
  );
};

export default RecipeList;
