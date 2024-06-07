import { useNavigate } from "react-router-dom";
import background from "../../assets/doctor.png";
import "./style.css";
import { useState } from "react";

const Register = () => {
    const navigate = useNavigate();
    const [nome, setNome] = useState("");
    const [cpf, setCpf] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [papel, setPapel] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
    

    try {
        const response = await fetch("http://localhost:3000/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ nome,email,cpf, senha, papel })
        });
        const data = await response.json();

        if (response.ok) {
            console.log("Registro bem-sucedido", data);
            navigate("/login");
        } else {
            console.error("Erro de registro", data);
        }
    } catch (error) {
        console.error("Erro de desconhecido", error);
    }
    }

    return (
        <div className="container-cl">
            <div id="container-img">
                <img id="img-login" src={background} alt="" />
            </div>
            <form className="container-register" onSubmit={handleSubmit}>
                <h1 id="title-user">Cadastre-se</h1>
                <label htmlFor="name"> Nome:
                    <input type="text" className="input-user" placeholder="Nome" id="name" onChange={(e) => setNome(e.target.value)} required/>
                </label>
                <label htmlFor="cpf"> CPF:
                    <input type="text" className="input-user" placeholder="CPF" id="cpf" onChange={(e) => setCpf(e.target.value)} required/>
                </label>
                <label htmlFor="email"> E-mail:
                    <input type="text" className="input-user" placeholder="E-mail" id="email" onChange={(e) => setEmail(e.target.value)} required/>
                </label>
                <label htmlFor="password">Senha:
                    <input type="password" className="input-user" placeholder="Senha" id="password" onChange={(e) => setSenha(e.target.value)} required/>
                </label>
                <label htmlFor="confirmPassword">Confirme a Senha:
                    <input type="password" className="input-user" placeholder="Confirme a Senha" id="confirmPassword" onChange={(e) => setSenha(e.target.value)} required/>
                </label>
                <label htmlFor="role">Papel:
                    <select className="input-user" id="role"  onChange={(e) => setPapel(e.target.value)} required>
                        <option value="medico">Médico</option>
                        <option value="paciente">Paciente</option>
                    </select>
                </label>
                <button className="button-red-header">Cadastrar</button>
            </form>
        </div>
    );
}

export default Register;
