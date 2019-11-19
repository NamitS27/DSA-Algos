import java.util.*;

class QuickSort{
    public static int partition(int[] arr,int start,int end){
        int pvt =  arr[end];   // choosing last element as pivot element
        int i = start-1;
        for(int j = start;j<end;j++){
            if(arr[j] <= pvt){
                i++;
                int temp = arr[i]; // swaping elements
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];  // swapping elements
        arr[i+1] = arr[end]; 
        arr[end] = temp; 

        return i+1;
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start < end){
            int parind = partition(arr,start,end);
            quickSort(arr, start, parind-1);        // recursive call to change pivots for new array to get sorted 
            quickSort(arr, parind+1, end);
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
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array : "+Arrays.toString(arr));
        sc.close();
    }
}

/* OUTPUT
Enter size of array : 5
Enter array elements : 87 125 14 7 3
Sorted Array : [3, 7, 14, 87, 125]
*/