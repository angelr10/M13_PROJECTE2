import '../assets/css/Lateral.css';

import React from 'react';
import { NavLink } from 'react-router-dom';
import imagen01 from '../img/capokar_logoAPP_v02_dark.png';
import imagenMenu01 from '../img/calendario-reloj.png';
import imagenMenu02 from '../img/garaje-coche.png';
import imagenMenu03 from '../img/usd-circulo.png';
import imagenMenu04 from '../img/llave-inglesa.png';

const Lateral = () => {
    
    return(
        <div className='root-lateral-barra'>
            <img className='imagenLogo' src={imagen01} alt="Logo capokar"/>
            <li className='root-sobre-nosotros-link'>
                <NavLink className='iconText' to={'/'}>
                    {/* <span>Sobre Nosotros</span> */}
                    <img className='icoMenu' src={imagenMenu01} alt="Calendario"/>
                </NavLink>
            </li>

            <li className='root-sobre-nosotros-link'>
                <NavLink className='iconText' to={'/MisVehiculos'}>
                    {/* <span>Sobre Nosotros</span> */}
                    <img className='icoMenu' src={imagenMenu02} alt="Mis Vehiculos"/>
                </NavLink>
            </li>

            <li className='root-sobre-nosotros-link'>
                <NavLink className='iconText' to={'/'}>
                    {/* <span>Sobre Nosotros</span> */}
                    <img className='icoMenu' src={imagenMenu03} alt="Tienda"/>
                </NavLink>
            </li>

            <li className='root-sobre-nosotros-link'>
                <NavLink className='iconText' to={'/Ajustes'}>
                    {/* <span>Sobre Nosotros</span> */}
                    <img className='icoMenu' src={imagenMenu04} alt="Ajustes"/>
                </NavLink>
            </li>
            
        </div>
        
    )
}

export default Lateral;