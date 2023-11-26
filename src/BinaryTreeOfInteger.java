public class BinaryTreeOfInteger {
  
  // Classe BinaryTreeOfInteger
  private int count; //contagem do número de nodos
  private Node root; //referência para o nodo raiz

  public BinaryTreeOfInteger() {
    count = 0;
    root = null;
  }

  //Classe Node
  private static final class Node {
    public Node father;
    public Node left;
    public Node right;
    private Integer element;

    public Node(Integer element) {
      father = null;
      left = null;
      right = null;
      this.element = element;
    }
}

  
  /*public boolean addRoot(Integer element) {
    if (root != null) // se a arvore nao estiver vazia
      return false;
    root = new Node(element);
    count++;
    return true;
  }*/

  //add
  public void add(Integer element){
    root = addRecursive(root, null, element);
    count++;
  }

  //Adicionar elementos na árvore: void add(obj);
  private Node addRecursive(Node node, Node father, Integer element){
    if(node == null){
      Node newNode = new Node(element);
      newNode.father = father;
      return newNode;
    }
    if(node.element < element){
      node.right = addRecursive(node.right, node, element);
    }else if(node.element > element){
      node.left = addRecursive(node.left, node, element);
    }
    return node;
  }

  /*private Node searchNodeRef(Integer element, Node target) {
    if ( target == null)
        return null;
    // Visita a "raiz"
    if (element.equals(target.element))
        return target; // se achou element na "raiz"

    // Visita subarvore da esquerda
    Node aux = searchNodeRef(element, target.left);

    // Se nao encontrou, visita a subarvore da direita
    if (aux == null)
        aux = searchNodeRef(element, target.right);

    return aux;
  }*/

  public Node getParent(Integer element){
    return getParentRecursive(root, element);
  }

  //Retornar o pai de um elemento: obj getParent(obj);
  public Node getParentRecursive(Node node, Integer element){
    if(node == null || node.element.equals(element)){
      return null;
    }
    if(element < node.element && node.element != null && node.element.equals(element)){
      return node;
    }
    if(element > node.element && node.element.equals(element)){
      return node;
    }
    Node auxLeftNode = getParentRecursive(node.left, element);
    if(auxLeftNode != null){
      return auxLeftNode;
    }else{
      return getParentRecursive(node.right, element);
    }
  }

  // Verificar qual é a altura da árvore: int height();
  public int height(){
    return getHeightRecursive(root);
  }

  private int getHeightRecursive(Node node){
    if(node == null){
      return 0;
    }
    int leftHeight = getHeightRecursive(node.left);
    int rightHeight = getHeightRecursive(node.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  // Verificar quantos elementos tem na árvore: int size()
  public int size(){
    return count;
  }

  //Verificar se a árvore está vazia ou não: boolean isEmpty();
  public boolean isEmpty(){
    return root == null;
  }


  //Printar Árvore
  public void printInOrder() {
    printInOrderRecursive(root);
  }

  private void printInOrderRecursive(Node node) {
    if (node != null){
      printInOrderRecursive(node.left);
      System.out.print((node.element != null) ? node.element : "null");
      System.out.print(" ");
      printInOrderRecursive(node.right);
    }
  }

}
