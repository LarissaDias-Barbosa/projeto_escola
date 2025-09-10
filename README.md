## Projeto de API REST, na qual, minha ideia foi simular matricula de alunos, alteração dos seus dados pessoais, transferencia de escola. Este também 
é um dos primeiros projetos, onde implementei testes unitários, para aperfeiçoamento da API

## 🚀 Tecnologias utilizadas no projeto:
- Spring Boot;
- JPA;
- Banco de dados H2;
- Spring web;
- testes unitários;

## 📂 Estrutura do projeto:
- src/main/java - código fonte
- src/teste/java - testes unitários
- pom.xml - dependencias Maven

## Exemplo de uso dos endpoints:
POST /alunos         – cria um aluno
GET  /alunos/{cpf}    – busca um aluno
PUT  /alunos/{id}    – atualiza dados do aluno
DELETE /alunos/{id}  – remove aluno
