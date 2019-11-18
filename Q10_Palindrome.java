/*
Author : Namit Shah AU1841067
Question : 10
Description : Check wether the string is palindromic or not
*/

import java.io.*;
import java.util.Arrays;

class Stack{
    protected char arr[];
    protected int top, size, len;

    public Stack(int n){
        size = n;
        len = 0;
        arr = new char[size];
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

    public char peek(){
        if( isEmpty() )
            return '\0';
        return arr[top];
    }

    public void push(char i){
        if(top + 1 >= size){
            System.out.print("Can't Push\n");
            return;
        }
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }

    public char pop()
    {
        if( isEmpty() )
            return '\0';
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

class cQueue {
    char arr[];
    int front;
    int rear;
    int capacity;

    cQueue(int n){
        capacity = n;
        arr = new char[n];
        front = -1;
        rear = -1;
    }

    public void enqueue(char val){
        if(rear==capacity-1){
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

    public char dequeue(){
        if(isEmpty()) return '\0';
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
}


public class Q10_Palindrome{  // Question 10
    public static void main(String args[]) throws IOException{
        Stack st = new Stack(1000);
        cQueue qu = new cQueue(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String : ");
        String str = br.readLine();
        char sr[] = str.toCharArray();
        int xpos = Arrays.binarySearch(sr, 'X');
        for(int i=0;i<str.length();i++){
            if(i<xpos) st.push(sr[i]);
            else if(i>xpos) qu.enqueue(sr[i]);
        }
        boolean check = true;
        while(!st.isEmpty() && !qu.isEmpty()){
            if(st.pop()!=qu.dequeue()){
                check = false;
                break;
            }
        }
        if(!st.isEmpty() || !qu.isEmpty()) check = false;
        if(check) System.out.println("\nString is Palindrome");
        else System.out.println("\nString is not a Palindrome");
        br.close();
    }

}

/* OUTPUT 
Enter String : abcdefghXhgfedcba

String is Palindrome
*/