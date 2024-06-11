import { useState } from 'react';
import './style.css';

const RegisterConsultation = () => {
    const [codPaciente, setCodPaciente] = useState('');
    const [codMedico, setCodMedico] = useState('');
    const [horarioData, setHorarioData] = useState('');
    const [status, setStatus] = useState('');
    const [descricao, setDescricao] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            // Formata a data para o formato brasileiro DD/MM/YYYY HH:mm:ss
            const formattedData = new Date(horarioData).toLocaleString('pt-BR', {
                year: 'numeric', month: '2-digit', day: '2-digit',
                hour: '2-digit', minute: '2-digit', second: '2-digit'
            }).replace(/\//g, '-').replace(',', '');

            const response = await fetch("http://localhost:3000/consulta", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    codpaciente: parseInt(codPaciente),
                    codmedico: parseInt(codMedico),
                    horariodata: formattedData,
                    status: status,
                    descricao: descricao
                })
            });
            const data = await response.json();

            if (response.ok) {
                console.log("Consulta marcada com sucesso", data);
            } else {
                console.error("Erro ao marcar consulta", data);
            }
        } catch (error) {
            console.error("Erro desconhecido", error);
        }
    };

    return (
        <div className="container">
            <h2>Marcar Consulta</h2>
            <form onSubmit={handleSubmit}>
                <label className="form-label">
                    Código do Paciente:
                    <input
                        type="number"
                        value={codPaciente}
                        onChange={(e) => setCodPaciente(e.target.value)}
                        className="form-input"
                        required
                    />
                </label>
                <br />
                <label className="form-label">
                    Código do Médico:
                    <input
                        type="number"
                        value={codMedico}
                        onChange={(e) => setCodMedico(e.target.value)}
                        className="form-input"
                        required
                    />
                </label>
                <br />
                <label className="form-label">
                    Horário e Data:
                    <input
                        type="datetime-local"
                        value={horarioData}
                        onChange={(e) => setHorarioData(e.target.value)}
                        className="form-input"
                        required
                    />
                </label>
                <br />
                <label className="form-label">
                    Status:
                    <input
                        type="text"
                        value={status}
                        onChange={(e) => setStatus(e.target.value)}
                        className="form-input"
                        required
                    />
                </label>
                <br />
                <label className="form-label">
                    Descrição:
                    <textarea
                        value={descricao}
                        onChange={(e) => setDescricao(e.target.value)}
                        className="form-textarea"
                        required
                    />
                </label>
                <br />
                <button type="submit" className="form-button">Marcar Consulta</button>
            </form>
        </div>
    );
};
export default  RegisterConsultation;