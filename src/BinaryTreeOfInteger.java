public class BinaryTreeOfInteger {

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

  // Atributos
  private int count; //contagem do número de nodos
  private Node root; //referência para o nodo raiz

  // Metodos
  public BinaryTreeOfInteger() {
    count = 0;
    root = null;
  }

  public boolean addRoot(Integer element) {
    if (root != null) // se a arvore nao estiver vazia
      return false;
    root = new Node(element);
    count++;
    return true;
  }

  //add
  public void add(Integer element){
    root = addRecursive(root, element);
  }

  //Adicionar elementos na árvore: void add(obj);
  public Node addRecursive(Node node, Integer element){
    if(node == null){
      count++;
      return new Node(element);
    }
    if(node.element < element){
      Node newNode = new Node(element);
      node.right = addRecursive(newNode, element);
      node.right.father = node;
    }else if(node.element > element){
      Node newNode = new Node(element);
      node.left = addRecursive(newNode, element);
      node.left.father = node;
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
}
