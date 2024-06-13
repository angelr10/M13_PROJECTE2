import '../../assets/css/Registro.css';
import axios from '../../apis/axiosConfig';
import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import '../../assets/css/Registro.css'

const Registro = () => {
    const obtenerFechaActual = () => {
        const fecha = new Date();
        return fecha.toISOString();
    };
    const [cliente, setCliente] = useState({
        nombre: '',
        apellido: '',
        direccion: '',
        poblacion: '',
        telefono: '',
        email: '',
        fecha_creacion:obtenerFechaActual(),
        dni: '',
        contraseña: ''
    });
    
    const cambiosFormulario = (e) => {
        const { name, value } = e.target;
        setCliente(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log('Enviando datos del cliente:', cliente);
        try {
            const response = await axios.post('/clientes/guardarCliente', cliente);
            if (response.status === 200) {
                console.log('Cliente guardado con éxito:', response.data);
                toast.success(
                    <div>
                        <NavLink className='msv-link' to={'/identificacion/login'}>
                                <h3 className='msv-link-span'>IniciarSesion</h3>
                        </NavLink>
                    </div>
                );
            } else {
                console.error('Error al guardar el cliente:', response.statusText);
            }
        } catch (error) {
            console.error('Error al guardar el cliente:', error);
        }
    };

    return (
        <div className='contenedor-main-registro'>
            <h1>Registro</h1>
            <div>
                <NavLink className='msv-link' to={'/'}>
                        <h3 className='msv-link-span'>Volver</h3>
                </NavLink>
            </div>
            <form className="formulario-registro" onSubmit={handleSubmit}>
                <div>
                    <label>Nombre:</label>
                    <input type="text" name="nombre" value={cliente.nombre} onChange={cambiosFormulario} />
                </div>
                <div>
                    <label>Apellido:</label>
                    <input type="text" name="apellido" value={cliente.apellido} onChange={cambiosFormulario} />
                </div>
                <div>
                    <label>Dirección:</label>
                    <input type="text" name="direccion" value={cliente.direccion} onChange={cambiosFormulario} />
                </div>
                <div>
                    <label>Población:</label>
                    <input type="text" name="poblacion" value={cliente.poblacion} onChange={cambiosFormulario} />
                </div>
                <div>
                    <label>Teléfono:</label>
                    <input type="text" name="telefono" value={cliente.telefono} onChange={cambiosFormulario} />
                </div>
                <div>
                    <label>Email:</label>
                    <input type="email" name="email" value={cliente.email} onChange={cambiosFormulario} />
                </div>
                <div>
                    <label>DNI:</label>
                    <input type="text" name="DNI" value={cliente.DNI} onChange={cambiosFormulario} />
                </div>
                <div>
                    <label>Contraseña:</label>
                    <input type="password" name="contraseña" value={cliente.contraseña} onChange={cambiosFormulario} />
                </div>
                <h3>* La contraseña debe contener al menos 5 caracteres y 2 digitos y 1 simbolo*</h3>
                <button className="boton-guardar-cliente" type="submit">Guardar Cliente</button>
                
            </form>
            <ToastContainer/>
        </div>
    );
};

export default Registro;
