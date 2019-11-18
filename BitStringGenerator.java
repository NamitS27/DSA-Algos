import java.util.*;

class BitStringGenerator{  // Question 5

    public static void generateStrings(int n,int[] arr,int i){
        if(i==n){
            for(int j=0;j<n;j++){
                System.out.print(arr[j]);   // printing the bit string when the size of i is equal to n (length of bitstring)
            }
            System.out.println();
            return;
        }
        arr[i] = 0;
        generateStrings(n, arr, i+1);     // this will assign 0 to the array and recursive call will be done
        arr[i] = 1;
        generateStrings(n, arr, i+1);
    }

    public static void generateStringsk(int n,int k,int size,int[] arrn){
        if(n<1){
            for(int j=0;j<size;j++){
                System.out.print(arrn[j]);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<k;i++){
            arrn[n-1] = i;
            generateStringsk(n-1,k,size,arrn);  // generating all strings of length n from num 0 to k-1
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of bit string : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        generateStrings(n, arr, 0);
        System.out.println("Enter the length of the bit string (n) you want to have and number of bits form 1 to k-1 (k)  and n <= k : ");
        int nnew = sc.nextInt();
        int k = sc.nextInt();
        int[] arrn = new int[k];
        if(nnew<=k) generateStringsk(nnew,k,nnew, arrn);
        else System.out.println("Wrong Inputn\n");
        sc.close();
    }
}

/* OUTPUT
Enter length of bit string :
2
00
01
10
11
Enter the length of the bit string (n) you want to have and number of bits form 1 to k-1 (k)  and n <= k :
2 3
00
10
20
01
11
21
02
12
22
*/