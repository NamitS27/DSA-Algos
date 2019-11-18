import java.util.Arrays;
import java.util.Scanner;

class DeleteElement{  // Question 2

    public static String toStringOwn(double[] v,int length)  // defined just that the array printed is readable
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


    public static int removeElements(double[] arr,int length, double key) 
    {  
        int index = 0; 
        for (int i=0; i<length; i++) 
            if (arr[i] != key) 
                arr[index++] = arr[i]; 

         return index; 
    } 

    public static int maxFreq(double[] arr){
        int max_freq = 0;
        for(int i=0;i<arr.length;i++){
            int cnt = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]) cnt++;
            }
            max_freq = Math.max(max_freq, cnt);  // finding maximum frequency
        }
        return max_freq;
    }

    public static double[] findMaxFreqElement(int maxf,double[] arr){
        double[] ele = new double[arr.length];
        for(int i=0;i<arr.length;i++){
            ele[i] = 0;
        }
        for(int i=0;i<arr.length;i++){
            int cnt = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]) cnt++;
            }
            if(cnt==maxf) {
                ele[i] = arr[i];
            }
            else continue;
        }
        return ele;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = sc.nextInt();
        System.out.print("Enter the array : ");
        double[] arr = new double[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextDouble();
        }
        //double arr[] = {55.90 , 65.90 , 65.90 , 77.81 , 65.90 , 77.81 , 77.81 , 54.54 , 69.69 , 67.13 , 27.26 , 11.11 , 90.90 , 45.32 , 88.88};
        System.out.println("\n" + Arrays.toString(arr) + "\n");
        System.out.println("Delete Elements : ");
        System.out.println("1. By entering the key");
        System.out.println("2. Delete the element with maximum frequency");
        System.out.print("Enter Choice : ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter the number you want to delete : ");
                double key = sc.nextDouble();
                int new_size = removeElements(arr, arr.length, key);
                System.out.println("New Array : " + toStringOwn(arr, new_size));
                break;
            
            case 2:
                double[] getele = new double[arr.length];
                int max_f = maxFreq(arr);
                int final_size = arr.length; 
                getele = findMaxFreqElement(max_f, arr);
                for(int i=0;i<getele.length;i++){
                    if(getele[i]!=0) final_size = removeElements(arr, final_size , getele[i]);
                }
                System.out.println();
                System.out.println("New Array : " + toStringOwn(arr, final_size));
                break;

            default:
                System.out.println("Wrong Input");
                break;
        }
        sc.close();
        
    }
}

/* OUTPUT
Enter size : 5
Enter the array : 1 2.3 4.56 7.89 7.89

[1.0, 2.3, 4.56, 7.89, 7.89]

Delete Elements :
1. By entering the key
2. Delete the element with maximum frequency
Enter Choice : 1
Enter the number you want to delete : 2.3
New Array : [1.0, 4.56, 7.89, 7.89]




Enter size : 7
Enter the array : 1.22 1.22 3.44 3.44 5.6 7.8 1

[1.22, 1.22, 3.44, 3.44, 5.6, 7.8, 1.0]

Delete Elements :
1. By entering the key
2. Delete the element with maximum frequency
Enter Choice : 2

New Array : [5.6, 7.8, 1.0]
*/