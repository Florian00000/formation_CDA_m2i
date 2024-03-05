import { useState } from 'react'
import './App.css'
import Header from './components/Header'
import RecipeList from './components/recipe/RecipeList'

function App() {  

  return (
    <>
      <Header/>
      <main>
        <RecipeList/>
      </main>
    </>
  )
}

export default App
