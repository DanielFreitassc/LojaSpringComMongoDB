# models/solictar_consulta.py

from database.db import db

class Solicita_consulta(db.Model):
    __tablename__ = 'solicita_consulta'

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    cpf = db.Column(db.String(12), nullable=False)
    tipo_de_consulta = db.Column(db.String(50), nullable=False)
    horario = db.Column(db.DateTime, nullable=False)
    endereco = db.Column(db.String(200))
    telefone = db.Column(db.String(20))

    def __init__(self, nome, cpf, tipo_de_consulta, horario, endereco=None, telefone=None):
        self.nome = nome
        self.cpf = cpf
        self.tipo_de_consulta = tipo_de_consulta
        self.horario = horario
        self.endereco = endereco
        self.telefone = telefone

    def to_dict(self):
        return {
            'id': self.id,
            'cpf': self.cpf,
            'tipo_de_consulta': self.tipo_de_consulta,
            'horario': self.horario.strftime('%d-%m-%Y %H:%M:%S'),
            'endereco': self.endereco,
            'telefone': self.telefone
        }
