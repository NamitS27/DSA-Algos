/* 
Name : Namit Shah AU1841067
Question : 3
Description : Cleaning of the the dirty plates
*/


import java.util.Scanner;

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
        System.out.print("Plates = ");
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

class Q3_CleanPlates{ // Question 3
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack dirtyPlates = new Stack(100);
        Stack cleanedPlates = new Stack(100);
        int choice  = 0;
        int i=1;
        do{
            System.out.println("\n1. Add Dirty Plate");
            System.out.println("2. Clean Plate");
            System.out.println("3. Display Dirty Plates");
            System.out.println("4. Display Cleaned Plates");
            System.out.println("5. Done");

            System.out.print("\nEnter choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nDirty Plate added\n");
                    dirtyPlates.push(i++);                
                    break;
                
                case 2:
                    int temp = dirtyPlates.pop(); 
                    System.out.print("\nPlate " + temp + " is cleaned\n");
                    cleanedPlates.push(temp);
                    break;

                case 3:
                    System.out.print("Dirty ");
                    dirtyPlates.display();
                    break;
                
                case 4:
                    System.out.print("Cleaned ");
                    cleanedPlates.display();
                    break;

                default:
                    break;
            }

        }while(choice<5 && choice >=1);
        sc.close();
    }
}

/* OUTPUT 
1. Add Dirty Plate
2. Clean Plate
3. Display Dirty Plates  
4. Display Cleaned Plates
5. Done

Enter choice : 1

Dirty Plate added        

1. Add Dirty Plate       
2. Clean Plate
3. Display Dirty Plates  
4. Display Cleaned Plates
5. Done

Enter choice : 1

Dirty Plate added        

1. Add Dirty Plate       
2. Clean Plate
3. Display Dirty Plates  
4. Display Cleaned Plates
5. Done

Enter choice : 1

Dirty Plate added 

1. Add Dirty Plate
2. Clean Plate
3. Display Dirty Plates
4. Display Cleaned Plates
5. Done

Enter choice : 2

Plate 3 is cleaned

1. Add Dirty Plate
2. Clean Plate
3. Display Dirty Plates
4. Display Cleaned Plates
5. Done

Enter choice : 2

Plate 2 is cleaned

1. Add Dirty Plate
2. Clean Plate
3. Display Dirty Plates
4. Display Cleaned Plates
5. Done

Enter choice : 3
Dirty Plates = 1

1. Add Dirty Plate
2. Clean Plate
3. Display Dirty Plates
4. Display Cleaned Plates
5. Done

Enter choice : 4
Cleaned Plates = 2 3

1. Add Dirty Plate
2. Clean Plate
3. Display Dirty Plates
4. Display Cleaned Plates
5. Done

Enter choice : 5

*/