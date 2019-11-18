import java.util.Scanner;

class MagicSquare{

    private static boolean checkMatrix(int[][] m){
        boolean check = false;
        int sum=0,sum1=0;
        if(m.length==m[0].length){              // condition to check wether rows and columns are same or not
            for(int i=0;i<m.length;i++){
                sum += m[i][i];                 // diagonal sum
            }
            int x = m.length-1;
            for(int i=0;i<m.length;i++){
                sum1 += m[x][i];                // diagonal sum
                x--;
            }
            boolean check2 = true,check3 = true;
            for(int i = 0;i<m.length;i++){
                int sum2 = 0;
                for(int j=0;j<m.length;j++){
                    sum2 += m[j][i];            // sum of every rows
                }
                if(sum2!=sum) check2 = false;   // checking that they are same or not
            }
            for(int i = 0;i<m.length;i++){
                int sum3 = 0;
                for(int j=0;j<m.length;j++){
                    sum3 += m[i][j];            // sum of every columns
                }
                if(sum3!=sum) check2 = false;  // checking that they are same or not
            }
            if(sum == sum1 && check2 && check3){ // if all conditions are true then it is a magic matrix
                check = true;
            }
        }
        else{
            check = false;
        }
        return check;
    }
public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows and columns : ");
        int n = sc.nextInt();
        
        int[][] m = new int[n][n];                     // for n x n matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m[i][j] = sc.nextInt();
            }
        }
        if(checkMatrix(m)){
            System.out.println("\nThe given matrix is magic square");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }
            
        }
        else{
            System.out.println("Matrix is not a magic square");
        }
        sc.close();
     
    }
}

/* OUTPUT
Enter no. of rows and columns :
3
1 2 3
4 5 6
7 8 9
Matrix is not a magic square
*/