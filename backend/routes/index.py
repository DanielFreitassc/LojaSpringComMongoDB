from routes.users_routes import users_routes

def default_routes(app):
    app.register_blueprint(users_routes)
    