import React, { useContext } from "react";
import { BookContext } from "./context/BookContext";
import { Link } from "react-router-dom";

const BookList = () => {
  const { listeLivres } = useContext(BookContext);

  return (
    <>
      {listeLivres && (
        <section>
          {listeLivres.map((livre) => (
            <article key={livre.cover_edition_key}>
              <Link to={`/livre/${livre.cover_edition_key}`}>
              <img
                src={`https://covers.openlibrary.org/b/id/${livre.cover_id}-M.jpg`}
                alt=""
                />
            </Link>
                <p>Titre: {livre.title}</p>
                <p>Auteur: {livre.authors[0].name}</p>
                <p>Année de la 1e parution: {livre.first_publish_year}</p>
            </article>

          ))}
        </section>
      )}
    </>
  );
};

export default BookList;
