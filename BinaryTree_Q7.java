/*
Author : Namit Shah
*/

class BinaryTree_Q7{
    int size;
    Node root;

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }

    void InOrder(Node node){
        if(node==null){
            return;
        }
        InOrder(node.left);
        System.out.print(node.data + " ");
        InOrder(node.right);
    }

    void PreOrder(Node node){
        if(node == null) return;
        System.out.print(node.data + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

    void PostOrder(Node node){
        if(node==null) return;
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.data + " ");
    }

    void createTree(){
        this.root = new Node(3);
        this.root.left = new Node(11);
        this.root.right = new Node(12);
        this.root.left.right = new Node(13);
        this.root.left.left = new Node(14);
        this.root.right.left = new Node(19);
        this.root.left.left.left = new Node(10);
        this.root.left.left.right = new Node(45);
        this.root.right.left .right= new Node(99);

    }

    public static void main(String args[]) {
        BinaryTree_Q7 bt = new BinaryTree_Q7();
        bt.createTree();
        System.out.print("Inorder Traversal : ");
        bt.InOrder(bt.root);
        System.out.print("\nPostorder Traversal : ");
        bt.PostOrder(bt.root);
        System.out.print("\nPreorder Traversal : ");
        bt.PreOrder(bt.root);
    }
}