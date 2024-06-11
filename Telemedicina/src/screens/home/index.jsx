import "./style.css";
import Header from "../../components/header";
const Home = () => {
    return (
        <div className="container-home">
            <Header />
            <div className="content">
                <h1>Bem-vindo à Telemedicina</h1>
                <p>Conectando você com profissionais de saúde onde quer que você esteja.</p>
                <img src="https://img.odcdn.com.br/wp-content/uploads/2021/09/telemedicina.jpeg" alt="Telemedicina" className="telemedicina-image" />
            </div>
        </div>
    );
};

export default Home;