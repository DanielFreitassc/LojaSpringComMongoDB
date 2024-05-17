import "./style.css"
import Cards from "../../components/cards";
import Header from "../../components/header";
import heart from "../../assets/heart.png"
import hear from "../../assets/hear.png"
import medic from "../../assets/medic.png"

const Home = () => {
    const data = [
        { title: "Apoio online", body: "Agende uma consulta de forma totalmente online", icon: heart },
        { title: "Médicos", body: "Veja o perfil dos nosso profissionais", icon: hear },
        { title: "Marque uma consulta presencial", body: "Agende uma consulta para ir até uma de nossas unidades", icon: medic }
    ];

    return (
        <div className="container-home">
            <Header />
            <div className="container-cards">
                {data.map((item, index) => (
                    <Cards key={index} data={item} />
                ))}
            </div>
        </div>
    );
};

export default Home;
