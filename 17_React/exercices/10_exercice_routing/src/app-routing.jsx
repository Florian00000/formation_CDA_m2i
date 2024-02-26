import {createBrowserRouter} from "react-router-dom"
import Page1 from "./components/Page1"
import ErrorPage from "./components/ErrorPage"
import Page2 from "./components/Page2"
import Page3 from "./components/Page3"
import App from "./App"

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/> ,
        errorElement: <ErrorPage/>,
        children: [
            {path: '/', element:<Page1/> },
            {path: '/p2', element: <Page2/> },
            {path: '/p3', element: <Page3/>}
        ]
    }
])

export default router