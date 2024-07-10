import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Outlet } from 'react-router-dom';
import Navbar from './components/shared/Navbar';
import "bootswatch/dist/spacelab/bootstrap.min.css"

function App() {  

  return (
    <>
    <Navbar/>
      <Outlet/>
    </>
  )
}

export default App
