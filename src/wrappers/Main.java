package wrappers;

public class Main {
  public static void main(String[] args) {
    // Numbers
    short num1 = 1;
    byte num2 = 10;
    int num3 = 100;
    long num4 = 1000L;
    float num5 = 3.5f;
    double num6 = 3.555555;

    // Boolean
    boolean flag = true;

    // Char
    char a = 'a';

    // autoboxing
    Short num7 = 1;
    Byte num8 = 10;
    Integer num9 = 100;
    Long num10 = 1000L;
    Float num11 = 3.5f;
    Double num12 = 3.5555;
    Boolean flag2 = true;
    Character b = 'b';

    // unboxing
    int num13 = num9;

    // auto boxing em expressões
    num9++;

    // unboxing num9 -> auto boxing num13/num9 -> num 14
    Integer num14 = num13 / num9;

    // o tipo de num vai ser int (primitivo)
    var num = Integer.parseInt("254");
    // o tipo de numInt vai ser Integer (Wrapper)
    var numInt = Integer.valueOf("9121");

  }
}