
/*
Author : Namit Shah
*/

import java.util.Scanner;


class DoublyLinkedList{
    int size;
    Node head;

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    void insert(int data){
        Node new_node = new Node(data);

        if(this.head==null) this.head = new_node;
        else{
            Node last = this.head;
            while(last.next != null) last = last.next;
            last.next = new_node;
            new_node.prev = last;
        }
        size++;
    }

    void insertFront(int data){
        Node new_front = new Node(data);
        new_front.next = this.head;
        this.head.prev = new_front;
        this.head = new_front;
        size++;
    }

    void insertAt(int keyind,int data){
        int count = 1;
        Node newNode = new Node(data);
        if(keyind==0){
            this.insertFront(data);
        } else {
            Node currNode = this.head;
            while(currNode != null){
                if(count == keyind){
                    newNode.next = currNode.next;
                    newNode.prev = currNode;
                    currNode.next.prev = newNode;
                    currNode.next = newNode;
                    break;
                }
                count++;
                currNode = currNode.next;
            }
        }
        size++;
    }

    void delFront(){
        if(size!=0){
            this.head = this.head.next;
            this.head.prev = null;
            size--;
        }
        else{
            System.out.print("Empty, Can't Delete\n");
        }
    }

    void delLast(){
        if(size==0) System.out.print("Can't delete as it is empty");
        else if(size==1) delFront();
        else{
            Node nxt = this.head;
            while(nxt.next.next!=null) nxt = nxt.next;
            nxt.next = null;
            size--;
        }
    }

    void deleteAt(int ind){
        Node currNode = this.head, prev = null; 
        if (ind == 0 && currNode != null) { 
            delFront();
            System.out.println(ind + " position element deleted");
        } 
        int counter = 0; 
        while (currNode != null) { 
            if (counter == ind) { 
                prev.next = currNode.next;
                currNode.next.prev = prev; 
                System.out.println(ind + " position element deleted"); 
                break; 
            } 
            else { 
                prev = currNode; 
                currNode = currNode.next; 
                counter++; 
            } 
        } 
        if (currNode == null) { 
            System.out.println(ind + " position element not found"); 
        } 
        size--;
    }

    int getSize(){
        return size;
    }

    boolean search(int value){
        Node node = this.head;
        if(getSize()>1){
            while(node.next != null){
                if(node.data==value){
                    return true;
                }else{
                    node = node.next;
                }
            }
        }
        else{
            if(node.data==value) return true;
        }
        return false;
    }

    void printLinkedList(){
        Node current_Node = this.head;
        System.out.print("Doubly Linked List : ");
        while(current_Node!=null){
            System.out.print(current_Node.data + " ");
            current_Node = current_Node.next;
        }
        System.out.println();
    }
}


class DoublyLinkedList_Q5{
    public static void main(String args[]) {
        DoublyLinkedList dls = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice!=9)
        {
            dls.printLinkedList();
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("1) Insert element at any position");
            System.out.println("2) Insert element at Tail");
            System.out.println("3) Insert element at Head");
            System.out.println("4) Delete element from last ");
            System.out.println("5) Delete element from specific position");
            System.out.println("6) Delete element from first");
            System.out.println("7) Find element");
            System.out.println("8) Get size");
            System.out.println("9) Exit");
            System.out.println("----------------------------------------------------------------------------");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter element and the position at which you want to insert : ");
                    int data = sc.nextInt();
                    int pos = sc.nextInt();
                    dls.insertAt(pos, data);
                    System.out.println("Inserted");
                    break;
                
                case 2:
                    System.out.print("Enter the element you want to insert at the end : ");
                    int dat = sc.nextInt();
                    dls.insert(dat);
                    System.out.println("Inserted");
                    break;

                case 3:
                    System.out.println("Enter the element you want to add at the front : ");
                    int frt = sc.nextInt();
                    dls.insertFront(frt);
                    System.out.println("Inserted");
                    break;

                case 4:
                    dls.delLast();
                    break;

                case 5:   
                    System.out.println("Enter position to be deleted in linked list ");
                    pos = sc.nextInt();
                    dls.deleteAt(pos);
                    break;

                case 6:
                    dls.delFront();
                    break;

                case 7:
                    System.out.println("Enter the element you want to search for : ");
                    int ser = sc.nextInt();
                    if(dls.search(ser)) System.out.println("Found");
                    else System.out.println("Not Found");
                    break;

                case 8:
                    System.out.println("Size of the Doubly Linked List is : " +dls.getSize());
                    break;

                case 9:
                    break;

                default:
                    System.out.println("Wrong Input");
                    break;
            }
        }
        sc.close();
    }
}