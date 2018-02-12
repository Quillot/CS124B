package room;

import anno.Command;
import anno.Direction;
import maze.MazeMaker;

public class Room2 {
	
	private boolean takeSwordCheck = false;

	@Direction(command="go to room3")
	private Room3 east;
	
	@Direction(command="go to room1")
	private Room1 south;

	@Command(command="swim")
	public String swim(MazeMaker maze) 
	{	
		if(!takeSwordCheck) 
		{
			takeSwordCheck = true;
			return "You find a shiny sword at the bottom.\nYou can takeSword";
		}
		else 
		{
			return "You already swam!";
		}
	}
	
	@Command(command="takeSword")
	public String takeSword(MazeMaker maze)
	{
		if(maze.hasSword) {
			return "You already have the sword";
		}
		else if(takeSwordCheck)  {
			maze.hasSword = true;
			return "You take the bright shiny sword";
		}
		else {
			return "How did you know the sword was there? You haven't even swam in the lake";
		}
	}
	
	@Command(command="look")
	public String look(MazeMaker maze)
	{
		return "You find a pile rubble.  It looks like a shallow grave.\r\n" + 
				"You can dig() to see what is under it.";
	}
	
	@Command(command="dig")
	public String dig(MazeMaker maze)
	{
		if(maze.hasDug) return "You've already dug here";
		maze.hasDug = true;
		maze.hasWord1 = true;
		return "You dig up the grave and find a skeleton holding a scroll.  It contains 3 words but 2 are unreadable.  The remaining word says 'Zam'";
	}
	
	public String getDescription(MazeMaker maze)
	{
		return "You see the door leads down some steps into an underground cave system. There is a deep pool in the middle of the cave.\r\n" + 
				"You see something shiny at the bottom of the pool.\r\n" + 
				"You can swim() in the pool.\r\n" + 
				"You can look() around.";		
	}
}
