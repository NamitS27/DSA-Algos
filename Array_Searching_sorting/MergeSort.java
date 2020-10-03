import java.util.Scanner;

public class MergeSort {
    public static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[q + j + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
        }

    }

    public static void mergeSort(int[] arr, int p, int r) {
        if(p < r) {
            int q = (p + r)/2;
            mergeSort(arr, p, q);
            mergeSort(arr, q+1, r);
            merge(arr, p, q, r);
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
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
