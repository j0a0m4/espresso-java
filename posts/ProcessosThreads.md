# Multitarefas: Processos e Threads

*Processo* é uma instância de um programa que está sendo executado.  
*Thread* é uma linha de execução dentro de um processo, sendo uma forma de um processo se autodividir em duas ou mais tarefas.  
Ao usar threads permitimos que um programa execute mais de uma tarefa ao mesmo tempo. Sendo assim, nos permite criar programas eficientes.

## Ciclo de Vida
![Ciclo de Vida Thread](../assets/ciclo-thread.png)
Existem cinco estados importantes no ciclo de uma thread.
- Criação da instância (**New**)
  - `new Thread()`
  - Prontificar: `start()`
- Pronta pra execução (**Runnable**)
  - Executar: `run()`
- Em execução (**Running**)
  - Parar: `yield()`
  - Suspender: `sleep(), wait(), suspend()`
  - Terminar
- Suspensa (**Waiting**)
  - Acordar: `notify()/notifyAll(), resume()`
- Término (**Dead**)

## Criando uma Thread
- Extender a classe `Thread`
- Implementar interface `Runnable`

### Métodos Importantes
- `start`: inicia a thread, iniciando o método `run`
- `run`: executar a tarefa
- `sleep`: suspende a thread por `N` ms;

### Extendendo a classe `Thread`

```java
// Criando a Thread
public class MinhaThread extends Thread {
  private String nome;

  public MinhaThread(String nome) {
    this.nome = nome;
    // Ao chamar start no construtor, a Thread é executada automaticamente no momento de criação.
    start();
  }

  // Sobrescrevendo o método run. É necessário para executar a Thread.
  public void run() {
    try {
      for (int i = 0; i < 6; i++) {
        // Imprime o nome da thread e o contador
        System.out.println(nome + " " + i);
        // Suspende a thred por 0.5s
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
```
Vamos criar uma classe Main para executarmos nossos testes.
```java
public class Main {
  public static void main(String[] args) {

    var thread = new MinhaThread("Thread #1");

  }
}
```

### Implementando a interface `Runnable`
Ao usar a interface `Runnable`, precisamos implementar o método `run`. Entretando, não tem como chamar o método start já que é uma interface que contem apenas a assinatura dos métodos.

```java
public class MeuRunnable implements Runnable {
  private String nome;
  private int tempo;

  public MeuRunnable(String nome, int tempo) {
    this.nome = nome;
    this.tempo = tempo;
    // Criamos a thread passando a Classe Meu Runnable como parametros
    Thread t = new Thread(this);
    // Inicializamos a thread
    t.start();
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 6; i++) {
        System.out.println(nome + " " + i);
        if (i == 5) {
          System.out.println();
          System.out.println("Fim da " + nome);
          System.out.println();
        }
        Thread.sleep(tempo);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
```
### Melhores Abordagens

- Quando fazemos `extends` da `Thread`, o único método que precisa ser sobreposto é o `run`.
- Quando implementamos `Runnable`, também precisamos implementar o método `run`
- Com a classe implementando `Runnable`, podemos extender qualquer outra classe.

:zap: Melhores Práticas:  
Se não for sobrepor qualquer outro método da classe `Thread`, pode ser melhor usar `Runnable`.