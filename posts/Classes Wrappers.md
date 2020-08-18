# Clases Wrappers

Java não pode ser considerado uma linguagem totalmente orientada a objetos por conta dos tipos primitivos. A princípio, os tipos primitivos não eram instancias de nenhuma classe. Foi introduzido então classes wrappers que representam os tipos primitivos. As Classes wrappers os "empacotam" - fenômeno também conhecido como *boxing*.

<table>
    <thead>
        <tr>
            <th></th>
            <th>Tipo Primitivo</th>
            <th>Classe Wrapper</th>
            <th>Super Classe</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Lógico</td>
            <td>
              <code>boolean</code>
            </td>
            <td>
              <code>Boolean</code>
            </td>
            <td rowspan="2">
              <code>Object</code>
            </td>
        </tr>
        <tr>
          <td>Caractere</td>
          <td>
            <code>char</code>
          </td>
          <td>
            <code>Character</code>
          </td>
        </tr>
        <tr>
            <td rowspan="4">Inteiro</td>
            <td>
            <code>byte</code>
            </td>
            <td>
              <code>Byte</code>
            </td>
            <td rowspan="6">
              <code>Number</code>
            </td>
        </tr>
        <tr>
            <td>
              <code>short</code>
            </td>
            <td>
              <code>Short</code>
            </td>
        </tr>
        <tr>
            <td>
              <code>int</code>
            </td>
            <td>
              <code>Integer</code>
            </td>
        </tr>
        <tr>
            <td>
              <code>long</code>
            </td>
            <td>
              <code>Long</code>
            </td>
        </tr>
        <tr>
          <td rowspan="2">Ponto Flutuante</td>
            <td>
              <code>float</code>
            </td>
            <td>
              <code>Float</code>
            </td>
        </tr>
        <tr>
            <td>
              <code>double</code>
            </td>
            <td>
              <code>Double</code>
            </td>
        </tr>
    </tbody>
</table>

Antigamente, era possível usar os construtores dos wrappers pra instanciar os tipos primitivos distintos e fazer casting.

```java
 // Wrappers

    Short num7 = new Short((short) 1);
    Byte num8 = new Byte((byte) 10);
    Integer num9 = new Integer(100);
    Long num10 = new Long(1000L);
    Float num11 = new Float(3.5f);
    Double num12 = new Double(3.5555);
    Boolean flag2 = new Boolean(true);
    Character b = new Character('b');
```

Entrentanto, desde a versão 9 do Java que essa maneira foi depreciada.[^1]

## Autoboxing




[^1]: https://stackoverflow.com/a/47095501