from flask import Flask
from flask_cors import CORS 
from database.db import db
from routes.index import default_routes
from models import *

class App():
    def __init__(self):
        self.app = Flask(__name__)
        CORS(self.app) 
        self.app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://user:password''@localhost:3306/db'
        
        db.init_app(self.app)
        
        with self.app.app_context():
             db.create_all()
        default_routes(self.app)
    
    def run(self):
        return self.app.run(port=3000, host='localhost', debug=True)
    
app = App()
app.run()