import { useState, useEffect } from 'react';
import axios from 'axios';
import "./style.css"

const Doctors = () => {
    const [medicos, setMedicos] = useState([]);

    useEffect(() => {
        const fetchMedicos = async () => {
            try {
                const response = await axios.get('http://localhost:3000/medico');
                setMedicos(response.data.medicos);
            } catch (error) {
                console.error("Erro ao buscar médicos:", error);
            }
        };

        fetchMedicos();
    }, []);

    return (
        <div className="container-doctor">
            <h2 className="mb-4">Médicos</h2>
            <div className="card-container-doctor">
                {medicos.map((medico) => (
                    <div key={medico.codigo} className="custom-card">
                        <div className='container-doctor-photo'>
                            <img
                                src="https://images.vexels.com/content/144170/preview/character-doctor-woman-d6ee7a.png"
                                alt="Doctor"
                                className="custom-img"
                            />
                        </div>
                        <div className="card-body">
                            <h5 className="card-title">{medico.nome}</h5>
                            <h6 className="card-subtitle mb-2 text-muted">{medico.afiliacaohospitalar}</h6>
                            <p className="card-text">{medico.especializacao}</p>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Doctors;
