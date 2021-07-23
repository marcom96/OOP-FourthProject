/**   
   @author       Marco Martinez
   @fileName     GenericItemType.java
   @version      1.0
   @description  This program will construct and manipulate IntegerDataType objects.
   
   Classes
      GenericItemType
      IntegerDataType
      StringDataType
      GenericContainer
      AppDriver
   
   Associations
      IntegerDataType --- 1 : 1 (inherits) ---> GenericItempType
      StringDataType --- 1 : 1 (inherits) ---> GenericItemType
      GenericContainer --- 1 : m (contains) ---> GenericItemType
      AppDriver --- 1 : 1 (uses) ---> GenericContainer
   
   IntegerDataItem
      INSTANCE VARIABLE DECLARATION
         (-) int myValue;
         
      CLASS CONSTRUCTORS
         (+) IntegerDataItem()
         (+) IntegerDataItem(int i)
         (+) IntegerDataItem(IntegerDataItem idi)
         
      CHANGE STATE SERVICES
         (+) void set(int i)
         
      READ STATE SERVICES
         (+) boolean isLess(GenericItemType git)
         (+) boolean isEqual(GenericItemType git)
         (+) boolean isGreater(GenericItemType git)
         (+) int get()
         (+) String toString()

   
   @date         12/12/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    12/12    Create baseline for IntegerDataType.
 */
 
public class IntegerDataItem extends GenericItemType
{
   // INSTANCE VARIABLE DECLARATION
   private int myValue;
   
   //CLASS CONSTRUCTORS
   // (+) IntegerDataItem()
   public IntegerDataItem(){}
   
   // (+) IntegerDataItem(int i)
   public IntegerDataItem(int i)
   { 
      set(i);
   }
   
   // (+) IntegerDataItem(IntegerDataItem idi)
   public IntegerDataItem(IntegerDataItem idi)
   { 
      set(idi.get());
   }
   
   // CHANGE STATE SERVICES
   // (+) void set(int i)
   public void set(int i) 
   { 
      myValue = i;
   }
   
   // READ STATE SERVICES
   // (+) boolean isLess(GenericItemType git)
   public boolean isLess(GenericItemType git)
   { 
      return (myValue < ((IntegerDataItem) git).get());
   }
   
   // (+) boolean isEqual(GenericItemType git)
   public boolean isEqual(GenericItemType git)
   { 
      return (myValue == ((IntegerDataItem) git).get());
   }
   
   // (+) boolean isGreater(GenericItemType git)
   public boolean isGreater(GenericItemType git)
   { 
      return (myValue > ((IntegerDataItem) git).get());
   }
   
   // (+) int get()
   public int get() 
   { 
      return myValue;
   }
   
   // (+) String toString()
   public String toString() 
   {
      return Integer.toString(myValue);
   }
} 