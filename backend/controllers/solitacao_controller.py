from flask import request, jsonify
from datetime import datetime
from database.db import db
from models.solictar_consulta import Solicita_consulta


def solicitacao_controller():
    if request.method == 'POST':
        try:
            data = request.json 

            cpf = data.get('cpf')
            nome = data.get('nome')
            tipo_de_consulta = data.get('tipo_de_consulta')
            horario_str = data.get('horario')

            horario = datetime.strptime(horario_str, '%d-%m-%Y %H:%M:%S')

            nova_solicitacao = Solicita_consulta(
                nome=nome,
                cpf=cpf,
                tipo_de_consulta=tipo_de_consulta,
                horario=horario,
                endereco=data.get('endereco'),  
                telefone=data.get('telefone')  
            )

            db.session.add(nova_solicitacao)
            db.session.commit()

            return jsonify({'message': 'Solicitação de consulta criada com sucesso!'}), 201
        except ValueError:
            return jsonify({'error': 'Formato de data inválido. Use o formato dd-mm-yyyy HH:MM:SS'}), 400
        except KeyError as e:
            return jsonify({'error': f'Campo obrigatório não encontrado: {e}'}), 400
        except Exception as e:
            return jsonify({'error': str(e)}), 500
    
    elif request.method == 'GET':
        try:
            solicitacoes = Solicita_consulta.query.all()

            return jsonify([solicitacao.to_dict() for solicitacao in solicitacoes]), 200
        except Exception as e:
            return jsonify({'error': str(e)}), 500
