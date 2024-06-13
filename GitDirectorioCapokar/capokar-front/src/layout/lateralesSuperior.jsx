import { Outlet } from "react-router-dom";
import Cabecera from './Cabecera';
import Lateral from "./Lateral";
import '../assets/css/LateralesSuperior.css';

const PublicLayout = () => {
    return (
        <div className="root-base-contenido">
            <Lateral/>
            <div className="root-base-contenido-cabecera">
                <Cabecera/>
                <main className="contenedorContenido">
                    <Outlet/>
                </main>
            </div>
            
        </div>
    )
}
export default PublicLayout;