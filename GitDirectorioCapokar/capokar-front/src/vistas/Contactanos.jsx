import '../assets/css/Contactanos.css';
import React, { useEffect, useState } from 'react';
import axios from '../apis/axiosConfig';
import ContenedorInformacionEmpresa from '../piezas/ContenedorInformacionEmpresa';

const AcercaDeNosotros = () => {
    const [empresas, setEmpresas] = useState([]);

    useEffect(() => {
        const obtenerEmpresas = async () => {
            try {
                const response = await axios.get('/informacionlocal/mostrarInformacionLocal');
                setEmpresas(response.data);
            } catch (error) {
                console.error('Error al obtener información de las empresas:', error);
            }
        };
        obtenerEmpresas();
    }, []);

    return (
        <>
            <div className='contenedor-cont-root'>
                <div className='barraGris01'></div>
                <div className='contenedorElementos'>
                    <section>
                        <h2>Información de los distintos locales</h2>
                    </section>
                    <ContenedorInformacionEmpresa empresas={empresas} />
                </div>
            </div>
        </>
    );
};

export default AcercaDeNosotros;
