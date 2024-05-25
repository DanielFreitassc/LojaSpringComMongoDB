import "./style.css"
import background from "../../assets/doctor.png"
const Login = () => {
    return(
        <div className="container-c">
            <div id="container-img"><img id="img-login" src={background} alt="" /></div>
        <div className="container-login">
            <h1 id="title-user">Informe abaixo CPF e senha</h1>
            <label htmlFor=""> CPF: <input type="text" className="input-user" placeholder="CPF"/></label>
            <label htmlFor="">Senha:<input type="password" className="input-user" placeholder="Senha"/></label>
            <button className="button-red-header">Entrar</button>
        </div>
        </div>
    )
}
export default Login;