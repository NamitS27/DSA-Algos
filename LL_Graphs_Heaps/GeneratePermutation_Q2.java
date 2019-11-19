
/*
Author : Namit Shah
*/

import java.util.Scanner;

class GeneratePermutation_Q2 {
    public static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int num = sc.nextInt();
        String strNum = String.valueOf(num);
        System.out.println("Permutations are : ");
        permute(strNum, 0, strNum.length() - 1);
        sc.close();
    }
}
/* 
OUTPUT 

Enter number : 125
Permutations are :
125
152
215
251
521
512
*/