import { useState } from 'react';
import axios from 'axios';

const Appointment = () => {
    const [formData, setFormData] = useState({
        nome: '',
        email: '',
        cpf: '',
        telefone: '',
        endereco: '',
        tipoConsulta: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        try {
            const horario = new Date().toLocaleDateString('pt-BR', {
                day: 'numeric',
                month: 'numeric',
                year: 'numeric',
                hour: 'numeric',
                minute: 'numeric',
                second: 'numeric',
                hour12: false
            }).replace(/[/]/g, '-').replace(',', '');

            const payload = {
                cpf: formData.cpf,
                nome: formData.nome,
                tipo_de_consulta: formData.tipoConsulta,
                horario: horario,
                endereco: formData.endereco,
                telefone: formData.telefone
            };

            const response = await axios.post('http://localhost:3000/apoio-online', payload);
            
            console.log('Resposta do backend:', response.data);
            setFormData({
                nome: '',
                email: '',
                cpf: '',
                telefone: '',
                endereco: '',
                tipoConsulta: ''
            });
        } catch (error) {
            console.error('Erro ao enviar dados:', error);
        }
    };

    return (
        <div className="support-container">
            <h1>Marque uma consulta Presncial</h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" value={formData.nome} onChange={handleChange} required className="support-input" />
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email:</label>
                    <input type="email" id="email" name="email" value={formData.email} onChange={handleChange} required className="support-input" />
                </div>
                <div className="form-group">
                    <label htmlFor="cpf">CPF:</label>
                    <input type="text" id="cpf" name="cpf" value={formData.cpf} onChange={handleChange} required className="support-input" />
                </div>
                <div className="form-group">
                    <label className='label-support' htmlFor="telefone">Telefone:</label>
                    <input type="tel" id="telefone" name="telefone" value={formData.telefone} onChange={handleChange} className="support-input" />
                </div>
                <div className="form-group">
                    <label className='label-support' htmlFor="endereco">Endereço:</label>
                    <textarea id="endereco" name="endereco" value={formData.endereco} onChange={handleChange} className="support-textarea" />
                </div>
                <div className="form-group">
                    <label htmlFor="tipoConsulta">Tipo de Consulta:</label>
                    <select id="tipoConsulta" name="tipoConsulta" value={formData.tipoConsulta} onChange={handleChange} required className="support-select">
                        <option value="">Selecione...</option>
                        <option value="Cardiologia">Cardiologia</option>
                        <option value="Pediatria">Pediatria</option>
                        <option value="Ginecologia">Ginecologia</option>
                        <option value="Ortopedia">Ortopedia</option>
                        <option value="Dermatologia">Dermatologia</option>
                    </select>
                </div>
                <button type="submit" className="support-button">Enviar</button>
            </form>
        </div>
    );
};
export default Appointment;