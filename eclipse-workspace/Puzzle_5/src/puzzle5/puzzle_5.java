package puzzle5;

public class puzzle_5 {

	public static void main(String[] args)
	{
	  int valueToFind  = 265149;
	  int steps        = -1;
	  
	  Grid grid = new Grid(valueToFind);
	  
	  for(int i = 1 ; ; i++)
	  {
      if((steps = grid.appendValue(i)) != -1)
	    {
	      break;
	    }
	  }
	  
	  System.out.println("Steps = " + steps);
	}
}
