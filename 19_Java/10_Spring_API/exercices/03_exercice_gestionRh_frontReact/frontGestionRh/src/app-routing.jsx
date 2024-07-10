import { createBrowserRouter} from "react-router-dom"
import App from './App';
import ErrorPage from './components/shared/ErrorPage';
import EmployeeList from "./components/employee/EmployeeList";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,
        children: [
            {
                path: "/",
                element: <EmployeeList/>
            }
        ]
    }
]);

export default router;