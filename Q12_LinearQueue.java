/*
Author : Namit Shah AU1841067
Question :  12
Description : Linear Queue
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

public class Q12_LinearQueue{

    public static void main(String args[]) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Queue qu = new Queue(5);
        do{
            System.out.print("Queue : ");
            qu.display();
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");

            System.out.print("\nEnter Choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value you want to insert : ");
                    qu.enqueue(sc.nextInt());
                    break;
            
                case 2:
                    qu.dequeue();
                    break;

                case 3:
                    qu.display();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Wrong Input");
                    break;
            }
        }while(choice!=4);
        sc.close();
    }

}

/* OUTPUT 
Queue : Queue is empty

1. Enqueue
2. Dequeue
3. Display Queue      
4. Exit

Enter Choice : 1      
Enter the value you want to insert : 3
Queue : 3       
1. Enqueue      
2. Dequeue      
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 4
Queue : 3 4     
1. Enqueue      
2. Dequeue      
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 5
Queue : 3 4 5
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 4 5
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 5
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : Queue is empty

1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 4

*/