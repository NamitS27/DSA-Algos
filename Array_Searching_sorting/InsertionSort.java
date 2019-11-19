import java.util.Arrays;
import java.util.Scanner;

class InsertionSort{

     public static void insertionSort(int[] arr){
        if(arr.length == 1) return;
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
     }

     public static void main(String args[]) {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter size of array : ");
         int len = sc.nextInt();
         int[] arr = new int[len];
         System.out.print("Enter array elements : ");
         for(int i=0;i<len;i++){
             arr[i] = sc.nextInt();
         }
         insertionSort(arr);
        //  for(int i=0;i<arr.length;i++){
        //      System.out.println(arr[i] + " ");
        //  }
        System.out.println("Sorted Array : " +Arrays.toString(arr));
        sc.close();
     }
}

/* OUTPUT
Enter size of array : 5
Enter array elements : 23 12 23 12 4
Sorted Array : [4, 12, 12, 23, 23]
*/