import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import BoutonExercice2 from './components/boutonExercice2';
import FizzBuzzExercice3 from './components/FizzBuzzExercice3';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className='App'>
      <BoutonExercice2/>
      <hr />
      <FizzBuzzExercice3/>    
    </div>
  )
}

export default App
