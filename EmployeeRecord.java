/**   
   @author       Marco Martinez
   @fileName     EmployeeRecord.java
   @version      1.1
   @description  This program will construct and manipulate EmployeeRecord objects.
   
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
   
   EmployeeRecord Class Attributes
      INSTANCE VARIABLES
      (+) String lastName
      (+) String firstName
      (+) double grossPay
      (+) double taxAmt
      (+) double netPay
      (+) int    employeeNumber
      (+) char   type
      
      CLASS CONSTRUCTORS	
      (+) EmployeeRecord()
      (+) EmployeeRecord(String newLastName, String newFirstName, double newGrossPay, char newType)
      (+) EmployeeRecord(EmployeeRecord e)
      
      READ STATE SERVICES
      (+) String toString()
   
   @date         10/11/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    10/11    Create baseline for EmployeeRecord.
   Marco    11/12    Adjust for inheritance.
 */
 
public class EmployeeRecord
{
   // INSTANCE VARIABLE DECLARATIONS
   public String lastName,
                 firstName;
   public double grossPay,
                 taxAmt,
                 netPay;
   public int    employeeNumber;
   public char   type;

   // CLASS CONSTRUCTORS
   // (+) EmployeeRecord()  				
   public EmployeeRecord(){}

   // (+) EmployeeRecord(String newLastName, String newFirstName, char newType)				
   public EmployeeRecord(String newLastName, String newFirstName, char newType)
   {
      if ((Character.toLowerCase(newType) != 'h' && Character.toLowerCase(newType) != 'p' && Character.toLowerCase(newType) != 's') || !newLastName.matches("[a-zA-Z]+") || !newFirstName.matches("[a-zA-Z]+")) return;
      else 
      {
         this.lastName = newLastName;
         this.firstName = newFirstName;
         this.type = newType;
         this.grossPay = this.taxAmt = this.netPay = 0.00;
      }
   }
    
   // (+) EmployeeRecord(EmployeeRecord newEmployeeRecord)
   public EmployeeRecord(EmployeeRecord newEmployeeRecord)
   {
      this.lastName = newEmployeeRecord.lastName;
      this.firstName = newEmployeeRecord.firstName;
      this.grossPay = newEmployeeRecord.grossPay;
      this.taxAmt = newEmployeeRecord.taxAmt;
      this.netPay = newEmployeeRecord.netPay;
      this.employeeNumber = newEmployeeRecord.employeeNumber;
      this.type = newEmployeeRecord.type;
   }
  
   // READ STATE SERVICES
   // (+) String toString()
   public String toString()
   {
      return this.lastName + ", " + this.firstName 
                           + " " + Double.toString(this.grossPay) 
                           + " " + Double.toString(this.taxAmt) 
                           + " " + Double.toString(this.netPay);
   }
}