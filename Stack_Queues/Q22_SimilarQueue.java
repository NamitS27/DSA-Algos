/*
Author : Namit Shah AU1841067
Question : 22
Description : Check wether contents of queues are same or not
*/

import java.util.Scanner;

class Queue {
    int arr[];
    int front;
    int rear;
    int capacity;

    Queue(int n){
        capacity = n;
        arr = new int[n];
        front = -1;
        rear = -1;
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is Full\n");
            return;
        }
        else if(front == -1 && rear == -1){
            front = rear = 0;
            arr[rear] = val;
        }
        else {
            rear++;
            arr[rear] = val;
        }
    }

    public int dequeue(){
        if(isEmpty()) return Integer.MIN_VALUE;
        else if(front==rear){
            int temp = front;
            front=rear=-1;
            return arr[temp];
        }
         else return arr[front++];
    }

    public void display(){
        if(isEmpty()) System.out.print("Queue is empty\n");
        else{
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1) return true;
        else return false;
    }

    public boolean isFull(){
        if(rear==capacity-1) return true;
        else return false;
    }
}

public class Q22_SimilarQueue {
    public static boolean compareQ(Queue q1,Queue q2){
        boolean check = true;
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q1.dequeue()!=q2.dequeue()){
                check = false;
                break;
            }
        }
        if(!q1.isEmpty() || !q2.isEmpty()) check = false;
        return check;
    }

    public static void main(String args[]) {
        Queue q1 = new Queue(100);
        Queue q2 = new Queue(100);
        Scanner sc = new Scanner(System.in);
        
        String cont = "Y";
        System.out.print("\nQueue 1 : \n\n");
        while(cont.equals("Y")){
            System.out.print("Enqueue element  (Queue 1) : ");
            q1.enqueue(sc.nextInt());
            System.out.print("Continue (Y/N) : ");
            cont = sc.next().toUpperCase();
        }
        System.out.print("\nQueue 2 : \n\n");
        cont = "Y";
        while(cont.equals("Y")){
            System.out.print("Enqueue element  (Queue 1) : ");
            q2.enqueue(sc.nextInt());
            System.out.print("Continue (Y/N) : ");
            cont = sc.next().toUpperCase();
        }
        System.out.print("\n\nQueue 1 : "); 
        q1.display();
        System.out.print("\nQueue 2 : "); 
        q2.display();

        if(compareQ(q1, q2)) System.out.println("\n\nContents of both the queues are same");
        else System.out.println("\nContents are not same");
        sc.close();
    }
}

/* OUTPUT 
Queue 1 :

Enqueue element  (Queue 1) : 1
Continue (Y/N) : y
Enqueue element  (Queue 1) : 2
Continue (Y/N) : n

Queue 2 :

Enqueue element  (Queue 1) : 1
Continue (Y/N) : y
Enqueue element  (Queue 1) : 2
Continue (Y/N) : n


Queue 1 : 1 2
Queue 2 : 1 2

Contents of both the queues are same
*/