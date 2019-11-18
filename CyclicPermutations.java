import java.util.*;

class CyclicPermutations{
    private static void cycPermutations(int cyc_ans, int n){
        int rem, div;
        for(int i=0; i<n; ++i){
            rem = cyc_ans % 10;   // finding remainder
            div = cyc_ans/10;
            cyc_ans = (int) Math.pow(10, n-1)*rem + div;  // formula to calculate cyclic permutations
            System.out.println(cyc_ans);
        }
    } 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number to generate its cyclic permutations: ");
        String str = scan.next();
        int get_per = Integer.parseInt(str);   // Converts String to Integer
        System.out.println("Cyclic Permutations : ");
        cycPermutations(get_per, str.length());
        scan.close();
    }
}

/*OUTPUT
Enter the number to generate its cyclic permutations:
1344
Cyclic Permutations :
4134
4413
3441
1344
*/