/**   
   @author       Marco Martinez
   @fileName     Salary.java
   @version      1.0
   @description  This program will construct and manipulate Salary-Employee objects.
   
   Classes
      EmployeeRecord
      Employee
      Hourly
      Salary
      Piece
      GenericItemType
      GenericContainer
      AppDriver
   
   Associations
      Employee(1) --- inherits --- (1) GenericItemType
      Hourly(1) --- inherits --- (1) Employee
      Salary(1) --- inherits --- (1) Employee
      Piece(1) --- inherits --- (1) Employee
      GenericContainer(1) --- contains --- (m) GenericItemType
      AppDriver(1) --- uses --- (1) GenericContainer
         
   Salary Class Attributes   
      CONSTANT DEFINITIONS
      (-) char TYPE = 's';
   
      INSTANCE VARIABLE DECLARATIONS
      (-) double salary;
      
      CLASS CONSTRUCTORS
      (+) Piece()
      (+) Piece(String lastName, String firstName, double newSalary)
      (+) Piece(EmployeeRecord newEmployeeRecord)
      (+) Piece(Employee newEmployee)
      
      CHANGE STATE SERVICES
      (+) void calcGross()
      
      READ STATE SERVICES
      (+) double getRate()
   
   @date         11/12/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    11/12    Create baseline for Piece.
 */

public class Salary extends Employee
{
   // CONSTANT DEFINITIONS
   private static final char TYPE = 's';
   
   // INSTANCE VARIABLE DECLARATIONS
   private double salary;
   
   // CLASS CONSTRUCTORS
   // (+) Salary()
   public Salary(){}
   
   // (+) Salary(String newLastName, String newFirstName, double newSalary)
   public Salary(String newLastName, String newFirstName, double newSalary)
   {
      super(newLastName, newFirstName, TYPE);
      if (newSalary < 0)
      {
         this.e = new EmployeeRecord();
         return;
      }
      else
      {
         this.salary = newSalary;
         calcGross();
         calcTax();
         calcNet();
      }
   }
  
   // (+) Salary(EmployeeRecord newEmployee)
   public Salary(EmployeeRecord newEmployee)
   {
      super(newEmployee);
   }
   
   // (+) Salary(Employee newEmployee)
   public Salary(Employee newEmployee)
   {
      super(newEmployee);
      this.salary = ((Salary)newEmployee).getSalary();
   }
   
   // CHANGE STATE SERVICES
   // (+) void calcGross()
   public void calcGross()
   {
      this.e.grossPay = this.salary;
   }
   
   // READ STATE SERVICES
   // (+) double getSalary()
   public double getSalary()
   {
      return this.salary;
   }
}