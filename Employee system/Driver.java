import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*
IDEAS FOR FURTHER IMPLEMENTATION IN FUTURE VERSIONS
1. implement more error checking
2. implement a GUI
3. Make sure ID number is unique before adding employee
4. Make input txt file more organized and adjust program to read and write with that format
*/

public class Driver 
{

    static ArrayList<Employee> empList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String [] args) throws FileNotFoundException, IOException
    {
        File f = new File("C:\\Users\\Alex\\Desktop\\Personal Projects\\Other Projects\\Employee system\\employees.txt");
        Scanner scf = new Scanner(f);
        scf.useDelimiter(",");

        while (scf.hasNext())
        {
            int id = scf.nextInt();
            String name = scf.next();
            String depart = scf.next();
            int sal = scf.nextInt();
            Employee e = new Employee(id, name, depart, sal);
            empList.add(e);
            scf.nextLine();
        }

        scf.close();
        int input = 0;
        while (input != 4)
        {
            System.out.println("Welcome to the Employee Computer System!");
            System.out.println("Please choose 1 of the following:");
            System.out.println("1. add employee");
            System.out.println("2. remove employee OR alter employee info");
            System.out.println("3. read out all employees");
            System.out.println("4. to exit ");
            //sc.nextLine();
            input = sc.nextInt();
            
            if (input == 1)
            {
                addEmployee();
            }
            else if (input == 2)
            {
                System.out.println("Input the id number of the employee you want to alter: ");
                int id = sc.nextInt();

                System.out.println("do you want to 1. remove employee, 2. change name, 3. change ID or 4. change department? ");
                int choice = sc.nextInt();
                if (choice == 1)
                {
                    removeEmployee(id);
                }
                else if (choice == 2)
                {
                    changeName(id);
                }
                else if (choice == 3)
                {
                    changeID(id);
                }
                else if (choice == 4)
                {
                    changeDepartment(id);
                }
            }
            else if (input == 3)
            {
                for (int i = 0; i < empList.size(); i++)
                {
                    Employee e = empList.get(i);
                    System.out.println("Employee ID = " + e.getEmpID() + " " + "Employee name = " + e.getEmpName() + " " + "Employee department = " + e.getEmpDepartment());
                }
            }
        }

        FileWriter fw = new FileWriter(f);
        for (int i = 0; i < empList.size(); i++)
        {
            Employee e = empList.get(i);
            fw.write(e.getEmpID() + "," + e.getEmpName() + "," + e.getEmpDepartment() + "," + e.getEmpSalary() + ",");
            fw.write("\n");
        }

        fw.close();
    }
    
    public static void addEmployee() //WORKS CORRECTLY
    {
        int cont = 1;
        while (cont == 1)
        {
            System.out.println("What is the new Employee's ID? ");
            int id = sc.nextInt();
            System.out.println("What is the new Employee's name? ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("What is the new Employee's department? ");
            String depart = sc.nextLine();
            System.out.println("What is the new Employee's salary? ");
            int sal = sc.nextInt();

            Employee e = new Employee(id, name, depart, sal);
            empList.add(e);

            System.out.println("1 to continue, 0 to stop ");
            cont = sc.nextInt();
        }
        
    }

    public static void removeEmployee(int id) //WORKS CORRECTLY
    {
        for (int i = 0; i < empList.size(); i++)
        {
            Employee e = empList.get(i);

            if (id == e.getEmpID())
            {
                empList.remove(i);
            }
        }
    }

    public static void changeName(int id) //WORKS CORRECTLY
    {
        for (int i = 0; i < empList.size(); i++)
        {
            Employee e = empList.get(i);
            if (id == e.getEmpID())
            {
                System.out.println("What do you want to change the name to? ");
                sc.nextLine();
                String name = sc.nextLine();
                e.setEmpName(name);
            }
        }
    }

    public static void changeID(int id) //WORKS CORRECTLY
    {
        for (int i = 0; i < empList.size(); i++)
        {
            Employee e = empList.get(i);
            if (id == e.getEmpID())
            {
                System.out.println("What do you want to change the ID to? ");
                int eID = sc.nextInt();
                e.setEmpID(eID);
            }
        }
    }

    public static void changeDepartment(int id) //CHANGES TO NULL INSTEAD OF WAITING FOR INPUT
    {
        for (int i = 0; i < empList.size(); i++)
        {
            Employee e = empList.get(i);
            if (id == e.getEmpID())
            {
                System.out.println("What do you want to change the department to? ");
                sc.nextLine();
                String depart = sc.nextLine();
                e.setEmpDepartment(depart);
            }
        }
    }
}
