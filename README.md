# :wrench: PROBE-2025-2

Repositório criado para as entregas das atividades da matéria de Programação Back-end.

## :memo: Descrição

O ManagesysAPI oferece informações sobre diversos tipos de produtos, permitindo que os usuários consultem características de cada produto, filtrem por marca e também realizem operações CRUD (Create, Read, Update & Delete), sobre o banco de dados de produtos. A API é voltada para fins educacionais e de pesquisa, fornecendo dados simples e acessíveis.

## Funcionalidades

- **Listar todos os produtos**: Retorna uma lista com todos os produtos, com uma opção de filtragem por marca.
- **Buscar produto por nome**: Busca informações sobre um produto específico filtrado por seu nome.
- **Adicionar um novo produto**: Permite adicionar um novo produto ao banco de dados.
- **Atualizar dados existentes**: Permite atualizar informações de um produto existente.
- **Deletar um produto**: Deleta um produto da lista.

## Estrutura

O projeto é estruturado em:

- **config**: Contém as configurações da API, como porta e banco de dados.

- **controllers**: Contém as classes que lidam com as requisições HTTP, realizando operações CRUD.

- **models**: Contém as classes que representam os produtos, com suas características e métodos

- **services**: Contém as classes que realizam operações de banco de dados. (funções)

- **resources**: Contém propriedades da aplicação.

## Tecnologias

- **Linguagem**: Java v. 17.0.16 >
- **Framework**: Spring Boot v. 2.6.0 
- **Gerenciador de Dependências**: Maven v. 4.0.0
- **Ambiente de Desenvolvimento**: Visual Studio Code (VSCode) v. 


## Como Executar o Projeto

**1. Clone ou baixe o zip do repositório (no caso do zip, descompacte a pasta).**
**2. Instale as dependências necessárias.**
**3. Configure o banco de dados corretamente.**
**4. Execute o comando 'mvn spring-boot:run' para iniciar a aplicação.**
**5. Acessa a API em http://localhost:8080/swagger-ui/index.html**

## Licença

Este projeto está licenciado sob a MIT License.

Projeto com fins educativos, sinta-se à vontade para modificar qualquer parte do README para atender suas necessidades.