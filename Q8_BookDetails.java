/* 
Name : Namit Shah AU1841067
Question : 8
Description : Storing book details into stack
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class details{
    String name,author;
    int pgs,ed;
    float price;

    public details(String name, String author, int pgs, int ed, float price) {
        this.name = name;
        this.author = author;
        this.pgs = pgs;
        this.ed = ed;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n------------------------------------\n" +
                "Name : " + name +
                "\nAuthor : " + author +
                "\nPages : " + pgs +
                "\nEdition : " + ed +
                "\nPrice : " + price +
                "\n------------------------------------\n";
    }
}

class oStack{
    details arr[];
    int top;
    int size;
    int len;

    public  oStack(int n){
        size = n;
        len = 0;
        arr = new details[n];
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
        return arr[top].toString();
    }

    public void push(details i){
        if(top + 1 >= size){
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
        return arr[top--].toString();
    }

    public void display()
    {
        System.out.print("\nStack = \n");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i].toString()+"\n");
        System.out.println();
    }
}

public class Q8_BookDetails {   // Question 8
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        oStack st = new oStack(5);
        int loop = 0;
        while(loop!=5){
            System.out.print("Enter name of the book : ");
            String name = br.readLine();
            System.out.print("Enter author of the book : ");
            String author = br.readLine();
            System.out.print("Enter edition of the book : ");
            int edi = Integer.parseInt(br.readLine());
            System.out.print("Enter total number of pages : ");
            int pgs = Integer.parseInt(br.readLine());
            System.out.print("Enter price of the book : ");
            float price  = Float.parseFloat(br.readLine());
            st.push(new details(name,author,edi,pgs,price));
            loop++;
            System.out.print("\n----------------------------------------------------------------\n");
        }
        System.out.println("Recent detail : ");
        System.out.println(st.peek());
        System.out.println("Deleted details");
        System.out.println(st.pop());
        System.out.println(st.pop());

        System.out.println("Remaining Details : ");
        st.display();

        br.close();
    }
}

/*
PROGRAM OUTPUT
Enter name of the book : a
Enter author of the book : a
Enter edition of the book : 1
Enter total number of pages : 1
Enter price of the book : 1

----------------------------------------------------------------
Enter name of the book : b
Enter author of the book : b
Enter edition of the book : 2
Enter total number of pages : 2
Enter price of the book : 2

----------------------------------------------------------------
Enter name of the book : c
Enter author of the book : c
Enter edition of the book : 3
Enter total number of pages : 3
Enter price of the book : 3

----------------------------------------------------------------
Enter name of the book : d
Enter author of the book : d
Enter edition of the book : 4
Enter total number of pages : 4
Enter price of the book : 4

----------------------------------------------------------------
Enter name of the book : e
Enter author of the book : e
Enter edition of the book : 5
Enter total number of pages : 5
Enter price of the book : 5

----------------------------------------------------------------
Recent detail :

------------------------------------
Name : e
Author : e
Pages : 5
Edition : 5
Price : 5.0
------------------------------------

Deleted details

------------------------------------
Name : e
Author : e
Pages : 5
Edition : 5
Price : 5.0
------------------------------------


------------------------------------
Name : d
Author : d
Pages : 4
Edition : 4
Price : 4.0
------------------------------------

Remaining Details :

Stack =

------------------------------------
Name : c
Author : c
Pages : 3
Edition : 3
Price : 3.0
------------------------------------


------------------------------------
Name : b
Author : b
Pages : 2
Edition : 2
Price : 2.0
------------------------------------


------------------------------------
Name : a
Author : a
Pages : 1
Edition : 1
Price : 1.0
------------------------------------
*/
