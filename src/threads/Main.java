package threads;

public class Main {
  public static void executarThreads() {
    var thread1 = new MinhaThread("Thread #1", 500);
    var thread2 = new MinhaThread("Thread #2", 900);
    var thread3 = new MinhaThread("Thread #3", 300);
  }

  public static void executarRunnables() {
    var t1 = new Thread(new MeuRunnable("T1", 400));
    var t2 = new Thread(new MeuRunnable("T2", 700));
    var t3 = new Thread(new MeuRunnable("T3", 1000));
  }

  public static void main(String[] args) {
    executarRunnables();
  }
}