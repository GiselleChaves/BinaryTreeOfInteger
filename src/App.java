/*
 * Trabalho 3 - Árvore Binária de Pesquisa - AVL
 * Autores: Giselle Chaves e Eduardo Barbosa
 * Professora Dra: Eduarda Monteiro
 * Data de Entrega: 30/11/2023
 */
public class App {
    public static void main(String[] args) throws Exception {
        BinaryTreeOfInteger bt = new BinaryTreeOfInteger();

        System.out.println("Árvore está vazia? " + bt.isEmpty());
        bt.add(1);
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        bt.add(6);
        bt.add(7);
        bt.add(8);
        bt.add(9);

        System.out.println("Árvore está vazia? " + bt.isEmpty());

        System.out.println("Tamanho: " + bt.size());
        
        //System.out.println("Altura: " + bt.height());
        
        System.out.print("Impressão dos valores na ordem de inserção: ");
        bt.printInOrder();
        System.out.println();
        
        bt.generateDOT();
        bt.balanceTree();
        bt.generateDOT();
        
        System.out.print("Caminhamento Pré-Ordem: ");
        bt.printTreePreOrder();
        System.out.println();        
        
        System.out.print("Caminhamento Pós-Ordem: ");
        bt.printTreePostOrder();
        System.out.println();
        System.out.println();
        
        System.out.println("Pai do Nodo 1: " + bt.getParent(1));        
        System.out.println("Pai do Nodo 2: " + bt.getParent(2));
        System.out.println("Pai do Nodo 3: " + bt.getParent(3));
        System.out.println("Pai do Nodo 4: " + bt.getParent(4));
        System.out.println("Pai do Nodo 5: " + bt.getParent(5));
        System.out.println("Pai do Nodo 6: " + bt.getParent(6));
        System.out.println("Pai do Nodo 7: " + bt.getParent(7));
        System.out.println("Pai do Nodo 8: " + bt.getParent(8));
        System.out.println("Pai do Nodo 9: " + bt.getParent(9));

    }
}
