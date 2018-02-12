package maze;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import anno.Direction;
import anno.Command;

public class MazeMaker 
{

	private HashMap<Class, Object> roomMap = new HashMap<Class, Object>();
	// Word bools: word1 => room2, word2 => room3
	public static boolean hasWord1, hasWord2, hasWord3;
	// Room 2 bools
	public static boolean hasSword, hasDug;
	// Room 3 bools
	public static boolean hasKilledBabyDragon;
	// Gamestate bools
	public static boolean isDead;
	
	public void load() throws Exception
	{
		// load all names
		FastClasspathScanner scanner = new FastClasspathScanner("room");
		ScanResult result = scanner.scan();
		
		List<String> allClasses = result.getNamesOfAllClasses();		
		System.out.println(allClasses);
		
		// instantiate
		for (String className : allClasses)
		{
			Class clazz = Class.forName(className);
			Object instance = clazz.newInstance();
			
			// associate the clazz to the instance
			roomMap.put(clazz, instance);
		}
		
		// associate fields

		for (Class roomClazz : roomMap.keySet())
		{
			Object currentRoom = roomMap.get(roomClazz);
			
			for (Field f : roomClazz.getDeclaredFields())
			{
				if (f.isAnnotationPresent(Direction.class))
				{
					Class fieldClazz = f.getType();
					Object roomInstance = roomMap.get(fieldClazz);
					f.setAccessible(true);
					f.set(currentRoom, roomInstance);
				}
			}
		}
		
		//Associate methods
		for (Class roomClazz : roomMap.keySet())
		{
			Object currentRoom = roomMap.get(roomClazz);
			
			for (Method m : roomClazz.getDeclaredMethods())
			{
				if (m.isAnnotationPresent(Command.class))
				{
					Class methodClazz = m.getDeclaringClass();
					Object roomInstance = roomMap.get(methodClazz);
					m.setAccessible(true);
				}
			}
		}
		
		
		// set the first room
		currentRoom = roomMap.get(room.Room1.class);
		printDescription();
	}
	


	private Object currentRoom;
	
	public void printDescription() throws Exception
	{
		Method m = currentRoom.getClass().getDeclaredMethod("getDescription", MazeMaker.class);
		System.out.println(m.invoke(currentRoom, this));
	}
	
	
	// Move checks fields, then methods for the command
	public void move(String command)
	{
		Class clazz = currentRoom.getClass();
		try
		{
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field f : fields)
			{
				if (f.isAnnotationPresent(Direction.class))
				{
					Direction d = f.getAnnotation(Direction.class);
					
					
					if (d.command().equals(command))
					{
						Class fieldClass = f.getType();
						currentRoom = roomMap.get(fieldClass);
						printDescription();	
					}
				}
			}
			
			// Try method
			Method[] methods = clazz.getDeclaredMethods();	
			
			for (Method m : methods)
			{
				if (m.isAnnotationPresent(Command.class))
				{
					Command c = m.getAnnotation(Command.class);
	
					if (c.command().equals(command))
					{
						System.out.println(m.invoke(currentRoom, this));
					}
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("You can't do that");
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		MazeMaker maze = new MazeMaker();
		maze.load();
		
		
		// take my input
		Scanner scanner = new Scanner(System.in);
		
		while (!isDead)
		{
			System.out.println();
			System.out.println("What do you want to do?: ");
			String text = scanner.nextLine();
			if (text.equals("exit"))
			{
				break;
			}
			else
			{
				maze.move(text);
			}
		}
		System.out.println("Game ended");
	}
}
