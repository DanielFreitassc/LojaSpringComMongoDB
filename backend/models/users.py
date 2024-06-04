from werkzeug.security import generate_password_hash, check_password_hash
from database.db import db

class Users(db.Model):
    __tablename__ = 'users'
    
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(50), nullable=False)
    cpf = db.Column(db.String(12), nullable=False)
    email = db.Column(db.String(50), unique=True, nullable=False)
    senha_hash = db.Column(db.String(500), nullable=False)
    papel = db.Column(db.String(50), nullable=False)
    

    def __init__(self, nome, cpf, email, senha, papel):
        self.nome = nome
        self.cpf = cpf
        self.email = email
        self.senha_hash = generate_password_hash(senha)
        self.papel = papel

    def check_password(self, senha):
        return check_password_hash(self.senha_hash, senha)

    def to_dict(self):
        return {
            'id': self.id,
            'nome': self.nome,
            'cpf': self.cpf,
            'email': self.email,
            'papel': self.papel
        }