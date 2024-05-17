import React from 'react';
import './style.css';

const Cards = ({ data }) => {
    return (
        <div className="card">
            <img src={data.icon} alt="icone" className="card-icon" />
            <h1 className="card-title">{data.title}</h1>
            <p className="card-body">{data.body}</p>
        </div>
    );
};

export default Cards;
