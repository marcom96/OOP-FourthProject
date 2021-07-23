/**
         GenericItemType // is an abstract class
           (+) abstract boolean isLess(GenericItemType)
           (+) abstract boolean isEqual(GenericItemType)
           (+) abstract boolean isGreater(GenericItemType)
           
         IntegerDataType --- 1 :  1 (inherits) ---> GenericItemType
           (+) all constructors
           (+) boolean isLess(GenericItemType) // overrides of base method
           (+) boolean isEqual(GenericItemType)
           (+) boolean isGreater(GenericItemType)
           (+) accessors (get(), toString())
           (+) manipulators
           
         StringDataType --- 1 :  1 (inherits) ---> GenericItemType
           (+) boolean isLess(GenericItemType) // override of base method
           (+) boolean isEqual(GenericItemType)
           (+) boolean isGreater(GenericItemType)
           
         GenericContainer --- 1 :  m (contains) --- GenericItemType 
*/

public class Main
{
   public static void main(String[] args)
   {
       GenericContainer gC = new GenericContainer();
   
       gC.add(new IntegerDataItem(13));
       gC.add(new IntegerDataItem(-30)); 
       gC.add(new IntegerDataItem(100));
       gC.add(new IntegerDataItem(70));
       gC.add(new IntegerDataItem(45));
       gC.sort();
       System.out.printf("    Sorted Integer Collection\n");
       gC.Iterator_Initialize();
       while (gC.Iterator_hasNext())  {
          IntegerDataItem nextOne = (IntegerDataItem )(gC.Iterator_getNext());   
          System.out.printf("  %5d", nextOne.get());
          if (!(gC.Iterator_hasNext())) System.out.printf("\n\n");
       }
       GenericContainer sgC= new GenericContainer();
       sgC.add(new StringDataItem("Johnson"));
       sgC.add(new StringDataItem("Dixon")); 
       sgC.add(new StringDataItem("Adams"));
       sgC.add(new StringDataItem("Baker"));
       sgC.add(new StringDataItem("Lee"));
       sgC.add(new StringDataItem("Camille"));
       sgC.sort();
       System.out.printf("    Sorted string Collection\n");
       System.out.print("  ");
       sgC.Iterator_Initialize();
       while (sgC.Iterator_hasNext())  {
          StringDataItem nextOne = (StringDataItem) (sgC.Iterator_getNext());   
          System.out.printf("  %s", nextOne.get());
          if (!(sgC.Iterator_hasNext())) System.out.printf("\n");
       }
   } // main
} // class
