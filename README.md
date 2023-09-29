# Fórum Alura - API Java

Este é o repositório da API Java para o Fórum Alura, uma aplicação de exemplo para um fórum de discussão de tópicos. O projeto foi desenvolvido utilizando Java 17, Spring Boot 3.0.11 e MySQL como banco de dados. Algumas das principais dependências incluem Lombok, Spring Data JPA, Flyway e OpenAPI (Swagger). A IDE utilizada para o desenvolvimento foi o IntelliJ.

## Visão Geral

O Fórum Alura é uma aplicação simples que permite a criação, leitura, atualização e exclusão de tópicos. Cada tópico tem os seguintes campos:

- **id**: Identificador único do tópico.
- **titulo**: Título do tópico.
- **mensagem**: Mensagem ou conteúdo do tópico.
- **data de criação**: Data e hora de criação do tópico.
- **status**: Status atual do tópico (por exemplo, ativo, inativo, resolvido, etc.).
- **autor**: Autor do tópico.
- **curso**: Curso relacionado ao tópico.

## Configuração do Ambiente

Certifique-se de ter as seguintes ferramentas e recursos instalados antes de iniciar:

- [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL](https://www.mysql.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Spring Boot 3.0.11](https://spring.io/projects/spring-boot)

## Configuração do Banco de Dados

O projeto utiliza o MySQL como banco de dados. Certifique-se de criar um banco de dados com o nome desejado e configurar as informações de conexão no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Executando o Projeto
1. Clone o repositório para o seu ambiente de desenvolvimento:
```
git clone https://github.com/rcleyton/forum_alura
```
2. Abra o projeto no IntelliJ IDEA.
3. Configure as informações do banco de dados no arquivo application.properties, conforme mencionado acima.
4. Execute a aplicação Spring Boot.
5. Acesse a documentação da API no Swagger em http://localhost:8080/swagger-ui/ para testar os endpoints e entender como a API funciona.

## Endpoints da API
A API oferece os seguintes endpoints:

- `GET /api/topicos`: Lista todos os tópicos.
- `GET /api/topicos/{id}`: Retorna um tópico específico pelo ID.
- `POST /api/topicos`: Cria um novo tópico.
- `PUT /api/topicos/{id}`: Atualiza um tópico existente pelo ID.
- `DELETE /api/topicos/{id}`: Exclui um tópico pelo ID.

Consulte a documentação Swagger para obter detalhes sobre como usar esses endpoints.

## Contribuições
Contribuições são bem-vindas! Se você deseja contribuir com este projeto, sinta-se à vontade para criar um fork do repositório, fazer as alterações desejadas e enviar um pull request.

### Licença
Este projeto está licenciado sob a <a href="https://opensource.org/licenses/MIT">Licença MIT</a>.