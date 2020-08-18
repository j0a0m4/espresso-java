package enumeradores.Calculadora;

public enum Operacao implements IOperacao {
  SOMAR("+") {
    @Override
    double executarOperacao(double x, double y) {
      return somar(x, y);
    }
  },
  SUBTRAIR("-") {
    @Override
    double executarOperacao(double x, double y) {
      return subtrair(x, y);
    }
  },
  MULTIPLICAR("*") {
    @Override
    double executarOperacao(double x, double y) {
      return multiplicar(x, y);
    }
  },
  DIVIDIR("/") {
    @Override
    double executarOperacao(double x, double y) {
      return dividir(x, y);
    }
  };

  private String operador;

  Operacao(String operador) {
    this.operador = operador;
  }

  public String getOperador() {
    return this.operador;
  }

  abstract double executarOperacao(double x, double y);
}