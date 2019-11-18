/*
Author : Namit Shah AU1841067
Question : 2
Description : Stack of Messages
*/


import java.io.*;

class sStack{
    protected String arr[];
    protected int top, size, len;

    public sStack(int n){
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
        if(top + 1 >= size){
            System.out.print("Can't Add\n");
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

    public void display()
    {
        System.out.print("\nStack :  \n");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+"\n");
        System.out.println();
    }    
}

public class Q2_MessageStack{  // Question 2
    public static void main(String args[]) throws IOException {
        sStack st = new sStack(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initMessage = {"Hello","How are you ?","Everything Okay?","How is your life going","What about your studies?"};
        for(int i=0;i<initMessage.length;i++){
            st.push(initMessage[i]);
        } 
        System.out.print("Current Messages : \n");
        st.display();
        System.out.println("");
        int choice = 0;
        do{
            System.out.println("\n1. Write message");
            System.out.println("2. Display All Messages");
            System.out.println("3. Delete Messages");
            System.out.println("4. Exit");

            System.out.print("\nEnter choice : ");
            choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                    System.out.print("Enter new Message : ");
                    String newM = br.readLine();
                    st.push(newM);
                    break;

                case 2:
                    st.display();
                    break;
                
                case 3:
                    System.out.print("Popped Message : " + st.pop() + "\n"); 
                    break;
                
                case 4:
                    break;
            }
        }while(choice !=4);
        br.close();
    }

}

/* OUTPUT 
1. Write message
2. Display All Messages
3. Delete Messages     
4. Exit

Enter choice : 1
Enter new Message : Hii

1. Write message
2. Display All Messages
3. Delete Messages
4. Exit

Enter choice : 2

Stack :
Hii
What about your studies?
How is your life going
Everything Okay?
How are you ?
Hello


1. Write message
2. Display All Messages
3. Delete Messages
4. Exit

Enter choice : 3
Popped Message : Hii

1. Write message
2. Display All Messages
3. Delete Messages
4. Exit

Enter choice : 4
*/