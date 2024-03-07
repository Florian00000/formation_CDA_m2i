import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchAlbums, removeAlbum } from "./albumSlice";
import { useNavigate } from "react-router-dom";

const AlbumList = () => {
  const dispatch = useDispatch();

  const navigate = useNavigate();

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
      {!albums.length && (
        <section>
          <p> Le monde manque cruellement de poësie </p>
        </section>
      )}

      {albums.length && (
        <section className="bg-dark" id="album-section">
          {/* boutons de tri */}
          <article id="select-tri">
            <h2 className="text-light">Albums</h2>
            <select className="form-select w-auto bg-dark text-light">
              <option>trier par:</option>
              <option onClick={() => sortAlbum("titreAsc")}>
                Titre d'album
              </option>
              <option onClick={() => sortAlbum("titreDesc")}>
                Ordre alpha. d'album inversé
              </option>
              <option onClick={() => sortAlbum("scoreDesc")}>
                Meilleure Note
              </option>
              <option onClick={() => sortAlbum("scoreAsc")}>
                Moins bonne note
              </option>
            </select>
          </article>

          <hr className="border border-light" />

          <article id="album-article">
            {/* liste d'albums */}
            {sortedAlbums.map((album, index) => (
              <div key={index} id="card">
                <h4>{album.title}</h4>
                <img
                  src={album.coverUrl}
                  alt={`cover de l'album: ${album.title}`}
                />
                <div className="w-100 px-3 pt-3">
                  <div className="w-100">
                    <div className="d-flex justify-content-between">
                      <span>Artiste: </span>
                      <span>{album.artist}</span>
                    </div>

                    <hr />
                    <div className="d-flex justify-content-between">
                      <span>Date de sortie:</span>
                      <span>
                        {" "}
                        {new Date(album.releaseDate).toLocaleDateString()}
                      </span>
                    </div>

                    <hr className="border-light" />
                    <div className="d-flex justify-content-between mb-3">
                      <span>Note: </span>
                      <span>{album.score}</span>
                    </div>
                  </div>
                  
                  <div id="div-button">
                    {user && (
                      <button className="btn btn-outline-light"
                        onClick={() =>
                          navigate(`/album/update/${album.id}?mode=update`)
                        }
                      >
                        Editer
                      </button>
                    )}{" "}
                    {user && (
                      <button className="btn btn-outline-danger" onClick={() => deleteAlbum(album)}>
                        Supprimer
                      </button>
                    )}
                  </div>
                </div>
              </div>
            ))}
          </article>
        </section>
      )}
    </>
  );
};

export default AlbumList;
