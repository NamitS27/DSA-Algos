import java.util.Scanner;

public class SelectionSort {
    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size: ");
        int length = in.nextInt();
        arr = new int[length];
        System.out.println("Enter elements: ");
        for (int i = 0; i < length; i++) {
            arr[i] = in.nextInt();
        }
        SelectionSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
