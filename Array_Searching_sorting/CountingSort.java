import java.util.*;

class CountingSort{

    public static void countSort(int[] arr,int max,int min){
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
       
        countSort(arr, max , min);
        System.out.println("Counting Sort (Without Prefix Array) : " +Arrays.toString(arr));
        sc.close();
    }
}

/* OUTPUT
Enter size of array : 7
9 5 8 7 6 4 1
Counting Sort (Without Prefix Array) : [1, 4, 5, 6, 7, 8, 9]
*/