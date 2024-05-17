import Header from "../../components/header";
import "./style.css";

const Contact = () => {
    return(
        <div className="container-c-contact">
                <Header/>
            <div className="container-contact">
                <div>
                    <h2>Entre em Contato</h2>
                    <p>Para mais informações ou dúvidas, entre em contato conosco através dos seguintes meios:</p>
                    <ul>
                        <li><strong>Telefone:</strong> (99) 9999-9999</li>
                        <li><strong>Email:</strong> <a href="mailto:contato@clinicadetelemedicina.com">contato@clinicadetelemedicina.com</a></li>
                        <li><strong>Endereço:</strong> Av. Principal, 1234 - Cidade, Estado</li>
                    </ul>
                </div>
        </div>
        </div>
    );
}

export default Contact;
