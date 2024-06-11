import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom"
import Home from './screens/home'
import Contact from './screens/contact'
import Appointment from './screens/appointment'
import Support from './screens/support'
import Doctors from './screens/doctors'
import Login from './screens/login'
import Register from './screens/register'
import Patient from './screens/patient'
import Doctor from './screens/doctor'
import RegisterConsultation from './screens/registerConsultation'
import RegisterPatient from './screens/registerPatient'

const router = createBrowserRouter([
  {
    path:"/",
    element:<Home/>
  },
  {
    path:"/login",
    element:<Login/>
  },
  {
    path:"/register",
    element:<Register/>
  },
  {
    path:"/contact",
    element:<Contact/>
  },
  {
    path:"/marque-consulta",
    element: <Appointment/>
  },
  {
    path:"/apoio-online",
    element:<Support/>
  },
  {
    path:"/medicos",
    element:<Doctors/>
  },
  {
    path:"/patient",
    element: <Patient/>  
  },
  {
    path:"/register-consultation",
    element: <RegisterConsultation/>
  },
  {
    path:"/doctor",
    element: <Doctor/>
  },
  {
    path:"/register-patient",
    element: <RegisterPatient/>
  }
]) 

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
   <RouterProvider router={router}/>
  </React.StrictMode>,
)
