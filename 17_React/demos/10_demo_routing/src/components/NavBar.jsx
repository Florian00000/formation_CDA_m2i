import React from 'react';
import { Link, Outlet } from 'react-router-dom';

const NavBar = () => {
    return (
        <>
        <nav>
            <span> <b> Navbar </b>  </span>
            <Link to={'/'} >HomePage </Link>
            <Link to={'/form'} >Form </Link>
        </nav>
        <div>
            <Outlet/>
        </div>
        <footer>Mon footer</footer>
        </>
    );
}

export default NavBar;
