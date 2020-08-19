# Gerenciamento de Memória
É importamos aprendermos como o Java gerencia a memória do programa para entedermos o comportamento do código em determinadas situações. O Java gerencia a memória automaticamente e existe um *garbage collector* que funciona no pano de fundo. Esse *garbage collector* limpa objetos não utilizados e libera memória.  

A memória costuma ser dividida em duas partes: **stack** e **heap**.
## Stack
Também conhecida como pilha, a *stack* é responsável por armazenar os tipos primitivos e as referências para os objetos.  
Essa distinção é importante: nos tipos primitivos, é armazenado o valor. Já nos objetos, é armazenado a referência para o objeto. O objeto, na verdade, se encontra armazenado no *heap*.  

Além disso, as variáveis que se encontram na pilha tem certa visibilidade, que é chamada de **escopo**. Quando o compilador executa o corpo de um método, ele pode apenas acessar objetos da pilha de memória daquela chamada. Ele não pode acessar outras variáveis, pois estão fora do escopo.  

A pilha de memória é alocada por thread. Logo, toda vez que uma thread é criada e executada, ela tem sua prórima pilha de memória e não pode acessar a pilha de memória das outras threads.

## Heap
Essa parte da memória é responsável por armazenar os objetos na memória. São referenciados pelas variáveis da pilha.

A palavra chave `new` assegura que tem espaço livre suficiente no *heap*, criando um objeto do tipo especificado na memória e criando a referência que vai para a pilha.