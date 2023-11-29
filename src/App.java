public class App {
    public static void main(String[] args) throws Exception {
        BinaryTreeOfInteger bt = new BinaryTreeOfInteger();

        System.out.println(bt.isEmpty());
        bt.add(1);
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        System.out.println(bt.getParent(5));


        // System.out.println("Árvore está vazia? " + bt.isEmpty());
        // // bt.add(1);
        // System.out.println("Quantidade de elementos: " + bt.size());      
        // // bt.add(2);
        // // bt.add(3);
        // // bt.add(4);
        // // bt.add(5);
        // // bt.add(6);
        // // bt.add(7);
        // // bt.add(8);
        // // bt.add(9);
        // System.out.print("Valores da Árvore não Balanceada: ");
        // bt.printInOrder();
        // System.out.println("");
        // System.out.println("Quantidade de elementos: " + bt.size());

        // //NÃO ESTÁ 100%
        // int treeHeight = bt.height();
        // System.out.println("Altura da Árvore: " + treeHeight);

        // // System.out.println("Árvore está vazia? " + bt.isEmpty());
        // bt.balanceTree();
        // System.out.print("Valores da Árvore Balanceada em PréOrdem: ");
        // bt.printTreePreOrder();
        // System.out.println("");
        // System.out.print("Valores da Árvore Balanceada em PósOrdem: ");
        // bt.printTreePostOrder();

        // //NAO ESTA FUNCIONANDO
        // System.out.println("");
        // System.out.println("Nodo pai: " + bt.getParent(6));
        
        // bt.generateDOT();

        
    }
}
