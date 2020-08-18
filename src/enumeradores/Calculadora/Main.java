package enumeradores.Calculadora;

public class Main {
  public static void main(String[] args) {
    var x = 10;
    var y = 2;

    for (Operacao operacao : Operacao.values()) {
      var resultado = operacao.executarOperacao(x, y);

      System.out.println(x + " " + operacao + " " + y);
      System.out.println(resultado);
      System.out.println();
    }
  }
}