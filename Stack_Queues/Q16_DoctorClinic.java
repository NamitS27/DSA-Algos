/* 
Name : Namit Shah AU1841067
Version : 16
Description : Checking patients in doctor's clinic
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class patientDetails{
    String name,problem;
    int age;
    char sex;

    public patientDetails(String name, String problem, int age, char sex) {
        this.name = name;
        this.problem = problem;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return  "\n----------------------------------------\n"+"Name : " + name +
                "\nProblem : " + problem +
                "\nAge : " + age +
                "\nSex : " + sex + "\n----------------------------------------\n";
    }
}

class cQueue {
    patientDetails arr[];
    int front;
    int rear;
    int capacity;

    cQueue(int n){
        capacity = n;
        arr = new patientDetails[n];
        front = -1;
        rear = -1;
    }

    public void enqueue(patientDetails val){
        if(rear==capacity-1){
            System.out.println("Queue is Full\n");
            return;
        }
        else if(front == -1 && rear == -1){
            front = rear = 0;
            arr[rear] = val;
        }
        else {
            rear++;
            arr[rear] = val;
        }
    }

    public patientDetails dequeue(){
        if(isEmpty()) return null;
        else if(front==rear){
            int temp = front;
            front=rear=-1;
            return arr[temp];
        }
        else return arr[front++];
    }

    public void display(){
        if(isEmpty()) System.out.print("Queue is empty\n");
        else{
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i].toString() + "\n");
            }
        }
    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1) return true;
        else return false;
    }
}

public class Q16_DoctorClinic {   // Question 16

    public static patientDetails addPatient() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter patient details : \n");
        System.out.print("\nEnter patient name : ");
        String name = br.readLine();
        System.out.print("Enter patient's problem : ");
        String problem = br.readLine();
        System.out.print("Enter patient's age : ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Enter patient's gender : ");
        char sex = br.readLine().charAt(0);
        return new patientDetails(name,problem,age,sex);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        cQueue qu = new cQueue(10);
        cQueue checkP = new cQueue(10);
        do{
            System.out.println("\n\n1. Add Patient");
            System.out.println("2. Check Patient");
            System.out.println("3. Show list of check patients");
            System.out.println("4. Exit");
            System.out.print("\nEnter choice : ");
            choice = Integer.parseInt(br.readLine());
            switch (choice){
                case 1:
                    qu.enqueue(addPatient());
                    break;

                case 2:
                    patientDetails temp = qu.dequeue();
                    System.out.println("Details of the checked patient : \n" +temp.toString());
                    checkP.enqueue(temp);
                    break;

                case 3:
                    System.out.println("\nList of checked patients : ");
                    checkP.display();
                    break;

                case 4:
                    break;
            }
        }while(choice!=4);

        br.close();
    }
}

/*
PROGRAM OUTPUT
1. Add Patient
2. Check Patient
3. Show list of check patients
4. Exit

Enter choice : 1

Enter patient details : 


Enter patient name : Namit
Enter patient's problem : Fever
Enter patient's age : 19
Enter patient's gender : M


1. Add Patient
2. Check Patient
3. Show list of check patients
4. Exit

Enter choice : 1

Enter patient details : 


Enter patient name : xyz
Enter patient's problem : tuberculosis
Enter patient's age : 75 
Enter patient's gender : M


1. Add Patient
2. Check Patient
3. Show list of check patients
4. Exit

Enter choice : 2
Details of the checked patient : 

----------------------------------------
Name : Namit
Problem : Fever
Age : 19
Sex : M
----------------------------------------



1. Add Patient
2. Check Patient
3. Show list of check patients
4. Exit

Enter choice : 3

List of checked patients :

----------------------------------------
Name : Namit
Problem : Fever
Age : 19
Sex : M
----------------------------------------



1. Add Patient
2. Check Patient
3. Show list of check patients
4. Exit

Enter choice : 4
*/
