import java.util.*;

public class BinaryTree<T extends Comparable<T>>{
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
    public void recursivePrintInOrder(){
        recursivePrintInOrder(root);
    }
    public void recursivePrintInOrder(BinaryNode<T> node){
        if(node != null){
            recursivePrintInOrder(node.left);
            System.out.print(node.data + " ");
            recursivePrintInOrder(node.right);
        }
    }
    public void recursivePrintPostOrder(){
        recursivePrintPostOrder(root);
    }
    public void recursivePrintPostOrder(BinaryNode<T> node){
        if(node != null){
            recursivePrintInOrder(node.left);
            recursivePrintInOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    public void recursivePrintPreOrder(){
        recursivePrintPostOrder(root);
    }
    public void recursivePrintPreOrder(BinaryNode<T> node){
        if(node != null){
            System.out.print(node.data + " ");
            recursivePrintInOrder(node.left);
            recursivePrintInOrder(node.right);
        }
    }
    public BinaryNode<T> recursiveSearch(T data){
        return recursiveSearch(root, data);
    }
    public BinaryNode<T> recursiveSearch(BinaryNode<T> node, T data){
        if(data.compareTo(node.data) == 0){
            return node;
        } else if(data.compareTo(node.data) < 0){
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
    public void recursiveInsert(BinaryNode<T> node, T data){
        if(size == 0){
            root = new BinaryNode<T>(data);
            size++;
            return;
        } else if(data.compareTo(node.data) == 0){
            // data already in tree (no duplicates allowed)
            return;
        } else if(data.compareTo(node.data) < 0){
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
    public void treeArr(BinaryNode<T> curr, Vector<BinaryNode<T>> nodes){
        if(curr == null){
            return;
        }
        treeArr(curr.left, nodes);
        nodes.add(curr);
        treeArr(curr.right, nodes);
    }
    public BinaryNode<T> balanceRecursive(Vector<BinaryNode<T>> nodes, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode<T> curr = nodes.get(mid);
        curr.left = balanceRecursive(nodes, start, mid - 1);
        curr.right = balanceRecursive(nodes, mid + 1, end);
        // return the final root
        return curr;
    }
    public void balance(){
        if(size == 0){
            return;
        }
        Vector<BinaryNode<T>> thisVector = new Vector<BinaryNode<T>>();
        treeArr(root, thisVector);
        root = balanceRecursive(thisVector, 0, size - 1);
    }
}
