from flask import request, jsonify
from database.db import db
from models.users import Users

def users_controller():
    if request.method == 'POST':
        try:
            data = request.get_json()
            user = Users(data['nome'],data['cpf'], data['email'], data['senha'], data['papel'])
            db.session.add(user)
            db.session.commit()
            return jsonify({'message': 'Usuário criado com sucesso'}), 200
        except Exception as e:
            return jsonify({'message': 'O usuário não foi criado', 'error': str(e)}), 405

    elif request.method == 'GET':
        try:
            users_data = Users.query.all()
            users_list = [user.to_dict() for user in users_data]
            return jsonify({'users': users_list}), 200
        except Exception as e:
            return jsonify({'message': 'Não foi possível buscar usuários', 'error': str(e)}), 405

def login_controller():
    if request.method == 'POST':
        try:
            data = request.get_json()
            cpf = data['cpf']
            senha = data['senha']
            
            user = Users.query.filter_by(cpf=cpf).first()
            if user and user.check_password(senha):
                return jsonify({'message': 'Login realizado com sucesso'}), 200
            else:
                return jsonify({'message': 'Credenciais inválidas'}), 401
        except Exception as e:
            return jsonify({'message': 'Erro no login', 'error': str(e)}), 405