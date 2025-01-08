# API de Produtos

Este projeto é uma API RESTful desenvolvida com **Spring Boot**. Ela permite que você busque e adicione produtos, armazenando-os em um arquivo **`products.txt`**.

## Foto da API Funcionando

![API Funcionando](https://drive.google.com/uc?id=1K2cRUAcsGZjrrXXSr3oGCFnmBfIVXv3n)

##

![API Funcionando](https://drive.google.com/file/d/1q-yJ19TpWTaIA8bXZa90EM5VfqblVm1B/view?usp=sharing)

## Endpoints

### 1. Buscar Produto
- **Endpoint:** `/api/produtos/buscar`
- **Método:** `POST`
- **Corpo da requisição (JSON):**
```json
{
  "nome": "Nome do Produto"
}
```
- **Resposta:**
    - Se o produto for encontrado, ele será retornado com os detalhes.
    - Se o produto não for encontrado, será lançado um erro **404** com a mensagem: **Produto não encontrado**.

### 2. Adicionar Produto (se o produto não existir)
- **Endpoint:** `/api/produtos/buscar`
- **Método:** `POST`
- **Corpo da requisição (JSON):**
```json
{
  "nome": "Nome do Produto",
  "descricao": "Descrição do Produto",
  "preco": "Preço do Produto"
}
```
- **Resposta:**
    - Se o produto já existir, ele será retornado com os detalhes.
    - Se o produto não existir, ele será criado e adicionado ao arquivo **`products.txt`**.

**Nota:** O endpoint `/api/produtos/buscar` pode ser utilizado tanto para buscar quanto para adicionar produtos. A diferença está nos dados enviados na requisição (apenas o nome para buscar ou o nome, descrição e preço para adicionar).

## Estrutura do Arquivo `products.txt`

O arquivo **`products.txt`** armazena os produtos no formato CSV, com três campos: **nome**, **descricao** e **preco**.

Exemplo de conteúdo do arquivo:

```
Nome: PlayStation 5
Descricao: video-game
Preco: 3999.99

Nome: Xbox One
Descricao: video-game
Preco: 3599.99

Nome: Nintendo Switch
Descricao: video-game
Preco: 2999.99

Nome: Xbox Series X
Descricao: video-game
Preco: 4999.99
```

## Tratamento de Erros

- **Produto não encontrado:** Quando um produto não for encontrado na busca, será retornado um erro com código **404** e a mensagem **Produto Não Encontrado**.
- **Produto já existe:** Se um produto com o mesmo nome já existir, ele será retornado na busca sem a necessidade de ser recriado.

## Como Usar

1. Clone o repositório.
2. Execute a aplicação com o comando:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse a API através de um cliente HTTP, como **Postman**.
4. Use o endpoint **`POST /api/produtos/buscar`** para buscar ou adicionar produtos.

## Exemplo de Teste no Postman

1. **Buscar Produto:**
   - Método: `POST`
   - URL: `http://localhost:8080/api/produtos/buscar`
   - Corpo da requisição (JSON):
     ```json
     {
       "nome": "PlayStation 5"
     }
     ```

2. **Adicionar Produto:**
   - Método: `POST`
   - URL: `http://localhost:8080/api/produtos/buscar`
   - Corpo da requisição (JSON):
     ```json
     {
       "nome": "Xbox Series X",
       "descricao": "video-game",
       "preco": "4999.99"
     }
     ```
