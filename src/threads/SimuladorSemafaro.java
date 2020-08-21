package threads;

public class SimuladorSemafaro {
  public static void main(String[] args) {
    var semafaro = new Semafaro(10);

    semafaro.ligar();
  }
}