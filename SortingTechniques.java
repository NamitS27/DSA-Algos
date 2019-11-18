import java.util.Arrays;
import java.util.*;

class SortingTechniques{
     
    static int bs=0,is=0,ss=0,qs=0;
    public static void bubblesort(int[] arr){  
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    bs++;
                    int temp = arr[j];   // swapping eleemnts
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
    }

    public static void selectionsort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[min]) {
                    ss++;
                    min = j;
                }
            }
            int temp = arr[min];    //swapping elements
            arr[min] = arr[i]; 
            arr[i] = temp; 
        }
    }

    public static void insertionsort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            int key = arr[i];    // key with which the element is compared
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                --j;
                is++;
            }
            arr[j+1] = key;
        }
    }

    public static int partition(int[] arr,int start,int end){
        int pvt =  arr[end];  // chosing pivot as the last element
        int i = start-1;
        for(int j = start;j<end;j++){
            if(arr[j] <= pvt){
                i++;
                qs++;
                int temp = arr[i];   // swapping 
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1]; // swapping
        arr[i+1] = arr[end]; 
        arr[end] = temp; 

        return i+1;
    }

    public static void quicksort(int[] arr,int start,int end){
        if(start < end){
            int parind = partition(arr,start,end);
            quicksort(arr, start, parind-1);
            quicksort(arr, parind+1, end);
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
        System.out.println("Enter heights of 10 students : ");
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = sc.nextInt();
        }

        long start,end;

        System.out.println("\nBubble sort : ");
        start = System.nanoTime();
        bubblesort(arr);
        System.out.println("No of Iterations : " +bs);
        System.out.println(Arrays.toString(arr));
        end = System.nanoTime();
        System.out.println("Time taken : " +(end-start) + " ns");

        shuffleArray(arr);
        System.out.println("\nInsertition sort : ");
        start = System.nanoTime();
        insertionsort(arr);
        System.out.println("No of Iterations : " +is);
        System.out.println(Arrays.toString(arr));
        end = System.nanoTime();
        System.out.println("Time taken : " +(end-start) + " ns");

        shuffleArray(arr);
        System.out.println("\nSelection sort : ");
        start = System.nanoTime();
        selectionsort(arr);
        System.out.println("No of Iterations : " +ss);
        System.out.println(Arrays.toString(arr));
        end = System.nanoTime();
        System.out.println("Time taken : " +(end-start) + " ns");

        shuffleArray(arr);
        System.out.println("\nQuick sort : ");
        start = System.nanoTime();
        quicksort(arr,0,arr.length-1);
        System.out.println("No of Iterations : " +qs);
        System.out.println(Arrays.toString(arr));
        end = System.nanoTime();
        System.out.println("Time taken : " +(end-start) + " ns");

        sc.close();
    }
    
}

/* OUTPUT
Enter heights of 10 students :
1 2 3 9 8 7 6 5 4 10

Bubble sort :
No of Iterations : 15
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Time taken : 729100 ns

Insertition sort :
No of Iterations : 12
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Time taken : 896500 ns

Selection sort :
No of Iterations : 11
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Time taken : 832600 ns

Quick sort :
No of Iterations : 7
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Time taken : 1033400 ns
*/