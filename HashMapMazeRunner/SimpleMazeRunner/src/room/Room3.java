package room;

import anno.Direction;

public class Room3 {

	@Direction(command="go west")
	private Room2 west;
	@Direction(command="go north")
	private Room5 north;
	@Direction(command="go south")
	private Room4 south;
	
	
	private int count = 0;

	public String getDescription()
	{
		count++;
		return "You are in room 3 -" +count+" times";
	}
}
