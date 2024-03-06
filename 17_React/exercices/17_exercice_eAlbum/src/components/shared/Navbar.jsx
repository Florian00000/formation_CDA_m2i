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
            <div>
                <Link to={'/album/add?mode=add'}> {user && <button>Ajouter</button>} </Link>

            <Link to={'/auth/login?mode=login'}>{!user && <button>Connexion</button>}</Link>
            
            {user && <button onClick={() => dispacth(removeUser())} >Déconnexion</button>}
            </div>
        </nav>
    );
}

export default Navbar;
