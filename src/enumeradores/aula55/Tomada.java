package enumeradores.aula55;

public enum Tomada {
  ON(true), OFF(false);

  private boolean ligado;

  Tomada(boolean ligado) {
    this.ligado = ligado;
  }

  public boolean isLigado() {
    return ligado;
  }
}