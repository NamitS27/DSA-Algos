import java.io.*;

class EmployeeData{
    private String name,designation;
    private int id;
    private double salary;

    public EmployeeData(String name,String designation,int id,double salary){  // constructor
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.id = id;
    }

    public double getSalary() {   // getter method to get salary of an employee
        return salary;
    }

    @Override
    public String toString() {   // to string method to print the employee details
        return "Employee\n" +
                "Id : " + id +
                "\nFirstname : " + name +
                "\nDesignation : " + designation + "\nSalary : " + salary + 
                "\n------------------------\n";
    }
}

class Employee{  // Question 1
    public static void bubblesort(EmployeeData[] arr){  
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j].getSalary() > arr[j+1].getSalary()) 
                { 
                    EmployeeData temp = arr[j];   // swapping objects
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
    }

    public static void selectionsort(EmployeeData[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j].getSalary() < arr[min].getSalary()) {
                    min = j;
                }
            }
            EmployeeData temp = arr[min];    //swapping objects on basis of salary
            arr[min] = arr[i]; 
            arr[i] = temp; 
        }
    }

    public static void main(String args[]) throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EmployeeData[] emp = new EmployeeData[10];
        System.out.println("Enter Employeee Details : \n");
        for(int i=0;i<10;i++){
            System.out.print("Name : ");
            String name = br.readLine();
            System.out.print("Designation : ");
            String desgn = br.readLine();
            System.out.print("ID : ");
            int id = Integer.parseInt(br.readLine());
            System.out.print("Salary : ");
            double salary = Double.parseDouble(br.readLine());
            emp[i] = new EmployeeData(name, desgn, id, salary);   // declaring the objects for the given inputs
            System.out.println("\n\n-------------------------------------------------\n");
        }
        System.out.println("1. Sort Employees (basis : Salary) by Bubble Sort");
        System.out.println("2. Sort Employees (basis : Salary) by Selection Sort");
        System.out.print("Enter choice : ");
        int choice = Integer.parseInt(br.readLine());
        switch(choice){
            case 1:
                System.out.println();
                bubblesort(emp);
                for(int i=0;i<10;i++){
                    System.out.println(emp[i].toString());
                }
                break;
            
            case 2:
                System.out.println();
                selectionsort(emp);
                for(int i=0;i<10;i++){
                    System.out.println(emp[i].toString());
                }
                break;

            default:
                System.out.println("Worng Input !!");
                break;
        }

    }
}

/*OUTPUT

Enter Employee Details

Name : Namit Shah
Designation : CEO
ID : 67
Salary : 10000000


-------------------------------------------------

Name : Harvish Jariwala
Designation : Manager
ID : 50
Salary : 9000000


-------------------------------------------------

Name : Martand Javia
Designation : Senior Developer
ID : 64
Salary : 8000000


-------------------------------------------------

Name : Prayag Savsani
Designation : Senior Designer
ID : 35
Salary : 7500000


-------------------------------------------------

Name : Yashraj Kakkad
Designation : Junior Developer
ID : 36
Salary : 7500000


-------------------------------------------------

Name : Dhatri Kapuriya
Designation : Junior Designer
ID : 129
Salary : 7000000


-------------------------------------------------

Name : Nancy Radadia
Designation : Marketing Head
ID : 70
Salary : 6000000


-------------------------------------------------

Name : Hardi Kadia
Designation : System Analyst
ID : 59
Salary : 5000000


-------------------------------------------------

Name : Devam Shah
Designation : Traniee Engineer
ID : 15
Salary : 3000000


-------------------------------------------------

Name : Anonymous       
Designation : Project Lead 
ID : 7 
Salary : 4200000


-------------------------------------------------

1. Sort Employees (basis : Salary) by Bubble Sort
2. Sort Employees (basis : Salary) by Selection Sort
Enter choice : 2

Employee
Id : 15
Firstname : Devam Shah
Designation : Traniee Engineer
Salary : 3000000.0
------------------------

Employee
Id : 7
Firstname : Anonymous
Designation : Project Lead
Salary : 4200000.0
------------------------

Employee
Id : 59
Firstname : Hardi Kadia
Designation : System Analyst
Salary : 5000000.0
------------------------

Employee
Id : 70
Firstname : Nancy Radadia
Designation : Marketing Head
Salary : 6000000.0
------------------------

Employee
Id : 129
Firstname : Dhatri Kapuriya
Designation : Junior Designer
Salary : 7000000.0
------------------------

Employee
Id : 36
Firstname : Yashraj Kakkad
Designation : Junior Developer
Salary : 7500000.0
------------------------

Employee
Id : 35
Firstname : Prayag Savsani
Designation : Senior Designer
Salary : 7500000.0
------------------------

Employee
Id : 64
Firstname : Martand Javia
Designation : Senior Developer
Salary : 8000000.0
------------------------

Employee
Id : 50
Firstname : Harvish Jariwala
Designation : Manager
Salary : 9000000.0
------------------------

Employee
Id : 67
Firstname : Namit Shah
Designation : CEO
Salary : 1.0E7
------------------------
*/

