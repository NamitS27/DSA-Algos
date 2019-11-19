import java.util.Scanner;

class CheckSorting{  // Question 8

    public static boolean checkArray(int[] arr){
        boolean sort = true;   // boolean variable to check wether any element after an element is greater or nor
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1] < arr[i]) { 
                sort = false;  // if next element is smaller then break and declare array is not sorted
                break;
            }
        }
        return sort;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);    
        System.out.print("Enter number of elements of the array for which you want to check : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the numbers : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        if(checkArray(arr)) System.out.println("Array is sorted");
        else System.out.println("Array is not sorted");
        sc.close();
    }
}

/* FORMAL DEFINATION : The array is sorted means that the next element is 
                       greater than or equal to the current element.

    LOOP INVARIANT : For an index j , the array before that index is sorted.
                --> Before the first execution we consider the a single element is always sorted
                    which is always true
                --> Whenever the next element is less than current element then the 
                    loop will break stating that array is not sorted... if the loop doesn't break 
                    and runs this size(arr)-1 then it means that no next element is less than
                    current element stating that the array is sorted.
                --> Hence the array is sorted and the correctness of algorithm is proved.
*/

/* OUTPUT
Enter number of elements of the array for which you want to check : 6
Enter the numbers : 1 2 3 4 5 6
Array is sorted
*/