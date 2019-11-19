import java.util.*;

class ArrayOperation{

    public static String toStringOwn(int[] v,int length)  // defined just that the array printed is readable
    {
        if (v == null) return "null";
        StringBuilder b = new StringBuilder("[");   // declaring string builder which helps in appending
        for (int i = 0; i < length; ++i) {
            if (i > 0) b.append(", ");              // appending ", " to seperate elements
            b.append(v[i]);
        }
        b.append("]");
        return b.toString();
   }

    public static int[] insert(int[] arr,int element,int ind){
        
        int[] arrnew = new int[arr.length+1];
        for(int i=0;i<ind;i++){
            arrnew[i] = arr[i];
        }
        for(int i=ind+1;i<arr.length+1;i++){
            arrnew[i] = arr[i-1];        // shifting elements
        }
        arrnew[ind] = element;
        return arrnew;
    }

    public static int[] update(int[] arr,int element,int ind){
        arr[ind] = element;         // updates the element for the provided index
        return arr;
    }

    public static int removeElements(int[] arr,int length, int key) 
    {
          int index = 0; 
          for (int i=0; i<length; i++) 
             if (arr[i] != key) 
                arr[index++] = arr[i]; 

         return index;  // returns the index of the array upto which we need to display the array
    } 


    public static int removeMaxFrequency(int[] arr,int max){
        int[] arr1 = new int[max+1];
        for(int i=0;i<arr.length;i++){
            arr1[arr[i]]++;            // hashing array
        }
        int m = 0;
        for(int i=0;i<arr1.length;i++){
            m = Math.max(arr1[i],m);        // finding max freq.
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==m){
                a.add(i);               // storing the element whose freq. is max.
            }
        }
        int finalsize = arr.length;
        for(int i=0;i<a.size();i++){
            finalsize = removeElements(arr,finalsize, a.get(i)); // removing elements by updating length
        }
        return finalsize;
    }

    

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int x = sc.nextInt();
        int[] arr = new int[x];
        System.out.print("Enter " +x+ " numbers : ");
        int maximumelement = 0;
        for(int i=0;i<x;i++){
            arr[i] = sc.nextInt();
            maximumelement = Math.max(arr[i], maximumelement);
        }

        System.out.println("Array : " +Arrays.toString(arr));  // to print original array

        System.out.println("Enter your choice : "); // this runs for one time only
        System.out.println("1. Insert Element");
        System.out.println("2. Update Element");
        System.out.println("3. Delete Element for the given key");
        System.out.println("4. Delete Element having maximum Frequency");
        System.out.print("\nEnter your choice : ");
        int choice = sc.nextInt();              // giving choice what to choose
        switch(choice){
            case 1:
                System.out.print("Enter the element you want to insert : ");
                int newEle = sc.nextInt();
                System.out.print("Enter the index at which you want to insert : ");
                int newInd = sc.nextInt();
                int[] arrn = insert(arr, newEle, newInd);
                System.out.println("\nNew Array : " +toStringOwn(arrn, arrn.length));
                break;

            case 2:
                System.out.print("Enter the new element for update : ");
                int upEle = sc.nextInt();
                System.out.print("Enter the index at which you want to update : ");
                int upInd = sc.nextInt();
                int[] arru = update(arr, upEle, upInd);
                System.out.println("\nNew Array : " +toStringOwn(arru, arru.length));
                break;

            case 3:
                System.out.print("Enter the element you want to delete : ");
                int delEl = sc.nextInt();
                int newin = removeElements(arr, arr.length, delEl);
                System.out.print("\nNew Array : " +toStringOwn(arr,newin));
                break;

            case 4:
                int size = removeMaxFrequency(arr,maximumelement);
                System.out.println("\nNew Array : " +toStringOwn(arr, size));
                break;

            default:
                System.out.println("Wrong Input");
                break;
        }
        sc.close();
        
    }
}

/* OUTPUT (ONE OF THE CASE)
Enter length of array : 8
Enter 8 numbers : 1 2 2 3 3 4 4 4
Array : [1, 2, 2, 3, 3, 4, 4, 4]
Enter your choice :
1. Insert Element
2. Update Element
3. Delete Element for the given key
4. Delete Element having maximum Frequency

Enter your choice : 4

New Array : [1, 2, 2, 3, 3]
*/