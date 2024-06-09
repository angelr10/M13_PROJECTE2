import {BrowserRouter, Routes ,Route} from 'react-router-dom';
import AcercaDe from '../vistas/AcercaDeNosotros';
import Login from '../vistas/acceso/Login';
import Registro from '../vistas/acceso/Registro';
import Laterales from '../layout/lateralesSuperior';

const Ruta = () => {

    return(
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Laterales/>}>
                    <Route path='/' element={<AcercaDe/>}/>
                </Route>
                <Route path='login' element={<Login/>}/>
                <Route path='registro' element={<Registro/>}/>
            </Routes>
        </BrowserRouter>
    )
}

export default Ruta;