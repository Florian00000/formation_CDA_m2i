import { createBrowserRouter } from "react-router-dom";
import App from './App'
import AuthForm from "./components/auth/AuthForm";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        children: [
            {
                path: "/auth/login",
                element: <AuthForm/>
            }
        ]
    }
])

export default router;