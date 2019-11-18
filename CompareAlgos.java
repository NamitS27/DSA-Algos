import java.util.Random;
import java.util.Scanner;

class CompareAlgos{  // Question 15
    public static void insertionsort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
        }
    }

    public static void Merge(int[] arr,int left,int mid,int right) {
        int n1 = mid-left+1;                           // size of left array
        int n2 = right-mid;                            // size of right array

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++)
            L[i] = arr[left+i];              // assigning elements to left array
        for(int i=0;i<n2;i++)               // assigning elements to right array
            R[i] = arr[mid+1+i];
        
        int i=0,j=0;
        int k = left;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){           // sorting them
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            } 
            k++;
        }

        // condition for the not using the sentinels
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
    
    public static void mergeSort(int[] arr,int left,int right) {
        if(left < right){
            int mid = (left+right)/2;   // finding the mid index
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            Merge(arr, left, mid, right);
        }
    }

    public static void shuffleArray(int[] arr) {
        Random rand = new Random();  
        for(int i=0;i<arr.length;i++){
            int j = rand.nextInt(arr.length); // To generate random number upto upper bound(here it is length of the array)
            int swap = arr[i];                // Swap two numbers
            arr[i] = arr[j];
            arr[j] = swap;
        }
    }

    public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            //System.out.print("Enter the size of array : ");
            int size = 1;
            double timediff = 0;
            
            while(timediff>=0){  // condition will become false when Merge Sort sorts the data faster than Insertion Sort
                int[] arr = new int[size];
                int[] arr2 = new int[size];
                Random rand = new Random();
                for(int i=0;i<size;i++){
                    arr[i] = arr2[i] = rand.nextInt(1000000000);    // produces random elements form 1<=ele<=10^9
                } 
                double start=0,end=0;
                start = System.nanoTime();
                mergeSort(arr, 0, arr.length-1);
                end = System.nanoTime();
                double timem = end-start;

                start = System.nanoTime();
                insertionsort(arr2);
                end = System.nanoTime();
                double timei = end-start;
                System.out.println("Size : " +size);
                System.out.println("Merge Sort : " +(timem)+" ns\n" + 
                                    "Insertion sort : "+(timei) + " ns");  // prints time of both sorting algos
                timediff = timem-timei;
                System.out.println("Difference : " +Math.abs(timediff) + " ns\n");
                size *= 2;  // doubing the size of array every time
            //sc.close();
        }
        sc.close();
    }
}

/* OUTPUT DEPENDS ON TWO THINGS
    --> Type of Data
    --> Processing Speed

    Will Produce different different output each time we run
*/

/* OUTPUT
Size : 1
Merge Sort : 2600.0 ns   
Insertion sort : 900.0 ns
Difference : 1700.0 ns

Size : 2
Merge Sort : 79200.0 ns   
Insertion sort : 1400.0 ns
Difference : 77800.0 ns   

Size : 4
Merge Sort : 9300.0 ns    
Insertion sort : 2800.0 ns
Difference : 6500.0 ns    

Size : 8
Merge Sort : 10200.0 ns
Insertion sort : 2500.0 ns
Difference : 7700.0 ns

Size : 16
Merge Sort : 34300.0 ns
Insertion sort : 4900.0 ns
Difference : 29400.0 ns

Size : 32
Merge Sort : 39200.0 ns
Insertion sort : 9600.0 ns
Difference : 29600.0 ns

Size : 64
Merge Sort : 244500.0 ns
Insertion sort : 64000.0 ns
Difference : 180500.0 ns

Size : 128
Merge Sort : 258400.0 ns
Insertion sort : 179600.0 ns
Difference : 78800.0 ns

Size : 256
Merge Sort : 136500.0 ns
Insertion sort : 758700.0 ns
Difference : 622200.0 ns
*/