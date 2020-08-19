# Escopo de Variáveis

O escopo de variáveis é definido de acordo com o bloco onde ela foi declarada.   

```java
if (6 > 3) {
  var x = 10;
}
// Erro de Compilação
x++
```
No exemplo, a variável `x` só pode ser acessada entre as chaves. Ao tentar acessar fora do seu escopo, o compilador não vai encontrar a localização da variável.

```java
for (int i = 0; i < 10; i++) {
  System.out.println(i);
}

// Erro de compilação
i++
```
No caso do loop, a mesma coisa acontece. A variável `i` só existe dentro do bloco do `for`. Portanto, não é acessível fora.
```java
// Por ser apenas uma linha, o uso de chaves é opcional. Porém, é uma má prática.

for (int i = 0; i < 10; i++)
  System.out.println(i);
```

:zap: Boa prática:  
Sempre utilizar chaves, mesmo que seja apenas uma linha dentro do bloco. Assim, fica mais legível a delimitação do escopo.

## Escope de classe e palavra-chave `this`
É muito comum termos atributos da classe e parâmetros de métodos com o mesmo nome. Por isso, é necessário usar a palavra-chave `this`, quando quisermos nos referir a classe. Só é necessário usar `this` quando existir essa ambiguidade. Caso contrário, não é preciso.    
Essa palavra-chave existe em diversas linguagens orientadas a objeto. Isso acontece pois é necessário que o objeto possa fazer auto-referência. Ao usarmos `this`, o objeto vai fazer referência àquela instância específica.
```java
public class Escopo {
  // Atributo da classe.
  private int valor;

  public int getValor() {
    // Não é necessário usar this nesse caso, já que nãp há passagem de parâmetros.
    return valor;
  }

  public void setValor(int valor) {
    // Por conta de existir um atributo "valor" e um parâmetro "valor", é preciso deixar explicito qual estamos referindo. Com a palavra-chave this, deixamos claro que estamos falando do atributo.
    this.valor = valor;
  }

  public int calculaValor(int valor) {
    // A variável valor se refere ao parâmetro do método e não ao atributo da classe.
    valor = valor + 10;
    return valor;
  }

}
```