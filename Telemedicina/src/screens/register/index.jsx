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
    const [papel, setPapel] = useState("medico");

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
                <img id="img-register" src={background} alt="" />
            </div>
            <form className="container-register" onSubmit={handleSubmit}>
                <h1 id="title-user">Cadastre-se</h1>
                <label className="label-r" htmlFor="name"> Nome:
                    <input type="text" className="input-register" placeholder="Nome" id="name" onChange={(e) => setNome(e.target.value)} required/>
                </label>
                <label className="label-r" htmlFor="cpf"> CPF:
                    <input type="text" className="input-register" placeholder="CPF" id="cpf" onChange={(e) => setCpf(e.target.value)} required/>
                </label>
                <label className="label-r" htmlFor="email"> E-mail:
                    <input type="text" className="input-register" placeholder="E-mail" id="email" onChange={(e) => setEmail(e.target.value)} required/>
                </label>
                <label  className="label-r" htmlFor="password">Senha:
                    <input type="password" className="input-register" placeholder="Senha" id="password" onChange={(e) => setSenha(e.target.value)} required/>
                </label>
                <label className="label-r" htmlFor="confirmPassword">Confirme a Senha:
                    <input type="password" className="input-register" placeholder="Confirme a Senha" id="confirmPassword" onChange={(e) => setSenha(e.target.value)} required/>
                </label>
                <label className="label-r" htmlFor="role">Papel:
                    <select className="input-register" id="role"  onChange={(e) => setPapel(e.target.value)} required>
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
