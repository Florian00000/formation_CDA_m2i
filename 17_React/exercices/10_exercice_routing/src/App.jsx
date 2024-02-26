import './App.css'
import {Link, Outlet} from 'react-router-dom'

function App() {
  

  return (    
     <>
            <nav>                
                <Link to={'/'} >Accueil </Link>
                <Link to={'/p2'} >Page 2 </Link>
                <Link to={'/p3'} >Page 3 </Link>
            </nav>
            <main>
                <Outlet/>
            </main>            
        </>
  
  )
}

export default App
