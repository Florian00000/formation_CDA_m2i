import "./App.css";
import { Link, Outlet } from "react-router-dom";
import { BookContext } from "./components/context/BookContext";
import axios from "axios";
import { useEffect, useState } from "react";

function App() {
  const [listeLivres, setListeLivres] = useState();

  useEffect(() => {
    axios.get("https://openlibrary.org/subjects/ancient.json?limit=100")
    .then((response) => {
      // console.log(response);
      setListeLivres(response.data.works);
    })
    .catch((error) => console.error(error))
  }, [])

  // version try catch
  // useEffect(() => {
  //   const fetchList = async () => {
  //     try {
  //       const response = await axios.get(
  //         "https://openlibrary.org/subjects/ancient.json?limit=100"
  //       );
  //       setListeLivres(response.data.works);
  //     } catch (error) {
  //       console.error(error);
  //     }
  //   }
  //   fetchList();
  // }, []);
  // console.log(listeLivres);
  
  return (
    <>
    <nav> <Link to={'/'}>Retour à l'accueil</Link> </nav>
      <BookContext.Provider value={{listeLivres}}>
        <main>
          <h1>Exercice 14 Api Open Library</h1>
          <Outlet />
        </main>
      </BookContext.Provider>
    </>
  );
}

export default App;
