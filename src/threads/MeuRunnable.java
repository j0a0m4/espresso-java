package threads;

public class MeuRunnable implements Runnable {
  private String nome;
  private int tempo;

  public MeuRunnable(String nome, int tempo) {
    this.nome = nome;
    this.tempo = tempo;
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