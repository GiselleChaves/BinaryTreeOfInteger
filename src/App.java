public class App {
    public static void main(String[] args) throws Exception {
        BinaryTreeOfInteger bt = new BinaryTreeOfInteger();

        bt.add(1);
        int size = bt.size();
        System.out.println("Quantidade de elementos: " + size);
        System.out.print("Valores da Árvora não Balanceada: ");
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        bt.add(6);
        bt.add(7);
        bt.add(8);
        bt.add(9);
        bt.printInOrder();
        System.out.println("");
        int newSize = bt.size();
        System.out.println("Nova quantidade de elementos: " + newSize);
        int treeHeight = bt.height();
        System.out.println("Altura da Árvore: " + treeHeight);
        System.out.println(bt.isEmpty());
        bt.balanceTree();
        System.out.println("Valores da Árvora Balanceada em PréOrdem: ");
        bt.printTreePreOrder();
        System.out.println("Valores da Árvora Balanceada em PósOrdem: ");
        bt.printTreePostOrder();
    }
}
