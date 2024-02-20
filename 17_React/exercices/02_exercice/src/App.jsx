import { useState } from 'react'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import BoutonExercice2 from './components/boutonExercice2';
import FizzBuzzExercice3 from './components/FizzBuzzExercice3';
import TestRecupValueInput from './components/TestRecupValueInput';
import InputExercice4 from './components/InputExercice4';
import DemoUseEffect from './components/demoUseEffect';
import UseEffectExercice5 from './components/useEffectExercice5';
import DemoAffichageConditionnel from './components/demoAffichageConditionnel';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className='App'>
      <BoutonExercice2/>
      <hr />
      <FizzBuzzExercice3/>
      <hr />
      <TestRecupValueInput/>
      <hr />
      <InputExercice4/>
      <hr />
      <DemoUseEffect/>
      <hr />
      <UseEffectExercice5/>
      <hr />
      <DemoAffichageConditionnel/>
    </div>
  )
}

export default App
