/**   
   @author       Marco Martinez
   @fileName     Hourly.java
   @version      1.0
   @description  This program will construct and manipulate Hourly-Employee objects.
   
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
   
   Hourly Class Attributes
      CONSTANT DEFINITIONS
      (-) double REGULARHOURS
      (-) double OVERTIMERATE
      (-) char TYPE

      INSTANCE VARIABLE DECLARATIONS
      (-) double hours;
      (-) double rate;
      
      CLASS CONSTRUCTORS
      (+) Employee()
      (+) Employee(String lastName, String firstName, double hrsWkd, double payRate)
      (+) Employee(EmployeeRecord newEmployeeRecord)
      (+) Employee(Employee newEmployee)
      
      CHANGE STATE SERVICES
      (+) void calcGross()
      
      READ STATE SERVICES
      (+) double getRate()
      (+) double getHours()
   
   @date         11/12/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    11/12    Create baseline for Hourly.
 */

public class Hourly extends Employee
{
   // CONSTANT DEFINITIONS
   private static final double REGULARHOURS = 40.0;
   private static final double OVERTIMERATE = 1.5;
   private static final char TYPE = 'h';
   
   // INSTANCE VARIABLE DECLARATIONS
   private double hours;
   private double rate;
   
   // CLASS CONSTRUCTORS
   // (+) Hourly()
   public Hourly(){}
   
   // (+) Hourly(String newLastName, String newFirstName, double newPayRate, double newHrsWkd)
   public Hourly(String newLastName, String newFirstName, double newPayRate, double newHrsWkd)
   {
      super(newLastName, newFirstName, TYPE);
      if (newPayRate < 0 || newHrsWkd < 0)
      {
         this.e = new EmployeeRecord();
         return;
      }
      else
      {
         this.rate = newPayRate;
         this.hours = newHrsWkd;
         calcGross();
         calcTax();
         calcNet();
      }
   }
   
   // (+) Hourly(EmployeeRecord newEmployee)
   public Hourly(EmployeeRecord newEmployee)
   {
      super(newEmployee);
   }
  
   // (+) Hourly(Employee newEmployee)
   public Hourly(Employee newEmployee)
   {
      super(newEmployee);
      this.rate = ((Hourly)newEmployee).getRate();
      this.hours = ((Hourly)newEmployee).getHours();
   }
   
   // CHANGE STATE SERVICES
   // (+) void calcGross()
   public void calcGross()
   {
      if (this.hours <= REGULARHOURS) 
      {
	      this.e.grossPay = this.rate * this.hours;
	   }
	   else 
      {
	   	this.e.grossPay = REGULARHOURS * this.rate;
         this.e.grossPay += (this.hours - REGULARHOURS) * this.rate * OVERTIMERATE;
	   }
   }
   
   // READ STATE SERVICES
   // (+) double getRate()
   public double getRate()
   {
      return this.rate;
   }
   
   // (+) double getHours()
   public double getHours()
   {
      return this.hours;
   }
}