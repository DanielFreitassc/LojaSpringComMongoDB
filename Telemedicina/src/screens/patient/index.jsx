import Cards from '../../components/cards';
import heart from "../../assets/heart.png";
import hear from "../../assets/hear.png";
import medic from "../../assets/medic.png";
import './style.css';

const Patient = () => {
    const data = [
        { link: "/apoio-online", title: "Apoio online", body: "Agende uma consulta de forma totalmente online", icon: heart },
        { link: "/medicos", title: "Médicos", body: "Veja o perfil dos nossos profissionais", icon: hear },
        { link: "/marque-consulta", title: "Marque uma consulta presencial", body: "Agende uma consulta para ir até uma de nossas unidades", icon: medic }
    ];
    return (
        <div className="container-patient">
            <div className="container-cards">
                {data.map((item, index) => (
                    <Cards key={index} data={item} />
                ))}
            </div>
        </div>
    );
};

export default Patient;
