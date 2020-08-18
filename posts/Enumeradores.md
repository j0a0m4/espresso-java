# Enumeradores

Enums são listas de constantes. Quando você precisar de uma lista com valores pré-definidos que representam algum dado, deve ser usado enum.

No java, constantes são declaradas com `final`. Isso significa que a atribuição feita é imutável. No seguinte exemplo, não é possível alterar o valor de `on` para `false`:

```java
class Tomada {
  // Métodos estáticos podem ser acessados sem precisar instanciar a classe.
  final static boolean on = true;
  final static boolean off = false;
}
```

Outra forma de abordar a mesma representação é modelar usando `enum`. Só que o `enum`, por ter sido criado para esse casos, é uma solução mais adequada e legível.

```java
enum Tomada {
  // (1) Define as possíveis constantes e seus respectivos valores
  ON(true), OFF(false);

  // (2) Valor que vai ser atribuído a constante
  private boolean ligado;

  // (3) Construdor padrão que vai ser chamado automaticamente em 1.
  Tomada(boolean ligado) {
    this.ligado = ligado;
  }

  // (4) Método que retorna o valor associado a constante
  public boolean isLigado() {
    return ligado;
  }
}
```

## Métodos values e valueOf
### Método `values()`
O método `Enum.values()` retorna um vetor com os valores do `enum`, e é utilizado quando se deseja saber todos os seus valores.

Exemplo de iteração sobre os valores do `enum` usando um `for` loop;

```java
// Mostra os valores do enum:
// ON
// OFF
  for (Tomada tomada : Tomada.values()) {
      System.out.println(tomada);
  }
```

### Método `valueOf()`
A classe `Enum` possuí o método `Enum.valueOf()` que permite obter uma instância de um `enum` através de uma `String`. Ou seja, permite avaliar um valor de uma String e tranforma-la numa instância do `enum`.

```java
// Instância do enum Tomada
Tomada tomada = Enum.valueOf(Tomada.class, "OFF");

// Mostra o valor do enum, no caso de "OFF" vai ser:
// false
System.out.println(tomada.isLigado());
```

## Métodos Abstratos
Podemos utilizar métodos abstratos através de uma interface ou podemos declarar dentro do `enum`.

```java
enum TipoDocumento {

  CPF {
    // Implementação obrigatória do método
    @Override
    public String geraNumeroTeste() {
      return GeraCpfCnpj.cpf();
    }
  },
  CNPJ {
    // Implementação obrigatória do método
    @Override
    public String geraNumeroTeste() {
      return GeraCpfCnpj.cnpj();
    }
  };

  // Criação do método abstrato
  public abstract String geraNumeroTeste();
}
```


## Informações importantes
- Enums extendem implicitamente a classe `java.lang.Enum`, e por isso não podem extender nenhuma outra classe. Isso se dá devido a linguagem não ter suporte para herança múltipla.
- Podem ser comparados usando o operador `==`
- Não podem ser instaciados com `new`
- Podem implementar interfaces
- Podem ser declarados sepearadamente ou dentro de uma classe