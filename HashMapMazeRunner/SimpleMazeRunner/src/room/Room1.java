package room;

import anno.Command;
import maze.MazeMaker;
import anno.Direction;

public class Room1 {

	@Direction(command="go to room2")
	private Room2 north;
	
	public String getDescription(MazeMaker maze)
	{
		return "You find yourself inside a dark room.  You see four doors marked Room2, Room3, Room4\nType 'go to room#' to enter.";
	}
}
