# Security App API 

API RESTful desenvolvida com **Spring Boot** e **Java 21**, focada em autenticação e autorização *Stateless* utilizando **Spring Security** e **JWT**. Inclui controle de acesso baseado em *roles* (RBAC), persistência com **PostgreSQL**, migrações com **Flyway** e documentação interativa com **Springdoc OpenAPI (Swagger)**.

---

##  Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Security & JWT** (Autenticação Stateless e RBAC)
* **Spring Data JPA & Hibernate**
* **PostgreSQL** (Banco de dados)
* **Flyway** (Migrações de banco de dados)
* **Springdoc OpenAPI / Swagger** (Documentação da API)

---
### Configuração e Instalação
Como o projeto utiliza variáveis de ambiente para proteger dados sensíveis, siga os passos abaixo para
rodá-lo localmente.
1. Clone o repositório
git clone https://github.com/seu-usuario/securityapp.git
cd securityapp

___

### Configure as Variáveis de Ambiente
Crie ou configure as seguintes variáveis de ambiente na sua IDE (como o IntelliJ IDEA) ou no seu
sistema operacional antes de executar o projeto:
Variável Descrição Exemplo
DB_HOST Host do banco de dados localhost


Variável Descrição Exemplo
DB_PORT Porta do PostgreSQL 5432
DB_NAME Nome do banco de dados seguranca
DB_USER Usuário do banco postgres
DB_PASSWORD Senha do banco sua_senha_real

Nota no IntelliJ: Vá em Run > Edit Configurations... > Environment variables e adicione as chaves
acima.

### Como Executar
Com o banco de dados PostgreSQL rodando e as variáveis de ambiente configuradas, execute a classe
principal SecurityappApplication pela sua IDE ou utilize o Maven via terminal:

./mvnw spring-boot:run

Documentação da API (Swagger)
Com a aplicação rodando, você pode acessar a documentação interativa da API diretamente pelo
navegador:
http://localhost:8080/swagger-ui/index.html
