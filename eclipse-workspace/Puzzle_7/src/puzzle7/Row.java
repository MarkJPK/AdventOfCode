package puzzle7;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Row
{
  ArrayList<String> mStringList = new ArrayList<String>();
  
  String mRow     = null;
  int mLineNumber = 0;
  
  //  Constructor
  
  Row(int lineNumber, String rowString)
  {
    mRow        = rowString;
    mLineNumber = lineNumber;
  }
  
  //  Procedure to calculate and return the result
  
  public int getResult()
  {
    //  Tokenise the string
    
    StringTokenizer st1 = new StringTokenizer(mRow);

    //  Loop through each token
    
    while(st1.hasMoreTokens())
    {
      //  Convert the token to a string
      
      String thisToken = st1.nextToken();
      
      //  Check whether the list already contains this string
      
      if(mStringList.contains(thisToken))
      {
        //  List already contains this string, return 0
       
        System.out.println("Line " + mLineNumber + " : Already contains string " + thisToken);
        
        return(0);
      }
      else
      {
        //  List does not contain this string, add it to the list
        
        mStringList.add(thisToken);
      }
    }
    
    //  All strings added with no duplicates, return 1
    
    return(1);
  }
}
