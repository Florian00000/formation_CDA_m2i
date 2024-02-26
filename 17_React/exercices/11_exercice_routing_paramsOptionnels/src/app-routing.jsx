import {createBrowserRouter} from "react-router-dom"
import App from "./App"
import CrudContacts from "./components/CrudContacts"
import ErrorPage from "./components/ErrorPage"
import Contacts from "./components/Contacts"

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,
        children: [
            {path: '/contacts', element: <Contacts/>},
            {path: '/contacts/:idContact', element: <CrudContacts/>}
        ]
    }
])

export default router