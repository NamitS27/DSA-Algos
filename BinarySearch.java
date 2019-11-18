import java.util.Arrays;
import java.util.*;

class BinarySearch{  // Question 4
    private static int binarySearch(char[] arr,int key){
        int lb = 0;   // lower bound
        int ub = arr.length-1;  // upper bound
        int it = 0;
        while(lb <= ub){
        
        int mid = (lb+ub)/2;   // finding the mid index
        System.out.println("Iteration " + (it+1) + " : "  + arr[mid] + " compared with " + (char)key);
        if(key > arr[mid]){   // comparing if it key is greater than  arr(mid)
            lb = mid+1;
        }
        else if(key < arr[mid]){
            ub = mid-1;
        }
        if(key==arr[mid]) {
            System.out.println("Total Iterations : " +(it+1));  // No. of steps done to find the element
            return mid+1;
        }
        it++;
    }
    return -1;      // condition (if not found)
}

private static int recursiveBinarySearch(char[] arr,int lb,int ub,int key,int itt){
    int mid = (lb + ub)/2;     // getting the middle element
    if(arr[mid]==key) {
        System.out.println("Iteration " + (itt+1) + " : "  + arr[mid] + " compared with " + (char)key);
        System.out.println("Total Iterations : " +(itt+1));
        return mid+1;
    }
    else if(lb>ub) return -1;
    else if(key > arr[mid]) {
        System.out.println("Iteration " + (itt+1) + " : "  + arr[mid] + " compared with " + (char)key);
        return recursiveBinarySearch(arr, mid+1, ub, key,itt+1);
    }
    else{
        System.out.println("Iteration " + (itt+1) + " : "  + arr[mid] + " compared with " + (char)key);
        return recursiveBinarySearch(arr, lb, mid-1, key,itt+1);
    } 
}

public static void selectionsort(char[] arr){
    for(int i = 0;i<arr.length-1;i++){
        int min = i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j] < arr[min]) min = j;
        }
        char temp = arr[min];    //swapping elements
        arr[min] = arr[i]; 
        arr[i] = temp; 
    }
}

public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[] arr = {'B','I','N','A','R','Y'};
        //Arrays.sort(arr);
        System.out.println("String : "+Arrays.toString(arr));
        selectionsort(arr);
        
        System.out.println("Type of Search : ");          // choice for which algorithm for searching
        System.out.println("1. Iterative Binary Search");
        System.out.println("2. Recursive Binary Search");
        System.out.print("Enter Choice : ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                long start = System.nanoTime();
                System.out.println("A found at index : " + binarySearch(arr, 'A'));
                long end = System.nanoTime();
                System.out.println("Time taken : " +(end-start) + " ns");
                break;
            case 2:
                long sttart = System.nanoTime();
                System.out.println("A found at index : " +recursiveBinarySearch(arr, 0, arr.length-1, 'A', 0));
                long eend = System.nanoTime();
                System.out.println("Time taken : " +(eend-sttart) + " ns");
                break;

            default:
                System.out.println("wrong Input");
                break;
        }
        sc.close();
        
}

}

/* OUTPUT
String : [B, I, N, A, R, Y]
Type of Search :
1. Iterative Binary Search
2. Recursive Binary Search
Enter Choice : 1
Iteration 1 : I compared with A
Iteration 2 : A compared with A
Total Iterations : 2
A found at index : 1
Time taken : 1329100 ns

String : [B, I, N, A, R, Y]
Type of Search :
1. Iterative Binary Search
2. Recursive Binary Search
Enter Choice : 2
Iteration 1 : I compared with A
Iteration 2 : A compared with A
Total Iterations : 2
A found at index : 1
Time taken : 1301899 ns
*/