import java.util.*;

class RadixSort{
    public static void bucketSort(int[] arr,int exp) {
        
        ArrayList<Integer>[] bucket = new ArrayList[10];  // 10 buckets (for radix sort : 0 --> 9);
        for(int i=0;i<10;i++){
            bucket[i] = new ArrayList<Integer>();   // declaring buckets
        }
        for(int i=0;i<arr.length;i++){
            int ind = (int)((arr[i]/exp)%10);
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

    public static void insertionsort(ArrayList<Integer> arr){ // Sorting algorithm
        for(int i=1;i<arr.size();i++){
            int j = i-1;
            int key = arr.get(i);
            while(j >= 0 && arr.get(j) > key){
                arr.set(j+1,arr.get(j)); // setting the element when greater than key
                --j;
            }
            arr.set(j+1, key);
        }
    }

    public static void radixSort(int[] arr) {
        int max = (Arrays.stream(arr).max().getAsInt());  // finds maximum element
        
        for(int exp = 1;max/exp > 0;exp *= 10){
            bucketSort(arr, exp);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int len = sc.nextInt();
        System.out.print("Enter array : ");
        int[] arr2 = new int[len] ; 
        for(int i = 0;i<len;i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println("Array : " +Arrays.toString(arr2));
        radixSort(arr2);
        System.out.println("Sorted Array : " +Arrays.toString(arr2));
        sc.close();
    }
}

/* OUTPUT
Enter size : 9
Enter array : 98 745 2356 12 10 8 2 74 456
Array : [98, 745, 2356, 12, 10, 8, 2, 74, 456]
Sorted Array : [2, 8, 10, 12, 74, 98, 456, 745, 2356]
*/