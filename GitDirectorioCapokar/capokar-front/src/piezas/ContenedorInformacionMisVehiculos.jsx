
import '../assets/css/ContenedorInformacionMisVehiculos.css';

const AcercaDeNosotros = ({vehiculos}) => {

    return (
        <>
            <div className='msvc-contenedor-root'>
                {vehiculos && vehiculos.map(vehiculos => (
                    <article key={vehiculos.id_local} className="contenedor-vehiculos">
                        <div className='section-contenido-contacto'>
                            
                            <h2>ID Vehiculo: {vehiculos.id_vehiculo}</h2>
                            <h2>Vehiculo</h2>
                            <h3>{vehiculos.marca},{vehiculos.modelo}</h3>
                            <h2>Matricula</h2>
                            <h3>{vehiculos.matricula}</h3>
                            <h2>Año Fabricacion</h2>
                            <h3>{vehiculos.año_fabricacion}</h3>
                        </div>
                    </article>
                ))}
            </div>
        </>
    );
};

export default AcercaDeNosotros;
