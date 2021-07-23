/**   
   @author       Marco Martinez
   @fileName     Piece.java
   @version      1.0
   @description  This program will construct and manipulate Piece-Employee objects.
   
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
   
   Piece Class Attributes
      CONSTANT DEFINITIONS
      (-) char TYPE
      
      INSTANCE VARIABLE DECLARATION
      (-) double pricePerPiece;
      (-) int    pieces;

      CLASS CONSTRUCTORS
      (+) Piece()
      (+) Piece(String newLastName, String newFirstName, double newPieceRate, int newNumPieces)
      (+) Piece(EmployeeRecord newEmployeeRecord)
      (+) Piece(Employee newEmployee)
      
      CHANGE STATE SERVICES
      (+) void calcGross()
      
      READ STATE SERVICES
      (+) double getPrice()
      (+) int getPieces()
   
   @date         11/12/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    11/12    Create baseline for Piece.
 */

public class Piece extends Employee
{
   // CONSTANT DEFINITIONS
   private static final char TYPE = 'p';
   
   // INSTANCE VARIABLE DECLARATION
   private double pricePerPiece;
   private int    pieces;
   
   // CLASS CONSTRUCTORS
   // (+) Piece()
   public Piece(){}
   
   // (+) Piece(String newLastName, String newFirstName, double newPieceRate, int newNumPieces)
   public Piece(String newLastName, String newFirstName, double newPieceRate, int newNumPieces)
   {
      super(newLastName, newFirstName, TYPE);
      if (newPieceRate < 0 || newNumPieces < 0) 
      {
         this.e = new EmployeeRecord();
         return;
      }
      else
      {
         this.pricePerPiece = newPieceRate;
         this.pieces = newNumPieces;
         calcGross();
         calcTax();
         calcNet();
      }
   }
  
   // (+) Piece(EmployeeRecord newEmployee)
   public Piece(EmployeeRecord newEmployee)
   {
      super(newEmployee);
   }
   
   // (+) Piece(Employee newEmployee)
   public Piece(Employee newEmployee)
   {
      super(newEmployee);
      this.pricePerPiece = ((Piece)newEmployee).getPrice();
      this.pieces = ((Piece)newEmployee).getPieces();
   }
   
   // CHANGE STATE SERVICES
   // (+) void calcGross()
   public void calcGross()
   {
      this.e.grossPay = this.pricePerPiece * this.pieces;
   }
   
   // READ STATE SERVICES
   // (+) double getPrice()
   public double getPrice()
   {
      return this.pricePerPiece;
   }
   
   // (+) int getPieces()
   public int getPieces()
   {
      return pieces;
   }
}