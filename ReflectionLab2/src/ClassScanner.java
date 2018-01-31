import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Set;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;



public class ClassScanner {
	
	// Method that prints the info of a class
	// Prints fields, constructors, methods, and parameters
	public static void printClassInfo(String cls) throws Exception {
		Class<?> currClass = Class.forName(cls);
		System.out.println("Class: " + currClass.getName());
		
		// Fields
		if(currClass.getDeclaredFields().length > 0) {
			System.out.println("Fields:");
			for(Field f : currClass.getDeclaredFields()) {
				System.out.println("\t" + Modifier.toString(f.getModifiers()) + " " + f.getType() + " " + f.getName() + ";");
			}
		}
		
		// Constructors
		try {
			if(currClass.getDeclaredConstructor() != null) {
				System.out.println("Constructors:");
				System.out.println("\t" + currClass.getDeclaredConstructor() + ";");
			}
		} catch (Exception e) {
			
		}
		
		// Methods
		System.out.println("Methods:");
		for(Method m : currClass.getDeclaredMethods()) {
			System.out.print("\t" + Modifier.toString(m.getModifiers()) + " " + m.getReturnType() + " " + m.getName() + "(");
			Parameter params[] = m.getParameters();	
			// Loop through parameters with a var, so that you can check if last param 
			for(int paramNum = 0; paramNum < m.getParameterCount(); paramNum ++) {
				System.out.print(params[paramNum].getType());
				if(!(paramNum == m.getParameterCount() - 1)) {
					System.out.print(", ");
				}
			}
			System.out.println(");");
		}
		System.out.println();
	}
	
	// Takes in a string cls, and recurses through the superclasses of cls
	// Base case of cls.equals("java.lang.Object")
	// printClassInfo starts at the 'bottom', at java.lang.Object
	public static int getClassInfo(String cls) throws Exception {
		Class<?> currClass = Class.forName(cls);
		try {
			getClassInfo(currClass.getSuperclass().getName());
		} catch (Exception e) {
			// If no super class
			printClassInfo(cls);
			return 1;
		}
		printClassInfo(cls);
		return 1;
	}
	
	public static void main(String[] args) throws Exception
	{
		FastClasspathScanner scanner = new FastClasspathScanner("lab");
		ScanResult result = scanner.scan();
		
		List<String> allClasses = result.getNamesOfAllClasses();		
		System.out.println(allClasses);
		
		// Get the class info of input object and its super classes
		getClassInfo("lab.WaterVehicle");
	}

}
