package threads;

public class Main {
  public static void main(String[] args) {
    var thread1 = new MinhaThread("Thread #1", 500);
    var thread2 = new MinhaThread("Thread #2", 900);
    var thread3 = new MinhaThread("Thread #3", 300);
  }
}