
# CRUD de Cadastro de Clientes

Este é um sistema de cadastro de clientes desenvolvido em Java, utilizando JDBC para interagir com o banco de dados MySQL. O sistema permite realizar operações CRUD (Create, Read, Update, Delete) para o gerenciamento de clientes. Os dados dos clientes, como nome, CPF, e-mail, telefone, endereço e data de nascimento, são armazenados e manipulados no banco de dados.


## Requisitos

- Java (versão 8 ou superior)

- MySQL (versão 5.x ou superior)

- Biblioteca FlatLaf para a interface gráfica

- JDBC para conexão com o banco de dados MySQL
## Funcionalidades
1. Cadastro de Cliente (Create)
O sistema permite cadastrar um cliente com as seguintes informações:

- Nome (String)

- CPF (String) - O CPF deve ser validado para garantir que esteja no formato correto e seja único.

- E-mail (String) - Deve ter um formato válido.

- Telefone (String) - O número de telefone deve ser validado para garantir que esteja no formato correto.

- Endereço (String)

- Data de Nascimento (Date) - Armazenada no formato YYYY-MM-DD.

O CPF deve ser único, ou seja, não é permitido cadastrar dois clientes com o mesmo CPF.

2. Visualização de Cliente (Read)
O sistema permite:

- Visualizar todos os clientes cadastrados.

- Buscar um cliente pelo CPF ou Nome e exibir seus dados, incluindo a data de nascimento.

3. Alteração de Cliente (Update)
O sistema permite editar os dados de um cliente, exceto o CPF (que é imutável). É possível atualizar os seguintes campos:

- Nome

- E-mail

- Telefone

- Endereço

- Data de Nascimento
 
4. Exclusão de Cliente (Delete)
Permite remover um cliente do banco de dados utilizando o CPF como identificador.

5. Validação e Tratamento de Erros
O sistema valida os dados inseridos, garantindo que os campos obrigatórios não fiquem em branco e que os dados (como CPF, telefone, e-mail e data de nascimento) estejam no formato correto.

Mensagens de erro apropriadas são exibidas nos seguintes casos:

- Tentativa de cadastrar um CPF já existente

- Inserção de dados em formato inválido

- Preenchimento incompleto de campos obrigatórios


## Banco de dados

### Estrutura da Tabela
A tabela `cadastro` no banco de dados MySQL deve ser criada com os seguintes campos:


    CREATE TABLE clientes (

    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL
    );
## Tecnologias Utilizadas

- Java - Para a implementação do sistema.

- MySQL - Para o armazenamento dos dados.

- JDBC - Para interação entre o Java e o banco de dados.

- FlatLaf - Biblioteca para a interface gráfica (UI), proporcionando um visual moderno e atraente.
## Como rodar o projeto

#### Passo 1: Configuração do Banco de Dados
1. Crie um banco de dados no MySQL, por exemplo, clientes_db.

2. Execute o script SQL acima para criar a tabela clientes.

#### Passo 2: Configuração do Projeto
1. Clone o repositório para sua máquina local:

       git clone https://github.com/leandrohcampos/crud-cadastro-clientes.git

2. Abra o projeto no seu IDE (NetBeans, IntelliJ, etc.).

3. No arquivo `ConnectionFactory`, insira as credenciais do seu banco de dados MySQL:

       jdbc:mysql://localhost/cadastro", "seu_usuario", "sua_senha"

#### Passo 3: Rodar o Projeto

1. Compile e execute o projeto em sua IDE.

A interface gráfica (GUI) será carregada, e você poderá realizar as operações de cadastro, visualização, edição e exclusão de clientes.

### Exemplo de Uso:

- Cadastrar um cliente:

   - Preencha os campos obrigatórios.

   - Clique em "Cadastrar" para salvar os dados no banco.

- Visualizar um cliente:

    - Todos os cliente já estarão visíveis na tela principal

- Editar um cliente:

   - Selecione um cliente e edite seus dados. O CPF não pode ser alterado.

- Excluir um cliente:

   - Clique no CPF do cliente desejado e escolha a opção de exclusão.
## Contribuições

Se você deseja contribuir para o projeto, fique à vontade para criar uma issue ou um pull request.



## Licença

[MIT](https://choosealicense.com/licenses/mit/)

