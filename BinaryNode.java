public class BinaryNode<T extends Comparable<T>>{
    BinaryNode<T> left;
    BinaryNode<T> right;
    T data;
    public BinaryNode(){
        this.data = null;
        left = null;
        right = null;
    }
    public BinaryNode(T data){
        this.data = data;
        left = null;
        right = null;
    }
}
