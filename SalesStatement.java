import java.util.Scanner;

class SalesStatement{    // Question 16
    
    public static void salesCount(int[] quantitySold,int item_code,int quantity_want) {
        quantitySold[item_code] += quantity_want;   // increament quantity for given item code
    }

    public static void viewSales(int[] quantitySold) {
        System.out.println("\n\tSales Statement\n");
        System.out.println("Item Code\tQuantity Sold");
        for(int i=0;i<quantitySold.length;i++){
            System.out.println((i+1)+".\t\t" +quantitySold[i]);    // Printing the sales statement
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean newcus = true;
        int[] saleshash = new int[10];
        while(newcus){   // will continue till we want to
            System.out.print("\nEnter item code you want to purchase : ");
            int itmc = sc.nextInt();
            if(itmc>=1 && itmc <=10) {     // checking for wrong item code
                System.out.print("Enter quantity of the item you want to purchase : ");
                int itmqua = sc.nextInt();
                salesCount(saleshash, itmc-1,itmqua);
            }
            else System.out.println("No such item present");
            System.out.print("New Customer ? Y/N : ");
            String cus = sc.next();
            cus = cus.toUpperCase();
            newcus = (cus.equals("Y"));
        }
        viewSales(saleshash);
        sc.close();
    }
}


/* OUTPUT
Enter item code you want to purchase : 1
Enter quantity of the item you want to purchase : 1
New Customer ? Y/N : y

Enter item code you want to purchase : 2
Enter quantity of the item you want to purchase : 2
New Customer ? Y/N : y

Enter item code you want to purchase : 3
Enter quantity of the item you want to purchase : 3
New Customer ? Y/N : y

Enter item code you want to purchase : 4
Enter quantity of the item you want to purchase : 4
New Customer ? Y/N : y

Enter item code you want to purchase : 5
Enter quantity of the item you want to purchase : 5
New Customer ? Y/N : y

Enter item code you want to purchase : 6
Enter quantity of the item you want to purchase : 6
New Customer ? Y/N : n

        Sales Statement

Item Code       Quantity Sold
1.              1
2.              2
3.              3
4.              4
5.              5
6.              6
7.              0
8.              0
9.              0
10.             0
*/