package variaveis;

public class Varargs {
  public static void main(String[] args) {
    // Usando vetor
    int[] vetor = { 1, 2, 3, 4, 5 };
    var res = soma(vetor);
    System.out.println(res);

    // Usandor varargs
    res = soma(1, 2, 3, 4, 5);
    System.out.println(res);
  }

  static int soma(int[] vetor) {
    int total = 0;
    for (int i = 0; i < vetor.length; i++) {
      total += vetor[i];
    }
    return total;
  }

  static int soma(Integer... vetor) {
    int total = 0;

    for (int i = 0; i < vetor.length; i++) {
      total += vetor[i];
    }

    return total;
  }
}