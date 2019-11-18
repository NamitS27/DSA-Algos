import java.util.Scanner;

class StrassenMatrixMultiplication{  // Question 11
    
    public static int[][] StrassensMatrix(int[][] A,int[][] B) {
        int n = A.length;

        int[][] out = new int[n][n];

        if(n==1){
            out[0][0] = A[0][0] * B[0][0];
            return out;
        }

        int[][] a = new int[n/2][n/2];
        int[][] b = new int[n/2][n/2];
        int[][] c = new int[n/2][n/2];
        int[][] d = new int[n/2][n/2];

        int[][] e = new int[n/2][n/2];
        int[][] f = new int[n/2][n/2];
        int[][] g = new int[n/2][n/2];
        int[][] h = new int[n/2][n/2];

        divideMatrix(A, a , 0 , 0);
        divideMatrix(A, b, 0, n/2);
        divideMatrix(A, c, n/2, 0);
        divideMatrix(A, d, n/2, n/2);

        divideMatrix(B, e , 0 , 0);
        divideMatrix(B, f, 0, n/2);
        divideMatrix(B, g, n/2, 0);
        divideMatrix(B, h, n/2, n/2);

        int[][] p1 = StrassensMatrix(a,subMatrix(f, h));
        int[][] p2 = StrassensMatrix(addMatrix(a, b),h);
        int[][] p3 = StrassensMatrix(addMatrix(c, d),e);
        int[][] p4 = StrassensMatrix(d,subMatrix(g, e));
        int[][] p5 = StrassensMatrix(addMatrix(a, d),addMatrix(e, h));
        int[][] p6 = StrassensMatrix(subMatrix(b, d),addMatrix(g, h));
        int[][] p7 = StrassensMatrix(subMatrix(a, c),addMatrix(e, f));

        int[][] C11 = subMatrix(addMatrix(p5, p4), subMatrix(p2, p6));
        int[][] C12 = addMatrix(p1, p2);
        int[][] C21 = addMatrix(p3, p4);
        int[][] C22 = subMatrix(addMatrix(p1, p5), addMatrix(p3, p7));

        copyMatrix(C11, out, 0, 0);
        copyMatrix(C12, out, 0, n/2);
        copyMatrix(C21, out, n/2, 0);
        copyMatrix(C22, out, n/2, n/2);

        return out;
    }

    public static void divideMatrix(int[][] A,int[][] B,int r,int c) {
        for(int i=0;i<B.length;i++){
            for(int j=0;j<B.length;j++){
                B[i][j] = A[r++][c++];
            }
        }
    }

    public static void copyMatrix(int[][] A,int[][] B,int r,int c) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                B[r++][c++] = A[i][j];
            }
        }
    }



    public static int[][] addMatrix(int[][] A,int[][] B) {
        int[][] ans = new int[A.length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                ans[i][j] = A[i][j] + B[i][j];
            }
        }
        return ans;
    }

    public static int[][] subMatrix(int[][] A,int[][] B) {
        int[][] ans = new int[A.length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                ans[i][j] = A[i][j] - B[i][j];
            }
        }
        return ans;
    }

    public static void printMatrix(int[][] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order of matrix (Power of 2) : ");
        int n = sc.nextInt();
        
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        System.out.println("Enter the elements of matrix 1: ");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of matrix 2: ");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }
        int[][] result = StrassensMatrix(matrix1, matrix2);
        printMatrix(result);
        sc.close();


    }
}