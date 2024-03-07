import React from 'react';
import {useDispatch, useSelector } from "react-redux"
import {removeUser} from "../auth/authSlice"
import {Link, useNavigate} from "react-router-dom"


const Navbar = () => {
    const user = useSelector((state) => state.auth.user);
    const dispacth = useDispatch();

    const navigate = useNavigate();   

    return (
        <nav className='bg-dark' id='nav-header'>
            <Link to={"/"} id='logoHeader'><span><b> Navbar</b></span></Link> 
            <div>
                {user &&   <button className='btn btn-outline-light me-2' onClick={() => navigate("/album/add?mode=add")}>Ajouter</button> } 

            {!user && <Link to={'/auth/login?mode=login'}> <button className='btn btn-outline-primary ms-2'>Connexion</button> </Link>}
            
            {user && <button onClick={() => dispacth(removeUser())} className='btn btn-outline-primary ms-2' >Déconnexion</button>}
            </div>
        </nav>
    );
}

export default Navbar;
