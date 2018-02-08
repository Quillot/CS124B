package room;

import anno.Direction;

public class Room4 {
	@Direction(command="go north")
	private Room3 north;
	
	
	private int count = 0;

	public String getDescription()
	{
		count++;
		return "You are in room 4 -" +count+" times";
	}
}
