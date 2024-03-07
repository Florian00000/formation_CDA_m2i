import React, { useEffect, useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams, useSearchParams } from "react-router-dom";
import { postAlbum, updateAlbum } from "./albumSlice";

const AlbumForm = () => {
  const [searchParams] = useSearchParams();
  const mode = searchParams.get("mode") ?? "add";
  const {idAlbum} = useParams();

  const dispatch = useDispatch();
  const user = useSelector((state) => state.auth.user);

  const navigate = useNavigate();  

  const titleRef = useRef();
  const releaseDateRef = useRef();
  const artistRef = useRef();
  const scoreRef = useRef();
  const coverUrlRef = useRef();

  //si un id d'abum dans l'url
  let editAlbum = null;
  if (idAlbum) {
    // let editAlbum = useSelector((state) => state.album.albums)
    // editAlbum = editAlbum.find((album) => album.id == idAlbum)   

    editAlbum = useSelector((state) => state.album.albums).find((album) => album.id == idAlbum)     
  }  

  const albumSubmit = (e) => {
    e.preventDefault();
    
    if (mode === "update") {
      const request = {
        token: user,
        album: {
          id: idAlbum,       
          title: titleRef.current.value,
          releaseDate: releaseDateRef.current.value,
          artist: artistRef.current.value,
          score: +scoreRef.current.value,
          coverUrl: coverUrlRef.current.value,
        },
      };

      dispatch(updateAlbum(request))
    }else {
      const request = {
        token: user,
        album: {        
          title: titleRef.current.value,
          releaseDate: releaseDateRef.current.value,
          artist: artistRef.current.value,
          score: +scoreRef.current.value,
          coverUrl: coverUrlRef.current.value,
        },
      };

      dispatch(postAlbum(request));
    }    
    navigate("/");
  };

  return (
    <>
      {mode === "update" ? <h3>Editer l'album</h3> : <h3>Ajouter un album</h3>}
      <form onSubmit={albumSubmit}>
        <div>
          <label htmlFor="title">Nom de l'album:</label>
          <input type="text" id="title" required ref={titleRef} defaultValue={editAlbum?.title || ""} />
        </div>
        <div>
          <label htmlFor="releaseDate">Date de sortie:</label>
          <input type="date" id="releaseDate" ref={releaseDateRef} defaultValue={editAlbum?.releaseDate || ""} />
        </div>
        <div>
          <label htmlFor="artist">Artiste de l'album</label>
          <input type="text" id="artist" required ref={artistRef} defaultValue={editAlbum?.artist || ""} />
        </div>
        <div>
          <label htmlFor="score">Note de l'album</label>
          <input type="number" id="score" max={5} min={0} step={0.5} ref={scoreRef} defaultValue={`${editAlbum?.score || ""}`} />
        </div>
        <div>
          <label htmlFor="cover">Cover:</label>
          <input type="text" id="cover" ref={coverUrlRef} defaultValue={editAlbum?.coverUrl || ""} />
        </div>
        <button type="submit">
          {mode === "update" ? "Modifier" : "Ajouter"}{" "}
        </button>
      </form>
    </>
  );
};

export default AlbumForm;
