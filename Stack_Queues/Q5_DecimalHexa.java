/* 
Name : Namit Shah AU1841067
Version : 5
Description : Convert decimal to hexadecimal
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

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

public class Q5_DecimalHexa{  // Question 5 
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter decimal number : ");
        int dec = Integer.parseInt(br.readLine());
        Stack st = new Stack(1000);
        while(dec!=0){
            int temp = dec%16;
            if(temp>9){ 
                st.push((char)(temp+55));
            }
            else st.push(String.valueOf(temp).charAt(0));
            dec/=16;
        }
        System.out.print("Hexadecimal Number : ");
        while(!st.isEmpty()) System.out.print(st.pop());

        br.close();

    }
}

/* OUTPUT 
Enter decimal number : 4567889
Hexadecimal Number : 45B351
*/