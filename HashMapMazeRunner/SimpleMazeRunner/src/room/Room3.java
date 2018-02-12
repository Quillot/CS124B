package room;

import anno.Command;
import anno.Direction;
import maze.MazeMaker;

public class Room3 {
	
	private boolean canOpenChest = false;

	@Direction(command="go to room2")
	private Room2 west;
	@Direction(command="go to room5")
	private Room5 north;
	@Direction(command="go to room4")
	private Room4 south;
	
	@Command(command="look")
	public String look(MazeMaker maze)
	{
		canOpenChest = true;
		if(maze.hasKilledBabyDragon) return "You make your way to the other side of the chamber and find a chest.\nYou can openChest()";
		return "You quietly avoid the baby dragon and make your way to the other side of the chamber and find a chest.\r\n" + 
				"You can openChest()";
	}
	
	@Command(command="openChest")
	public String openChest(MazeMaker maze)
	{
		if(!canOpenChest) return "What chest?";
		maze.hasWord2 = true;
		return "Inside is a book.  A page is ear-marked and the word 'Ala' written in blood.";
	}
	

	@Command(command="attack")
	public String attack(MazeMaker maze)
	{
		if(maze.hasKilledBabyDragon) return "You already killed the baby dragon.";
		if(!maze.hasSword) 
		{
			maze.isDead = true;
			return "You charge the baby dragon and try to take in on with your bare hands.  Its wakes and bites your head clean off... The End";
		}
		else { 
			maze.hasKilledBabyDragon = true;
			return "You charge the baby dragon with your bright shiny sword.  You cleave its head clean off.\r\n" + 
			"You can look() around.";
		}
	}
	
	public String getDescription(MazeMaker maze)
	{
		return "You enter a large cavern and hear deep laboured breathing.\r\n" + 
				"In the center of the chamber is small baby dragon sleeping on a big pile of gold coins.\r\n" + 
				"You can attack() the dragon.\r\n" + 
				"You can look() around.";
	}
}
