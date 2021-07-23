/**   
   @author       Marco Martinez
   @fileName     EmployeeReportAppDriver.java
   @version      1.0
   @description  This program will utilize GenericContainer objects for creating a report.
   
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
   
   AppDriver Class
      (+) static void getEmployees(GenericContainer myEmps)
      (+) static void getEmployee(GenericContainer myEmps, String payPrompt, String numOfPrompt, char tempType, Scanner input)
      (-) static Employee determineEmployee(String lastName, String firstName, double payRate, double hrsWkd, char c)
      (+) static char validateAnswer(char c, Scanner input)
      (+) static String validateString(String name, Scanner input)
      (+) static double validateDouble(double value, Scanner input)
      (+) static char validateYesNo(char c, Scanner input)
      (+) static void printReport(GenericContainer myEmps)
      (+) static void printHeading()
      (+) static void printLabels()
      (+) static void printEmployees(GenericContainer myEmps)
      (+) static boolean determineIfTypeExists(GenericContainer myEmps, char type)
      (+) static void printEmployee(EmployeeRecord emp, String str, char type)
      (+) static void printTypeFooter(GenericContainer myEmps, char type)
      (+) static void printTotals(double totalRate, double totalQuantity, double totalGross, double totalTax, double totalNet, char type)
      (+) static void printAverages(double totalRate, double totalQuantity, double totalGross, double totalTax, double totalNet, int empNum, char type)
      (+) static void printFooter(GenericContainer myEmps)
      (+) static void printString38(String str)
      (+) static void printString12(String str)
      (+) static void printDouble12(double value)
      (+) static String concatenateName(String lastName, String firstName)

   
   @date         10/11/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    10/11    Create baseline for AppDriver.
   Marco    10/28    Add finishing touches to AppDriver.
   Marco    11/13    Adjust for inheritance.
   Marco    12/8     Adjust for feedback. Moved "determineEmployee" method.
   Marco    12/13    Adjusted for generics.
 */
// LIBRARIES
import java.util.Scanner; // Allows access to scanner

public class EmployeeReportAppDriver
{
   // CONSTANT DEFINITIONS
   public static final String TYPE_PROMPT = new String("Please enter the employee's type here: ");
   public static final String FIRST_PROMPT = new String("Please enter the employee's first name here: ");
   public static final String LAST_PROMPT = new String("Please enter the employee's last name here: ");
   public static final String HOUR_RATE_PROMPT = new String("Please enter the employee's hourly pay here: ");
   public static final String HOUR_HRS_PROMPT = new String("Please enter the employee's number of worked hours: ");
   public static final String PIECE_RATE_PROMPT = new String("Please enter the employee's pay per piece of work here: ");
   public static final String PIECE_NUM_PROMPT = new String("Please enter the employee's number of pieces here: ");
   public static final String SALARY_PROMPT = new String("Please enter the employee's salary here: ");
   public static final String HOURLY_LABEL_TOP = new String(String.format("%-38s","Employee (Hourly)") + String.format("%12s","Pay") + String.format("%12s","Hours") + String.format("%12s","Gross") + String.format("%12s","Tax") + String.format("%12s","Net"));
   public static final String HOURLY_LABEL_MIDDLE = new String(String.format("%-38s","Name") + String.format("%12s","Rate") + String.format("%12s","Worked") + String.format("%12s","Pay") + String.format("%12s","Amount") + String.format("%12s","Pay"));
   public static final String HOURLY_LABEL_BOTTOM = new String(String.format("%-38s","=======") + String.format("%12s","=====") + String.format("%12s","=====") + String.format("%12s","=====") + String.format("%12s","=====") + String.format("%12s","====="));
   public static final String SALARY_LABEL_TOP = new String(String.format("%-38s","Employee (Salary)") + String.format("%12s","") + String.format("%12s","") + String.format("%12s","Salary") + String.format("%12s","Tax") + String.format("%12s","Net"));
   public static final String SALARY_LABEL_MIDDLE = new String(String.format("%-38s","Name") + String.format("%12s","") + String.format("%12s","") + String.format("%12s","Pay") + String.format("%12s","Amount") + String.format("%12s","Pay"));
   public static final String SALARY_LABEL_BOTTOM = new String(String.format("%-38s","======================================") + String.format("%12s","============") + String.format("%12s","============") + String.format("%12s","=====") + String.format("%12s","=====") + String.format("%12s","====="));
   public static final String PIECE_LABEL_TOP = new String(String.format("%-38s","Employee (PieceWork)") + String.format("%12s","Pieces") + String.format("%12s","Price of") + String.format("%12s","Gross") + String.format("%12s","Tax") + String.format("%12s","Net"));
   public static final String PIECE_LABEL_MIDDLE = new String(String.format("%-38s","Name") + String.format("%12s","Sold") + String.format("%12s","Piece") + String.format("%12s","Pay") + String.format("%12s","Amount") + String.format("%12s","Pay"));
   public static final String PIECE_LABEL_BOTTOM = new String(String.format("%-38s","=======") + String.format("%12s","=====") + String.format("%12s","=====") + String.format("%12s","=====") + String.format("%12s","=====") + String.format("%12s","====="));
   
