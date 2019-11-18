import java.util.Scanner;

class MatrixMultiplication{ // Question 10
    public static boolean multiply(int[][] A,int[][] B,int[][] C){
        boolean check = true;
        if(A[0].length == B.length){       // columns of A = rows of B
            check = true;               
            for(int i=0;i<A[0].length;i++){
                for(int j=0;j<B[0].length;j++){
                    C[i][j] = 0;
                    for(int k=0;k<C[0].length;k++){
                        C[i][j] += A[i][k] * B[k][j];   // multiplying elements by element
                    }
                }
            }
            return check;
        }
        else{
            System.out.println("\n\nCan't Multiply");
            return false;
        } 
    }

    static int i=0,j=0,k=0;
    public static void multiplyRecursive(int[][] A,int[][] B,int[][] C) {
        if(i >= A.length) return;
        if(j < B[0].length){
            if(k < A[0].length){
                C[i][j] += A[i][k] * B[k][j];  // multiplying element by element
                k++;
                multiplyRecursive(A, B, C);   // gives first column of C
            }
            k = 0;
            j++;
            multiplyRecursive(A, B, C);  // gives second column of C
        }
        j = 0;
        i++;
        multiplyRecursive(A, B, C);  // gives third column of C
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows of the matrix 1 : ");
        int rows = sc.nextInt();
        System.out.print("Enter the columns of matrix 1 : ");
        int columns = sc.nextInt();
        
        int[][] a = new int[rows][columns];
        System.out.println("\nEnter Matrix 1 : ");   // Matrix 1
        for(int i=0;i<rows;i++){ 
            for(int j=0;j<columns;j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.print("\n\nEnter the rows of matrix 2 : ");
        int rows1 = sc.nextInt();
        System.out.print("Enter the columns of matrix 2 : ");
        int columns1 = sc.nextInt();
        
        int[][] b = new int[rows1][columns1];
        System.out.println("\nEnter Matrix 2 : "); // Matrix 2
        for(int i=0;i<rows1;i++){
            for(int j=0;j<columns1;j++){
                b[i][j] = sc.nextInt();
            }
        }
        int[][] c = new int[rows][columns1];   // Ans matrix

        System.out.println("\n1. Matrix Multiplication (Iterative) ");  
        System.out.println("2. Matrix Multiplication (Recursive) ");
        System.out.print("Enter Choice : ");  // choice
        int choice = sc.nextInt();
        switch(choice){
            case 1:
            if(multiply(a, b, c)){
                System.out.println("\nMatrix after multiplication : ");
                for(int i=0;i<rows;i++){        // gives the output of the matrix after multiplied
                    for(int j=0;j<columns1;j++){
                        System.out.print(c[i][j]+ " ");
                    }
                    System.out.println();
                }
            }
            break;

            case 2:
            if(a[0].length == b.length){  // condition weather they can be multiplied or not
                multiplyRecursive(a, b, c);
                System.out.println("\nMatrix after multiplication : ");
                for(int i=0;i<rows;i++){        // gives the output of the matrix after multiplied
                    for(int j=0;j<columns1;j++){
                        System.out.print(c[i][j]+ " ");
                    }
                    System.out.println();
                }
            }
            else System.out.println("Multiplication Not Possible");
            break;

            case 3:
            System.out.println("Wrong Input");
            break;
        }
        
        sc.close();

    }
}

/* OUTPUT
Enter the rows of the matrix 1 : 3
Enter the columns of matrix 1 : 3

Enter Matrix 1 :
1 2 3
1 2 3
1 2 3


Enter the rows of matrix 2 : 3
Enter the columns of matrix 2 : 3

Enter Matrix 2 :
1 0 0
0 1 0
0 0 1

1. Matrix Multiplication (Iterative)
2. Matrix Multiplication (Recursive)
Enter Choice : 2

Matrix after multiplication :
1 2 3
1 2 3
1 2 3

---------------------------------

Enter the rows of the matrix 1 : 3
Enter the columns of matrix 1 : 3

Enter Matrix 1 :
1 2 3
1 2 3
1 2 3


Enter the rows of matrix 2 : 3
Enter the columns of matrix 2 : 3

Enter Matrix 2 :
1 0 0
0 1 0
0 0 1

1. Matrix Multiplication (Iterative)
2. Matrix Multiplication (Recursive)
Enter Choice : 1

Matrix after multiplication :
1 2 3
1 2 3
1 2 3
*/