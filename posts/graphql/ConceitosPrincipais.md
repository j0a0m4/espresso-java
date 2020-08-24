# GraphQL: 02 - Conceitos Principais

![GraphQL Logo](../../assets/graphql.png)

Vamos explorar os conceitos principais para construir uma `query` e `mutation`.

## Navegação

- [Types](##types)
- [Queries](##queries)
- [Mutation](##mutations)

## Types

GraphQL tem um _schema_ fortemente tipado. Por isso, precisamos conhecer os tipos permitidos, para descrevermos nossos dados corretamente.

### Scalar Types

> Tipos escalares

Os tipos primitivos do GraphQL:

| Tipo      | Descrição                                                                       |
| --------- | ------------------------------------------------------------------------------- |
| `Int`     | Inteiro 32-bit                                                                  |
| `Float`   | Ponto flutante com precião dupla 32-bit                                         |
| `String`  | Uma sequência de caracteres UTF-8                                               |
| `Boolean` | Valores `true` ou `false`                                                       |
| `ID`      | Identificador único. Usado para recarregar um objeto ou como chave para o cache |

### Complex Types

> Tipos complexos

Podemos declarar objetos própios, com comportamentos complexos específicos.

```graphql
type Author {
  id: ID
  firstName: String
  lastName: String
  rating: Float
  numOfCourses: Int
}
```

Esse é um exemplo de definição de tipos numa _schema_ GraphQL. Dessa forma podemos criar tipos personalizados, de acordo com a necessidade da aplicação.

### Enumeration Types

> Tipo Enumerador ou Enum

Enums são tipos escalares especiais que são restritos a um conjunto de valores permitidos. São usados por permitir a validação dos argumentos passados. Ou seja, os argumentos desse tipo só podem ser um dos valores especificados.

```graphql
enum language {
  ENGLISH
  SPANISH
  FRENCH
}
```

### Query e Mutation

Todo serviço GraphQL obrigatoriamente tem um tipo `query`. Entretanto, pode ter tipos `mutation` ou não, caso a API seja somente para leitura. Esses tipos agem como um ponto de entrada no _schema_.

```graphql
schema {
  query: Query
  mutation: mutation
}
```

A `query` representa uma consulta, ou o que o _client_ estiver pedindo. E a `mutation` representa as operações de modificação dos dados: criação, deleção e edição.  
Esses tipos são tratados como qualquer outro tipo GraphQL.

```graphql
type Query {
  author_details: [Author]
}

type Mutation {
  addAuthor(firstName: String, lastName: String): Author
}
```

### Non-nullable Type

> Tipos Obrigatórios

Ao usar o ponto de exclamação (`!`) na definição de um objeto, você assegura que aquele tipo escalar é obrigatório, ou seja, não pode ser `null`.

```graphql
type Author {
  id: ID!
  firstName: String
  lastName: String
  rating: Float
  numOfCourses: Int
  courses: [String!]
}
```

Nesse caso, o objeto `Author` sempre vai ter uma `id`. Por ter sido declarado como um campo _non-nullable_.

## Queries

Vamos usar o GitHub [GraphQL API Explorer](https://developer.github.com/v4/explorer/) para explorar a linguagem. Essa é uma API pública e com dados de produção.

### Queries - Fields

> Query - Campos

Uma query GraphQL permite pedir por campos específicos dos objetos. Logo, pode ser considerada uma consulta.

Query:

```graphql
query {
  viewer {
    name
    bio
    company
  }
}
```

Resposta:

```json
{
  "data": {
    "viewer": {
      "name": "João Marcos",
      "bio": "👨🏻‍💻 consulting intern @ sensedia\r\n👨🏻‍🎓 estudante @ uff\r\n🔙 backend dev",
      "company": "@Sensedia"
    }
  }
}
```

### Queries - Arguments

> Query - Argumentos

É possível passar argumentos para os campos. Todo campo e objeto aninhado pode ter o seu próprio conjunto de argumentos. É essa funcionalidade que pemite não precisarmos de múltiplos _requests_ para a API.

Query:

```graphql
query {
  viewer {
    login
    following(last: 2) {
      nodes {
        id
        bio
        name
      }
    }
  }
}
```

Resposta:

```json
{
  "data": {
    "viewer": {
      "login": "j0a0m4",
      "following": {
        "nodes": [
          {
            "id": "MDQ6VXNlcjE1MDMzMA==",
            "bio": "I envision and evangelize the future of Open Web technologies, especially JS.",
            "name": "Kyle Simpson"
          },
          {
            "id": "MDQ6VXNlcjU5NTQ1",
            "bio": "Software Engineer at Citi. Published author (PacktPub). Tech articles (loiane.com) and video courses (loiane.training).",
            "name": "Loiane Groner"
          }
        ]
      }
    }
  }
}
```

Os argumentos foram passados no objeto `following` para filtrar os últimos dois objetos.

```graphql
following (last: 2) {
}
```

### Queries - Alias

Essa funcionalidade permite usarmos um nome difrentes pros objetos. É útil principalmente quando queremos resultados do mesmo objeto com argumentos diferentes.

```graphql
query {
  viewer {
    login
    firstFollowers: following(last: 2) {
      nodes {
        id
        bio
      }
    }
    lastFollowers: followers(last: 5) {
      nodes {
        id
        bio
      }
    }
  }
}
```

### Queries - Fragments e Operation

> Queries - Fragmentos e Operação

_Fragments_ são unidades reutilizáveis. Permite construir um conjunto de campos e incluir em múltiplas queries.

```graphql
query viewerInfo {
  viewer {
    login
    firstFollowers: following(last: 2) {
      nodes {
        ...userInfo
      }
    }
    lastFollowers: followers(last: 5) {
      nodes {
        ...userInfo
      }
    }
  }
}

fragment userInfo on User {
  name
  id
  bio
  avatarUrl
}
```

Usando fragments, podemos reutilizar campos que estamos buscando em múltiplos lugares da query.

É possível nomear a query anônima, colocando o nome da operação. Nesse caso, a operação foi batizada `viewerInfo`.

### Queries - Variables

> Queries - Variáveis

Os argumentos para os campos podem se tornar dinâmicos com o uso de variáveis. GraphQL usa variáveis para coletar os valores dinâmicas da query, e passa-las em um dicionário separado.

Query:

```graphql
query viewerInfo($isOwner: Boolean!) {
  viewer {
    id
    name
    starredRepositories(ownedByViewer: $isOwner, last: 5) {
      nodes {
        id
        name
      }
    }
  }
}
```

Query Variables:

```graphql
{
  "isOwner" : false
}
```

## Mutations

> Mutações

- Mutações são usadas para fazer mudanças nos dados: criar, atualizar ou excluir.
- GraphQL assume que vão acontecer efeitos colaterais (_side-effects_) após as mutações e muda o conjuntos de dados após essa operação.
- Enquanto queries são executadas em paralelo, mutações ocorrem em série, uma após a outra.

Mutation:

```graphql
mutation NewStatus($input: ChangeUserStatusInput!) {
  changeUserStatus(input: $input) {
    clientMutationId
    status {
      message
    }
  }
}
```

Query Variables:

```graphql
{
  "input": {
    "clientMutationId": "10101020",
    "message": "Demo for Pluralsight"
  }
}
```
