package variaveis;

public class Main {
  public static void main(String[] args) {
    var escopo = new Escopo();
    escopo.setValor(10);

    System.out.println(escopo.getValor());
    System.out.println(escopo.calculaValor(20));
    System.out.println(escopo.getValor());
  }

}