package room;

import anno.Direction;
import anno.Command;
import maze.MazeMaker;
import java.util.Scanner;

public class Room4 {
	Scanner input = new Scanner(System.in);
	@Direction(command="go to room3")
	private Room3 north;
	
	@Direction(command="go to room5")
	private Room5 secret;
	
	@Command(command="answer")
	public String answer(MazeMaker maze) 
	{
		if(maze.hasWord3) return "You already answered the question";
		System.out.println("What is 342 * 587?");
		int newInput = input.nextInt();
		if(newInput == (342 * 587)) 
		{
			maze.hasWord3 = true;
			return "A low voice reverberates the word 'Ka' and fades away\r\n" + 
					"You may now access secret Room5";
		}
		else 
		{
			maze.isDead = true;
			return "The door closes behind you and you are trapped here forever to contemplate the value of 342*587... The End";
		}
		
	}
	
	@Command(command="look")
	public String look(MazeMaker maze)
	{
		return "You see nothing else of interest.";
	}
	
	

	public String getDescription(MazeMaker maze)
	{
		return "You find yourself in an empty circular room.  On the wall opposite, you see '342 * 587 = _' \r\n" + 
				"You can say answer(), then enter your answer\r\n" + 
				"You can look() around";
	}
}
