import "./style.css";
import background from "../../assets/doctor.png";
import { useNavigate } from "react-router-dom";
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

                if (data.message === "Login realizado com sucesso" && data.papel) {
                    const papel = data.papel;

                    if (papel === "medico") {
                        navigate("/doctor");
                    } else if (papel === "paciente") {
                        navigate("/patient");
                    } else {
                        console.error("Papel de usuário não reconhecido");
                    }
                } else {
                    console.error("Dados de usuário incompletos no payload", data);
                }
            } else {
                console.error("Erro de login", data);
            }
        } catch (error) {
            console.error("Erro de rede", error);
        }
    };
        
    return (
        <div className="container-login-centralized">
            <div className="container-img"><img className="img-login" src={background} alt="" /></div>

            <div id="center">
                <form className="container-login-form" onSubmit={handleSubmit}>
                    <h1 className="title-user">Informe abaixo CPF e senha</h1>
                    <div className="container-label">
                    <label htmlFor="" className="label-login"> CPF:
                        <input type="text" className="input-user" placeholder="CPF" onChange={(e) => setCpf(e.target.value)} required />
                    </label>
                    </div>
                    <div className="container-label">
                    <label htmlFor="" className="label-login">Senha:
                        <input type="password" className="input-user" placeholder="Senha" onChange={(e) => setSenha(e.target.value)} required />
                    </label>
                    </div>
                    <button className="button-red-header" type="submit">Entrar</button>
                </form>
            </div>
        </div>
    );
};

export default Login;
