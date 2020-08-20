package memory;

import variaveis.Contato;

public class ColetorLixo {

  public static void obterMemoriaUsada() {
    final var MB = 1024 * 1024;
    // Singleton
    Runtime runtime = Runtime.getRuntime();

    final var usedMem = runtime.totalMemory() - runtime.freeMemory();

    System.out.println(usedMem / MB);
  }

  public static void main(String[] args) {
    Contato[] contatos = new Contato[10000000];
    Contato contato;

    for (int i = 0; i < contatos.length; i++) {
      contato = new Contato("Contato" + i, "1234-123" + i, "contato" + i + "@email.com");
      contatos[i] = contato;
    }

    System.out.println("Contatos criados");

    obterMemoriaUsada();

    contatos = null;

    Runtime.getRuntime().runFinalization();
    Runtime.getRuntime().gc();

    System.out.println("Contatos removidos");

    obterMemoriaUsada();
  }

}