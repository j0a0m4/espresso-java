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

    // Wrappers
    Short num7 = new Short((short) 1);
    Byte num8 = new Byte((byte) 10);
    Integer num9 = new Integer(100);
    Long num10 = new Long(1000L);
    Float num11 = new Float(3.5f);
    Double num12 = new Double(3.5555);
    Boolean flag2 = new Boolean(true);
    Character b = new Character('b');

    // o tipo de num vai ser int (primitivo)
    var num = Integer.parseInt("254");
    // o tipo de numInt vai ser Integer (Wrapper)
    var numInt = Integer.valueOf("9121");

  }
}