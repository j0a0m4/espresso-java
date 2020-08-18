package enumeradores.aula55;

public class Enumeradores {
  public static void main(String[] args) {

    for (Tomada tomada : Tomada.values()) {
      System.out.println(tomada);
    }

    Tomada tomada = Enum.valueOf(Tomada.class, "OFF");

    System.out.println(tomada.isLigado());

  }
}