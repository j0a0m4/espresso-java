package annotations;

@interface Informacao {
  String nome();

  int aulaNumero();

  String site() default "joaomarcoslopes.me";
}