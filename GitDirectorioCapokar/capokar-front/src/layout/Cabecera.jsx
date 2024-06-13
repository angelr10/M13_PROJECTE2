import '../assets/css/Cabecera.css';
import { Outlet } from "react-router-dom";
import React, { useState } from 'react';
import Lateral from './Lateral';
import { NavLink } from 'react-router-dom';

const PublicLayout = () => {
    const [dropdownVisible, setDropdownVisible] = useState(false);
    const toggleDropdown = () => {
        setDropdownVisible(!dropdownVisible);
    };

    const token = localStorage.getItem('token');
    const [registrado, setRegistrado] = useState(!!token);

    const handleLogout = () => {
        localStorage.removeItem('token');
        setRegistrado(false);
    };

    return (
        <>
            <header className='main-cabecera'>
                <ul className='main-cabecera-links'>
                    <li>
                        <NavLink className='main-iconText' to={'/'}>
                            <span>Sobre Nosotros</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink className='main-iconText' to={'/contactanos'}>
                            <span>Contáctanos</span>
                        </NavLink>
                    </li>
                    {!registrado ? (
                        <li onClick={toggleDropdown}>
                            <span className='main-iconText'>Iniciar/Registrarse</span>
                            {dropdownVisible && (
                                <ul className='dropdown-menu'>
                                    <li>
                                        <NavLink className='main-iconText' to={'/identificacion/login'}>
                                            Iniciar Sesión
                                        </NavLink>
                                    </li>
                                    <li>
                                        <NavLink className='main-iconText' to={'/identificacion/registro'}>
                                            Registrarse
                                        </NavLink>
                                    </li>
                                </ul>
                            )}
                        </li>
                    ) : (
                        <li>
                            <button className='main-iconText-cerrar' onClick={handleLogout}>Cerrar Sesión</button>
                        </li>
                    )}
                </ul>
            </header>
        </>
    );
};

export default PublicLayout;
