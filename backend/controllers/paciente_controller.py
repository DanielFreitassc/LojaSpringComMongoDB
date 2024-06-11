from flask import request, jsonify
from database.db import db
from models.paciente import Paciente 

def paciente_controller():
    if request.method == 'POST':
        try:
            data = request.get_json()
            codusuario = data.get('codusuario')
            nome = data.get('nome')
            nascimento = data.get('nascimento')
            genero = data.get('genero')
            endereco = data.get('endereco')

            paciente = Paciente(codusuario=codusuario, nome=nome,
                                nascimento=nascimento, genero=genero, endereco=endereco)

            db.session.add(paciente)
            db.session.commit()
            return jsonify({'message': 'Paciente cadastrado com sucesso'}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao cadastrar paciente', 'error': str(e)}), 500

    elif request.method == 'GET':
        try:
            pacientes = Paciente.query.all()
            pacientes_list = [paciente.to_dict() for paciente in pacientes]
            return jsonify({'pacientes': pacientes_list}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao buscar pacientes', 'error': str(e)}), 500
