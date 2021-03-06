# Passagem de parâmetros por valor e por referência

Os parâmetros dos métodos funcionam da maneira similar à pilha de memória. Os tipos primitivos vão ser passados por _valor_, enquanto os objetos vão ser passados por _referência_.

| Tipo      | Exemplo                | Passagem   |
| --------- | ---------------------- | ---------- |
| Primitivo | `int, double, boolean` | Valor      |
| Objeto    | `class, enum, Array`   | Referência |

Isso significa que a pilha do método que está sendo executado vai ter uma cópia do valor, caso seja passagem por valor. E uma _referência_, caso seja uma passagem por referência.

Vamos examinar um exemplo usando a classe `Contato`

```java
public class PassagemValorRef {
  public static void main(String[] args) {
    var contato = new Contato("Kylo Ren", "96222-8799", "kylo@darkside.com");
    int valor = 10;

    // O contato não é alterado
    testePassagemValor(valor, contato);
    // O contato é alterado
    testePassagemRef(valor, contato);
  }

  private static void testePassagemValor(int valor, Contato contato) {
    // Variável local, não altera o escopo do main
    int novoValor = valor + 10;
    valor = novoValor;

    // Outro objeto é instanciado e armazenado localmente no lugar do contato que foi passado por parâmetro
    contato = new Contato("Rey Skywalker", "988822222", "rey@ashla.com");
  }

  private static void testePassagemRef(int valor, Contato contato) {
    // Variável local, não altera o escopo do main
    int novoValor = valor + 10;
    valor = novoValor;

    // Chamada do método do objeto, altera o atributo do objeto referenciado
    contato.setNome("Rey Skywalker" + valor);
  }
}
```
