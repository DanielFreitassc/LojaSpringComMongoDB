### Endpoint: Criar Formulário

- **URL**: `/forms`
- **Método**: `POST`
- **Payload**:
  ```json
  {
    "name":"Fulano de Tal",
    "comment":"Achei super legal..",
    "input_one":"Sim",
    "input_two":"Sim",
    "input_three":"Não",
    "input_four":"Sim",
    "input_five":"Não",
    "input_six":"Sim"
}
  ```
- **Resposta**: Retorna o formulário criado no formato.
- **Exceções**:
  - **400 Bad Request**: Se o payload não estiver conforme esperado ou se houver erros de validação nos campos.
  
### Endpoint: Obter Todos os Formulários

- **URL**: `/forms`
- **Método**: `GET`
- **Resposta**: Retorna uma lista de todos os formulários cadatrados.
- **Exceções**:
  - **404 Not Found**: Se não houver formulários cadastrados no momento.

### Endpoint: Obter Formulário por ID

- **URL**: `/forms/{id}`
- **Método**: `GET`
- **Resposta**: Retorna o formulário específico identificado pelo `id`.
- **Exceções**:
  - **404 Not Found**: Se o formulário com o `id` especificado não existir.

### Endpoint: Atualizar Formulário

- **URL**: `/forms/{id}`
- **Método**: `PUT`
- **Payload**:
  ```json
  {
    "name":"Fulano de Tal",
    "comment":"Achei super legal..",
    "input_one":"Sim",
    "input_two":"Sim",
    "input_three":"Não",
    "input_four":"Sim",
    "input_five":"Não",
    "input_six":"Sim"
}
  ```
- **Resposta**: Retorna o formulário atualizado.
- **Exceções**:
  - **400 Bad Request**: Se o payload não estiver conforme esperado ou se houver erros de validação nos campos.
  - **404 Not Found**: Se o formulário com o `id` especificado não existir.

### Endpoint: Excluir Formulário

- **URL**: `/forms/{id}`
- **Método**: `DELETE`
- **Resposta**: Retorna o formulário excluído.
- **Exceções**:
  - **404 Not Found**: Se o formulário com o `id` especificado não existir.

### Endpoint: Obter Cartões de Formulário

- **URL**: `/forms/cards`
- **Método**: `GET`
- **Resposta**: Retorna uma lista de cartões de formulário, contendo apenas os campos `id`, `name`, `date` e `comment`.
- **Exceções**:
  - **404 Not Found**: Se não houver formulários cadastrados no momento.
