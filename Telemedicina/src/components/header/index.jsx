import { Link } from "react-router-dom";
import "./style.css"
const Header = () => {
    return(
        <div>
            <div className="header">
                <nav className="nav-header">
                    <h1 id="title-header">Life</h1>
                    <Link className="link-header" to="/">Home</Link>
                    <Link className="link-header" to="/contact">Contato</Link>
                    <Link to={"/login"}>
                    <button className="button-red-header">Login</button>
                    </Link>
                    <Link to={"/register"}>
                    <button className="button-white-header">Cadastre-se</button>
                    </Link>
                    <Link to={"/admin"}>
                    <button className="button-red-header">Admin</button>
                    </Link>
                </nav>
            </div>
        </div>
    )
}
export default Header;