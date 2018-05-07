public class Test{
    public static void main(String[] args){
        int start = 5;
        BinaryTree<Integer> bt = new BinaryTree<Integer>(start);
        bt.recursiveInsert(29);
        bt.recursiveInsert(3);
        bt.recursiveInsert(7);
        bt.recursiveInsert(18);
        bt.recursiveInsert(0);
        bt.recursiveInsert(100);
        BTreePrinter.printBinaryNode(bt.root);
        bt.balance();
        BTreePrinter.printBinaryNode(bt.root);
    }
}
