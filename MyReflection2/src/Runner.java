import java.lang.reflect.Method;
import java.util.Arrays;

import Boo.TargetClass;


public class Runner {
	public static void main(String[] Args) throws Exception {

		
//		TargetClass tc;
//		tc = new TargetClass();
//		tc.setName("New Names");
//		tc.setAge(10);
//		System.out.println(tc.toString());
		
		 Class cls = Class.forName("Boo.TargetClass");
		// System.out.println(Arrays.toString(cls.getDeclaredMethods()));  // Print all methods of class
		
		Object tc = cls.newInstance();  // Assumes that its using a default constructor
//		
//		Method m1 = cls.getDeclaredMethod("setName", String.class);
//		m1.invoke(tc, "Bogus");
//		
//		Method m2 = cls.getDeclaredMethod("setAge",  Integer.TYPE);
//		m2.invoke(tc,  10);
//		
		Method m3 = cls.getDeclaredMethod("setAll", String.class, Integer.TYPE);
		m3.invoke(tc,  "Not Bogus", 1000);
		System.out.println(tc);
	}
}
