import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Bucket_RadixSort{   // Question 14
    public static void bucketSort(double[] arr) {
        
        ArrayList<Double>[] bucket = new ArrayList[arr.length];  // buckets for input 0.00 to 1.00;
        for(int i=0;i<arr.length;i++){
            bucket[i] = new ArrayList<Double>();   // declaring buckets
        }
        for(int i=0;i<arr.length;i++){
            int ind = (int)arr[i]*arr.length;
            bucket[ind].add(arr[i]);   // filling buckets
        } 
        for(int i=0;i<arr.length;i++){
            insertionsort(bucket[i]);   // sorting buckets using insertion sort
        }
        int ndx = 0;
        for(int i=0;i<bucket.length;i++){
            for(int j=0;j<bucket[i].size();j++){
                arr[ndx++] = bucket[i].get(j);   // adding the element into original array to its perfect pos.
            }
        }
    }

    public static void insertionsort(ArrayList<Double> arr){ // Sorting algorithm
        for(int i=1;i<arr.size();i++){
            int j = i-1;
            double key = arr.get(i);
            while(j >= 0 && arr.get(j) > key){
                arr.set(j+1,arr.get(j)); // setting the element when greater than key
                --j;
            }
            arr.set(j+1, key);
        }
    }

    public static void countSort(int[] arr,int exp,int min) {  // count sort
        
        int[] ans = new int[arr.length];
        int[] hash = new int[10];
        Arrays.fill(hash,0);
        for(int i=0;i<arr.length;i++){
            hash[((arr[i]-min)/exp)%10]++;   // hashing
        }
        for(int i=1;i<10;i++){
            hash[i] += hash[i-1];  // prefix array 
        }
        for(int i=arr.length-1;i>=0;i--){
            ans[hash[((arr[i]-min)/exp)%10]-1] = arr[i];
            hash[((arr[i]-min)/exp)%10]--;
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = ans[i];
        }
    }

    public static void radixSort(int[] arr) {
        int max = (Arrays.stream(arr).max().getAsInt());  // finds maximum element
        int min = (Arrays.stream(arr).min().getAsInt()); // finds  minimum element
        for(int exp = 1;max/exp > 0;exp *= 10){
            countSort(arr, exp,min);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bucket Sort :- \n");
        System.out.print("Enter size : ");
        int size = sc.nextInt();
        System.out.print("Enter elements (0.00 <= ele < 1.00): ");
        double[] arr =  new double[size]; //{0.832 , 0.158 , 0.2456 , 0.123 , 0.987 , 0.456 , 0.67};
        boolean check = true;
        for(int i = 0;i<size;i++){
            arr[i] = sc.nextDouble();
            if(arr[i]<0 || arr[i] >=1) check = false;
        }
        System.out.println("Array : " +Arrays.toString(arr));
        if(check){
            bucketSort(arr);
            System.out.println("Sorted Array using Bucket Sort : " +Arrays.toString(arr));
        }
        else System.out.println("Wrong Input");
        
        System.out.println("\nRadix Sort :- \n");
        System.out.print("Enter size : ");
        int len = sc.nextInt();
        int[] arr2 = new int[len] ; //{170, 45, 75, 90, 802, 24, 2, 66}; 
        for(int i = 0;i<len;i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println("Array : " +Arrays.toString(arr2));
        radixSort(arr2);
        System.out.println("Sorted Array using Radix Sort : " +Arrays.toString(arr2));
        sc.close();
    }
}

/*OUTPUT
Bucket Sort :-

Enter size : 5
Enter elements (0.00 <= ele < 1.00): 0 0.1 0.2 0.5 0.4
Array : [0.0, 0.1, 0.2, 0.5, 0.4]
Sorted Array using Bucket Sort : [0.0, 0.1, 0.2, 0.4, 0.5]

Radix Sort :-

Enter size : 5
1 2 6 4 3
Array : [1, 2, 6, 4, 3]
Sorted Array using Radix Sort : [1, 2, 3, 4, 6]
*/