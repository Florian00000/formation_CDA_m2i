import {createBrowserRouter} from "react-router-dom"
import HomePage from "./components/HomePage"
import FormPage from "./components/FormPage"
import ErrorPage from "./components/ErrorPage"
import NavBar from "./components/NavBar"
import Project from "./components/Project"

const router = createBrowserRouter([
    // {path: '/', element: <HomePage/>, errorElement: <ErrorPage/>},
    // {path: '/form', element: <FormPage/>, errorElement: <ErrorPage/>}
    {
        path: "/", 
        element: <NavBar/>,
        errorElement: <ErrorPage/>,
        children: [
            {path: '/', element: <HomePage/>},
            {path: '/form', element: <FormPage/>},
            {path: "/projects/:monparams", element: <Project/>}
        ]
    }
])

export default router