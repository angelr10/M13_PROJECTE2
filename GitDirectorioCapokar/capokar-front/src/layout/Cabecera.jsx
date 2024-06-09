import '../assets/css/Cabecera.css';

import { Outlet } from "react-router-dom";
import React, { useState } from 'react';

import Lateral from './Lateral';

const PublicLayout = () => {
    return (
        <>
            <header className='cabeceraPrincipal'>
                <button>Sobre nosotros</button>
                <button>Contactos</button>
                <button>Iniciar/Registrarse</button>
            </header>

        </>
    )
}
export default PublicLayout;