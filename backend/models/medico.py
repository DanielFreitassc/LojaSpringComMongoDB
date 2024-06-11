from database.db import db

class Medico(db.Model):
    __tablename__ = 'medicos'
    
    codigo = db.Column(db.Integer, primary_key=True, autoincrement=True)
    codusuario = db.Column(db.Integer, db.ForeignKey('users.id'), nullable=False)
    nome = db.Column(db.String(50), nullable=False)
    especializacao = db.Column(db.String(50), nullable=False)
    afiliacaohospitalar = db.Column(db.String(50), nullable=False)

    usuario = db.relationship('Users', backref='medicos', foreign_keys=[codusuario])

    def __init__(self, codusuario, nome, especializacao, afiliacaohospitalar):
        self.codusuario = codusuario
        self.nome = nome
        self.especializacao = especializacao
        self.afiliacaohospitalar = afiliacaohospitalar
        
    def to_dict(self):
        return {
            'codigo': self.codigo,
            'codusuario': self.codusuario,
            'nome': self.nome,
            'especializacao': self.especializacao,
            'afiliacaohospitalar': self.afiliacaohospitalar,
            'usuario': self.usuario.to_dict() 
        }
