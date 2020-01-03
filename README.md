# Teste de API REST com Spring Boot

Aplicação Spring Boot

## Instruções para executar o projeto 

### Utilizar o IntelijIDEA
O 'projeto foi realizado na IDE Intelij, para rodar em outras IDEs será necessário converter'.
Basta abrir o projeto na IDE Intelij e importar as configurações do Maven que estão no pom.xml.
A IDE faz isso automaticamente. Após a importação de todas as dependências do projeto vai ser necessário
utilizar o MySQL na sua máquina.

### Utilizar o MySQL
O projeto está configurado para criar um banco de dados automaticamente e possui o gerenciamento de migração
do Flyway, assim que o spring boot iniciar vai criar o banco com todos os dados inclusos.

#### Configurar senha do root do seu MySQL
Para que a criação do banco de dados funcione será necessário alterar a senha no arquivo application.properties na linha 4, do seu usuario root do MySQL:

spring.jpa.database=mysql
spring.datasource.url=jdbc:mysql://localhost:3306/transactionapi?createDatabaseIfNotExist=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=SUA SENHA // <- ALTERAR A SENHA AQUI

## Teste de chamadas da API pelo Postman

Foi utilizado o postman para testar as requisições, veja os prints de tela dos testes:

