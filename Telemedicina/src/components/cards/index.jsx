import './style.css';

const Cards = ({ data }) => {
    return (
        <div className="card">
            <div className='icon-c'><img src={data.icon} alt="icone" className="card-icon" /></div>
            <span className="card-title">{data.title}</span>
            <p className="card-body">{data.body}</p>
        </div>
    );
};

export default Cards;
