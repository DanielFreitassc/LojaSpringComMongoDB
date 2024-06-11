from flask import request, jsonify
from database.db import db
from models.medico import Medico

def medico_controller():
    if request.method == 'POST':
        try:
            data = request.get_json()
            codusuario = data.get('codusuario')
            nome = data.get('nome')
            especializacao = data.get('especializacao')
            afiliacaohospitalar = data.get('afiliacaohospitalar')

            medico = Medico(codusuario=codusuario, nome=nome,
                            especializacao=especializacao, afiliacaohospitalar=afiliacaohospitalar)

            db.session.add(medico)
            db.session.commit()
            return jsonify({'message': 'Médico cadastrado com sucesso'}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao cadastrar médico', 'error': str(e)}), 500

    elif request.method == 'GET':
        try:
            medicos = Medico.query.all()
            medicos_list = [medico.to_dict() for medico in medicos]
            return jsonify({'medicos': medicos_list}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao buscar médicos', 'error': str(e)}), 500
