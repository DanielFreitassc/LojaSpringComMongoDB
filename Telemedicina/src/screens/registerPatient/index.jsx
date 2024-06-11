import axios from 'axios';
import "./style.css";

const RegisterPatient = () => {
    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const payload = {
                codusuario: e.target.codusuario.value,
                nome: e.target.nome.value,
                nascimento: e.target.nascimento.value,
                genero: e.target.genero.value,
                endereco: e.target.endereco.value
            };

            const response = await axios.post('http://localhost:3000/paciente', payload);
            console.log('Resposta do backend:', response.data);

            e.target.reset();
        } catch (error) {
            console.error('Erro ao cadastrar paciente:', error);
        }
    };

    return (
        <div className="container">
            <h2>Cadastro de Paciente</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="codusuario">Código do Usuário:</label>
                    <input type="number" id="codusuario" name="codusuario" required />
                </div>
                <div className="form-group">
                    <label htmlFor="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required />
                </div>
                <div className="form-group">
                    <label htmlFor="nascimento">Data de Nascimento:</label>
                    <input type="date" id="nascimento" name="nascimento" required />
                </div>
                <div className="form-group">
                    <label htmlFor="genero">Gênero:</label>
                    <select id="genero" name="genero" required>
                        <option value="">Selecione...</option>
                        <option value="Masculino">Masculino</option>
                        <option value="Feminino">Feminino</option>
                        <option value="Outro">Outro</option>
                    </select>
                </div>
                <div className="form-group">
                    <label htmlFor="endereco">Endereço:</label>
                    <textarea id="endereco" name="endereco" required />
                </div>
                <button type="submit">Cadastrar Paciente</button>
            </form>
        </div>
    );
};

export default RegisterPatient;
