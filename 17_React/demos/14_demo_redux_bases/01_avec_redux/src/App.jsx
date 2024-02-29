import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import TaskList from './components/Task/TaskList'
import TaskForm from './components/Task/TaskForm'
import TaskHeader from './components/Task/TaskHeader'

function App() {

  return (
    <>
      <TaskHeader />
      <TaskForm />
      <TaskList />
    </>
  )
}

export default App
