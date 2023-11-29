import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOfInteger {
  private int count; //contagem do número de nodos
  private Node root; //referência para o nodo raiz

  public BinaryTreeOfInteger() {
    count = 0;
    root = null;
  }


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

  /**
   * add Method, add an node in the tree
   * Use the addRecursive Method
   * @param element
   */
  public void add(Integer element){
    addRecursive(root, element);
    count++;
  }

  /**
   * addRecursive Method
   * @param node
   * @param father
   * @param element
   * @return a node that will be used by add Method
   */
  private Node addRecursive(Node node, Integer element){
    if(node == null){
      node = new Node(element);
      if(root == null){
        root = node;
      }
      return node;
    }
    if(node.element < element){
      node.right = addRecursive(node.right,  element);
      node.right.father = node;
    }else if(node.element > element){
      node.left = addRecursive(node.left, element);
      node.left.father = node;
    }
    return node;
  }


  /**
   * getParent Method
   * Use the getParentRecursive Method
   * @param element
   * @return the node parent of a specific node
   */
  public Integer getParent(Integer element){
    return getParentRecursive(root, element);
  }

  /**
   * getParentRecursive Method
   * @param node
   * @param element
   * @return a node that will be used by getParent Method
   */
  public Integer getParentRecursive(Node node, Integer element){
    if(node == null){
      return null;
    }
    if(node.element.equals(element)){
      return node.father.element;
    }
    if (node.element > element) {
      return getParentRecursive(node.left, element);
    } else {
      return getParentRecursive(node.right, element);
    }
  }

  /**
   * height Method
   * Use the heightRecursive Method
   * @return the tree height
   */
  public int height() {
    return heightRecursive(root);
  }

  //NÃO ESTÁ 100%
  /**
   * heightRecursive Method
   * @param node
   * @return the tree height
   */
  private int heightRecursive(Node node) {
    if (node == null) {
      return -1; // altura da árvore vazia retorna -1
    } else {
      int leftHeight = heightRecursive(node.left);
      int rightHeight = heightRecursive(node.right);
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }

  /**
   * size Method
   * @return the tree size
   */
  public int size(){
    return count;
  }

  /**
   * isEmpty Method
   * @return if the tree is empty or not
   */
  public boolean isEmpty(){
    return root == null;
  }

  /**
   * printInOrder Method
   * Use the printInOrderRecursive Method
   */
  public void printInOrder() {
    printInOrderRecursive(root);
  }

  /**
   * printInOrderRecursive Method
   * @param node
   */
  private void printInOrderRecursive(Node node) {
    if (node != null){
      printInOrderRecursive(node.left);
      System.out.print((node.element != null) ? node.element : "null");
      System.out.print(" ");
      printInOrderRecursive(node.right);
    }
  }

   /**
   * Performs an in-order traversal and stores the nodes in a list
   * @param node
   * @param nodes
   */
  private void inOrder(Node node, List<Node> nodes) {
    if (node != null) {
      inOrder(node.left, nodes);
      nodes.add(node);
      inOrder(node.right, nodes);
    }
  }

  /**
   * balance Method
   */
  public void balanceTree() {
    if (root != null) {
      List<Node> nodes = new ArrayList<>();
      inOrder(root, nodes);

      List<Integer> elements = new ArrayList<>();
      for (Node node : nodes) {
          elements.add(node.element);
      }

      // Constrói uma nova árvore balanceada com base na lista de elementos
      root = buildBalancedTree(elements, 0, elements.size() - 1);
    }
  }


  private Node buildBalancedTree(List<Integer> elements, int start, int end) {
    if (start > end) {
        return null;
    }

    int mid = (start + end) / 2;
    Node newNode = new Node(elements.get(mid));

    newNode.left = buildBalancedTree(elements, start, mid - 1);
    newNode.right = buildBalancedTree(elements, mid + 1, end);

    return newNode;
  }

  /**
   * printTreePreOrder Method
   * Used to print the tree with the preorder path
   */
  public void printTreePreOrder() {
    printTreePreOrderRecursive(root);
  }

  private void printTreePreOrderRecursive(Node node) {
    if (node != null) {
      System.out.print(node.element + " "); // Visita o nó
      printTreePreOrderRecursive(node.left);         // Percorre à esquerda
      printTreePreOrderRecursive(node.right);        // Percorre à direita
    }
  }

  /**
   * printTreePostOrder Method
   * Used to print the tree with the postorder path
   */
  public void printTreePostOrder() {
    printTreePostOrderRecursive(root);
  }

  /**
   * printTreePostOrder Method
   * Used in the printTreePostOrder method
   * @param node
   */
  private void printTreePostOrderRecursive(Node node) {
    if (node != null) {
      printTreePostOrderRecursive(node.left);     
      printTreePostOrderRecursive(node.right);    
      System.out.print(node.element + " ");
    }
  }

  public void generateDOT() {
    System.out.println("digraph BinaryTree {");
    generateDOTRecursive(root);
    System.out.println("}");
}

  private void generateDOTRecursive(Node node) {
    if (node != null) {
      if (node.left != null) {
        System.out.println("  " + node.element + " -> " + node.left.element + " [label=\"left\"]");
        generateDOTRecursive(node.left);
      }

      if (node.right != null) {
        System.out.println("  " + node.element + " -> " + node.right.element + " [label=\"right\"]");
        generateDOTRecursive(node.right);
      }
    }
  }
}
