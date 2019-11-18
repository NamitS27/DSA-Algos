import java.util.*;

class ArraySearch{

    private static void LinearSearch(int[] arr,int key){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                System.out.println("Element Found at index : " + i);  // print all elements when found at their index
                cnt++;
            }
        }
        if(cnt == 0) System.out.println("Element not found");
    }

    private static int recursiveLinearSearch(int[] arr,int startind,int endindex,int key){
        if(startind > endindex) return -1;                  // if not found then return -1 
        else if(arr[startind]==key) return startind;        // check with first element
        else if(arr[endindex]==key) return endindex;        // check with last element
        else return recursiveLinearSearch(arr, startind+1, endindex-1, key); // recursive call
    }

    private static int BBinarySearch(int[] arr,int key){ // input taken is as sorted array
        int lb = 0;
        int ub = arr.length-1;
        
        while(lb <= ub){
            int mid = (lb+ub)/2;  // finding middle element 
            if(key > arr[mid]){         // comparing that with the key
                lb = mid+1;
            }
            else if(key < arr[mid]){
                ub = mid-1;
            }
        
            if(key==arr[mid]) return mid+1;
        }
    return -1;    // if not found
}

private static int recursiveBinarySearch(int[] arr,int lb,int ub,int key){
    int mid = (lb + ub)/2; // calculate middle index
    if(arr[mid]==key) return mid+1;
    else if(lb>ub) return -1; // when not found
    else if(key > arr[mid]) return recursiveBinarySearch(arr, mid+1, ub, key);
    else return recursiveBinarySearch(arr, lb, mid-1, key);
}

private static void bubblesort(int[] arr,int n){
        if(n>1){
            boolean swapped = true;
            int j = 0;
            int temp;
            while(swapped){
                swapped = false;                // changing the swap value back to false (it will be true when all swaping is done)
                j++;
                for(int i=0;i<n-j;i++){
                    if(arr[i] > arr[i+1]){
                        temp = arr[i];              // swap elements
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                        swapped = true;
                    }
                }
            }
        }
}

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int x = sc.nextInt();
        int[] arr = new int[x];
        System.out.printf("Enter %d num : ",x);
        for(int i=0;i<x;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array : "+Arrays.toString(arr));

        System.out.println("Type of searching :- ");
        System.out.println("1. Linear Search");
        System.out.println("2. Recursive Linear Search");
        System.out.println("3. Binary Search");
        System.out.println("4. Recursive Binary Search");
        System.out.print("\nEnter Choice : ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
            System.out.print("Enter the element which you want to find : ");
            int key = sc.nextInt();
            LinearSearch(arr, key);
            break;

            case 2:
            System.out.print("Enter the element which you want to find : ");
            key = sc.nextInt();
            System.out.println("Element found at : " +recursiveLinearSearch(arr,0, arr.length-1, key));
            break;

            case 3:
            System.out.print("Enter the element which you want to find : ");
            key = sc.nextInt();
            bubblesort(arr, arr.length);
            if(BBinarySearch(arr, key)<0) System.out.println("Element not found");
            else System.out.println("Element found at index " + BBinarySearch(arr, key));
            break;

            case 4:
            System.out.print("Enter the element which you want to find : ");
            key = sc.nextInt();
            bubblesort(arr, arr.length);
            System.out.println("Element found at index " +recursiveBinarySearch(arr, 0, arr.length-1, key));
            break;

            default:
            System.out.println("Wrong Input");
            break;
        }
        
        sc.close();
    }
    
}

/* OUTPUT (ONE OF THE CASE)
Enter length of array : 6
Enter 6 num : 1 2 3 4 5 6
Array : [1, 2, 3, 4, 5, 6]
Type of searching :-
1. Linear Search
2. Recursive Linear Search
3. Binary Search
4. Recursive Binary Search

Enter Choice : 3
Enter the element which you want to find : 3
Element found at index 3
*/