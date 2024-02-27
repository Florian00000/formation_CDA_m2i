import {useRouteError} from "react-router-dom"

const ErrorPage = () => {
  const error = useRouteError()

  return (  
    <>
      <h3>Error {error.status}</h3>
      <p>{error.data}</p>
    </>
  );
}
 
export default ErrorPage;