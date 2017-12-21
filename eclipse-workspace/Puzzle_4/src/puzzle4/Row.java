package puzzle4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Row
{
  ArrayList<Integer> integerList = new ArrayList<Integer>();
  
  String thisRow = null;
  
  //  Constructor
  
  Row(String rowString)
  {
    thisRow = rowString;
  }
  
  //  Procedure to calculate and return the result
  
  public int getResult()
  {
    //  Tokenise the string
    
    StringTokenizer st1 = new StringTokenizer(thisRow);

    //  Loop through each token
    
    while(st1.hasMoreTokens())
    {
      //  Convert the token to an integer and add it to the list
      
      integerList.add(Integer.parseInt(st1.nextToken()));
    }
    
    //  Assign an iterator from the list
    
    Iterator<Integer> srcIterator = integerList.iterator();
    
    //  Iterate through the list
    
    while(srcIterator.hasNext())
    {
      //  Get the integer referred to by this iterator
      
      int srcInteger = srcIterator.next();
      
      //  Assign an iterator from the list
      
      Iterator<Integer> destIterator = integerList.iterator();
      
      //  Iterate through the list
      
      while(destIterator.hasNext())
      {
        //  Get the integer referred to by this iterator
        
        int destInteger = destIterator.next();
        
        //  Check that the two iterators are not pointing at the same value
        //  (assumes that the same value will not appear in the list twice)
        
        if(srcInteger != destInteger)
        {
          //  If the integers may be wholly divided, return the result
          
          if     (srcInteger  % destInteger == 0) return(srcInteger  / destInteger);
          else if(destInteger % srcInteger  == 0) return(destInteger / srcInteger);
        }
      }
    }
    
    //  If this point has been reached an error has occurred
    
    System.out.println("No match");
    
    return(0);
  }
}
