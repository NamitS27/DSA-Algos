import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class ShuffleArray{
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
        System.out.print("Enter Size : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " +size +" elements for array you want to shuffle : ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        shuffleArray(arr);
        System.out.println("Shuffled Array : " +Arrays.toString(arr));
        sc.close();
    }
}


/* OUTPUT
Enter Size : 5
Enter 5 elements for array you want to shuffle :
1 2 3 4 5
Shuffled Array : [3, 4, 2, 1, 5]
*/