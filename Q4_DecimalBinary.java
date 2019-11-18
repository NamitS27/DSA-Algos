/* 
Name : Namit Shah AU1841067
Version : 4
Description : Convert decimal to binary
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;


class Stack{
    protected int arr[];
    protected int top, size, len;

    public Stack(int n){
        size = n;
        len = 0;
        arr = new int[size];
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

    public int peek(){
        if( isEmpty() )
            return Integer.MIN_VALUE;
        return arr[top];
    }

    public void push(int i){
        if(top + 1 >= size){
            System.out.print("Can't Push\n");
            return;
        }
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }

    public int pop()
    {
        if( isEmpty() )
            return Integer.MIN_VALUE;
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

public class Q4_DecimalBinary{  // Question 4
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack st = new Stack(1000);
        System.out.print("Enter decimal number : ");
        int dec = Integer.parseInt(br.readLine());
        while(dec!=0){
            int temp = dec%2;
            st.push(temp);
            dec /= 2;
        }
        System.out.print("Binary Equivalent : ");
        while(!st.isEmpty()) System.out.print(st.pop());
        br.close();
    }

}

/* OUTPUT 
Enter decimal number : 47
Binary Equivalent : 101111
*/