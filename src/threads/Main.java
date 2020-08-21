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
    var thread1 = new MeuRunnable("#1", 500);
    var thread2 = new MeuRunnable("#2", 500);
    var thread3 = new MeuRunnable("#3", 500);

    var t1 = new Thread(thread1);
    var t2 = new Thread(thread2);
    var t3 = new Thread(thread3);

    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MIN_PRIORITY);
    t3.setPriority(Thread.NORM_PRIORITY);

    Thread[] threads = { t1, t2, t3 };

    for (Thread thread : threads) {
      thread.start();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Finalizou");
  }
}