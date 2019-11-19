
/*
Author : Namit Shah
*/

import java.util.*;

class BinarySearchTree_Q8 {
    Node root;
    int num_nodes = 0;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    void insert(Node key, int val) {
        if (key.data > val) {
            if (key.left == null) {
                Node key_left = new Node(val);
                key.left = key_left;
            } else
                insert(key.left, val);
        } else {
            if (key.right == null) {
                Node key_right = new Node(val);
                key.right = key_right;
            } else
                insert(key.right, val);
        }
        num_nodes++;
    }

    void Inorder(Node node) {
        if (node == null) {
            return;
        }
        Inorder(node.left);
        System.out.print(node.data + " ");
        Inorder(node.right);
    }

    void PreOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

    void PostOrder(Node node) {
        if (node == null)
            return;
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.data + " ");
    }

    void traverse(int traverseType) {
        switch (traverseType) {
        case 1:
            System.out.print("\nPreorder traversal: ");
            PreOrder(root);
            break;
        case 2:
            System.out.print("\nInorder traversal:  ");
            Inorder(root);
            break;
        case 3:
            System.out.print("\nPostorder traversal: ");
            PostOrder(root);
            break;
        default:
            System.out.println("Wrong Input");
        }
        System.out.println();
    }

    Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.data != key) {
            parent = current;
            if (key < current.data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null)
                return false;
        }

        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }

        else if (current.right == null)
            if (current == root)
                root = current.left;
            else if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;

        else if (current.left == null)
            if (current == root)
                root = current.right;
            else if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;

        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        num_nodes--;
        return true;
    }

    Node find(int key) {
        Node current = root;
        while (current.data != key) {
            if (key < current.data)
                current = current.left;
            else
                current = current.right;
            if (current == null)
                return null;
        }
        return current;
    }

    int getNodesNumber() {
        return num_nodes;
    }

    boolean isFull() {
        if (Math.log(getNodesNumber() + 1) == 2)
            return true;
        else
            return false;
    }

    int findHeight(Node aNode) {
        if (aNode == null) {
            return -1;
        }
        int lefth = findHeight(aNode.left);
        int righth = findHeight(aNode.right);
        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    int maxValue() {
        Node current = root;
        while (current.right != null)
            current = current.right;
        return (current.data);
    }

    int minValue() {
        Node current = root;
        while (current.left != null)
            current = current.left;
        return (current.data);
    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null || temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("......................................................");
    }

    public static void main(String args[]) {
        BinarySearchTree_Q8 bst = new BinarySearchTree_Q8();
        bst.root = new Node(1);
        char choice = 'a';
        Scanner sc = new Scanner(System.in);
        while (choice != 'e') {
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("s) Show Tree ");
            System.out.println("i) Insert in Tree ");
            System.out.println("f) Find in Tree ");
            System.out.println("d) Delete element from Tree");
            System.out.println("t) Traverse Tree");
            System.out.println("a) Smallest element of tree");
            System.out.println("b) Largest element of tree");
            System.out.println("c) Height of the tree");
            System.out.println("g) Determine if the tree is full or not");
            System.out.println("e) Exit");
            System.out.println("----------------------------------------------------------------------------");
            System.out.print("Enter your choice : ");
            choice = sc.next().charAt(0);
            switch (choice) {
            case 's':
                bst.displayTree();
                break;

            case 'i':
                System.out.println("Enter data you want to insert in thee tree : ");
                int data = sc.nextInt();
                bst.insert(bst.root, data);
                break;

            case 'f':
                System.out.println("Enter the key which you want to find : ");
                int key = sc.nextInt();
                if(bst.find(key)!=null) System.out.println("Found");
                else System.out.println("Not Found");
                break;

            case 'd':
                System.out.println("Enter the element which you want to delete from the tree : ");
                int key1 = sc.nextInt();
                if(bst.delete(key1)) System.out.println("Deleted");
                else System.out.println("Cannot be deleted");
                break;

            case 't':
                System.out.println("\n----------------------------------------------------------------------------");
                System.out.println("1) PreOrder Traversal");
                System.out.println("2) InOrder Traversal");
                System.out.println("3) PostOrder Traversal");
                System.out.println("----------------------------------------------------------------------------");
                System.out.print("Enter your choice : ");
                int ttype = sc.nextInt();
                bst.traverse(ttype);

            case 'a':
                System.out.println("Smallest Element : " +bst.minValue());
                break;
            
            case 'b':
                System.out.println("Largest Element : " +bst.maxValue());
                break;

            case 'c':
                System.out.println("Height of the tree : " +bst.findHeight(bst.root));
                break;

            case 'g':
                if(bst.isFull()) System.out.println("Tree is full");
                else System.out.println("Tree is not full");
                break;

            case 'e':
                break;

            default:
                System.out.println("\nWrong input");
            }
        }
        sc.close();
    }
}