import background from "../../assets/doctor.png";
import "./style.css";

const Register = () => {
    return (
        <div className="container-cl">
            <div id="container-img">
                <img id="img-login" src={background} alt="" />
            </div>
            <div className="container-register">
                <h1 id="title-user">Cadastre-se</h1>
                <label htmlFor="name"> Nome:
                    <input type="text" className="input-user" placeholder="Nome" id="name"/>
                </label>
                <label htmlFor="cpf"> CPF:
                    <input type="text" className="input-user" placeholder="CPF" id="cpf"/>
                </label>
                <label htmlFor="email"> E-mail:
                    <input type="text" className="input-user" placeholder="E-mail" id="email"/>
                </label>
                <label htmlFor="password">Senha:
                    <input type="password" className="input-user" placeholder="Senha" id="password"/>
                </label>
                <label htmlFor="confirmPassword">Confirme a Senha:
                    <input type="password" className="input-user" placeholder="Confirme a Senha" id="confirmPassword"/>
                </label>
                <label htmlFor="role">Papel:
                    <select className="input-user" id="role">
                        <option value="medico">Médico</option>
                        <option value="paciente">Paciente</option>
                    </select>
                </label>
                <button className="button-red-header">Entrar</button>
            </div>
        </div>
    );
}

export default Register;
