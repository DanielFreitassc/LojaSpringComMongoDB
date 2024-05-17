import { Link } from "react-router-dom";
import "./style.css"
const Header = () => {
    return(
        <div>
            <div className="header">
                <nav className="nav-header">
                    <h1 id="title-header">Life</h1>
                    <Link className="link-header" to="/">Home</Link>
                    <Link className="link-header" to="#">Marcar Consulta</Link>
                    <Link className="link-header" to="/contact">Contato</Link>

                    <button className="button-red-header">Login</button>
                    <button className="button-white-header">Cadastre-se</button>
                </nav>
            </div>
        </div>
    )
}
export default Header;