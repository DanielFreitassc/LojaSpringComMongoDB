from database.db import db

from datetime import datetime 

class Consulta(db.Model):
    __tablename__ = 'consultas'
    
    codigo = db.Column(db.Integer, primary_key=True, autoincrement=True)
    codpaciente = db.Column(db.Integer, db.ForeignKey('pacientes.codigo'), nullable=False)
    codmedico = db.Column(db.Integer, db.ForeignKey('medicos.codigo'), nullable=False)
    horariodata = db.Column(db.DateTime, nullable=False)
    status = db.Column(db.String(50), nullable=False)
    descricao = db.Column(db.String(200), nullable=False)
    
    paciente = db.relationship('Paciente', backref='consultas', foreign_keys=[codpaciente])
    medico = db.relationship('Medico', backref='consultas', foreign_keys=[codmedico])
    
    def __init__(self, codpaciente, codmedico, horariodata, status, descricao):
        self.codpaciente = codpaciente
        self.codmedico = codmedico
        self.horariodata = horariodata
        self.status = status
        self.descricao = descricao
        
    def to_dict(self):
        return {
            'codigo': self.codigo,
            'codpaciente': self.codpaciente,
            'paciente': self.paciente.to_dict(),
            'codmedico': self.codmedico,
            'medico': self.medico.to_dict(),
            'horariodata': self.horariodata.strftime('%d-%m-%Y %H:%M:%S'),
            'status': self.status,
            'descricao': self.descricao
        }
