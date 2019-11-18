/* 
AUTHOR : Namit Shah AU1841067
Question : 24
Description :  Implementation of queue using stack
*/
   
import java.util.Scanner;

class Stack { // Question 24
    protected int arr[];
    protected int top, size, len;

    public Stack(int n){  // constructor to initialize the neccessary conditions for the stack
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty(){  // to check wether the stack is empty or not
        return top == -1;
    }

    public boolean isFull(){  // to check wether the stack is full or not
        return top == size -1 ;        
    }

    public int getSize(){  // fetching the size of the stack
        return len ;
    }

    public int peek(){  // function to see the top element in the stack
        if( isEmpty() )
            return Integer.MIN_VALUE;
        return arr[top];
    }

    public void push(int i){ // insert element in the stack
        if(top + 1 >= size){
            System.out.print("Can't Push\n");
            return;
        }
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }

    public int pop(){  // delete element from the stack
        if( isEmpty() )
            return Integer.MIN_VALUE;
        len-- ;
        return arr[top--]; 
    }    

    public void display() {   // display the stack
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

class Queue_Stack{
    Stack s1,s2;   // declaring 2 stacks to implement queue

    Queue_Stack(int n){
        s1 = new Stack(n);  // initializing the stack as per the size of the queue
        s2 = new Stack(n);
    }

    public void enqueue(int x){
        if(s1.isFull()) System.out.print("\nQueue is full\n");
        else s1.push(x);   // enqueuing the queue usisg the stack's push function
    }

    public int dequeue(){
        if(s1.isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        else{  // deleteing the element from the queue by first emptying one stack adding it inot other and at last popping the last element
            while(s1.getSize()!=1){
                s2.push(s1.pop());
            }
            int rt = s1.pop();
            while(!s2.isEmpty()) s1.push(s2.pop());
            return rt;
        }
    }

    public void display(){  // display the queue
        if(s1.isEmpty()) System.out.println("Queue is empty");
        else{
            for(int i=0;i<=s1.top;i++){
                System.out.print(s1.arr[i] + " ");
            }
        }
    }
}


public class Q24_QueueStack{
    public static void main(String args[]) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Queue_Stack qu = new Queue_Stack(5);
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
Enter the value you want to insert : 4
Queue : 3 4 4   
1. Enqueue      
2. Dequeue      
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 3
Queue : 3 4 4 3 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 5
Queue : 3 4 4 3 5 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 2

Queue is full
Queue : 3 4 4 3 5 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 4 4 3 5 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 4 3 5
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 3 5
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