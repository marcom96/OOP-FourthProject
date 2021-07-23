/**   
   @author       Marco Martinez
   @fileName     Employee.java
   @version      1.0
   @description  This program will construct and manipulate Employee objects.
   
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
   
   Employee Class Attributes
      CONSTANT DEFINITIONS
      (-) double TAXRATE
   
      INSTANCE VARIABLES
      (#) EmployeeRecord e
      
      CHANGE STATE SERVICES
      (+) abstract void calcGross()
      (+) void calcTaxes()
      (+) void calcNet()
      
      READ STATE SERVICES
      (+) boolean isLess(GenericItemType git)
      (+) boolean isEqual(GenericItemType git)
      (+) boolean isGreater(GenericItemType git)
      (+) EmployeeRecord get()
      (+) String toString()
   
   @date         10/11/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    10/11    Create baseline for Employee.
   Marco    11/12    Adjust for inheritance.
 */
 
public abstract class Employee extends GenericItemType
{
   // CONSTANT DEFINITIONS
   private static final double TAXRATE = 0.15;
   
   // INSTANCE VARIABLE DECLARATIONS
   protected EmployeeRecord e;
   
   // CLASS CONSTRUCTORS
   // (+) Employee() 				
   public Employee(){}

   // (+) Employee(String newLastName, String newFirstName, char newType)				
   public Employee(String newLastName, String newFirstName, char newType)
   {
      if ((Character.toLowerCase(newType) != 'h' && Character.toLowerCase(newType) != 'p' && Character.toLowerCase(newType) != 's') || !newLastName.matches("[a-zA-Z]+") || !newFirstName.matches("[a-zA-Z]+")) this.e = new EmployeeRecord();
      else 
      {
         this.e = new EmployeeRecord(newLastName, newFirstName, newType);
      }
   }
    
   // (+) Employee(EmployeeRecord newEmployeeRecord)
   public Employee(EmployeeRecord newEmployeeRecord)
   {
      this.e = new EmployeeRecord(newEmployeeRecord);
      if (this.e.grossPay == 0) calcGross();
      if (this.e.taxAmt == 0) calcTax();
      if (this.e.netPay == 0) calcNet();
   }
  
   // (+) Employee(Employee newEmployee)
   public Employee(Employee newEmployee)
   {
      this.e = new EmployeeRecord(newEmployee.get());
      if (this.e.grossPay == 0) calcGross();
      if (this.e.taxAmt == 0) calcTax();
      if (this.e.netPay == 0) calcNet();
   }
   
   // CHANGE STATE SERVICES
   // (+) abstract void calcGross()
   public abstract void calcGross();
   
   // (+) void calcTax()
   public void calcTax()
   {
      this.e.taxAmt = this.e.grossPay * TAXRATE; 
   }
   
   // (+) void calcNet()
   public void calcNet()
   {
      this.e.netPay = this.e.grossPay - this.e.taxAmt;
   }
   
   // READ STATE SERVICES
   // (+) boolean isLess(GenericItemType git)
   public boolean isLess(GenericItemType git)
   {
      if(this.e.lastName.compareToIgnoreCase(((Employee)(git)).get().lastName) < 0)
         return true;
      else
         return false;
   }
   
   // (+) boolean isEqual(GenericItemType git)
   public boolean isEqual(GenericItemType git)
   {
      if(this.e.lastName.compareToIgnoreCase(((Employee)(git)).get().lastName) == 0)
         return true;
      else
         return false;
   }
   
   // (+) boolean isGreater(GenericItemType git)
   public boolean isGreater(GenericItemType git)
   {
      if(this.e.lastName.compareToIgnoreCase(((Employee)(git)).get().lastName) > 0)
         return true;
      else
         return false;
   }
   
   // (+) EmployeeRecord get()
   public EmployeeRecord get()
   {
      return this.e;
   }
   
   // (+) String toString()
   public String toString()
   {
      return this.e.toString();
   }
}