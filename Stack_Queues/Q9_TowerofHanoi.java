/*
Author : Namit Shah AU1841067
Question : 9
Description : Tower of Hanoi
*/

import java.util.Scanner;
import java.util.Stack;

class Q9_TowerofHanoi { // Question 9

    public static int N;
    public static Stack<Integer>[] tower = new Stack[4];

    public static void towerHanoi(int n, char rod1, char rod3, char rod2) { // recursive
        if (n == 1) {
            System.out.println("Move Disk 1 from rod " + rod1 + " to rod " + rod3);
            return;
        }
        towerHanoi(n - 1, rod1, rod2, rod3);
        System.out.println("Move Disk " + n + " from rod " + rod1 + " to rod " + rod3);
        towerHanoi(n - 1, rod2, rod3, rod1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of disks : ");
        int disk = sc.nextInt();
        N = disk;
        int disk2 = disk;
        System.out.println("\n----------------- WITHOUT STACK ----------------\n");
        towerHanoi(disk, 'A', 'C', 'B');
        System.out.println("\n------------------------------------------------\n");
        System.out.println("\n------------------- WITH STACK ------------------\n");
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();
        toh(disk2);
        System.out.println("\n-------------------------------------------------\n");
        sc.close();
    }

    public static void toh(int n) {
        for (int d = n; d > 0; d--)
            tower[1].push(d);
        display();
        move(n, 1, 2, 3);
    }

    public static void move(int n, int a, int b, int c){
        if (n > 0){
            move(n - 1, a, c, b);
            int d = tower[a].pop();
            tower[c].push(d);
            display();
            move(n - 1, b, a, c);
        }
    }

    public static void display()
    {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = N - 1; i >= 0; i--){
            String d1 = " ", d2 = " ", d3 = " ";
            try{
                d1 = String.valueOf(tower[1].get(i));
            }
            catch (Exception e) {
            }
            try{
                d2 = String.valueOf(tower[2].get(i));
            }
            catch (Exception e) {
            }
            try{
                d3 = String.valueOf(tower[3].get(i));
            }
            catch (Exception e) {
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.println("\n");
    }
}

/* OUTPUT 
Enter Number of disks : 4

----------------- WITHOUT STACK ----------------

Move Disk 1 from rod A to rod B
Move Disk 2 from rod A to rod C
Move Disk 1 from rod B to rod C
Move Disk 3 from rod A to rod B
Move Disk 1 from rod C to rod A
Move Disk 2 from rod C to rod B
Move Disk 1 from rod A to rod B
Move Disk 4 from rod A to rod C
Move Disk 1 from rod B to rod C
Move Disk 2 from rod B to rod A
Move Disk 1 from rod C to rod A
Move Disk 3 from rod B to rod C
Move Disk 1 from rod A to rod B
Move Disk 2 from rod A to rod C
Move Disk 1 from rod B to rod C

------------------------------------------------ 


------------------- WITH STACK ------------------

  A  |  B  |  C
---------------
  1  |     |   
  2  |     |   
  3  |     |   
  4  |     |


  A  |  B  |  C
---------------
     |     |
  2  |     |   
  3  |     |   
  4  |  1  |


  A  |  B  |  C
---------------
     |     |
     |     |
  3  |     |   
  4  |  1  |  2


  A  |  B  |  C
---------------
     |     |
     |     |
  3  |     |  1
  4  |     |  2


  A  |  B  |  C
---------------
     |     |
     |     |
     |     |  1
  4  |  3  |  2


  A  |  B  |  C
---------------
     |     |
     |     |
  1  |     |
  4  |  3  |  2


  A  |  B  |  C
---------------
     |     |
     |     |   
  1  |  2  |
  4  |  3  |   


  A  |  B  |  C
---------------
     |     |   
     |  1  |
     |  2  |
  4  |  3  |


  A  |  B  |  C
---------------
     |     |
     |  1  |
     |  2  |   
     |  3  |  4


  A  |  B  |  C
---------------
     |     |
     |     |
     |  2  |  1
     |  3  |  4


  A  |  B  |  C
---------------
     |     |
     |     |
     |     |  1
  2  |  3  |  4


  A  |  B  |  C
---------------
     |     |
     |     |
  1  |     |
  2  |  3  |  4


  A  |  B  |  C
---------------
     |     |
     |     |
  1  |     |  3
  2  |     |  4


  A  |  B  |  C
---------------
     |     |
     |     |
     |     |  3
  2  |  1  |  4


  A  |  B  |  C
---------------
     |     |
     |     |  2
     |     |  3
     |  1  |  4


  A  |  B  |  C
---------------
     |     |  1
     |     |  2
     |     |  3
     |     |  4



-------------------------------------------------
*/