import java.util.Arrays;
import java.util.Scanner;

class LinearSearch{     // Question 3

    private static void linearSearch(char[] arr,char key){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            System.out.println("Iteration " + (i+1) + " : "  + arr[i] + " compared with " + key);
            if(arr[i]==key){                // checking wether we found the element or not
                System.out.println("Element Found at index : " + i);   // printing the index of the element which we need to found
                cnt++;
                System.out.println("Total Iterations : " + i); // printing the number ofiterations done before finding the element
                break;
            }
            
        }
        if(cnt == 0) System.out.println("Element not found");
    }

    private static int recursiveLinearSearch(char[] arr,int startind,int endindex,char key,int it){
        System.out.println("Iteration " + (it+1) + " : "  + arr[startind] + " and " + arr[endindex] + " compared with " + key); // printing what is compared with what
        if(startind > endindex) return -1;
        else if(arr[startind]==key) {   // comparing with staring index
            System.out.println("Total Iterations : " + (it+1));
            return startind;
        }
        else if(arr[endindex]==key) {  // comparing with the ending index
            System.out.println("Total Iterations : " + (it+1));
            return endindex;
        }
        else return recursiveLinearSearch(arr, startind+1, endindex-1, key,it+1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[] arr = {'L','I','N','E','A','R'};
        System.out.println("Array : " +Arrays.toString(arr));
        System.out.println("Type of Search : ");
        System.out.println("1. Iterative Linear Search");
        System.out.println("2. Recursive Linear Search");
        System.out.print("Enter Choice : ");      // giving choice which algorithm to choose
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                long start = System.nanoTime();
                linearSearch(arr,'A');
                long end = System.nanoTime();
                System.out.println("Time taken : " +(end-start) + " ns");   // printing the time taken to find the element in nano seconds 
                break;
            case 2:
                long sttart = System.nanoTime();
                System.out.println("A found at index : " +recursiveLinearSearch(arr, 0, arr.length-1, 'A', 0));
                long eend = System.nanoTime();
                System.out.println("Time taken : " +(eend-sttart) + " ns"); // printing the time taken to find the element in nano seconds 
                break;

            default:
                System.out.println("wrong Input");
                break;
        }
        sc.close();
    }
}

/* OUTPUT
Array : [L, I, N, E, A, R]
Type of Search :
1. Iterative Linear Search
2. Recursive Linear Search
Enter Choice : 2
Iteration 1 : L and R compared with A
Iteration 2 : I and A compared with A
Total Iterations : 2
A found at index : 4
Time taken : 1347500 ns



Array : [L, I, N, E, A, R]
Type of Search :
1. Iterative Linear Search
2. Recursive Linear Search
Enter Choice : 1
Iteration 1 : L compared with A
Iteration 2 : I compared with A
Iteration 3 : N compared with A
Iteration 4 : E compared with A
Iteration 5 : A compared with A
Element Found at index : 4
Total Iterations : 4
Time taken : 2170000 ns

*/