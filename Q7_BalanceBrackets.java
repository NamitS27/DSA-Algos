/* 
Name : Namit Shah AU1841067
Question : 7
Description :  Bracket sequence is made up of opening '(' and closing ')' parenthese & we have to 
               check if this bracket sequence is balanced
*/

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

class Q7_BalanceBrackets{   // Question 7

    public static boolean checkBalance(String seq) {
        Stack st = new Stack(1000);
        boolean check =  true;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='(') st.push(seq.charAt(i));
            else{
                char test =  st.pop();
                if(test=='\0'){
                    check = false;
                    break;
                }
            }
        }
        if(!st.isEmpty()) check = false;
        return check;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter bracket seq. : ");
        String seq = br.readLine();
        if(checkBalance(seq)) System.out.println("The given sequence is balanced");
        else System.out.println("The given sequence is not Balanced");
        br.close();
    }
}

/* OUTPUT 
Enter bracket seq. : ()()
The given sequence is balanced
*/