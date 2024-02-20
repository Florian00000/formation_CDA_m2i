import { useState } from 'react'
import './App.css'
import FormLogin from './components/FormLogin'

function App() {
  const [count, setCount] = useState(0)

  const loginData = (userData) => {
    console.log(userData);
  }

  return (
    <>
      <FormLogin loginData={loginData}/>
    </>
  )
}

export default App
