package variaveis;

public class PassagemValorRef {
  public static void main(String[] args) {
    var contato = new Contato("Kylo Ren", "96222-8799", "kylo@darkside.com");
    int valor = 10;

    testePassagemValor(valor, contato);
    testePassagemRef(valor, contato);
  }

  private static void testePassagemValor(int valor, Contato contato) {
    int novoValor = valor + 10;
    valor = novoValor;
    contato = new Contato("Rey Skywalker", "988822222", "rey@ashla.com");
  }

  private static void testePassagemRef(int valor, Contato contato) {
    int novoValor = valor + 10;
    valor = novoValor;

    contato.setNome("Mark " + novoValor);
  }
}