   public static void main(String[] args) 
   {
      // VARIABLE DECLARATIONS
      GenericContainer myEmps = new GenericContainer();
      
      // CALLS
      getEmployees(myEmps);
      myEmps.sort();
      printReport(myEmps);
   }
   
   // METHODS
   // (+) static void getEmployees(GenericContainer myEmps)
   public static void getEmployees(GenericContainer myEmps)
   {
      Scanner input = new Scanner(System.in);
      char c = 'y';
      char tempType;

	   while (c != 'n' && c != 'N') 
      {  
         System.out.print(TYPE_PROMPT);
         tempType = validateAnswer(Character.toLowerCase(input.next().charAt(0)), input);
         
         switch (Character.toLowerCase(tempType))
         {
            case 'h':
               getEmployee(myEmps, HOUR_RATE_PROMPT, HOUR_HRS_PROMPT, 'h', input);
               break;
            case 's':
               getEmployee(myEmps, SALARY_PROMPT, "", 's', input);
               break;
            case 'p':
               getEmployee(myEmps, PIECE_RATE_PROMPT, PIECE_NUM_PROMPT, 'p', input);
               break;
            default:
               System.out.println("Error found in getEmployees(Employees) switch statement.");
               break;
         }
         
		   System.out.print("Would you like to continue? (Y/N) ");
         c = validateYesNo((input.next().charAt(0)), input);
         System.out.println();

         if (myEmps.getLength() >= myEmps.getMax() - 1) 
         {
		   	System.out.println("You have hit the maximum amount of employees to enter.");
            c = 'n';
         }
      }
      input.close();
   }
   
   // (+) static void getEmployee(GenericContainer myEmps, String payPrompt, String numOfPrompt, char c, Scanner input)
   public static void getEmployee(GenericContainer myEmps, String payPrompt, String numOfPrompt, char c, Scanner input)
   {
      String tempFirstName = new String("");
      String tempLastName = new String("");
      Double tempHrsWkd = 0.00;
      Double tempPayRate = 0.00;
      
      System.out.print(FIRST_PROMPT);
      tempFirstName = validateString(input.next(), input);
         
      System.out.print(LAST_PROMPT);
      tempLastName = validateString(input.next(), input);
   
      System.out.print(payPrompt);
      tempPayRate = validateDouble(input.nextDouble(), input);
   
      if (Character.toLowerCase(c) != 's')
      {
         System.out.print(numOfPrompt);
         tempHrsWkd = validateDouble(input.nextDouble(), input);
      }
      
      myEmps.add(determineEmployee(tempLastName,tempFirstName,tempPayRate,tempHrsWkd,c));
   }
   
