import { createBrowserRouter} from "react-router-dom"
import App from './App';
import ErrorPage from "./components/shared/ErrorPage";
import CardsList from "./components/card/CardsList";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,
        children: [
            {
                path: "/",
                element: <CardsList/>
            },
            {
                path: "/:idPage",
                element: <CardsList/>
            }
        ]
    }
]);

export default router