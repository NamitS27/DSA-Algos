/* 
AUTHOR : Namit Shah AU1841067
Question : 6
Description :  Converting infix to postfix
*/


import java.io.*;

class Stack { // Question 6
    protected char arr[];
    protected int top, size, len;

    public Stack(int n){  // constructor to initialize the neccessary conditions for the stack
        size = n;
        len = 0;
        arr = new char[size];
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

    public char peek(){  // function to see the top element in the stack
        if( isEmpty() )
            return '\0';
        return arr[top];
    }

    public void push(char i){ // insert element in the stack
        if(top + 1 >= size){
            System.out.print("Can't Push\n");
            return;
        }
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }

    public char pop(){  // delete element from the stack
        if( isEmpty() )
            return '\0';
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

public class Q6_InfixPostfix{
    public static int precedence(char a) {   // function to define precedence of the operators
        if(a=='+' || a=='-') return 1;
        if(a=='*' || a=='/' || a=='%') return 2;
        if(a=='^') return 3;
        return -1;
    }


    public static String infixPostfix(String exp) {
        Stack st = new Stack(1000);   // stack class
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<exp.length();i++){
            char sym = exp.charAt(i);
            if(sym >= 'a' && sym<='z' || sym>='A' && sym<='Z' || sym>=48 && sym<=57) sb.append(sym);  // just taking the character into the expression
            else if(sym=='(') st.push(sym);  // if ( is encountered it is pushed into stack
            else if(sym==')'){   // if ) is encountered then the following is done
                char temp = st.pop();
                while(temp!='(') {
                    sb.append(temp);
                    temp = st.pop();
                }
            }
            else{  // else for the operators precedence is checked 
                while(!st.isEmpty() && precedence(sym)<=precedence(st.peek())){
                    sb.append(st.pop());
                }
                st.push(sym);
            }
        }
        while(!st.isEmpty()) sb.append(st.pop());  // for the operators left they are appended
        return sb.toString();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the algebric expression : ");
        String expression = br.readLine();
        System.out.println("Postfix Epression is : " +infixPostfix(expression));
        br.close();
    }
}

/* OUTPUT 
Enter the algebric expression : A+B*(C^D-E)
Postfix Epression is : ABCD^E-*+
*/