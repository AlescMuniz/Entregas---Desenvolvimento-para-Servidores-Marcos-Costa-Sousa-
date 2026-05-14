# P2 - Sistema de Login com Java + MySQL
**Disciplina:** Desenvolvimento para Servidores I  
**Professor:** Marcos Costa de Sousa  
**Instituição:** FATEC São Roque

---

## Estrutura do Projeto

```
P2_Login/
├── bd_login.sql                  ← Script SQL do banco de dados
└── src/
    └── login/
        ├── Conexao.java          ← Classe de conexão com MySQL
        ├── Usuario.java          ← Classe modelo + métodos de BD
        ├── TelaLogin.java        ← Tela de Login (Swing)
        ├── TelaCadastro.java     ← Tela de Cadastro (Swing)
        ├── TestaConexao.java     ← Main: testa a conexão
        ├── TestaTela.java        ← Main: testa a TelaLogin
        └── TestaTelaCadastro.java← Main: testa a TelaCadastro
```

---

## Como configurar no NetBeans

### 1. Criar o Banco de Dados
Abra o MySQL (MySQL Workbench ou linha de comando) e execute o arquivo `bd_login.sql`:
```sql
source caminho/bd_login.sql
```
Isso cria o banco `bd_login`, a tabela `usuario` e um usuário de teste:
- **usuário:** `marcao` | **senha:** `batatinha`

### 2. Criar o Projeto no NetBeans
1. File → New Project → **Java with Ant** → Java Application
2. Nome do projeto: `Login`
3. **Desmarque** a opção "Create Main Class"
4. Finish

### 3. Criar o Pacote
1. Clique com botão direito em Source Packages → New → Java Package
2. Nome: `login`

### 4. Adicionar os arquivos `.java`
Copie todos os arquivos da pasta `src/login/` para dentro do pacote `login` do projeto.

### 5. Adicionar o Driver MySQL (JDBC)
1. Clique com botão direito em **Libraries** → Add JAR/Folder
2. Selecione o arquivo `mysql-connector-java-8.x.xx.jar`
   - Se não tiver, baixe em: https://dev.mysql.com/downloads/connector/j/
   - Escolha "Platform Independent" → baixe o ZIP → extraia o JAR

### 6. Verificar a string de conexão em `Conexao.java`
Ajuste os atributos conforme seu ambiente:
```java
private final String servidor = "jdbc:mysql://127.0.0.1:3306/bd_login";
private final String usuario  = "root";
private final String senha    = "";   // sua senha do MySQL
```
> ⚠️ A porta padrão do MySQL é **3306**. O professor usou 3308 nas notas; ajuste conforme seu ambiente.

---

## Ordem de Execução

| Classe Main          | O que faz                              |
|----------------------|----------------------------------------|
| `TestaConexao`       | Testa se a conexão com o BD funciona   |
| `TestaTela`          | Exibe a tela de Login                  |
| `TestaTelaCadastro`  | Exibe a tela de Cadastro               |

Para executar uma classe específica: clique com botão direito sobre ela → **Run File (Shift+F6)**

---

## Funcionalidades implementadas

### TelaLogin
- Validação de campo vazio (usuário e senha)
- Autenticação no banco via MD5
- Mensagem de sucesso ou erro com `JOptionPane`
- Botão Cadastrar abre a `TelaCadastro`

### TelaCadastro
- Validação de todos os campos obrigatórios
- Verificação de senha mínima (10 caracteres)
- Verificação se senha == confirmar senha
- Verificação de duplicidade de usuário no banco
- INSERT com senha criptografada em MD5
- Ao cadastrar com sucesso, redireciona para o Login
- Botão Cancelar volta para a tela de Login

### Usuario (métodos)
| Método | Descrição |
|--------|-----------|
| `verificaUsuario(String usuario, String senha)` | Valida o login |
| `verificaUsuario(String usuario)` | Verifica duplicidade (**sobrecarga**) |
| `verificaPadraoSenha(String senha)` | Mínimo 10 caracteres |
| `cadastraUsuario(String nome, String usuario, String senha)` | INSERT no banco |

---

## Conceitos de OO aplicados (P2)

- ✅ **Classe** com atributos e métodos
- ✅ **Encapsulamento** (atributos `private`, getters/setters)
- ✅ **Sobrecarga de método** (`verificaUsuario` com 1 e 2 parâmetros)
- ✅ **Visibilidade** (`public`, `private`, `final`)
- ✅ **Orientação a Objetos** com banco de dados e GUI (Swing)
- ✅ **CRUD** (Create e Read implementados)
