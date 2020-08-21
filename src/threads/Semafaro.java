package threads;

public class Semafaro implements Runnable {
  private CorSemafaro cor;
  private boolean parar;
  private boolean corMudou;
  private int n;

  public Semafaro(int n) {
    this.cor = CorSemafaro.VERMELHO;
    this.parar = false;
    this.corMudou = false;
    this.n = n;
    new Thread(this).start();
  }

  public void ligar() {
    for (int i = 0; i < n; i++) {
      System.out.println(this.getCor());
      this.esperaCorMudar();
    }
    this.desligar();
  }

  public synchronized void desligar() {
    this.parar = true;
  }

  public CorSemafaro getCor() {
    return this.cor;
  }

  @Override
  public void run() {
    while (!parar) {
      try {
        var tempoDeEspera = this.cor.getTempoEspera();
        Thread.sleep(tempoDeEspera);
        this.mudarCor();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private synchronized void mudarCor() {
    switch (this.cor) {
      case VERMELHO:
        this.cor = CorSemafaro.VERDE;
        break;
      case AMARELO:
        this.cor = CorSemafaro.VERMELHO;
        break;
      case VERDE:
        this.cor = CorSemafaro.AMARELO;
        break;
      default:
        break;
    }
    this.corMudou = true;
    notify();
  }

  private synchronized void esperaCorMudar() {
    while (!this.corMudou) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.corMudou = false;
  }

}