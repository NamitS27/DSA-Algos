
/*
Author : Namit Shah
*/

import java.util.Scanner;

class CircularLinkedList {
    int size;
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    CircularLinkedList(){
        size = 0;
    }

    int getSize(){
        return size;
    }

    boolean isEmpty(){
        return size==0;
    }

   void insertAtFront(int data){
       Node newNode = new Node(data);
       if(head == null){
           head = newNode;
           head.next = head;
       }
       else{
           Node temp = head;
           newNode.next = head;
            while (temp.next != head) 
                temp = temp.next; 
            temp.next = newNode; 
       }
       head = newNode;
       size++;
   }

   void insertAtTail(int data){
       Node newNode = new Node(data);
       if(isEmpty()){
            head = newNode;
       }
       else{
           Node temp = head;
           while(temp.next != head){
               temp = temp.next;
           }
           temp.next = newNode;
       }
       newNode.next = head;
       size++;
   }

   void delAtFront(){
       if(!isEmpty()){
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            size--;
        }
        else{
            System.out.print("Cannot Delete\n");
        }
   }

   void delete(int pos){
       pos = pos-1;
       if(pos<0 ||pos>=size){
           System.out.println("Cannot Delete");
       }
       else{
           Node curr = head,prev = head;
           for(int i=0;i<pos;i++){
               if(curr.next==head) break;
               prev = curr;
               curr = curr.next;
           }
           if(pos==0) delAtFront();
           else prev.next = curr.next;
           size--;
       }
       
   }

   void display(){
       if(isEmpty()){
           System.out.println("\nCirular Linked List : Empty");
       }
       else{
           System.out.print("\nCircular Linked List : ");
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
       }
   }
}

class CircularLinkedList_Q6{
   public static void main(String args[]) {
       CircularLinkedList cls = new CircularLinkedList();
       Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice!=4)
        {
            cls.display();
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("1) Insert element at Tail");
            System.out.println("2) Insert element at Head");
            System.out.println("3) Delete element from specific position");
            System.out.println("4) Exit");
            System.out.println("----------------------------------------------------------------------------");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            int data = 0;
            switch(choice)
            {
                case 1:
                    System.out.print("Enter element you want to add at tail : ");
                    data = sc.nextInt();
                    cls.insertAtTail(data);
                    break;

                case 2:
                    System.out.println("Enter the element you want to add at head : ");
                    data = sc.nextInt();
                    cls.insertAtFront(data);
                    break;

                case 3:
                    System.out.println("Enter the position at which you want to delete the element : ");
                    int pos = sc.nextInt();
                    cls.delete(pos);
                    break;

                case 4:
                    break;
            }
        }
        sc.close();
   }

}