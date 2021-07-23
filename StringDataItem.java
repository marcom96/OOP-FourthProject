/**   
   @author       Marco Martinez
   @fileName     StringDataItem.java
   @version      1.0
   @description  This program will construct and manipulate StringDataItem objects.
   
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
   
   StringDataItem
      INSTANCE VARIABLE DECLARATION
         (-) String myString;
         
      CLASS CONSTRUCTORS
         (+) StringDataItem()
         (+) StringDataItem(String s)
         (+) StringDataItem(StringDataItem sdi)
         
      CHANGE STATE SERVICES
         (+) void set(String s)
         
      READ STATE SERVICES
         (+) boolean isLess(GenericItemType git)
         (+) boolean isEqual(GenericItemType git)
         (+) boolean isGreater(GenericItemType git)
         (+) String get()
         (+) String toString()
   
   @date         12/12/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    12/12    Create baseline for StringDataItem.
 */
 
public class StringDataItem extends GenericItemType
{
   // INSTANCE VARIABLE DECLARATION
   private String myString;
   
   // CLASS CONSTRUCTORS
   // (+) StringDataItem()
   public StringDataItem(){}
   
   // (+) StringDataItem(String s)
   public StringDataItem(String s)
   { 
      myString = new String(s);
   }
   
   // (+) StringDataItem(StringDataItem sdi)
   public StringDataItem(StringDataItem sdi)
   { 
      set(sdi.get());
   }
   
   // CHANGE STATE SERVICES
   // (+) void set(String s)
   public void set(String s) 
   { 
      myString = s;
   }
   
   // READ STATE SERVICES
   // (+) boolean isLess(GenericItemType git)
   public boolean isLess(GenericItemType git)
   { 
      return ( myString.compareTo(((StringDataItem) git).get()) < 0);
   }
   
   // (+) boolean isEqual(GenericItemType git)
   public boolean isEqual(GenericItemType git)
   { 
      return ( myString.compareTo(((StringDataItem) git).get()) == 0);
   }
   
   // (+) boolean isGreater(GenericItemType git)
   public boolean isGreater(GenericItemType git)
   { 
      return ( myString.compareTo(((StringDataItem) git).get()) > 0);
   }
   
   // (+) String get()
   public String get() 
   { 
      return myString;
   }
   
   // (+) String toString()
   public String toString()
   {
      return "Value of myString: " + myString;
   }
}
