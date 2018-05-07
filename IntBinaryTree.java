import java.util.*;

public class IntBinaryTree{
    BinaryNode root;
    int size;
    public IntBinaryTree(int data){
        root = new BinaryNode(data);
        size = 1;
    }
    public IntBinaryTree(){
        // create empty tree
        root = new BinaryNode();
        size = 0;
    }
    public void recursivePrintInOrder(){
        recursivePrintInOrder(root);
    }
    public void recursivePrintInOrder(BinaryNode node){
        if(node != null){
            recursivePrintInOrder(node.left);
            System.out.print(node.data + " ");
            recursivePrintInOrder(node.right);
        }
    }
    public void recursivePrintPostOrder(){
        recursivePrintPostOrder(root);
    }
    public void recursivePrintPostOrder(BinaryNode node){
        if(node != null){
            recursivePrintInOrder(node.left);
            recursivePrintInOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    public void recursivePrintPreOrder(){
        recursivePrintPostOrder(root);
    }
    public void recursivePrintPreOrder(BinaryNode node){
        if(node != null){
            System.out.print(node.data + " ");
            recursivePrintInOrder(node.left);
            recursivePrintInOrder(node.right);
        }
    }
    public void breadthFirstPrint(){
        breadthFirstPrint(root);
    }
    public void breadthFirstPrint(BinaryNode node){
        if(node != null){
            // make queue
            // add current node
            // while queue not empty
            // 
        }
    }
    public BinaryNode recursiveSearch(int data){
        return recursiveSearch(root, data);
    }
    public BinaryNode recursiveSearch(BinaryNode node, int data){
        if(data == node.data){
            return node;
        } else if(data < node.data){
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
    public void recursiveInsert(int data){
        recursiveInsert(root, data);
    }
    public void recursiveInsert(BinaryNode node, int data){
        if(size == 0){
            root = new BinaryNode(data);
            return;
        } else if(data == node.data){
            // data already in tree (no duplicates allowed)
            return;
        } else if(data < node.data){
            // left side
            BinaryNode left = node.left;
            if(left != null){
                recursiveInsert(left, data);
            } else{
                size++;
                node.left = new BinaryNode(data);
            }
        } else{
            // right side
            BinaryNode right = node.right;
            if(right != null){
                recursiveInsert(right, data);
            } else{
                size++;
                node.right = new BinaryNode(data);
            }
        }
    }
    public void treeArr(BinaryNode curr, Vector<BinaryNode> nodes){
        if(curr == null){
            return;
        }
        treeArr(curr.left, nodes);
        nodes.add(curr);
        treeArr(curr.right, nodes);
    }
    public BinaryNode balanceRecursive(Vector<BinaryNode> nodes, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode curr = nodes.get(mid);
        curr.left = balanceRecursive(nodes, start, mid - 1);
        curr.right = balanceRecursive(nodes, mid + 1, end);
        // return the final root
        return curr;
    }
    public void balance(){
        if(size == 0){
            return;
        }
        Vector<BinaryNode> thisVector = new Vector<BinaryNode>();
        treeArr(root, thisVector);
        root = balanceRecursive(thisVector, 0, size - 1);
    }
}

class BinaryNode{
    BinaryNode left;
    BinaryNode right;
    Integer data;
    public BinaryNode(){
        this.data = null;
        left = right = null;
    }
    public BinaryNode(int data){
        this.data = data;
        left = right = null;
    }
}
