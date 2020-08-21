package threads;

public enum CorSemafaro {
  VERDE(1200), AMARELO(500), VERMELHO(2000);

  private int tempoEspera;

  CorSemafaro(int tempoEspera) {
    this.tempoEspera = tempoEspera;
  }

  public int getTempoEspera() {
    return this.tempoEspera;
  }
}