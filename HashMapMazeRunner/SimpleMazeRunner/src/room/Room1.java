package room;

import anno.Command;
import anno.Direction;

public class Room1 {

	@Direction(command="go north")
	private Room2 north;


	private Object boo;
	
	private int count = 0;
	
	public String getDescription()
	{
		count++;
		return "You are in room 1 - "+count+" times";
	}
	
	@Command(command="dig")
	public String dig() 
	{
		return "You dug";
	}
	
	public void look() 
	{
		
		return;
	}
}
