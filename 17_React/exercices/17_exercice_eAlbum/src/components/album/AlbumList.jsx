import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchAlbums, removeAlbum } from "./albumSlice";
import { Link } from "react-router-dom";

const AlbumList = () => {
  const dispatch = useDispatch();

  const albums = useSelector((state) => state.album.albums);
  const [sortedAlbums, setSortedAlbums] = useState([]);
  useEffect(() => {
    if (!albums.length) {
      dispatch(fetchAlbums());
    }
    setSortedAlbums([...albums]);
  }, [albums]);

  const user = useSelector((state) => state.auth.user);

  const deleteAlbum = (album) => {
    const request = {
      token: user,
      album: album,
    };

    dispatch(removeAlbum(request));
  };

  //fonctions de tri
  const sortAlbum = (param) => {
    let sorted = [];

    switch (param) {
      case "titreAsc":
        sorted = [...albums].sort((a, b) => a.title > b.title);
        break;
      case "titreDesc":
        sorted = [...albums].sort((a, b) => a.title < b.title);
        break;
      case "scoreAsc":
        sorted = [...albums].sort((a, b) => a.score > b.score);
        break;
      case "scoreDesc":
        sorted = [...albums].sort((a, b) => a.score < b.score);
        break;
      default:
        sorted = albums;
    }    

    setSortedAlbums(sorted);
  };

  return (
    <>
      <h2>Albums</h2>

      {!albums.length && (
        <section>
          <p> Le monde manque cruellement de poësie </p>
        </section>
      )}

      {albums.length && (
        <section>
            {/* boutons de tri */}
          <article>
            <button onClick={() => sortAlbum("titreAsc")}>
              Trier par titre d'album
            </button>
            <button onClick={() => sortAlbum("titreDesc")}>
              Trier par titre d'album Desc
            </button>
            <button onClick={() => sortAlbum("scoreDesc")}>
              Trier par note Note
            </button>
            <button onClick={() => sortAlbum("scoreAsc")}>
              Trier par moins bonne note Note
            </button>
          </article>

            {/* liste d'albums */}
          {sortedAlbums.map((album, index) => (
            <article key={index}>
              <h4>{album.title}</h4>
              <img
                src={album.coverUrl}
                alt={`cover de l'album: ${album.title}`}
                width="300px"
              />
              <div>
                <p>Artiste: {album.artist}</p>
                <hr />
                <p>
                  Date de sortie:{" "}
                  {new Date(album.releaseDate).toLocaleDateString()}
                </p>
                <hr />
                <p>Note: {album.score} </p>
              </div>
              <div>
                <Link to={`/album/update/${album.id}?mode=update`}>
                  {user && <button>Editer</button>}{" "}
                </Link>
                {user && (
                  <button onClick={() => deleteAlbum(album)}>Supprimer</button>
                )}
              </div>
            </article>
          ))}
        </section>
      )}
    </>
  );
};

export default AlbumList;
