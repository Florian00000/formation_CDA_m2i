import {createBrowserRouter} from 'react-router-dom';
import App from './App'
import Form from './components/Form';
import Compte from './components/Compte';
import ProtectedRoute from './components/ProtectedRoute';

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>
    },
    {
        path: "login",
        element: <Form/>
    },
    {
        path: "/compte",
        element: <ProtectedRoute><Compte/></ProtectedRoute> 
    }
])

export default router;