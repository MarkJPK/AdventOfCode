package puzzle6;

public class puzzle_6 {

	public static void main(String[] args)
	{
	  int valueToFind  = 265149;
	  int answer       = -1;
	  
	  Grid grid = new Grid(valueToFind);
	  
	  while((answer = grid.appendValue()) == -1)
	  {
	  }
	  
	  System.out.println("Answer = " + answer);
	}
}
