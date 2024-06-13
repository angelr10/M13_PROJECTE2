import "../assets/css/contenedores-css/ContenedorInformacionEmpresa.css";
import React from 'react';
import MapaComponente from '../apis/MapaComponente';

const ContenedorInformacionEmpresa = ({ empresas }) => {
    return (
        <section className="contactanos-root">
            {empresas && empresas.map(empresa => (
                <article key={empresa.id_local} className="contenedor-empresa">
                    <div className='section-contenido-contacto'>
                        <h2 className="idempresa">Local numero {empresa.id_local}</h2>
                        
                        <h2>Encargado de empresa</h2>
                        <h3>{empresa.nombre_representante} {empresa.apellido_representante}</h3>
                        <h2>Dirección</h2>
                        <h3>{empresa.direccion},{empresa.codigo_postal}</h3>
                        <h2>Teléfono empresa</h2>
                        <h3>{empresa.telefono}</h3>
                        <h2>Correo electrónico</h2>
                        <h3>Capokar@gmail.com</h3>
                    </div>
                    <div className='contenedor-mapa'>
                        <MapaComponente ejex={empresa.ejeX} ejey={empresa.ejeY} />
                    </div>
                </article>
            ))}
        </section>
    );
};

export default ContenedorInformacionEmpresa;
