import java.util.List;
import java.util.Set;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;



public class ClassScanner {
	
	public static void main(String[] args) throws Exception
	{
		FastClasspathScanner scanner = new FastClasspathScanner("lab.WarShip");
		ScanResult result = scanner.scan();
		
		List<String> allClasses = result.getNamesOfAllClasses();		
		System.out.println(allClasses);


				
		
	}

}
