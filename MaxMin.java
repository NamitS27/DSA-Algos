import java.util.*;

class MaxMin{  // Question 18

    public static int getMax(int[] arr,int lb,int ub) {
        int max = Integer.MIN_VALUE;
        ub = Math.min(ub, arr.length);  // when the upper bound exceed len(array)
        for(int i=lb;i<ub;i++){
            max = Math.max(max, arr[i]);  // finds maximum element from the given array
        }
        return max;
    }

    public static int getMin(int[] arr,int lb,int ub) {
        int min = Integer.MAX_VALUE;
        ub = Math.min(ub, arr.length);  // when the upper bound exceed len(array)
        for(int i=lb;i<ub;i++){
            min = Math.min(min, arr[i]);  // finds the minimum element from the given array
        }
        return min;
    }


    public static String findPartsMax(int[] arr,int parts) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i+= parts){
            max = Math.max(max, getMax(arr,i,i+parts));  // does parts and finds the max. element
            min = Math.min(min, getMin(arr,i,i+parts));  // does parts and finds the min. element
        }
        return "Maximum : "+ max + "\nMinimum : " +min;
    }

    public static String findMax_Even_Odd(int[] arr) {
        int evenmax = Integer.MIN_VALUE;
        int oddmax = Integer.MIN_VALUE;
        int evenmin = Integer.MAX_VALUE;
        int oddmin = Integer.MAX_VALUE;
        int max=0,min=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                evenmax = Math.max(evenmax, arr[i]);   // maximum of even elements of the array
                evenmin = Math.min(evenmin, arr[i]);   // minimum of even elements of the array
            }
            else{
                oddmax = Math.max(oddmax, arr[i]);     // maximum of odd elements of the array
                oddmin = Math.min(oddmin, arr[i]);     // minimum of odd elements of the array
            }
        }
        max = Math.max(evenmax, oddmax);   // maximum of whole array
        min = Math.min(oddmax, oddmin);    // minimum of whole array

        return "Maximum : " +max + "\nMinimun : "+min;

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter elements : ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array : " +Arrays.toString(arr));
        System.out.println("1. Find Max & Min by parts");
        System.out.println("2. Find Max & Min by odd..even array");
        System.out.print("Enter choice : ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
            System.out.print("Enter parts : ");
            int prts = sc.nextInt();   // number of parts in oreder to divide the given array
            if(prts < arr.length && prts > 0) System.out.println(findPartsMax(arr, prts));
            else System.out.print("Wrong Input \n");
            break;

            case 2:
            System.out.println(findMax_Even_Odd(arr));
            break;

            default:
            System.out.println("wrong input");
            break;
        }
        sc.close();
    }
}

/* OUTPUT
Enter size : 5
Enter elements :
1 2 3 4 5
Array : [1, 2, 3, 4, 5]
1. Find Max & Min by parts
2. Find Max & Min by odd..even array
Enter choice : 2
Maximum : 5
Minimun : 1


Enter size : 5
Enter elements :
1 2 3 3 4
Array : [1, 2, 3, 3, 4]
1. Find Max & Min by parts
2. Find Max & Min by odd..even array
Enter choice : 1
Enter parts : 3
Maximum : 4
Minimum : 1
*/