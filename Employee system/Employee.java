public class Employee
{
    //employee attributes
    private int EmpID;
    private String EmpName;
    private String EmpDepartment;
    private int EmpSalary;
    
    public Employee(int id, String name, String depart, int sal) //constructor for employee
    {
        this.EmpID = id;
        this.EmpName = name;
        this.EmpDepartment = depart;
        this.EmpSalary = sal;
    }


    //GETTERS

    public int getEmpID()
    {
        return this.EmpID;
    }

    public String getEmpName()
    {
        return this.EmpName;
    }

    public String getEmpDepartment()
    {
        return this.EmpDepartment;
    }

    public int getEmpSalary()
    {
        return this.EmpSalary;
    }

    //SETTERS

    public void setEmpID(int id)
    {
        this.EmpID = id;
    }

    public void setEmpName(String name)
    {
        this.EmpName = name;
    }

    public void setEmpDepartment(String depart)
    {
        this.EmpDepartment = depart;
    }

    public void setEmpSalary(int sal)
    {
        this.EmpSalary = sal;
    }

}