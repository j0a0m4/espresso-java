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