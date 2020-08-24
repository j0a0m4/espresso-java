# GraphQL - O que é GraphQL?

![GraphQL Logo](../../assets/graphql.png)

## História

Em 2012, o Facebook iniciou esse projeto para superar problemas de busca de dados na sua plataforma mobile nativa. Isso mudou o foco de desenvolvimento para os aplicativos _client_. Em 2015, GraphQL virou open source e um grande envolvimento da comunidade se consolidou.

## O motivo do GraphQL

GraphQL veio a existência devido a necessidade de melhor flexibilidade e eficiência nas interações cliente-servidor.

## O que é GraphQL?

GraphQL é essencialmente uma linguagem de consulta para sua API. É somente uma especificação e não é uma biblioteca, produto nem uma base de dados.
É uma alternativa mais flexível eficiente do que o REST.

## API Rest

Usando o REST, nos comunicamos com um _endpoint_ fazendo uma requisição. E como resposta, recebemos um JSON massivo.

## API GraphQL

GraphQL permite escrevermos uma query com os resultados que desejamos e recebemos um JSON somente com os campos e filtros escolhidos.

GraphQL Query:

```graphql
{
  allPeople(last: 3) {
    people {
      name
      gender
    }
  }
}
```

Resposta JSON:

```json
{
  "data": {
    "allPeople": {
      "people": [
        {
          "name": "João",
          "gender": "male"
        },
        {
          "name": "Nathan",
          "gender": "male"
        },
        {
          "name": "Lívia",
          "gender": "female"
        }
      ]
    }
  }
}
```

### Benefícios

- O _client_ tem o poder de pedir exatamente o que é necessário e nada mais
- Agnóstico em relação a linguagem de programação
- A API GraphQL permite a busca de todos os dados necessário numa só requisição

## Quem está usando?

Tantos times pequenos como grandes estão usando GraphQL no lugar de APIs REST.
Alguns grandes utilizadores:

- Facebook
- PayPal
- Twitter
- Yelp
- GitHub

> Lista completa pode ser acessada [aqui](https://graphql.org/users/).

## REST vs GraphQL

![REST vs GraphQL](../../assets/restVSgraphql.jpeg)

Imagine uma interface de usuário (UI) que deseja exibir informção de um autor:

- Nome do Autor
- Cursos ministrados
- Avalição do autor
- Tópicos recentes

### REST

Usando um serviço REST, precisáriamos acessar cada um desses endpoints para buscarmos as informações necessárias.

- `GET /ps/author/<id>`
- `GET /ps/author/<id>/courses`
- `GET /ps/author/<id>/rating`
- `GET /ps/author/<id>/topics`

Um problema com essa abordagem é que as respostas de cada requisição vão conter mais dados do que necessário. Sendo assim, o _client_ vai precisar filtrar as informações. Além de ter trafegado pacotes de dados desnecessários, usando mais banda e reduzindo a eficiência da comunicação.

### GraphQL

Usando GraphQL podemos na mesma requisição especificar os campos que desejamos e receber uma resposta com todas as informações necessárias, já filtradas e prontas para o consumo.

GraphQL Query:

```graphql
{
  author(id: 2100) {
    name
    courses {
      title
    }
    rating
    topics(last: 3) {
      name
    }
  }
}
```

Resposta JSON:

```json
{
  "data": {
    "author": {
      "name": "Loiane Groner",
      "courses": [
        { "title": "Dicas e Truques com Visual Studio Code" },
        { "title": "Novidades Java 14" }
      ],
      "rating": "4.8",
      "topics": [
        { "name": "Java" },
        { "name": "Angular" },
        { "name": "TypeScript" }
      ]
    }
  }
}
```

| REST                                                                          | GraphQL                                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| Múltiplas _round trips_ para coletar informção de múltiplos recursos          | Uma única requisição para coleter uma informção por agregação de dados                    |
| _Over fetching_ e _Under fetching_                                            | Somente recebe o que você pediu, de acordo com suas necessidades                          |
| Os times Front-end precisam contar com o Back-end para disponibilizar as APIs | Os times podem trabalhar independetemente                                                 |
| Caching vem por padrão por usar a especificação HTTP                          | Não usa a especificação HTTP para usar o _cache_ e necessita de bibliotecas como _Apollo_ |

**Over fetching** ocorre quando a requisição para a API Rest retorna um JSON com mais dados do que eu preciso. **Under fetching** ocorre quando eu precisar fazer requisições para vários _endpoints_ para conseguir buscar todos os dados necessários.
