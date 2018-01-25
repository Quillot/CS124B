import java.lang.reflect.*;


public class TheLongWay
{
    public static void main(String[] args) throws Exception
    {
        Class<?> room1Class = Class.forName("Room1");
        Object room1 = room1Class.newInstance();
        
        // Room 2
        Class<?> room2Class = Class.forName("Room2");
        Object room2 = room2Class.newInstance();
        
        // Swim at room 2
        System.out.println("You [Swim] at Room 2");
        Method room2Swim = room2Class.getMethod("swim");
		room2Swim.invoke(room2);
		System.out.println();
		
		// takeSword at room 2
		System.out.println("You [takeSword] at Room 2");
        Method room2takeSword = room2Class.getMethod("takeSword");
		room2takeSword.invoke(room2);
		System.out.println();
		
		// Look at room 2
        System.out.println("You [Look] at Room 2");
		Method room2Look = room2Class.getMethod("look");
		room2Look.invoke(room2);
		System.out.println();
		
		// dig at room 2
        System.out.println("You [dig] at Room 2");
		Method room2Dig = room2Class.getDeclaredMethod("dig");
		room2Dig.setAccessible(true);
		room2Dig.invoke(room2);
		System.out.println();


        // Room 3
        Class<?> room3Class = Class.forName("Room3");
        Object room3 = room3Class.newInstance();

        // attack the dragon at room 3
//        System.out.println("You [attack] at Room 3");
//		Method room3Attack = room3Class.getDeclaredMethod("attack");
//		room3Attack.setAccessible(true);
//		room3Attack.invoke(room3);
//		System.out.println();

		// look at room 3
		 System.out.println("You [look] at Room 3");
		Method room3Look = room3Class.getDeclaredMethod("look");
		room3Look.setAccessible(true);
		room3Look.invoke(room3);
		System.out.println();

		// openChest at room 3
		 System.out.println("You [openChest] at Room 3");
		Method room3OpenChest = room3Class.getDeclaredMethod("openChest");
		room3OpenChest.setAccessible(true);
		room3OpenChest.invoke(room3);
		System.out.println();


		// Room 4
        Class<?> room4Class = Class.forName("Room4");
        Object room4 = room4Class.newInstance();

        // answer at room 4
        System.out.println("You [answer] at Room 4");
		Method room4Answer = room4Class.getDeclaredMethod("answer", Integer.TYPE);
		room4Answer.setAccessible(true);
		room4Answer.invoke(room4, 200754);
		System.out.println();
		
		// Room 5
        Class<?> room5Class = Class.forName("Room5");
        Constructor<?> room5C = room5Class.getDeclaredConstructor();
        room5C.setAccessible(true);
        Object room5 = room5C.newInstance();
        
        // Passphrase at Room 5
        System.out.println("You [passphrase] at Room 5");
		Method room5Answer = room5Class.getDeclaredMethod("passphrase", String.class, String.class, String.class);
		room5Answer.setAccessible(true);
		room5Answer.invoke(room5, "Ala", "Ka", "Zam");
		System.out.println();


		

		
		
		
        
    }
}
