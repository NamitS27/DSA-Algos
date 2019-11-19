
/*
Author : Namit Shah
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class kthSmallLarge_Q3{
    public static int findSmallest(Integer[] arr,int k) {
        Arrays.sort(arr);
        return arr[k-1];
    }

    public static int findLargest(Integer[] arr,int k) {
        Arrays.sort(arr,Collections.reverseOrder());
        return arr[k-1];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int len = sc.nextInt();
        Integer arr[] = new Integer[len];
        System.out.print("Enter array : ");
        for(int i=0;i<len;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("1. Find kth largest");
        System.out.print("\n2. Find kth smallest\n");
        System.out.print("Enter choice : ");
        int choice = sc.nextInt();
        if(choice==1){
            System.out.print("Enter k : ");
            int k = sc.nextInt();
            if(k==1) System.out.print(k + "st largest number is " +findLargest(arr, k));
            else if(k==2) System.out.print(k + "nd largest number is " +findLargest(arr, k));
            else if(k==3) System.out.print(k + "rd largest number is " +findLargest(arr, k));
            else System.out.print(k + "th largest number is " +findLargest(arr, k));
        }
        else if(choice==2){
            System.out.print("Enter k : ");
            int k = sc.nextInt();
            if(k==1) System.out.print(k + "st smallest number is " +findSmallest(arr, k));
            else if(k==2) System.out.print(k + "nd smallest number is " +findSmallest(arr, k));
            else if(k==3) System.out.print(k + "rd smallest number is " +findSmallest(arr, k));
            else System.out.print(k + "th smallest number is " +findSmallest(arr, k));
        }
        else{
            System.out.print("Wrong input");
        }
        sc.close();
    }
}

/* OUTPUT 
Enter length of array : 5
Enter array : 7 8 9 4 5
1. Find kth largest
2. Find kth smallest
Enter choice : 2
Enter k : 3
3rd smallest number is 7
*/