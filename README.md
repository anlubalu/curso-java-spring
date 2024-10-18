# API de Consultório Médico

## Descrição
Esta é uma API para um aplicativo de consultório médico fictício, desenvolvida usando Java e Spring Boot. O projeto utiliza Spring Security para segurança, Spring Data para acesso a dados e MySQL 8.1 como banco de dados. O Maven é usado para gerenciamento de dependências e o projeto inclui testes unitários para garantir a qualidade do código.

## Requisitos
- Java 22.0.2
- Maven 3.9.8
- MySQL 8.1
- Recomendado que se use o Intellij
- Linux: Manjaro 24 ou superior

## Dependências
As principais dependências do projeto incluem:
- Lombock
- FlyWay
- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Test
- MySQL Connector Java
- Auth0 JWT

## Spring Docs/Swagger
```
http://localhost:8080/v3/api-docs
```

## Insomnia
```
src/main/resources/Insomnia_2024-10-17.json
```

## Configuração do Banco de Dados
Certifique-se de que o MySQL esteja instalado e em execução. Crie um banco de dados chamado `vollmed_api` e configure o arquivo `application.yml` com as suas credenciais de banco de dados:

```properties
    spring:
      application: api
      datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/vollmed_api
        username: root
        password: minhaSenhaForte
      jpa:
        show-sql: true
        properties:
          hibernate:
            format_sql: true
    server:
      error:
        include-stacktrace: never
    api:
      security:
        token:
          secret: ${JWT_SECRET:12345678}
```

## Docker Mysql
```
sudo docker run --name estudo-java -v /www/mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=minhaSenhaForte -d mysql:8.1 
```

## Este projeto está licenciado sob a licença MIT.


