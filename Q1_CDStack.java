/* 
Name : Namit Shah AU1841067
Question  : 1
Description : Stack operation on stack of CDs
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack{
    protected String arr[];
    protected int top, size, len;

    public Stack(int n){
        size = n;
        len = 0;
        arr = new String[size];
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

    public String peek(){
        if( isEmpty() )
            return "Empty";
        return arr[top];
    }

    public void push(String i){
        if(isFull()){
            System.out.print("Can't Push\n");
            return;
        }
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }

    public String pop()
    {
        if( isEmpty() )
            return "Empty";
        len-- ;
        return arr[top--];
    }

    public String peep(int ind){
        if(top < ind-2) return "Cannot peep";
        return arr[top-ind+1];
    }

    public void change(String new_it,int ind){
        if(top-ind+1 < -1) System.out.println("Cannot change");
        else{
            System.out.print("\nElement is change from "+arr[top-ind+1] + " to");
            arr[top-ind+1] = new_it;
            System.out.print(" "+arr[top-ind+1]);
        }
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
    }
}


public class Q1_CDStack { // Question 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cont = "Y";
        Stack st = new Stack(10);
        while(cont.equals("Y")){
            System.out.println("\n1. Push");
            System.out.println("2. Peek");
            System.out.println("3. Pop");
            System.out.println("4. Peep");
            System.out.println("5. Change");
            System.out.println("6. Size");
            System.out.println("7. Display");
            System.out.println("8. Exit");

            System.out.print("\n\nEnter choice : ");
            int choice  = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.print("\nEnter CD name to add : ");
                    String cdn = br.readLine();
                    st.push(cdn);
                    break;

                case 2:
                    System.out.print("Last CD added : " +st.peek());
                    break;

                case 3:
                    System.out.print("\nRemoved CD : "+st.pop());
                    break;

                case 4:
                    System.out.print("\nEnter the index at which you want to peep : ");
                    int pind = Integer.parseInt(br.readLine());
                    System.out.print("\nCD : "+st.peep(pind));
                    break;

                case 5:
                    System.out.print("\nEnter new CD name :");
                    String newN = br.readLine();
                    System.out.print("Enter index at which you want to change :");
                    int cind = Integer.parseInt(br.readLine());
                    st.change(newN,cind);
                    break;

                case 6:
                    System.out.println("\nSize : " +st.getSize());
                    break;

                case 7:
                    st.display();
                    break;

                case 8:
                    System.exit(0);
                    break;

            }
            System.out.print("\n\nContinue (Y/N) ? : ");
            cont = br.readLine().toUpperCase();
        }
        br.close();
    }
}

/*
PROGRAM OUTPUT
1. Push
2. Peek        
3. Pop
4. Peep        
5. Change      
6. Size        
7. Display     
8. Exit        


Enter choice : 1

Enter CD name to add : na


Continue (Y/N) ? : y

1. Push        
2. Peek        
3. Pop
4. Peep        
5. Change      
6. Size        
7. Display     
8. Exit        


Enter choice : 1

Enter CD name to add : qw


Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 1

Enter CD name to add : qwer


Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 2
Last CD added : qwer

Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 3

Removed CD : qwer

Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 4

Enter the index at which you want to peep : 2

CD : na

Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 7

Stack = qw na

Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 5

Enter new CD name :qq
Enter index at which you want to change :1

Element is change from qw to qq

Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 6

Size : 2


Continue (Y/N) ? : y

1. Push
2. Peek
3. Pop
4. Peep
5. Change
6. Size
7. Display
8. Exit


Enter choice : 7

Stack = qq na

Continue (Y/N) ? : n
*/
