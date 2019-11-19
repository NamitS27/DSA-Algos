/* 
AUTHOR : Namit Shah AU1841067
Question : 13
Description :  Implementation of circular queue
*/


import java.util.*;

class cirQueue{  // Question 13
	protected int arr[];         
	protected int front;         
	protected int rear;          
	protected int capacity;      
	protected int count;         
	
	cirQueue(int size)  // initializing the queue
	{
		arr = new int[size];
		capacity = size;
		front = -1;
		rear = -1;
	}

	public void enqueue(int value) {   // inserting elementin the queue
        if ((front == 0 && rear == capacity - 1) || front - 1 == rear) {
            System.out.println("Full");
        } else {
            if (rear < 0) {
                rear = front = 0;
                arr[rear] = value;
            } else if (rear == capacity - 1) {
                rear = 0;
                arr[rear] = value;

            } else {
                rear++;
                arr[rear] = value;
            }
        }
    }

    public int dequeue() {  // deleting element from the queue
        if (front < 0) {
			System.out.println("empty");
			return Integer.MIN_VALUE;
		}
        if (front == rear) {
			int tmp = front;
			front = rear = -1;
			return arr[tmp];
        } else if (front == capacity- 1) {
			int tmp = front;
			front = 0;
			return arr[tmp];
        } else {
            return arr[front++];
        }
    }

    public void display() {  // display the crcular queue
        if (front < 0) {
            System.out.println("Empty");
        } else if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        } else if (rear < front) {
            for (int i = front; i <= capacity - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
	}
}

class Q13_CircularQueue{
	public static void main(String args[]) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        cirQueue qu = new cirQueue(5);
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
Queue : Empty   

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
Enter the value you want to insert : 5
Queue : 3 4 4 5 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 6
Queue : 3 4 4 5 6 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 4
Full
Queue : 3 4 4 5 6
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 4 4 5 6 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 4 5 6 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 1
Enter the value you want to insert : 3
Queue : 4 5 6 3 
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 5 6 3
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 6 3
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : 3
1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 2
Queue : Empty

1. Enqueue
2. Dequeue
3. Display Queue
4. Exit

Enter Choice : 4
*/