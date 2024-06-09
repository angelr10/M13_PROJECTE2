import { Outlet } from "react-router-dom";
import Cabecera from './Cabecera';
import Lateral from "./Lateral";
import '../assets/css/LateralesSuperior.css';

const PublicLayout = () => {
    return (
        <div className="contenedorInformacionLateralSuperior">
            <Lateral/>
            <div className="mainContent">
                <Cabecera/>
                <main className="contenedorContenido">
                    <Outlet/>
                </main>
            </div>
            
        </div>
    )
}
export default PublicLayout;