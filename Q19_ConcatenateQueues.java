/* 
Name : Namit Shah AU1841067
Version : 19
Description : Concatenate two queues
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

class Q19_ConcatenateQueues {  // Question 19
    public static void concatenateQ(Queue q1,Queue q2) {
        while(!q2.isEmpty()){
            q1.enqueue(q2.dequeue());
        }
    }
    public static void main(String args[]) {
        System.out.print("Enter size of the queue which you need to concatenate : ");
        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();
        Queue q2 = new Queue(sz);
        char s = 'n';
        do{
            System.out.print("Enter value : ");
            q2.enqueue(sc.nextInt());
            System.out.print("Continue (y/n) : ");
            s = sc.next().charAt(0);
        }while(s=='y');
        System.out.print("\nEnter size of queue in which you want to concatenate the other queue : ");
        int size = sc.nextInt();
        Queue q3 = new Queue(size+sz);
        int cnt = 0;
        char ss = 'n';
        do{
            if(cnt>=size) System.out.print("Queue is full");
            else {
                System.out.print("Enter value : ");
                q3.enqueue(sc.nextInt());
                cnt++;
            }
            System.out.print("Continue (y/n) : ");
            ss = sc.next().charAt(0);
        }while(ss=='y');
        concatenateQ(q3, q2);
        System.out.print("\nQueue after concatenating is : ");
        q3.display();
        sc.close();

    }
}

/* OUTPUT 
Enter size of the queue which you need to concatenate : 3
Enter value : 1
Continue (y/n) : y
Enter value : 2
Continue (y/n) : y
Enter value : 3
Continue (y/n) : n

Enter size of queue in which you want to concatenate the other queue : 2
Enter value : 1
Continue (y/n) : n

Queue after concatenating is : 1 1 2 3
*/