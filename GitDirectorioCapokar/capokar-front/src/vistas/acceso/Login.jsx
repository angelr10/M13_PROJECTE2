import '../../assets/css/Login.css';
import axios from '../../apis/axiosConfig';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { NavLink } from 'react-router-dom';

const Login = () => {
    const [nombreUsuario, setNombreUsuario] = useState('');
    const [contraIntroducida, setContraIntroducida] = useState('');
    const [resultado, setResultado] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.get(`/clientes/comprobarExiste/${nombreUsuario}`);
            console.log('Respuesta de comprobarExiste:', response.data);
            if (response.data) {
                setResultado("Usuario encontrado.");
                const responseDos = await axios.get(`/clientes/iniciarSesionCliente/${nombreUsuario}/${contraIntroducida}`);
                console.log('Respuesta de iniciarSesionCliente:', responseDos.data);
                if (responseDos.data !== "Error al autorizar token") {
                    setResultado("User y contraseña correctos");
                    localStorage.setItem('token', responseDos.data);
                    navigate('/MisVehiculos');
                } else {
                    setResultado("Ha habido un error con el nombre de usuario o la contraseña");
                }
            } else {
                setResultado("Usuario no encontrado.");
            }
        } catch (error) {
            console.error('Error al comprobar el usuario:', error);
            setResultado('Error al comprobar el usuario.');
        }
    };

    const handleChange = (e) => {
        setNombreUsuario(e.target.value);
    };

    const handleChangeContra = (e) => {
        setContraIntroducida(e.target.value);
    };

    return (
        <div className='contenedor-main-login'>
            <h1>Login</h1>
            <NavLink className='msv-link' to={'/'}>
                        <h3 className='msv-link-span'>Volver</h3>
                </NavLink>
            <form className="formulario-login" onSubmit={handleSubmit}>
                <div className='contenedor-interior'>
                    <div className='contenedor-profundo'>
                        <label>Nombre/Correo electronico</label>
                        <input type="text" name="nombre" value={nombreUsuario} onChange={handleChange} />
                    </div>
                    <div className='contenedor-profundo'>
                        <label>Contraseña</label>
                        <input type="password" name="contra" value={contraIntroducida} onChange={handleChangeContra} />
                    </div>
                    <h3>* La contraseña debe contener al menos 5 caracteres y 2 digitos y 1 simbolo*</h3>
                </div>
                <button className='boton-iniciar-sesion' type="submit">Iniciar sesion</button>
            </form>
            {resultado && (
                <div>
                    <h1>{resultado}</h1>
                </div>
            )}
        </div>
    );
}

export default Login;