   // (-)  static Employee determineEmployee(String lastName, String firstName, double payRate, double hrsWkd, char c)
   private static Employee determineEmployee(String lastName, String firstName, double payRate, double hrsWkd, char c)
   {
      switch (c)
      {
         case 'h':
            return new Hourly(lastName, firstName, payRate, hrsWkd);
         case 's':
            return new Salary(lastName, firstName, payRate);
         case 'p':
            return new Piece(lastName, firstName, payRate, (int) hrsWkd);
         default:
            System.out.println("Error found within determineEmployee(String, String, double, double, char) case.");
            break;
      }
      return new Hourly();
   }
   
   // (+) static char validateAnswer(char c, Scanner input)
   public static char validateAnswer(char c, Scanner input)
   {
      while (Character.toLowerCase(c) != 'h' && Character.toLowerCase(c) != 's' && Character.toLowerCase(c) != 'p') 
      {
		   System.out.println("Invalid employee type.");
			System.out.print("Please specify between hourly, piecework or salary: ");
			c = input.next().charAt(0);
		}
      return c;
   }
   
   // (+) static String validateString(String name, Scanner input)
   public static String validateString(String name, Scanner input)
   {   
      for(int i = 0; i < 3; i++)
      {
         if (name.matches("[a-zA-Z]+")) return name;
         System.out.println("Error. A name must be alphanumeric.");
         System.out.print("Please enter a name with the correct specifications: ");
         name = input.next();
      }
      
      return "Default";
   }
   
   // (+) static double validateDouble(double value, Scanner input)
   public static double validateDouble(double value, Scanner input)
   {  
      for(int i = 0; i < 3; i++)
      {
         if (value > 0.00) return value;
         System.out.println("Error. Value must be more than 0.");
         System.out.print("Please enter a value with the correct specifications: ");
         value = input.nextDouble();
      }
      
      return 0.00;
   }
   
   // (+) static char validateYesNo(char c, Scanner input)
   public static char validateYesNo(char c, Scanner input)
   {
      while (c != 'n' && c != 'N' && c != 'y' && c != 'Y') 
      {
		   System.out.println("Invalid input.");
			System.out.print("Please enter either a 'y' or 'n': ");
			c = input.next().charAt(0);
         System.out.println();
		}
      return c;
   }
   
   // (+) static void printReport(GenericContainer myEmps)
   public static void printReport(GenericContainer myEmps)
   {
      printHeading();
      printEmployees(myEmps);
      printFooter(myEmps);
   }
   
   // (+) static void printHeading()
   public static void printHeading()
   {
      System.out.println("==================================================================================================");
		System.out.println("                                  YOUR FINANCIAL REPORT ANALYSIS");
		System.out.println("==================================================================================================");
		System.out.println();
   }
      
