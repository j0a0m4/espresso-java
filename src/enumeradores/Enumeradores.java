package enumeradores;

/**
 * Enumeradores. Classe teste.
 */
public class Enumeradores {
  public static void main(final String[] args) {
    usandoConstantes();
    System.out.println();
    usandoEnum();
  }

  private static void usandoEnum() {
    final DiaSemanaEnum segunda = DiaSemanaEnum.SEGUNDA;
    final DiaSemanaEnum terca = DiaSemanaEnum.TERCA;
    final DiaSemanaEnum quarta = DiaSemanaEnum.QUARTA;
    final DiaSemanaEnum quinta = DiaSemanaEnum.QUINTA;
    final DiaSemanaEnum sexta = DiaSemanaEnum.SEXTA;
    final DiaSemanaEnum sabado = DiaSemanaEnum.SABADO;
    final DiaSemanaEnum domingo = DiaSemanaEnum.DOMINGO;

    final DiaSemanaEnum[] dias = { segunda, terca, quarta, quinta, sexta, sabado, domingo };

    System.out.println("Usando enums");

    for (final DiaSemanaEnum dia : dias) {
      imprimeDiaSemana(dia);
    }

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

    System.out.println("Usando constantes");

    for (final int dia : dias) {
      imprimeDiaSemana(dia);
    }
  }

  private static void imprimeDiaSemana(final DiaSemanaEnum dia) {
    switch (dia) {
      case SEGUNDA:
        System.out.println("Segunda-feira");
        break;
      case TERCA:
        System.out.println("Terça-feira");
        break;
      case QUARTA:
        System.out.println("Quarta-feira");
        break;
      case QUINTA:
        System.out.println("Quinta-feira");
        break;
      case SEXTA:
        System.out.println("Sexta-feira");
        break;
      case SABADO:
        System.out.println("Sábado");
        break;
      case DOMINGO:
        System.out.println("Domingo");
        break;
      default:
        break;
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
      case 7:
        System.out.println("Domingo");
        break;
      default:
        break;
    }
  }
}