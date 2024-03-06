import { createBrowserRouter } from "react-router-dom";
import App from './App'
import AuthForm from "./components/auth/AuthForm";
import ErrorPage from "./components/shared/ErrorPage";
import AlbumForm from "./components/album/AlbumForm";
import ProtectedRoute from "./components/shared/ProtectedRoute";
import AlbumList from "./components/album/AlbumList";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,
        children: [
            {
                path: "/",
                element: <AlbumList/>
            },
            {
                path: "/auth/login",
                element: <AuthForm/>
            },
            {
                path: "/auth/signup",
                element: <AuthForm/>
            },
            {
                path: "/album/add",
                element: <ProtectedRoute><AlbumForm/></ProtectedRoute> 
            },
            {
                path: "/album/update/:idAlbum",
                element: <ProtectedRoute><AlbumForm/></ProtectedRoute>
            },
        ]
    }
])

export default router;