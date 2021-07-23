/**   
   @author       Marco Martinez
   @fileName     GenericItemType.java
   @version      1.0
   @description  This program will construct and manipulate GenericItemType objects.
   
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
   
   GenericItemType
      (+) Abstract boolean isLess(GenericItemType)
      (+) Abstract boolean isEqual(GenericItemType)
      (+) Abstract boolean isGreater(GenericItemType)

   
   @date         10/11/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    12/12    Create baseline for GenericItemType.
 */
 
public abstract class GenericItemType
{ 
   // (+) abstract boolean isLess(GenericItemType git)
   public abstract boolean isLess(GenericItemType git);
   
   // (+) abstract boolean isEqual(GenericItemType git)
   public abstract boolean isEqual(GenericItemType git);
   
   // (+) abstract boolean isGreater(GenericItemType git)
   public abstract boolean isGreater(GenericItemType git);
}
