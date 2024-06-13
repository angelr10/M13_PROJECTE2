import {BrowserRouter, Routes ,Route} from 'react-router-dom';
import SobreNosotros from '../vistas/SobreNosotros';
import Contactanos from '../vistas/Contactanos';
import Login from '../vistas/acceso/Login';
import Registro from '../vistas/acceso/Registro';
import Laterales from '../layout/lateralesSuperior';
import LateralesIdentificacion from '../layout/lateralesIdentificacion'
import MisVehiculos from '../vistas/registrado/MisVehiculos'
import Ajustes from '../vistas/registrado/Ajustes'
import RutaProtegida from '../rutas/RutaProtegida'
import MisVehiculosAgregar from '../vistas/registrado/MisVehiculosAgregar'

const Ruta = () => {

    return(
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Laterales/>}>
                    <Route path='/' element={<SobreNosotros/>}/>
                    <Route path='/contactanos' element={<Contactanos/>}/>
                    <Route 
                        path="/MisVehiculos" 
                        element={
                            <RutaProtegida>
                                <MisVehiculos />
                            </RutaProtegida>
                        } 
                    />
                    <Route 
                        path="/MisVehiculosAgregar" 
                        element={
                            <RutaProtegida>
                                <MisVehiculosAgregar />
                            </RutaProtegida>
                        } 
                    />
                    <Route 
                        path="/ajustes" 
                        element={
                            <RutaProtegida>
                                <Ajustes />
                            </RutaProtegida>
                        } 
                    />
                </Route>
                <Route path='/identificacion' element={<LateralesIdentificacion/>}>
                    <Route path='login' element={<Login/>}/>
                    <Route path='registro' element={<Registro/>}/>
                </Route>
                
            </Routes>
        </BrowserRouter>
    )
}

export default Ruta;