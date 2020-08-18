package enumeradores;

/**
 * Enumeradores. Exemplo usando constantes para representar dias da semana.
 */
public class Enumeradores {
  public static void main(final String[] args) {
    usandoConstantes();
  }

  private static void usandoConstantes() {
    final int segunda = DiaSemanaConstantes.SEGUNDA;
    final int terca = DiaSemanaConstantes.TERCA;
    final int quarta = DiaSemanaConstantes.QUARTA;
    final int quinta = DiaSemanaConstantes.QUINTA;
    final int sexta = DiaSemanaConstantes.SEXTA;
    final int sabado = DiaSemanaConstantes.SABADO;
    final int domingo = DiaSemanaConstantes.DOMINGO;

    final int[] dias = { segunda, terca, quarta, quinta, sexta, sabado, domingo };

    for (final int dia : dias) {
      imprimeDiaSemana(dia);
    }
  }

  private static void imprimeDiaSemana(final int dia) {
    switch (dia) {
      case 1:
        System.out.println("Segunda-feira");
        break;
      case 2:
        System.out.println("Terça-feira");
        break;
      case 3:
        System.out.println("Quarta-feira");
        break;
      case 4:
        System.out.println("Quinta-feira");
        break;
      case 5:
        System.out.println("Sexta-feira");
        break;
      case 6:
        System.out.println("Sábado");
        break;
      default:
        break;
    }
  }
}