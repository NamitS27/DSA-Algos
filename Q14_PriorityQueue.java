/*
Author : Namit Shah AU1841067
Question :  14
Description : Priority queue using array
*/

import java.util.*;

class priority{
    int el;
    int prior;

    public priority(int el,int prior){
        this.el = el;
        this.prior = prior;
    }

    @Override
    public String toString() {
        return "Element : " + el + ", Priority : " + prior;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }

}

class pQueue{
    int front,rear;
    priority arr[];
    int capacity;

    public void initialize(int n,priority[] pr){
        for(int i=0;i<n;i++){
            pr[i] = new priority(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    public pQueue(int n){
        front = -1;
        rear = -1;
        arr = new priority[n];
        capacity = n;
        initialize(n, arr);
    }

    public void enqueue(int el,int pr){
        if(isFull()) System.out.println("Queue is full");
        else if(front==-1 && rear==-1){
            front = rear = 0;
            arr[rear] = new priority(el, pr);
        }
        else{
            rear++;
            arr[rear] = new priority(el, pr);
        }
    }

    public priority dequeue(){
        int n = capacity;
        for (int i = 0; i < n-1; i++){ 
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].getPrior() < arr[j+1].getPrior()) 
                { 
                    priority temp = arr[j];   // swapping objects
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
            }
        }
        if(isEmpty()) return null;
        else if(front==rear){
            int temp = front;
            front = rear = -1;
            return arr[temp];
        }
        else return arr[front++];
    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1) return true;
        else return false;
    }

    public boolean isFull(){
        if(rear==capacity-1) return true;
        else return false;
    }

    public void display(){
        if(isEmpty()) System.out.print("Queue is empty\n");
        else{
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i].toString() + "\n");
            }
        }
    }
}

public class Q14_PriorityQueue{  // Question 14
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String cont = "Y";
        pQueue pq = new pQueue(10);
        while(cont.equals("Y")){
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("\nEnter choice : ");
            int  choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter element and its priority(seperated by space) : ");
                    int el = sc.nextInt();
                    int pr = sc.nextInt();
                    pq.enqueue(el,pr);
                    break;

                case 2:
                    System.out.println("Dequeued : "+pq.dequeue().toString());
                    break;

                case 3:
                    pq.display();
                    break;

                case 4:
                    System.exit(0);
                    break;
            }
            System.out.print("Continue (Y/N) : ");
            cont = sc.next().toUpperCase();
        }
        sc.close();
    }

}

/* OUTPUT 
1. Enqueue
2. Dequeue     
3. Display
4. Exit

Enter choice : 1
Enter element and its priority(seperated by space) : 2 3
Continue (Y/N) : y

1. Enqueue
2. Dequeue
3. Display
4. Exit

Enter choice : 1
Enter element and its priority(seperated by space) : 5 1
Continue (Y/N) : y

1. Enqueue
2. Dequeue
3. Display
4. Exit

Enter choice : 2
Dequeued : Element : 2, Priority : 3
Continue (Y/N) : y

1. Enqueue
2. Dequeue
3. Display
4. Exit

Enter choice : 3
Element : 5, Priority : 1
Continue (Y/N) : n
*/