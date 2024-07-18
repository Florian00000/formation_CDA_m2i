import React, { useEffect, useRef } from "react";
import { Navigate, useNavigate, useSearchParams } from "react-router-dom";
import {Link} from "react-router-dom";
import axios from 'axios';
import { useDispatch, useSelector } from "react-redux";
import { postLogin} from "./authSlice";

const AuthForm = () => {
  // const [searchParams] = useSearchParams();
  // const mode = searchParams.get("mode") ?? "login";

  const emailRef = useRef();
  const passwordRef = useRef();

  const dispacth = useDispatch();
  const navigate = useNavigate();

  const mode = useSelector(state => state.auth.authMode);
  const token = useSelector(state => state.auth.token)

  //Fonction du formulaire
  const authSubmit = (e) => {
    e.preventDefault();

    // const URL = mode === "signup"? SIGN_UP_URL : SIGN_IN_URL;

    const credentials = {
        email: emailRef.current.value,
        password: passwordRef.current.value,       
    }

    dispacth(postLogin(credentials))    

  };
  

    useEffect(()=> {
      if (token) {
        navigate("/")
      }
    }, [token])



  return (
    <main className="container">
        {mode === "signup"? <h3 className="mt-4">S'inscire</h3>: <h3 className="mt-4">Connexion</h3>}
      <form onSubmit={authSubmit} >
        <div>
          <label htmlFor="email" className="form-label mt-4">Email:</label>
          <input type="email" required ref={emailRef} className="form-control" />
        </div>
        <div>
          <label htmlFor="password" className="form-label mt-4">Mot de passe:</label>
          <input type="password" min={6} required ref={passwordRef} className="form-control"/>
        </div>
        <div className="d-flex">
          <button type="submit" className="btn btn-success mt-4 ms-auto"> {mode === "signup"? "S'inscire": "Connexion"} </button>

        </div>
      </form>
      {mode === "login" && <Link to={"/auth/signup?mode=signup"}>Pas encore de compte?</Link>}
      {mode === "signup" && <Link to={"/auth/login?mode=login"}>Déjà un compte?</Link>}
    </main>
  );
};

export default AuthForm;
