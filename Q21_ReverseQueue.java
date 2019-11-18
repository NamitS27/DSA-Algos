/*
Author : Namit Shah AU1841067
Question : 21
Description : Reverse contents of the queue.
*/

import java.util.*;

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

class Stack{
    protected int arr[];
    protected int top, size, len;

    public Stack(int n){
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size -1 ;        
    }

    public int getSize(){
        return len ;
    }

    public int peek(){
        if( isEmpty() )
            return Integer.MIN_VALUE;
        return arr[top];
    }

    public void push(int i){
        if(top + 1 >= size){
            System.out.print("Can't Push\n");
            return;
        }
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }

    public int pop()
    {
        if( isEmpty() )
            return Integer.MIN_VALUE;
        len-- ;
        return arr[top--]; 
    }    

    public void display()
    {
        System.out.print("\nStack = ");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }    
}

public class Q21_ReverseQueue{  // Question 21
    public static void reverseQueue(Queue arr) {
        System.out.print("\nOriginal Queue : ");
        arr.display();
        Stack st = new Stack(arr.capacity);
        while(!arr.isEmpty()){
            st.push(arr.dequeue());
        }
        while(!st.isEmpty()){
            arr.enqueue(st.pop());
        }
        System.out.println("\nReversed Queue : ");
        arr.display();
    }

    public static void main(String args[]) {
        Queue q = new Queue(100);
        Scanner sc = new Scanner(System.in);
        String cont = "Y";
        System.out.print("\nQueue : \n\n");
        while(cont.equals("Y")){
            System.out.print("Enqueue element : ");
            q.enqueue(sc.nextInt());
            System.out.print("Continue (Y/N) : ");
            cont = sc.next().toUpperCase();
        }
        
        reverseQueue(q);
        sc.close();
    }
}