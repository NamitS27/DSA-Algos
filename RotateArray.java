import java.util.Arrays;
import java.util.Scanner;

class RotateArray{   // Question 9

    public static void rotateArray(int[] arr,int d) {
        if(d==0) return;
        else if(d<0){       // reverse whole array at start
            d = -d;         // converting neg. to pos.
            if(d>arr.length) d = d%arr.length;
            reverseArray(arr,0,arr.length-1);      // reverse the array
            reverseArray(arr,0,d-1);         // reverse the array from starting to len(arr) - (rotation num) - 1
            reverseArray(arr,d,arr.length-1); // reverse the array left
        }
        else{               // reverse whole array at end
            if(d>arr.length) d = d%arr.length;      // to minimize rotations
            reverseArray(arr,0,d-1);
            reverseArray(arr,d,arr.length-1);
            reverseArray(arr,0,arr.length-1);
        }
    }

    public static void reverseArray(int[] arr,int l,int r) {
        while(l<r){
            int temp = arr[l];  // swaping two elements
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];  // given array
        System.out.print("Enter Array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array : " +Arrays.toString(arr));
        System.out.print("Enter Rotation Value : ");
        int d = sc.nextInt();
        rotateArray(arr, d);
        System.out.println("Rotated Array after " + Math.abs(d) +" rotations : "+Arrays.toString(arr));
        sc.close();
    }
}

/* OUTPUT
Array : [2, 4, 5, 7, 9, 11, 14, 17]
Enter Rotation Value : 45
Rotated Array after 45 rotations : [7, 9, 11, 14, 17, 2, 4, 5]
*/