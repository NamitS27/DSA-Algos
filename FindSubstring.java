import java.util.Scanner;

class FindSubstring{  // Question 7

    public static int findSubInd(String orig,String to_find){
        boolean flag  = false;
        for(int i=0;i<=orig.length()-to_find.length();i++){   // for loop will only execute upto len(str) - len(substr_to_find)
            flag = true;
            for(int j=0;j<to_find.length();j++){
                if(orig.charAt(i+j) != to_find.charAt(j)) { // checking if the character of original string matches with the req substring or not
                    flag = false;
                    break;
                }
            }
            if(flag) return i+1;  // if substr is found then it will give the starting index
        }
        return -1;  // if not found will give neg ans which means not found
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the original string : ");
        String original = sc.next();
        System.out.print("Enter substring that is needed to be found out : ");
        String find = sc.next();
        System.out.println("\nString : " +original +"\nSubstring to be found : " +find);
        if(findSubInd(original, find)<0) System.out.println("Substring not found");
        else System.out.println("Substring found from index : " +findSubInd(original, find));
        sc.close();
    }
}


/* OUTPUT
Enter the original string : assignment
Enter substring that is needed to be found out : ment

String : assignment
Substring to be found : ment
Substring found from index : 7
*/