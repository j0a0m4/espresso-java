package classesAninhadas;

public class Externa {
  private String texto = "externo";

  public class Interna {
    private String texto = "texto interno";

    public void imprimeTexto() {
      System.out.println(texto);

      System.out.println(Externa.this.texto);
    }
  }

  public static void main(String[] args) {
    var externa = new Externa();
    var interna = externa.new Interna();

    interna.imprimeTexto();
  }
}