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
    if(root == null){
      count++;
      return root = new Node(element);
    }
    if(node.element < element){
      Node newNode = new Node(element);
      node.right = addRecursive(newNode, element);
      node.right.father = node;
    }
  }
}
