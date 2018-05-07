public class BinaryTree<T>{
    BinaryNode<T> root;
    int size;
    public BinaryTree(T data){
        root = new BinaryNode<T>(data);
        size = 1;
    }
    public BinaryTree(){
        // create empty tree
        root = new BinaryNode<T>();
        size = 0;
    }
    public BinaryNode recursiveSearch(T data){
        return recursiveSearch(root, data);
    }
    public BinaryNode recursiveSearch(BinaryNode node, T data){
        if(data == (T)node.data){
            return node;
        } else if(data < (T)node.data){
            // left side
            if(node.left == null){
                return null;
            }
            return recursiveSearch(node.left, data);
        } else{
            if(node.right == null){
                return null;
            }
            return recursiveSearch(node.right, data);
            // right side
        }
    }
    public void recursiveInsert(T data){
        recursiveInsert(root, data);
    }
    public void recursiveInsert(BinaryNode node, T data){
        if(size == 0){
            root = new BinaryNode<T>(data);
            return;
        } else if(data == (T)node.data){
            // data already in tree (no duplicates allowed)
            return;
        } else if(data < (T)node.data){
            // left side
            BinaryNode<T> left = node.left;
            if(left != null){
                recursiveInsert(left, data);
            } else{
                size++;
                node.left = new BinaryNode<T>(data);
            }
        } else{
            // right side
            BinaryNode<T> right = node.right;
            if(right != null){
                recursiveInsert(right, data);
            } else{
                size++;
                node.right = new BinaryNode<T>(data);
            }
        }
    }
}

class BinaryNode<T>{
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
