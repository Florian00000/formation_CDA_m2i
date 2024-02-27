import {createBrowserRouter} from "react-router-dom"
import ErrorPage from "./components/ErrorPage"
import HomePage from "./components/HomePage"
import ContactList from "./components/ContactList"
import ContactForm from "./components/ContactForm"
import NavBar from "./components/NavBar"

const router = createBrowserRouter([
  {
    path: "/",
    element: <NavBar/>,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <HomePage />
      },
      {
        path: "/contacts",
        element: <ContactList />
      },
      {
        path: "/contact/add",
        element: <ContactForm />
      },
      {
        path: "/contact/edit/:contactId",
        element: <ContactForm />
      },
      {
        path: "/contact/delete/:contactId",
        element: <ContactForm />
      }
    ]
  }
])

export default router