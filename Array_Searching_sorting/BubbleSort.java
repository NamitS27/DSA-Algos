import java.util.*;

class BubbleSort{

    public static void bubbleSort(int[] arr){
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    arr[j] ^= arr[j+1];     // swapping elements using bitwise xor
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
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
        bubbleSort(arr);
        System.out.println("Sorted Array : " +Arrays.toString(arr));
        sc.close();
    }
}

/* OUTPUT
Enter size of array : 9
Enter array elements : 87 65 34 21 12 1 3 90 8
Sorted Array : [1, 3, 8, 12, 21, 34, 65, 87, 90]
*/