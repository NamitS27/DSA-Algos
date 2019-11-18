/* 
Name : Namit Shah AU1841067
Version : 18
Description : Copying one content of queue from other queue
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

    public int peek(){
        if(isEmpty()) return Integer.MIN_VALUE;
        return arr[rear];
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

public class Q18_CopyContentQueue {   // Question 18
    public static Queue copyContents(Queue q) {
        Queue qr = new Queue(q.capacity);
        while(!q.isEmpty()){
            qr.enqueue(q.dequeue());
        }
        return qr;
    }

    public static void main(String args[]) {
        Queue que = new Queue(10);
        Scanner sc = new Scanner(System.in);
        String cnt = "Y";
        while(cnt.equals("Y")){
            System.out.print("\nEnqueue integer : ");
            que.enqueue(sc.nextInt());
            System.out.print("Continue (Y/N) ? ");
            cnt = sc.next().toUpperCase();
        }
        Queue q2 = copyContents(que);
        System.out.print("\nContents in new queue : ");
        q2.display();
        sc.close();
    }
}

/* OUTPUT 
Enqueue integer : 34
Continue (Y/N) ? y
Enqueue integer : 23
Continue (Y/N) ? y
Enqueue integer : 56
Continue (Y/N) ? y
Enqueue integer : 89
Continue (Y/N) ? n

Contents in new queue : 34 23 56 89
*/