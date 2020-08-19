package variaveis;

public class Escopo {
  private int valor;

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public int calculaValor(int valor) {
    valor = valor + 10;
    return valor;
  }

}