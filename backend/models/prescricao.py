from database.db import db

class Prescricao(db.Model):
    __tablename__ = 'prescricoes'
    
    codigo = db.Column(db.Integer, primary_key=True, autoincrement=True)
    codconsulta = db.Column(db.Integer, db.ForeignKey('consultas.codigo'), nullable=False)
    medicamento = db.Column(db.String(50), nullable=False)
    dosagem = db.Column(db.String(50), nullable=False)
    frequencia = db.Column(db.String(50), nullable=False)
    datainicio = db.Column(db.Date, nullable=False)
    datafim = db.Column(db.Date, nullable=False)
    
    consulta = db.relationship('Consulta', backref='prescricoes', foreign_keys=[codconsulta])

    def __init__(self, codconsulta, medicamento, dosagem, frequencia, datainicio, datafim):
        self.codconsulta = codconsulta
        self.medicamento = medicamento
        self.dosagem = dosagem
        self.frequencia = frequencia
        self.datainicio = datainicio
        self.datafim = datafim
        
    def to_dict(self):
        return {
            'codigo': self.codigo,
            'codconsulta': self.codconsulta,
            'consulta': self.consulta.to_dict(),
            'medicamento': self.medicamento,
            'dosagem': self.dosagem,
            'frequencia': self.frequencia,
            'datainicio': self.datainicio.isoformat(),
            'datafim': self.datafim.isoformat()
        }
