package threads;

import java.util.Arrays;

public class Calculadora {
  private int soma;

  public synchronized int somaArray(int[] numeros) {
    soma = 0;
    for (int num : numeros) {
      soma += num;

      System.out.println("Executando a soma " + Thread.currentThread().getName() + " somando o valor " + num
          + " com o total de " + soma);

      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return soma;
  }

  public static int somar(Integer... nums) {
    return Arrays.asList(nums).stream().reduce(0, (x, y) -> x + y);
  }
}