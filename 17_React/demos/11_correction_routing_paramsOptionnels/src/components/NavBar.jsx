import { Link, Outlet } from "react-router-dom";

const NavBar = () => {
  return ( 
    <>
      <nav>
        <div>
            <Link to={"/"}>E-contact</Link>
        </div>
        <div>
          <Link to={"/contacts"}>Contacts</Link>
        </div>
      </nav>
      <div>
        <Outlet />
      </div>
      <div>
        <p>Pied de page</p>
      </div>
    </>
   );
}
 
export default NavBar;