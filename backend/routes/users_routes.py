from flask import Blueprint
from controllers.users_controller import users_controller, login_controller

users_routes = Blueprint('users_routes', __name__)

@users_routes.route('/users', methods=['GET', 'POST'])
def handle_users():
    return users_controller()

@users_routes.route('/login', methods=['POST'])
def handle_login():
    return login_controller()