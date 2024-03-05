import { useState } from 'react'
import './App.css'
import Navbar from './components/shared/Navbar'
import {Outlet} from "react-router-dom";

function App() {
  

  return (
    <>
      <Navbar/>
      <main>
        <Outlet/>
      </main>
    </>
  )
}

export default App
