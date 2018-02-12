package room;

import java.util.Scanner;

import anno.Direction;
import anno.Command;
import maze.MazeMaker;

public class Room5 {
	Scanner input = new Scanner(System.in);

	@Direction(command="go to room3")
	private Room3 south;
	
	public boolean canEnter(MazeMaker maze) {
		return maze.hasWord3 && maze.hasWord2 && maze.hasWord1;
	}

	public String getDescription(MazeMaker maze)
	{
		if(!canEnter(maze)) return "You are not allowed in this room. A ball of fire turns you to ash...";
		return "You enter a long tunnel which opens into a large chamber.\r\n" + 
				"You can see an opening to the outside on the other side.\r\n" + 
				"As you walk towards it, a large dragon head peers from the opening.\r\n" + 
				"'What is the passphrase?' it asks.\r\n" + 
				"You can try passphrase(), then enter the 3 strings\r\n" + 
				"You can attack() the dragon.\r\n" + 
				"You can look() around";
	}
	
	@Command(command="passphrase")
	public String passphrase(MazeMaker maze) 
	{
		System.out.println("Enter the 3 passphrase, with no space");
		String words = input.nextLine();
		if(words.equalsIgnoreCase("alakazam")) 
		{
			if(maze.hasKilledBabyDragon) 
			{
				maze.isDead = true;
				return "That is correct.  The dragon breathes fire into the chamber turning you to ash for killing her baby... The End.";
			}
			else 
			{
				maze.isDead = true;
				return "That is correct.  The dragon allows you to pass and you escape... Congratulations on your 10pts.";
			}
		}
		maze.isDead = true;
		return "That is incorrect.  The dragon breathes fire into the chamber turning you to ash... The End.";
		
		
	}
}
