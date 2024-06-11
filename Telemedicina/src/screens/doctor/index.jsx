import { Link } from "react-router-dom";
import "./style.css"

const Doctor = () => {
    return (
        <div>
            <h2>Bem-vindo, Médico!</h2>
            <div className="card-container">
                <div className="card-medic">
                    <h3>Cadastro de Consulta</h3>
                    <p>Aqui você pode cadastrar novas consultas.</p>
                    <Link to={"/register-consultation"}>
                    <button>Ir para Cadastro</button>
                    </Link>
                </div>
                <div className="card-medic">
                    <h3>Cadastro de Paciente</h3>
                    <p>Aqui você pode cadastrar novos pacientes.</p>
                    <Link to={"/register-patient"}>
                    <button>Ir para Cadastro</button>
                    </Link>
                
                </div>
            </div>
        </div>
    );
};

export default Doctor;
