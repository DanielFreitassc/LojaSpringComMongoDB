from flask import request, jsonify
from database.db import db
from models.consulta import Consulta
from models.paciente import Paciente
from models.medico import Medico
from datetime import datetime

def consulta_controller():
    if request.method == 'POST':
        try:
            data = request.get_json()
            codpaciente = data.get('codpaciente')
            codmedico = data.get('codmedico')
            horariodata_str = data.get('horariodata')
            status = data.get('status')
            descricao = data.get('descricao')

            horariodata = datetime.strptime(horariodata_str, '%d-%m-%Y %H:%M:%S')

            paciente = Paciente.query.get(codpaciente)
            medico = Medico.query.get(codmedico)

            if not paciente:
                return jsonify({'message': 'Paciente não encontrado'}), 404
            if not medico:
                return jsonify({'message': 'Médico não encontrado'}), 404

            consulta = Consulta(codpaciente=codpaciente, codmedico=codmedico,
                                horariodata=horariodata, status=status, descricao=descricao)

            db.session.add(consulta)
            db.session.commit()

            return jsonify({'message': 'Consulta marcada com sucesso'}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao marcar consulta', 'error': str(e)}), 500

    elif request.method == 'GET':
        try:
            consultas = Consulta.query.all()
            consultas_list = [consulta.to_dict() for consulta in consultas]
            return jsonify({'consultas': consultas_list}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao buscar consultas', 'error': str(e)}), 500