   // (+) static void printEmployees(GenericContainer myEmps)
   public static void printEmployees(GenericContainer myEmps)
   {
   Employee temp;
   EmployeeRecord emp;
   int counter;
      for(int i = 0; i < 3; i++)
      {
         switch (i)
         {
            case 0:
               if (determineIfTypeExists(myEmps, 'h'))
               {
                  System.out.println(HOURLY_LABEL_TOP);
                  System.out.println(HOURLY_LABEL_MIDDLE);
                  System.out.println(HOURLY_LABEL_BOTTOM);
                  while(myEmps.Iterator_hasNext()) 
                  {
                     emp = new EmployeeRecord(((Employee) myEmps.Iterator_getNext()).get());
                     if (emp.type == 'h')
                     {
                        temp = new Hourly((Employee) myEmps.get(myEmps.getCurrentIndex()-1));
                        printEmployee(emp,'h',((Hourly) temp).getRate(),((Hourly) temp).getHours());
                     }
                  }
                  myEmps.Iterator_Initialize();
                  System.out.println();
                  printTypeFooter(myEmps,'h');
                  System.out.println();
               }
               break;
            case 1:
               if (determineIfTypeExists(myEmps,'s'))
               {
                  System.out.println(SALARY_LABEL_TOP);
                  System.out.println(SALARY_LABEL_MIDDLE);
                  System.out.println(SALARY_LABEL_BOTTOM);
                  while(myEmps.Iterator_hasNext()) 
                  {
                     emp = new EmployeeRecord(((Employee) myEmps.Iterator_getNext()).get());
                     if (emp.type == 's')
                     {
                        temp = new Salary((Employee) myEmps.get(myEmps.getCurrentIndex()-1));
                        printEmployee(emp,'s',((Salary) temp).getSalary(), 0.00);
                     }
                  }
                  myEmps.Iterator_Initialize();
                  System.out.println();
                  printTypeFooter(myEmps, 's');
                  System.out.println();
               }
               break;
            case 2:
               if (determineIfTypeExists(myEmps,'p'))
               {
                  System.out.println(PIECE_LABEL_TOP);
                  System.out.println(PIECE_LABEL_MIDDLE);
                  System.out.println(PIECE_LABEL_BOTTOM);
                  while(myEmps.Iterator_hasNext()) 
                  {
                     emp = new EmployeeRecord(((Employee)myEmps.Iterator_getNext()).get());
                     if (emp.type == 'p')
                     {
                        temp = new Piece(((Employee)myEmps.get(myEmps.getCurrentIndex()-1)));
                        printEmployee(emp,'p',((Piece) temp).getPrice(),((Piece) temp).getPieces());
                     }
                  }
                  myEmps.Iterator_Initialize();
                  System.out.println();
                  printTypeFooter(myEmps, 'p');
                  System.out.println();
               }
               break;
            default:
               System.out.println("Error found within printEmployees(Employees) switch statement.");
               break;
         }
      }
   }
      
   // (+) static boolean determineIfTypeExists(GenericContainer myEmps, char type)
   public static boolean determineIfTypeExists(GenericContainer myEmps, char type)
   {
      EmployeeRecord emp;
      
      while(myEmps.Iterator_hasNext())
      {
         emp = new EmployeeRecord(((Employee)myEmps.Iterator_getNext()).get());
         if (emp.type == type) 
         {
            myEmps.Iterator_Initialize();
            return true;
         }
      }
      myEmps.Iterator_Initialize();
      return false;
   }
   
   // (+) static void printEmployee(EmployeeRecord emp, char type, double rate, double quantity)
   public static void printEmployee(EmployeeRecord emp, char type, double rate, double quantity)
   {
      if (emp.type == type)
      {
         switch (type)
         {
            case 'h':
               printString38(concatenateName(emp.lastName, emp.firstName));
               printDouble12(rate);
               printDouble12(quantity);
               printDouble12(emp.grossPay);
               printDouble12(emp.taxAmt);
               printDouble12(emp.netPay);
               System.out.println();
               break;
            case 's':
               printString38(concatenateName(emp.lastName, emp.firstName));
               printString12("");
               printString12("");
               printDouble12(rate);
               printDouble12(emp.taxAmt);
               printDouble12(emp.netPay);
               System.out.println();
               break;
            case 'p':
               printString38(concatenateName(emp.lastName, emp.firstName));
               printDouble12(rate);
               printDouble12(quantity);
               printDouble12(emp.grossPay);
               printDouble12(emp.taxAmt);
               printDouble12(emp.netPay);
               System.out.println();
               break;
         }
      }
   }

