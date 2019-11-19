/*
Author : Namit Shah AU1841067
Question : 20
Description : Delete all the spaces in the given string
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class Q20_RemoveSpace { // Question 20
    public static String removeSpace(String str) {
        StringBuilder sb = new StringBuilder();
        cQueue q = new cQueue(100);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' ') q.enqueue(str.charAt(i));
        }
        while(!q.isEmpty()){
            sb.append(q.dequeue());
        }
        return sb.toString();
    }

    public static void main(String args[])  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the string : ");
        String str = br.readLine();
        System.out.println("String after removing spaces : " +removeSpace(str));
        br.close();
    }
}

/* OUTPUT 
Enter the string : data structures and algorithm
String after removing spaces : datastructuresandalgorithm
*/