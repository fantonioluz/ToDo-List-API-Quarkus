# ToDo List API - Quarkus

Este projeto foi desenvolvido como parte do meu aprendizado em **Quarkus**, um framework Java otimizado para containers nativos e execução rápida. O objetivo principal desta aplicação é gerenciar uma lista de tarefas (ToDo List), fornecendo uma API RESTful com funcionalidades de CRUD (Criar, Ler, Atualizar e Deletar) para as tarefas.

## Tecnologias Utilizadas

- **Quarkus**: Framework principal da aplicação
- **RESTEasy**: Para criação dos endpoints REST
- **Hibernate ORM com Panache**: Simplificação do uso do JPA para persistência de dados
- **H2 Database**: Banco de dados em memória para testes e desenvolvimento
- **Swagger UI**: Documentação interativa da API

## Funcionalidades

A API permite:

- **Criar uma nova tarefa** com título e descrição
- **Listar todas as tarefas**
- **Atualizar uma tarefa existente** (título, descrição e status de conclusão)
- **Deletar uma tarefa** pelo ID
- **Marcar uma tarefa como concluída**

