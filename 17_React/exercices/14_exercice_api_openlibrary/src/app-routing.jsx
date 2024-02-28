import {createBrowserRouter} from 'react-router-dom'
import App from './App'
import ErrorPage from './components/ErrorPage'
import BookList from './components/BookList'
import BookDetail from './components/BookDetail'

const router = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        errorElement: <ErrorPage/>,       
        children: [
            {path: "/", element: <BookList/>},
            {path: "/livre/:idlivre", element: <BookDetail/>}
        ]
    }
])

export default router