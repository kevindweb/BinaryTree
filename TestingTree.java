public class TestingTree{
    public static void main(String[] args){
        int start = 11;
        IntBinaryTree bt = new IntBinaryTree(start);
        bt.recursiveInsert(3);
        bt.recursiveInsert(10);
        bt.recursiveInsert(13);
        bt.recursiveInsert(8);
        // bt.recursivePrintPostOrder();
        BTreePrinter.printBinaryNode(bt.root);
        // bt.balance();
        // System.out.println("Balancing...");
        // BTreePrinter.printBinaryNode(bt.root);
    }
}
