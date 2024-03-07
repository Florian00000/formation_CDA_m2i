import React, { useEffect, useRef } from "react";
import { Navigate, useNavigate, useSearchParams } from "react-router-dom";
import {Link} from "react-router-dom";
import { SIGN_IN_URL, SIGN_UP_URL } from "../../firebaseConfig";
import axios from 'axios';
import { useDispatch } from "react-redux";
import { setUser } from "./authSlice";

const AuthForm = () => {
  const [searchParams] = useSearchParams();
  const mode = searchParams.get("mode") ?? "login";

  const emailRef = useRef();
  const passwordRef = useRef();

  const dispacth = useDispatch();
  const navigate = useNavigate();

  //Fonction du formulaire
  const authSubmit = (e) => {
    e.preventDefault();

    const URL = mode === "signup"? SIGN_UP_URL : SIGN_IN_URL;

    const credentials = {
        email: emailRef.current.value,
        password: passwordRef.current.value,
        returnSecureToken: true
    }

    axios.post(URL, credentials)
    .then((response) => {
        console.log(response.data);
        localStorage.setItem("token", response.data.idToken);
        dispacth(setUser(response.data.idToken));
        navigate("/");
    })
  };
  

    if (localStorage.getItem("token")) {
        return <Navigate to={"/"}/>
    }

  return (
    <>
        {mode === "signup"? <h3>S'inscire</h3>: <h3>Connexion</h3>}
      <form onSubmit={authSubmit}>
        <div>
          <label htmlFor="email">Email:</label>
          <input type="email" required ref={emailRef}  />
        </div>
        <div>
          <label htmlFor="password">Mot de passe:</label>
          <input type="password" min={6} required ref={passwordRef} />
        </div>
        <button type="submit"> {mode === "signup"? "S'inscire": "Connexion"} </button>
      </form>
      {mode === "login" && <Link to={"/auth/signup?mode=signup"}>Pas encore de compte?</Link>}
      {mode === "signup" && <Link to={"/auth/login?mode=login"}>Déjà un compte?</Link>}
    </>
  );
};

export default AuthForm;
