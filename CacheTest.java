import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CacheTest {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		try {
			
			if(args.length == 2) {
				int size1 = Integer.parseInt(args[0]);
				int size2 = 0;
				String fileName = "" + args[1];
				if(size1 == 0) throw new IndexOutOfBoundsException("Incorect size for cashe 1");
				reader(size1, size2, fileName);
			} else if(args.length == 3) {
				int size1 = Integer.parseInt(args[0]);
				int size2 = Integer.parseInt(args[1]);
				if(size2 <= size1) throw new IndexOutOfBoundsException("Incorect size for cashe 2");
				String fileName = "" + args[2];
				
				reader(size1, size2, fileName);
			} else {
				System.out.println("incorrect input");
			}
			
		} catch(NumberFormatException e) {
			System.out.println("wrong inpute format");
		}
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("Time elapsed: " + time + " milliseconds");
	}
	
	public static void reader (int size1, int size2, String string) {
		
		File file = new File(string);
		Cache cache;
		
		if(size2 == 0) {
			cache = new Cache (size1);
		} else {
			cache = new Cache (size1, size2);
		}
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				//String v = scan.nextLine();
				
				StringTokenizer read = new StringTokenizer(scan.nextLine(), "\t ");
				while(read.hasMoreElements()) {
			        cache.getObject(read.nextToken());
				}
		      }
		    
			System.out.println(cache.toString());
			scan.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			
		}
	}
}
