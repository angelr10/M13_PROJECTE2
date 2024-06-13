import '../assets/css/AcercaDeNosotros.css';
import React, {useEffect, useState } from 'react';
import imagenSobreNosotros01 from '../img/imagen_ejemplo.png';

const AcercaDeNosotros = () => {
    return (
        <>
            <div className='rootAcercaDeNosotros'>
                <div className='barraGris'></div>
                <div className='contenidoReal'>
                    <div className='seccion-imagen-acercade'>
                        <section className='que-realizamos'>
                            <h1>Que realizamos?</h1>
                            <h2>Desde Capokar queremos darte el mejor servicio posible y asequible del mercado.
                                <br /><br />
                                "Agregar salto de linea"Te facilitaremos el proceso de inscripcion tanto desde esta misma pagina como desde la aplicacion movil.
                            </h2>
                        </section>
                        <img className='img01' src={imagenSobreNosotros01} alt="Mis Vehiculos"/>
                    </div>
                    <div className='barraSeparadora'></div>
                    <div className='compromiso-informacion-seguridad'>
                        <div className='contenedor-botones'>
                            <button>
                                Compromiso
                            </button>
                            <button>
                                Informacion
                            </button>
                            <button>
                                Seguridad
                            </button>
                        </div>
                        <div className='contenedor-al-presionar-compromiso'>
                            <section className='seccion-al-presionar-compromiso01'>
                                <h2>Cada uno de nuestros clientes se merece un trato especial y por ello nos comprometemos en darte acceso a las mejores herramientas garantizando una reparacion correcta incluyendo  una garantia de 3.000km.</h2>
                            </section>
                            <div className='seccion-compromiso-img'>
                                <img className='img02' src={imagenSobreNosotros01} alt="Mis Vehiculos"/>
                                <section className='seccion-al-presionar-compromiso02'>
                                    <h2>La mayor seguridad para todos tus datos, somos conscientes que tenemos que brindar una seguridad ejemplar al tener toda su informacion en nuestras manos, por ello nos comprometemos en hacer uso de las mejores herramientas disponibles para mantenerte a salvo.</h2>
                                </section>
                                
                            </div>
                            
                        </div>
                        
                    </div>
                </div>
            </div>
        </>
    )
}

export default AcercaDeNosotros;