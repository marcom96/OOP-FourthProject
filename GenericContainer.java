/**   
   @author       Marco Martinez
   @fileName     GenericContainer.java
   @version      1.0
   @description  This program will construct and manipulate GenericContainer objects.
   
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
      IntegerDataItem(1) --- inherits --- (1) GenericItemType
      StringDataItem(1) --- inherits --- (1) GenericItemType
      Hourly(1) --- inherits --- (1) Employee
      Salary(1) --- inherits --- (1) Employee
      Piece(1) --- inherits --- (1) Employee
      GenericContainer(1) --- contains --- (m) GenericItemType
      AppDriver(1) --- uses --- (1) GenericContainerClasses
   
   GenericContainer
      CLASS CONSTRUCTOR
         (+) GenericContainer()
         (+) GenericContainer(int size)
         (+) GenericContainer(GenericContainer gc)
         
      CHANGE STATE SERVICES
         (+) void init()
         (+) void add(GenericItemType git)
         (+) void remove(GenericItemType git)
         (+) GenericItemType search(GenericItemType key)
         (-) GenericItemType biSearch(GenericItemType key,int low,int high)
         (+) void sort()
         (-) void qSort(int start, int finish)
         (+) void Iterator_Initialize()
         
      READ STATE SERVICES
         (+) int getMax()
         (+) int getLength()
         (+) int getCurrentIndex()
         (+) GenericItemType get(int i)
         (+) boolean Iterator_hasNext()
         (+) GenericItemType Iterator_getNext()
   
   @date         12/12/2018

   Program Change Log 
   ==========================
   Name     Date     Description
   Marco    12/12    Create baseline for GenericContainer.
 */
 
public class GenericContainer
{
   // INSTANCE VARIABLE DECLARATION
   private final int MAXSIZE = 30;
   private int sizeLimit,
               index,
               currentIndex;
   private GenericItemType[] collection;
   
   // CLASS CONSTRUCTORS
   // (+) GenericContainer()
   public GenericContainer()
   {
      this.collection = new GenericItemType[MAXSIZE];
      this.sizeLimit = MAXSIZE; 
      this.currentIndex = 0; 
   }
   
   // (+) GenericContainer(int size)
   public GenericContainer(int size)
   { 
      this.currentIndex = 0;
      if (size <= MAXSIZE)
         this.sizeLimit = size;
      else
         this.sizeLimit = MAXSIZE;
   }
   
   // (+) GenericContainer(GenericContainer gc)
   public GenericContainer(GenericContainer gc)
   { 
      this.currentIndex = this.index = 0;
      gc.Iterator_Initialize();
      while (gc.Iterator_hasNext()) 
      {
         this.collection[this.currentIndex] = gc.Iterator_getNext();
         this.index++;
      }
   }
   
   // CHANGE STATE SERVICES 
   // (+) void init()
   public void init()
   { 
      Iterator_Initialize();
      while (Iterator_hasNext()) 
         this.collection[this.currentIndex] = null;
   }
   
   // (+) void add(GenericItemType git)
   public void add(GenericItemType git)
   {
      this.collection[this.index++] = git;
   }
   
   // (+) void remove(GenericItemType git)
   public void remove(GenericItemType git)
   {
      Iterator_Initialize();
      GenericItemType temp;
      while (Iterator_hasNext())
      {
         temp = Iterator_getNext();
         if (temp.isEqual(git))
         {
            this.collection[this.currentIndex-1] = this.collection[this.index-1];
            this.collection[this.index-1] = new IntegerDataItem();
            this.index--;
            return;
         }
      }
   }
   
   // (+) GenericItemType search(GenericItemType key)
   public GenericItemType search(GenericItemType key)
   {
      return biSearch(key,0,this.index);
   }
   
   // (-)  GenericItemType biSearch(GenericItemType key,int low,int high)
   private GenericItemType biSearch(GenericItemType key,int low,int high)
   {       
      while(high >= low) 
      {
         int middle = (low + high) / 2;
         if (collection[middle].isEqual(key))
         {
            return collection[middle];
         }
         if (collection[middle].isGreater(key)) 
         {
            return biSearch(key, low, middle-1);
         }
         if (collection[middle].isLess(key)) 
         {
            return biSearch(key, middle+1, high);
         }   
      }   
      return new StringDataItem();
   }
   
   // (+) void bubbleSort()
   public void bubbleSort()
   {
      int outer,inner;

      for (outer=0;outer < this.index;outer++)
         for(inner=0; inner < this.index-1;inner++)
         {
            if (collection[inner].isGreater(collection[inner+1]))
            {
               GenericItemType temp = collection[inner];
               collection[inner] = collection[inner+1];
               collection[inner+1] = temp;
            }
         }
   }
   
   // (+) void sort()
   public void sort()
   {
      if (this.index > 0) qSort(0, this.index-1);
   }
   
   // (-)  void qSort(int start, int finish)
   private void qSort(int start, int finish)
   {
      int i = start;
      int j = finish;
      GenericItemType pivot = this.collection[start + (finish - start) / 2];

      while (i <= j) 
      {
         while (this.collection[i].isLess(pivot)) 
         {
            i++;
         }

         while (this.collection[j].isGreater(pivot)) 
         {
            j--;
         }

         if (i <= j) 
         {
            GenericItemType temp = this.collection[i];
            this.collection[i] = this.collection[j];
            this.collection[j] = temp;
            i++;
            j--;
         }
      }
    
      if (start < j) 
      {
            qSort(start, j);
      }
      if (i < finish) 
      {
            qSort(i, finish);
      }
   }
   
   // (+) int getMax()
   public int getMax()
   {
      if (this.sizeLimit != 0)
         return sizeLimit;
      else
         return MAXSIZE;
   }
   
   // (+) int getLength()
   public int getLength()
   {
      return this.index;
   }
   
   // (+) int getCurrentIndex()
   public int getCurrentIndex()
   {
      return this.currentIndex;
   }
   
   // (+) GenericItemType get(int i)
   public GenericItemType get(int i)
   {
      return this.collection[i];
   }
   
   // (+) void Iterator_Initialize()
   public void Iterator_Initialize() 
   {
      this.currentIndex = 0;
   }
   
   // (+) boolean Iterator_hasNext()
   public boolean Iterator_hasNext() 
   {
      return this.currentIndex <= this.index-1;
   }
   
   // (+) GenericItemType Iterator_getNext()
   public GenericItemType Iterator_getNext()
   { 
      return this.collection[this.currentIndex++];
   }
}