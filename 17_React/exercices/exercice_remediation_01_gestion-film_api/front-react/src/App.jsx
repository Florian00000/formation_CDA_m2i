import { useEffect, useState } from 'react'
import './App.css'
import axios from 'axios';
import { MovieContext } from './components/context/MovieContext';
import DisplayMovies from './components/DisplayMovies';
import FormMovie from './components/FormMovie';


function App() {
  const [movieList, setMovieList] = useState();
  const [changeBdd, setChangeBdd] = useState(false);

  const reRender = () => {
    setChangeBdd(!changeBdd);
  }

  useEffect(() => {
    axios.get("http://localhost:3000/api/movies/")
    .then((response) => {
      // console.log(response)
      setMovieList(response.data)
    })
    .catch(error => console.error(error))
  }, [changeBdd])  

  console.log(movieList);
  
  return (
    <>
      <MovieContext.Provider value={{movieList, reRender}}>
        <FormMovie title={"Ajouter un Film"}/>
      <DisplayMovies/>
      </MovieContext.Provider>
    </>
  )
}

export default App
