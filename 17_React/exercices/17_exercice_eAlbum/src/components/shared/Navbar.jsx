import React from 'react';
import {useDispatch, useSelector } from "react-redux"
import {removeUser} from "../auth/authSlice"
import {Link} from "react-router-dom"


const Navbar = () => {
    const user = useSelector((state) => state.auth.user);
    const dispacth = useDispatch();

    return (
        <nav>
            <span> <b> Navbar </b>  </span>
            <Link to={'/auth/login?mode=login'}>{!user && <button>Connexion</button>}</Link>
            
            {user && <button onClick={() => dispacth(removeUser())} >Déconnexion</button>}
        </nav>
    );
}

export default Navbar;
