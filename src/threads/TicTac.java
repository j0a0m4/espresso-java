package threads;

public class TicTac {
  boolean tic;

  synchronized void tic(boolean executing) {
    if (!executing) {
      notifyStatus(true);
      return;
    }

    System.out.println("Tic ");
    notifyStatus(true);

    try {
      while (tic) {
        wait();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized void tac(boolean executing) {
    if (!executing) {
      notifyStatus(false);
      return;
    }

    System.out.println("Tac ");
    notifyStatus(false);

    try {
      while (!tic) {
        wait();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void notifyStatus(boolean status) {
    tic = status;
    notify();
  }

}