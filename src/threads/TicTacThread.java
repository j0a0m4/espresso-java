package threads;

public class TicTacThread implements Runnable {
  Thread thread;
  TicTac tt;
  final int NUM = 5;

  public TicTacThread(String nome, TicTac tt) {
    this.tt = tt;
    thread = new Thread(this, nome);
    thread.start();
  }

  @Override
  public void run() {
    if (thread.getName().equalsIgnoreCase("Tic")) {
      for (int i = 0; i < NUM; i++) {
        tt.tic(true);
      }
      tt.tic(false);
    } else {
      for (int i = 0; i < NUM; i++) {
        tt.tac(true);
      }
      tt.tac(false);
    }
  }
}