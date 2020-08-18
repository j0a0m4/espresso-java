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

É possível modelar um exemplo similar usando enum. Só que o enum, por ter sido criado para esse casos, é uma solução mais adequada e legível.

```java
enum Tomada {
  // (1) Define as possíveis constantes e seus respectivos valores
  ON(true), OFF(false)

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

### Informações importantes
- Enums extendem implicitamente a classe `java.lang.Enum`, e por isso não podem extender nenhuma outra classe. Isso se dá devido ao java não ter suporte para herança múltipla.
- Você pode usar `Tomada.values()` para retorna um vetor com os valores de `Tomada`. (Obs.: Isso vale para qualquer enum)
- Podem ser comparados usando o operador `==`
- Não podem ser instaciados com `new`
- Podem implementar interfaces
- Pode ser declarado sepearadamente ou dentro de uma classe