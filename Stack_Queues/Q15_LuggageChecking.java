/*
Author : Namit Shah AU1841067
Question : 15
Description : Luggage Checking
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

public class Q15_LuggageChecking{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Queue lug = new Queue(1000);
        for(int i=0;i<15;i++){
            lug.enqueue(i+1);
        }
        System.out.println("Luggages in queue to be checked are : ");
        lug.display();
        Queue checkLug = new Queue(1000);
        int choice = 0;
        do{
            System.out.println("\n1. Check Luggage");
            System.out.println("2. Display Checked Luggage");
            System.out.println("3. Done");
            System.out.print("\nEnter choice : ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    int temp = lug.dequeue();
                    System.out.println("\nLuggage " + temp + " is checked");
                    checkLug.enqueue(temp);
                    break;

                case 2:
                    System.out.print("\nChecked Luggages : ");
                    checkLug.display();
                    break;

                case 3:
                    break;
            }
        }while(choice!=3);
        sc.close();
    }

}

/* OUTPUT 
Luggages in queue to be checked are : 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
1. Check Luggage
2. Display Checked Luggage
3. Done

Enter choice : 1

Luggage 1 is checked

1. Check Luggage
2. Display Checked Luggage
3. Done

Enter choice : 1

Luggage 2 is checked

1. Check Luggage
2. Display Checked Luggage
3. Done

Enter choice : 1

Luggage 3 is checked

1. Check Luggage
2. Display Checked Luggage
3. Done

Enter choice : 2

Checked Luggages : 1 2 3
1. Check Luggage
2. Display Checked Luggage
3. Done

Enter choice : 3

*/