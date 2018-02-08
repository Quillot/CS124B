package room;

import anno.Direction;

public class Room2 {

	@Direction(command="go east")
	private Room3 east;
	
	@Direction(command="go south")
	private Room1 south;
	
	private int count = 0;

	
	public String getDescription()
	{
		count++;
		return "You are in room 2 - "+count+" times";
	}
}
