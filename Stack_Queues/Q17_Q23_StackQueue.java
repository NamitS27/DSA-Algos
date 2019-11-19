/* 
AUTHOR : Namit Shah AU1841067
Question : 23 & 17
Description :  Implementation of stack using queue
*/
   
import java.util.Scanner;

class Queue {   // Question 23  & Question 17
    int arr[];
    int front;
    int rear;
    int capacity;
    
    // Queue class used to make stack

    Queue(int n){  // constructor to initialise the given variables
        capacity = n;
        arr = new int[n];
        front = -1;
        rear = -1;
    }

    public void enqueue(int val){  // function of the queue used to insert element in the  queue
        if(isFull()){  // condition of stack being full
            System.out.println("Queue is Full\n");
            return;
        }
        // other conditions are as follows
        else if(front == -1 && rear == -1){
            front = rear = 0;
            arr[rear] = val;
        }
        else {
            rear++;
            arr[rear] = val;
        }
    }

    public int dequeue(){  // function to delete the element from the queueu by FIFO rule
        if(isEmpty()) return Integer.MIN_VALUE;  // conition of queue being empty
        else if(front==rear){
            int temp = front;
            front=rear=-1;
            return arr[temp];
        }
         else return arr[front++];
    }

    public void display(){   // function to display the queue
        if(isEmpty()) System.out.print("Queue is empty\n");
        else{
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public boolean isEmpty(){   // boolean function to check wether the queue is empty or not
        if(front==-1 && rear==-1) return true;
        else return false;
    }

    public boolean isFull(){ // function to check wether the queue is full or not
        if(rear==capacity-1) return true;
        else return false;
    }
}

class Stack_Queue{
    Queue q1,q2;  // defining two queues to make stack

    Stack_Queue(int n){
        q1 = new Queue(n);  // intializing the two queues as per the requirement of size of the stack
        q2 = new Queue(n);
    }

    public void push(int x){  // stack push function 
        if(q1.isFull()) {
            System.out.println("Stack Full");
            return;
        } 
        else{
            q1.enqueue(x);  // push function is implemented using one of the queue by using queue's enqueue function
        }
    }

    public int pop(){
        if(q1.isEmpty()){
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        else{  // in order to pop element the element ... first the queue is emptied upto second last element and enqueue in the temporary queue
            while(q1.front!=q1.rear){
                q2.enqueue(q1.dequeue());
            }  // the last element left is the popped element from the stack 
            int rt = q1.dequeue();
            Queue temp = q1;  // swapping the two queues
            q1 = q2;
            q2 = temp;
            return rt;
        }
    }

    public void display(){  // displaying the stack using queue's display function
        if(q1.isEmpty()) System.out.print("Stack is Empty\n");
        else{
            for(int i=q1.rear;i>=q1.front;i--){
                System.out.print(q1.arr[i] + " ");
            }
        }
    }
}

class Q17_Q23_StackQueue{  // Question 23 & 17
    public static void main(String args[]) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Stack_Queue st = new Stack_Queue(5);
        do{
            System.out.print("\nStack : ");
            st.display();
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display Stack");
            System.out.println("4. Exit");

            System.out.print("\nEnter Choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value you want to insert : ");
                    st.push(sc.nextInt());
                    break;
            
                case 2:
                    System.out.println(st.pop() + " is removed\n");
                    break;

                case 3:
                    st.display();
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
Stack : Stack is Empty

1. Push
2. Pop
3. Display Stack      
4. Exit

Enter Choice : 1      
Enter the value you want to insert : 3

Stack : 3       
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 1
Enter the value you want to insert : 4

Stack : 4 3     
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 1
Enter the value you want to insert : 5

Stack : 5 4 3 
1. Push       
2. Pop        
3. Display Stack
4. Exit

Enter Choice : 1
Enter the value you want to insert : 6

Stack : 6 5 4 3
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 1
Enter the value you want to insert : 7

Stack : 7 6 5 4 3
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 1
Enter the value you want to insert : 2
Stack Full

Stack : 7 6 5 4 3 
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 2
7 is removed


Stack : 6 5 4 3
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 2
6 is removed


Stack : 5 4 3
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 2
5 is removed


Stack : 4 3
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 2
4 is removed


Stack : 3
1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 2
3 is removed


Stack : Stack is Empty

1. Push
2. Pop
3. Display Stack
4. Exit

Enter Choice : 4
*/