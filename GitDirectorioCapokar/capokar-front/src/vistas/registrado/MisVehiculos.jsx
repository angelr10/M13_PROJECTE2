
import '../../assets/css/MisVehiculos.css';
import React, { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import ListadoVehiculosItem from '../../piezas/ContenedorInformacionMisVehiculos';
import axios from '../../apis/axiosConfig';

const AcercaDeNosotros = () => {
    const [vehiculos, setVehiculos] = useState([]);

    useEffect(() => {
        const obtenerMisVehiculos = async () => {
            try {
                const response = await axios.get('/vehiculos/mostrarVehiculos');
                setVehiculos(response.data);
            } catch (error) {
                console.error('Error al obtener información de tus vehiculos:', error);
            }
        };
        obtenerMisVehiculos();
    }, []);

    return (
        <>
            <div className='msv-contenedor-root'>
                
                <section className='barraGris'></section>
                <div className='msv-contenedor-base'>
                    <section>
                        <h1>MIS VEHICULOS</h1>
                        <div className='div-boton-agregar-vehiculo'>
                            <NavLink className='msv-link' to={'/MisVehiculosAgregar'}>
                                <h3 className='msv-link-span'>AgregarVehiculo</h3>
                            </NavLink>
                        </div>
                        
                    </section>
                    <div>
                        <h2>Todos mis vehiculos</h2>
                    </div>
                    <ListadoVehiculosItem className="elementosListado" vehiculos={vehiculos} />
                </div>
                
                
            </div>
        </>
    );
};

export default AcercaDeNosotros;
