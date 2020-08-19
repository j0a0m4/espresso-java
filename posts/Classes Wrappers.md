# Clases Wrappers

Java não pode ser considerado uma linguagem totalmente orientada a objetos por conta dos tipos primitivos. Os tipos primitivos não são instancias de nenhuma classe, são apenas valores específicos. A partir do Java 5, foi introduzido então classes wrappers que representam os tipos primitivos. As Classes wrappers os "empacotam" - fenômeno também conhecido como *boxing*.   

<table>
  <caption>
    Tabela de Hierarquia dos Tipos
  </caption>
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
<br>

Antigamente, era possível usar os construtores dos wrappers pra instanciar os tipos primitivos distintos.  

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

Entrentanto, desde a versão 9 do Java que essa maneira foi depreciada.[^1] De acordo com a documentação da Oracle, raramente o uso é apropriado e portanto é uma escolha melhor usar os método estático `<Wrapper>.valueOf()`[^2]

```java
// o tipo de num vai ser int (primitivo)
var num = Integer.parseInt("254");

// o tipo de numInt vai ser Integer (Wrapper)
var numInt = Integer.valueOf("9121")
```

## Autoboxing e Unboxing
Uma funcionalidade muito útil que o compilador Java fornece é a conversão automática entre os tipos primitivos e os wrappers correspondentes.




[^1]: https://stackoverflow.com/a/47095501
[^2]: https://docs.oracle.com/javase/9/docs/api/deprecated-list.html#constructor