package room;

import anno.Direction;

public class Room5 {

	@Direction(command="go south")
	private Room3 south;
	
	
	private int count = 0;

	public String getDescription()
	{
		count++;
		return "You are in room 5 - "+count+" times";
	}
}
