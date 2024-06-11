from database.db import db

class Paciente(db.Model):
    __tablename__ = 'pacientes'
    
    codigo = db.Column(db.Integer, primary_key=True, autoincrement=True)
    codusuario = db.Column(db.Integer, db.ForeignKey('users.id'), nullable=False)
    nome = db.Column(db.String(50), nullable=False)
    nascimento = db.Column(db.Date, nullable=False)
    genero = db.Column(db.String(50), nullable=False)
    endereco = db.Column(db.String(50), nullable=False)
    
    usuario = db.relationship('Users', backref='pacientes', foreign_keys=[codusuario])
    
    def __init__(self, codusuario, nome, nascimento, genero, endereco):
        self.codusuario = codusuario
        self.nome = nome
        self.nascimento = nascimento
        self.genero = genero
        self.endereco = endereco
        
    def to_dict(self):
        return {
            'codigo': self.codigo,
            'codusuario': self.codusuario,
            'nome': self.nome,
            'nascimento': self.nascimento.strftime('%Y-%m-%d'),
            'genero': self.genero,
            'endereco': self.endereco,
            'usuario': self.usuario.to_dict()
        }