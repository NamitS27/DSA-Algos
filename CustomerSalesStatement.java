import java.util.*;

class CustomerSalesStatement{  // Question 17

    public static void salesCount(int[][] quantitySold,int customer_id,int item_code,int quantity_want) {
        quantitySold[customer_id][item_code] += quantity_want;   // incrementing the quantity of the item of the particular customer
        quantitySold[customer_id][10] += quantity_want;            // total sum gives the total quantity purchased by the customer
    }

    public static void printStatement(int[][] quantitySold) {
        System.out.println("\n\t\t\tPrimary Trading Co.\n");
        System.out.print("Customer\t");
        for(int i=0;i<10;i++){
            System.out.print("Item" + (i+1) +"\t");
        }
        System.out.print("Total");
        System.out.println();
        for(int i=0;i<quantitySold.length;i++){         // printing the customer details
                System.out.print(i+1+"\t\t");
                for(int j=0;j<quantitySold[0].length;j++){
                    System.out.print(quantitySold[i][j] + "\t");
                }
                //System.out.println("Total quantity of items purchased : " +quantitySold[i][10]);
                System.out.println();
        }        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean newcus = true;
        int[][] saleshash = new int[9][11];
        
        System.out.println("Welcome to Primary Trading Co.\n");
        while(newcus){
            System.out.print("\nEnter your customer ID : ");
            int cusid = sc.nextInt();
            if(cusid >=1 && cusid<=9){ // checking for customer ID
                
                boolean new_item = true;
                while(new_item){  // condition for the customer to buy all the items he needs
                    System.out.print("\nEnter item code you want to purchase : ");
                    int itmc = sc.nextInt();
                    if(itmc>=1 && itmc <=10) {
                        System.out.print("Enter quantity of the item you want to purchase : ");
                        int itmqua = sc.nextInt();
                        salesCount(saleshash,cusid-1, itmc-1,itmqua);
                    }
                    else System.out.println("No such item present");
                    System.out.print("Purchase new item ? Y/N : ");
                    String yn = sc.next();
                    yn = yn.toUpperCase();
                    new_item = yn.equals("Y");
                }   
            }
            else System.out.println("Wrong Customer ID");
            
            System.out.print("\nNew Customer ? Y/N : ");  // asking for new customer
            String cus = sc.next();
            cus = cus.toUpperCase();
            newcus = (cus.equals("Y"));
        }
        printStatement(saleshash);
        sc.close();
    }
}

/* OUTPUT
Welcome to Primary Trading Co.

Enter your customer ID : 1

Enter item code you want to purchase : 2
Enter quantity of the item you want to purchase : 2
Purchase new item ? Y/N : y

Enter item code you want to purchase : 5
Enter quantity of the item you want to purchase : 6
Purchase new item ? Y/N : n

New Customer ? Y/N : y

Enter your customer ID : 3

Enter item code you want to purchase : 5
Enter quantity of the item you want to purchase : 5
Purchase new item ? Y/N : n

New Customer ? Y/N : n
Primary Trading Co.

Customer        Item1   Item2   Item3   Item4   Item5   Item6   Item7   Item8   Item9   Item10  Total
1               0       2       0       0       6       0       0       0       0       0       8
2               0       0       0       0       0       0       0       0       0       0       0
3               0       0       0       0       5       0       0       0       0       0       5
4               0       0       0       0       0       0       0       0       0       0       0
5               0       0       0       0       0       0       0       0       0       0       0
6               0       0       0       0       0       0       0       0       0       0       0
7               0       0       0       0       0       0       0       0       0       0       0
8               0       0       0       0       0       0       0       0       0       0       0
9               0       0       0       0       0       0       0       0       0       0       0
*/