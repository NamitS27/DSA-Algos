import java.util.Arrays;
import java.util.Scanner;

class CountingSort{  // Question 13
    public static int[] countSort(int[] arr,int max,int min) {
        int[] hash = new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]-min]++;      // hashing
        }
        for(int i=1;i<hash.length;i++){
            hash[i] += hash[i-1];   // forming prefix array
        }
        int[] sorted = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){   // sorting 
            sorted[hash[arr[i]-min]-1] = arr[i];
            hash[arr[i]-min]--;
        }
        return sorted;
    }

    public static void countSort2(int[] arr,int max,int min){
        int[] hash = new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]-min]++;    // hashing 
        }
        int ndx = 0;
        for(int i=0;i<hash.length;i++){
            if(hash[i]>0){
                while(hash[i]!=0){   // storing the element in its sorting index
                    arr[ndx] = i+min;
                    ndx++;
                    hash[i]--;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int s = sc.nextInt();
        int[] arr = new int[s];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<s;i++){
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);   // finding max. element 
            min = Math.min(min, arr[i]);   // finding min. element (in order to do sorting for )
        }
        int[] ans = countSort(arr, max, min);
        System.out.println("Counting Sort (Using Prefix Array) : "+Arrays.toString(ans));
        countSort2(arr, max , min);
        System.out.println("Counting Sort (Without Prefix Array) : " +Arrays.toString(arr));
        sc.close();
    }
}

/* OUTPUT
Enter size of array : 5
1 9 8 4 5
Counting Sort (Using Prefix Array) : [1, 4, 5, 8, 9]
Counting Sort (Without Prefix Array) : [1, 4, 5, 8, 9]
*/