package threads;

public class Deadlock {
  public static void main(String[] args) {
    final String RECURSO_1 = "Recurso #1";
    final String RECURSO_2 = "Recurso #2";
    
    var t1 = new Thread(() -> {
      synchronized (RECURSO_1) {
        System.out.println("T #1: block recurso 1");

        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println("T #1: access recurso 2");

        synchronized (RECURSO_2) {
          System.out.println("T #1: block recurso 2");
        }
      }
    });

    var t2 = new Thread(() -> {
      synchronized (RECURSO_2) {
        System.out.println("T #2: block recurso 2");

        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println("T #2: access recurso 1");

        synchronized (RECURSO_1) {
          System.out.println("T #2: block recurso 1");
        }
      }
    });

    t1.start();
    t2.start();
  }
}