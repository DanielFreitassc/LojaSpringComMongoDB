from flask import request, jsonify
from database.db import db
from models.prescricao import Prescricao

def prescricao_controller():
    if request.method == 'POST':
        try:
            data = request.get_json()
            codconsulta = data.get('codconsulta')
            medicamento = data.get('medicamento')
            dosagem = data.get('dosagem')
            frequencia = data.get('frequencia')
            datainicio = data.get('datainicio')
            datafim = data.get('datafim')

            prescricao = Prescricao(codconsulta=codconsulta, medicamento=medicamento,
                                    dosagem=dosagem, frequencia=frequencia,
                                    datainicio=datainicio, datafim=datafim)

            db.session.add(prescricao)
            db.session.commit()
            return jsonify({'message': 'Prescrição cadastrada com sucesso'}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao cadastrar prescrição', 'error': str(e)}), 500

    elif request.method == 'GET':
        try:
            prescricoes = Prescricao.query.all()
            prescricoes_list = [prescricao.to_dict() for prescricao in prescricoes]
            return jsonify({'prescricoes': prescricoes_list}), 200
        except Exception as e:
            return jsonify({'message': 'Erro ao buscar prescrições', 'error': str(e)}), 500
