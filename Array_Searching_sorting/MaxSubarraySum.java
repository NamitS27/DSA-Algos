import java.util.Scanner;

class MaxSubarraySum{   // Question 12
    public static int maxSum(int[] arr) {  // kadane's algorithm
        int max_of_all = Integer.MIN_VALUE;
        int max_end = 0;
        for(int i=0;i<arr.length;i++){
            max_end += arr[i];   // iterating for every element and adding them
            if(max_of_all < max_end) max_of_all = max_end;   //  this thing maintain the maximum sum so far we have got
            if(max_end < 0) max_end = 0; // if the sum uptil now becomes < 0 then sum changes to 0
        }
        return max_of_all;  // this will have the value of maximum subarray sum`
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array : ");
        int size = sc.nextInt();
        System.out.print("Enter the elements : ");
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Max Subarray Sum : " + maxSum(arr));

        sc.close();
    }
}

/* OUTPUT
Enter the length of array : 10
Enter the elements : -2 -7 3 -4 5 -7 -9 16 13 -8 -3
Max Subarray Sum : 29
*/