from flask import Blueprint
from controllers.users_controller import users_controller, login_controller
from controllers.consulta_controller import consulta_controller
from controllers.paciente_controller import paciente_controller
from controllers.medico_controller import medico_controller
from controllers.prescricao_controller import prescricao_controller
from controllers.solitacao_controller import solicitacao_controller

users_routes = Blueprint('users_routes', __name__)

@users_routes.route('/register', methods=['GET', 'POST'])
def handle_users():
    return users_controller()

@users_routes.route('/login', methods=['POST'])
def handle_login():
    return login_controller()

@users_routes.route('/consulta', methods=['GET', 'POST'])
def handle_consulta():
    return consulta_controller()

@users_routes.route('/paciente', methods=['GET', 'POST'])
def handle_pacientes():
    return paciente_controller()

@users_routes.route('/medico', methods=['GET', 'POST'])
def handle_medico():
    return medico_controller()

@users_routes.route('/prescricao', methods=['GET', 'POST'])
def handle_prescricao():
    return prescricao_controller()

@users_routes.route('/apoio-online', methods=['GET', 'POST'])
def handle_solicitacao():
    return solicitacao_controller()
