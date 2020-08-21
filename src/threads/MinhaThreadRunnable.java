package threads;

public class MinhaThreadRunnable implements Runnable {
  private String nome;
  private int tempo;
  private boolean suspensa;
  private boolean terminada;

  public MinhaThreadRunnable(String nome, int tempo) {
    this.nome = nome;
    this.tempo = tempo;
    this.suspensa = false;
    new Thread(this, nome).start();
  }

  @Override
  public void run() {
    System.out.println("Executando " + this.nome);

    try {
      for (int i = 0; i < 6; i++) {
        System.out.println(nome + " " + i);

        Thread.sleep(tempo);
        synchronized (this) {
          while (suspensa) {
            wait();
          }
          if (terminada) {
            break;
          }
        }

        if (i == 5) {
          System.out.println();
          System.out.println("Fim da " + nome);
          System.out.println();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  void suspend() {
    this.suspensa = true;
  }

  synchronized void resume() {
    this.suspensa = false;
    notify();
  }

  synchronized void stop() {
    this.terminada = true;
    notify();
  }

}