   // (+) static void printTypeFooter(GenericContainer myEmps, char type)
   public static void printTypeFooter(GenericContainer myEmps, char type)
   {
      double totalRate = 0,
             totalQuantity = 0,
             totalGross = 0,
             totalTax = 0,
             totalNet = 0;
      int counter = 0;
      Employee temp;
      
      while(myEmps.Iterator_hasNext())
      {   
         if ((((Employee)(myEmps.Iterator_getNext())).get()).type == type)
         {  
            counter++;
            switch (type)
            {
               case 'h':
                  temp = new Hourly((Employee)myEmps.get(myEmps.getCurrentIndex()-1));
                  totalRate += ((Hourly)temp).getRate();
                  totalQuantity += ((Hourly)temp).getHours();
                  totalGross += (temp.get()).grossPay;
                  totalTax += (temp.get()).taxAmt;
                  totalNet += (temp.get()).netPay;
                  break;
               case 's':
                  temp = new Salary(((Employee)myEmps.get(myEmps.getCurrentIndex()-1)));
                  totalRate += ((Salary)temp).getSalary();
                  totalGross += (temp.get()).grossPay;
                  totalTax += (temp.get()).taxAmt;
                  totalNet += (temp.get()).netPay;
                  break;
               case 'p':
                  temp = new Piece((Employee)myEmps.get(myEmps.getCurrentIndex()-1));
                  totalRate += ((Piece)temp).getPrice();
                  totalQuantity += ((Piece)temp).getPieces();
                  totalGross += (temp.get()).grossPay;
                  totalTax += (temp.get()).taxAmt;
                  totalNet += (temp.get()).netPay;
                  break;
            }
         }
      }
      myEmps.Iterator_Initialize();
         
      printTotals(totalRate, totalQuantity, totalGross, totalTax, totalNet, type);
      printAverages(totalRate, totalQuantity, totalGross, totalTax, totalNet, counter, type);
   }
   
   // (+) static void printTotals(double totalRate, double totalQuantity, double totalGross, double totalTax, double totalNet, char type)
   public static void printTotals(double totalRate, double totalQuantity, double totalGross, double totalTax, double totalNet, char type)
   {
      printString38("Totals: ");
      if (type != 's')
      {
         printDouble12(totalRate);
         printDouble12(totalQuantity);
      }
      else
      {
         printString12("");
         printString12("");
      }
      printDouble12(totalGross);
      printDouble12(totalTax);
      printDouble12(totalNet);
      System.out.println();
   }
   
   // (+) static void printAverages(double totalRate, double totalQuantity, double totalGross, double totalTax, double totalNet, int empNum, char type)
   public static void printAverages(double totalRate, double totalQuantity, double totalGross, double totalTax, double totalNet, int empNum, char type)
   {
      printString38("Averages: ");
      if (type != 's')
      {
         printDouble12(totalRate/empNum);
         printDouble12(totalQuantity/empNum);
      }
      else
      {
         printString12("");
         printString12("");
      }
      printDouble12(totalGross/empNum);
      printDouble12(totalTax/empNum);
      printDouble12(totalNet/empNum);
      System.out.println();
   }

   
   // (+) static void printFooter(GenericContainer myEmps)
   public static void printFooter(GenericContainer myEmps)
   {
      double totalGrossPay = 0;
      double totalTaxAmt = 0;
      double totalNetPay = 0;
   
      while(myEmps.Iterator_hasNext())
      {
         EmployeeRecord tempRecord = new EmployeeRecord(((Employee)myEmps.Iterator_getNext()).get());
         totalGrossPay += tempRecord.grossPay;
         totalTaxAmt += tempRecord.taxAmt;
         totalNetPay += tempRecord.netPay;
      }
      
      printString38("Grand Totals:");
      printString12("");
      printString12("");
      printDouble12(totalGrossPay);
      printDouble12(totalTaxAmt);
      printDouble12(totalNetPay);
      System.out.println();
      
      printString38("Grand Averages:");
      printString12("");
      printString12("");
      printDouble12(totalGrossPay/myEmps.getLength());
      printDouble12(totalTaxAmt/myEmps.getLength());
      printDouble12(totalNetPay/myEmps.getLength());
      System.out.println();
   }
   
   // (+) static void printString38(String str)
   public static void printString38(String str)
   {
      System.out.printf("%-38s", str);
   }

   // (+) static void printString12(String str)
   public static void printString12(String str)
   {
      System.out.printf("%12s", str);
   }
   
   // (+) static void printDouble12(double value)
   public static void printDouble12(double value)
   {
      System.out.printf("%12.2f", value);
   }
   
   // (+) static String concatenateName(String lastName, String firstName)
   public static String concatenateName(String lastName, String firstName)
   {
      return lastName + ", " + firstName;
   }
}