import { Outlet } from "react-router-dom";
import LateralBloque from './LateralBloque';
import '../assets/css/Lateralesidentificacion.css';

const PublicLayout = () => {
    return (
        <div className="contenedorLateralBloques">
            <LateralBloque/>
            <div className="mainContentIdentificacion">
                <Outlet/>
            </div>
            
        </div>
    )
}
export default PublicLayout;