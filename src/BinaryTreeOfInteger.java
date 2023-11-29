import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOfInteger {
  private int count; 
  private Node root; 

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
   * @return a Integer that will be used by getParent Method
   */
  private Integer getParentRecursive(Node node, Integer element){
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
      return 1 - Math.max(leftHeight, rightHeight);
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
   * is used by printInOrder Method
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
    if (node != null) {           //Se nodo diferente de null
      inOrder(node.left, nodes);  
      nodes.add(node);            //Adiciona na lista nodes os nodos left e right da árvore 
      inOrder(node.right, nodes);
    }
  }

  /**
   * balance Method
   */
  public void balanceTree() {
    if (root != null) {
      List<Node> nodes = new ArrayList<>();     //Onde é iniciada a lista nodes usada em inOrder
      inOrder(root, nodes);                     //Chama inOrder passando por parâmenteo a root e a lista nodes

      List<Integer> elements = new ArrayList<>();   //Inicializa lista elements
      for (Node node : nodes) {                     //Para cada node da lista nodes
        elements.add(node.element);                //Adiciona na lisra elements o elemento do node
      }

      // Constrói uma nova árvore balanceada com base na lista de elementos
      root = buildBalancedTreeRecursive(elements, 0, elements.size() - 1);   //root recebe o retorno do método buildBalancedTreeRecursive
    }
  }


  /**
   * buildBalancedTreeRecursive Method
   * Is used in the balanceTree method
   * @param elements
   * @param start
   * @param end
   * @return 
   */
  private Node buildBalancedTreeRecursive(List<Integer> elements, int start, int end) {
    if (start > end) { //Se o índice de início da árvore for maior que do fim, a árvore está vazia e retorna null 
        return null;
    }

    int mid = (start + end) / 2; //Encontra o centro da árvore
    Node newNode = new Node(elements.get(mid)); //Instancia um novo nodo com o elemento encontrado como meio da árvore

    newNode.left = buildBalancedTreeRecursive(elements, start, mid - 1); //newNode.left recebe o retorno recursivo, mid-1 para descontar o nodo mid da montagem do ramo esquerdo
    newNode.right = buildBalancedTreeRecursive(elements, mid + 1, end); //newNode.right recebe o retorno recursivo mid+1, para descontar o nodo mid da montagem do ramo direito 
    if(newNode.left != null){
     newNode.left.father = newNode;
    }
    if(newNode != null){
      newNode.father = newNode;
    }
    if(newNode.right != null){
      newNode.right.father = newNode;
    }

    return newNode;
  }

  /**
   * printTreePreOrder Method
   * Used to print the tree with the preorder path
   */
  public void printTreePreOrder() {
    printTreePreOrderRecursive(root);
  }

  /**
   * printTreePreOrderRecursive Method
   * is used by printInOrder Method
   * @param node
   */
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

  /**
   * generateDOT Method
   * Print the DOT Method
   */
  public void generateDOT() {
    System.out.println("DOT Method");
    generateDOTRecursive(root);
    System.out.println("}");
  }

  /**
   * generateDOTRecursive Method
   * Used in the generateDOT method
   * @param node
   */
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
