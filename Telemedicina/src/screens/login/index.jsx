import "./style.css"
import background from "../../assets/doctor.png"
import { useNavigate } from "react-router-dom"
import { useState } from "react";

const Login = () => {
    const navigate = useNavigate();
    const [cpf, setCpf] = useState("");
    const [senha, setSenha] = useState("");
    const handleSubmit = async (event) => {
        event.preventDefault();
    

    try {
        const response = await fetch("http://localhost:3000/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ cpf, senha })
        });
        const data = await response.json();

        if (response.ok) {
            console.log("Login bem-sucedido", data);
            navigate("/admin-home");
        } else {
            console.error("Erro de login", data);
        }
    } catch (error) {
        console.error("Erro de rede", error);
    }
    }
        
    return(
        <div className="container-c">
            <div id="container-img"><img id="img-login" src={background} alt="" /></div>

        <form className="container-login" onSubmit={handleSubmit}>
            <h1 id="title-user">Informe abaixo CPF e senha</h1>
            <label htmlFor="" className="label-login"> CPF: <input type="text" className="input-user" placeholder="CPF" onChange={(e) => setCpf(e.target.value)} required/></label>
            <label htmlFor="" className="label-login">Senha:<input type="password" className="input-user" placeholder="Senha" onChange={(e) => setSenha(e.target.value)} required/></label>
            <button className="button-red-header" type="submit">Entrar</button>
        </form>
        
        </div>
    )
}
export default Login;