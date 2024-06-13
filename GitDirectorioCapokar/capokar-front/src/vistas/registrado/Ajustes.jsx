import '../../assets/css/Ajustes.css';
import React, { useEffect, useState } from 'react';
import axios from '../../apis/axiosConfig';
import { ToastContainer, toast } from 'react-toastify';
import imagenSobreNosotros01 from '../../img/imagen_ejemplo.png';
import 'react-toastify/dist/ReactToastify.css';

const Ajustes = () => {
    const [perfil, setPerfil] = useState({
        id_cliente: '',
        nombre: '',
        apellido: '',
        direccion: '',
        poblacion: '',
        telefono: '',
        email: '',
        dni: '',
        contraseña: ''
    });

    const getToken = () => {
        const token = localStorage.getItem('token');
        if (!token) {
            return null;
        }
        const payload = JSON.parse(atob(token.split('.')[1]));
        return payload.id;
    };

    useEffect(() => {
        const obtenerPerfil = async () => {
            try {
                const id_cliente = getToken();
                if (id_cliente) {
                    const response = await axios.get(`/clientes/buscarClienteID/${id_cliente}`);
                    setPerfil(response.data);
                }
            } catch (error) {
                console.error('Error al obtener el perfil del cliente:', error);
            }
        };

        obtenerPerfil();
    }, []);

    const cambiosFormulario = (e) => {
        const { name, value } = e.target;
        setPerfil(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log('Enviando datos del cliente:', perfil);
        try {
            const response = await axios.put(`/clientes/actualizarClienteID/${perfil.id_cliente}`, perfil);
            if (response.status === 200) {
                console.log('Cliente guardado con éxito:', response.data);
                toast.success('Cliente Guardado con Éxito!');
            } else {
                console.error('Error al guardar el cliente:', response.statusText);
            }
        } catch (error) {
            console.error('Error al guardar el cliente:', error);
        }
    };

    return (
        <>
            <div className='contenedor-cont-root'>
                <div className='ajustes-barra-lateral'></div>
                <div className='ajustes-contenedor-main'>
                    <div className='ajustes-contenedor-cabecera'>
                        <h2>Mi Perfil</h2>
                        <h2>Opciones</h2>
                        <h2>Politica de privacidad</h2>
                    </div>
                    <div className='ajustes-menu-inferior'>
                        <div className='ajustes-menu-inferior-01'>
                            <form className="formulario-actualizar-cliente" onSubmit={handleSubmit}>
                                <div className='formulario-individual'>
                                    <h2>Nombre:</h2>
                                    <input type="text" name="nombre" value={perfil.nombre} onChange={cambiosFormulario} />
                                </div>
                                <div className='formulario-individual'>
                                    <h2>Apellido:</h2>
                                    <input type="text" name="apellido" value={perfil.apellido} onChange={cambiosFormulario} />
                                </div>
                                <div className='formulario-individual'>
                                    <h2>Dirección:</h2>
                                    <input type="text" name="direccion" value={perfil.direccion} onChange={cambiosFormulario} />
                                </div>
                                <div className='formulario-individual'>
                                    <h2>Población:</h2>
                                    <input type="text" name="poblacion" value={perfil.poblacion} onChange={cambiosFormulario} />
                                </div>
                                <div className='formulario-individual'>
                                    <h2>Teléfono:</h2>
                                    <input type="text" name="telefono" value={perfil.telefono} onChange={cambiosFormulario} />
                                </div>
                                <div className='formulario-individual'>
                                    <h2>Email:</h2>
                                    <input type="email" name="email" value={perfil.email} onChange={cambiosFormulario} />
                                </div>
                                <div className='formulario-individual'>
                                    <h2>DNI:</h2>
                                    <input type="text" name="dni" value={perfil.dni} onChange={cambiosFormulario} />
                                </div>
                                <div className='formulario-individual'>
                                    <h2>Contraseña:</h2>
                                    <input type="password" name="contraseña" value={perfil.contraseña} onChange={cambiosFormulario} />
                                </div>
                                <button className="boton-guardar-perfil" type="submit">Guardar Cliente</button>
                            </form>
                        </div>
                        <div className='ajustes-menu-inferior-02'>
                            <img className='img01' src={imagenSobreNosotros01} alt="Mis Vehiculos"/>
                        </div>
                    </div>
                </div>            
            </div>
            <ToastContainer />
        </>
    );
};

export default Ajustes;
