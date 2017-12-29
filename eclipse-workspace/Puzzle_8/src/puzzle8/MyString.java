package puzzle8;

import java.util.Arrays;

public class MyString
{
  private String myString;
  
  //  Constructor
  
  MyString(String initialString)
  {
    myString = initialString;
  }
  
  //  Override the equals method
  
  @Override
  public boolean equals(Object o)
  {
    //  If the object is NULL return False
    
    if(o == null) return(false);
    
    //  If the object passed is this object return True
    
    if(o == this) return(true);
    
    //  Sort the strings to be compared and return the result of equals()
    
    return(sortString(((MyString)o).getMyString()).equals(sortString(myString)));
  }
  
  //  Procedure to get the string
  
  public String getMyString()
  {
    return(myString);
  }
  
  //  Procedure to set the string
  
  public void setMyString(String newString)
  {
    myString = newString;
  }
  
  //  Procedure to sort the string
  
  private String sortString(String stringToBeSorted)
  {
    //  Convert the string to a character array
    
    char[] charArray = stringToBeSorted.toCharArray();
    
    //  Sort the character array
    
    Arrays.sort(charArray);
    
    //  Convert the sorted character array to a string
    
    String sortedString = new String(charArray);
    
    //  Return the sorted string
    
    return(sortedString);
  }
}
