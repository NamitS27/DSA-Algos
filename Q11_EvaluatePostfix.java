/*
Author : Namit Shah AU1841067
Question : 11
Description : Evaluating the postfix expression
*/

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

public class Q11_EvaluatePostfix{

    public static int evaluatePostfix(String postfix) {
        Stack st = new Stack(1000);
        for(int i=0;i<postfix.length();i++){
            char w = postfix.charAt(i);
            if(Character.isDigit(w)) st.push(w-'0');
            else{
                int op1 = st.pop();
                int op2 = st.pop();
                switch(w){
                    case '+':
                        st.push(op1+op2);
                        break;
                    
                    case '-':
                        st.push(op2-op1);
                        break;
                    
                    case '*':
                        st.push(op1*op2);
                        break;
                    
                    case '/':
                        st.push(op2/op1);
                        break;

                    case '^':
                        st.push((int)Math.pow(op2,op1));
                        break;

                    case '%':
                        st.push(op2%op1);
                        break;
                }
            }
        }
        return st.pop();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the postfix expression : ");
        String expression = br.readLine();
        System.out.println("Ans : " +evaluatePostfix(expression));
        br.close();
    }
}

/* OUTPUT 
Enter the postfix expression : 23+5*6*7*
Ans : 1050
*/