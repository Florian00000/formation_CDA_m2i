import React from 'react';
import {useDispatch, useSelector } from "react-redux"
import {Link, useNavigate} from "react-router-dom"


const Navbar = () => {
    const user = useSelector((state) => state.auth.user);
    const dispacth = useDispatch();

    const navigate = useNavigate();   

    return (
        // <nav className='bg-dark' id='nav-header'>
        //     <Link to={"/"} id='logoHeader'><span><b> Navbar</b></span></Link> 
        //     {/* <div>
        //         {user &&   <button className='btn btn-outline-light me-2' onClick={() => navigate("/album/add?mode=add")}>Ajouter</button> } 

        //     {!user && <Link to={'/auth/login?mode=login'}> <button className='btn btn-outline-primary ms-2'>Connexion</button> </Link>}
            
        //     {user && <button onClick={() => dispacth(removeUser())} className='btn btn-outline-primary ms-2' >Déconnexion</button>}
        //     </div> */}
        // </nav>

        
        <nav className="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/"}>TodoList</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarColor01">
            {/* <ul className="navbar-nav me-auto">
              <li className="nav-item">
                <a className="nav-link active" href="#">Home
                  <span className="visually-hidden">(current)</span>
                </a>
              </li>
              </ul> */}
          </div>
        </div>
      </nav>

        

    );
}

export default Navbar;
