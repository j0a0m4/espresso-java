package enumeradores.Calculadora;

public interface IOperacao {
  default double somar(double x, double y) {
    return x + y;
  }

  default double subtrair(double x, double y) {
    return x - y;
  }

  default double multiplicar(double x, double y) {
    return x * y;
  }

  default double dividir(double x, double y) {
    return x / y;
  }

}