# Sistema de Locação de Imóveis

Este é um projeto de exemplo de um sistema de locação de imóveis desenvolvido em Spring, destinado a demonstrar as funcionalidades básicas de uma aplicação monolítica de locação de imóveis.

## Visão Geral

Este sistema permite a gestão de imóveis disponíveis para locação, locatários, contratos de locação e outras funcionalidades relacionadas à locação de imóveis.

## Funcionalidades Principais

- Cadastro de imóveis para locação.
- Consulta e busca de imóveis disponíveis.
- Cadastro de endereço.
- Cadastro de locatores.
- Listagem, edição e deleção de cada um deles

## Pré-requisitos

- Java 11 ou superior
- Spring Boot
- Banco de dados Mysql
- Maven para gerenciamento de dependências

## Configuração do Projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/Locacao-Imoveis.git
spring.datasource.url=jdbc:mysql://localhost:3306/imoveis
spring.datasource.username=root
spring.datasource.password=

## Execute o projeto
- mvn spring-boot:run
