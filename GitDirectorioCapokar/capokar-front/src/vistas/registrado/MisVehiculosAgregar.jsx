import '../../assets/css/MisVehiculosAgregar.css';
import React, { useEffect, useState } from 'react';
import axios from '../../apis/axiosConfig';
import { ToastContainer, toast } from 'react-toastify';

const MisVehiculosAgregar = () => {
    // Función para obtener el token y extraer el ID del usuario
    const getToken = () => {
        const token = localStorage.getItem('token'); // Asumiendo que el token se almacena bajo la clave 'token'
        if (!token) {
            return null;
        }
        // Decodificar el token (si está en formato JWT)
        const payload = JSON.parse(atob(token.split('.')[1])); // Decodificar la parte del payload del token JWT
        return payload.id; // Asumimos que el ID del usuario está almacenado en 'id'
    };

    const [vehiculo, setVehiculo] = useState({
        cliente: {
            id_cliente: getToken() // Cambiado a id_cliente para coincidir con el backend
        },
        marca: '',
        modelo: '',
        anyo_fabricacion: '',
        matricula: '',
        kilometros: ''
    });

    const cambiosFormulario = (e) => {
        const { name, value } = e.target;
        setVehiculo(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log('Enviando datos del vehiculo:', vehiculo);
        try {
            const response = await axios.post('/vehiculos/guardarVehiculo', vehiculo);
            if (response.status === 200) {
                console.log('Vehiculo guardado con éxito:', response.data);
                toast.success(
                    <div>
                        Vehiculo Guardado con Éxito!
                    </div>
                );
            } else {
                console.error('Error al guardar el vehiculo:', response.statusText);
            }
        } catch (error) {
            console.error('Error al guardar el vehiculo:', error);
        }
    };

    return (
        <div className='mva-root'>
            <div className='barra-lateral'></div>
            <div className='contenedor-informacion'>
                <h1>Formulario para agregar un vehiculo</h1>
                <form className="formulario-registro-vehiculo" onSubmit={handleSubmit}>
                    <div>
                        <label>Marca:</label>
                        <input type="text" name="marca" value={vehiculo.marca} onChange={cambiosFormulario} />
                    </div>
                    <div>
                        <label>Modelo:</label>
                        <input type="text" name="modelo" value={vehiculo.modelo} onChange={cambiosFormulario} />
                    </div>
                    <div>
                        <label>Año de Fabricación:</label>
                        <input type="text" name="anyo_fabricacion" value={vehiculo.anyo_fabricacion} onChange={cambiosFormulario} />
                    </div>
                    <div>
                        <label>Matrícula:</label>
                        <input type="text" name="matricula" value={vehiculo.matricula} onChange={cambiosFormulario} />
                    </div>
                    <div>
                        <label>Kilómetros:</label>
                        <input type="text" name="kilometros" value={vehiculo.kilometros} onChange={cambiosFormulario} />
                    </div>
                    <button className="boton-guardar-cliente" type="submit">Guardar Vehiculo</button>
                </form>
                <ToastContainer />
            </div>        
        </div>
    );
};

export default MisVehiculosAgregar;
