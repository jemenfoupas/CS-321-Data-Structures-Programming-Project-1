import java.text.DecimalFormat;
import java.util.LinkedList;

public class Cache<T> implements CacheInterface<T> {

	
	private double HR1;
	private double HR2;
	private double HR;
	private int NH1;
	private int NH2;
	private int NH;
	private int NR1;
	private int NR2;
	private int NR;
	private int levelOneSize;
	private int levelTwoSize;
	private LinkedList<T> levelOne;
	private LinkedList<T> LevelTwo;
	
	
	/**
	 * Constructor
	 */
	public Cache(int size) {
		levelOne = new LinkedList<T>();
		LevelTwo = new LinkedList<T>();
		levelOneSize = size;
		levelTwoSize = 0;
		
	}
	
	/**
	 * Constructor
	 */
	public Cache(int size1, int size2) {
		levelOne = new LinkedList<T>();
		LevelTwo = new LinkedList<T>();
		levelOneSize = size1;
		levelTwoSize = size2;
		
	}

	@Override
	public T getObject(T o) {
		
		NR1++;
		if(levelOne.contains(o)) {
			NH1++;
			T result = o;
			levelOne.remove(result);
			levelOne.addFirst(result);
			if(levelTwoSize != 0) {
				LevelTwo.remove(result);
				LevelTwo.addFirst(result);
			}
			return result;
			
		} else if(levelTwoSize != 0) {
			
			NR2++;
			if(LevelTwo.contains(o)) {
				NH2++;
				T result = o;
				
				levelOne.addFirst(result);
				if(levelOne.size() > levelOneSize) levelOne.removeLast();
				
				LevelTwo.remove(result);
				LevelTwo.addFirst(result);
			    
				return result;
			}
		}

		addObject(o);
		return o;
	}

	@Override
	public void addObject(T o) {
		
		levelOne.addFirst(o);
		if(LevelTwo.size() != 0 ) LevelTwo.addFirst(o);
		
		if(levelOne.size() > levelOneSize) levelOne.removeLast();
		if( LevelTwo.size() > levelTwoSize) LevelTwo.removeLast();
		
	}

	@Override
	public T removeObject(T o) {
		
		T result = o;
		if(levelOne.contains(o)) levelOne.remove(o);
		if(LevelTwo.contains(o)) LevelTwo.remove(o);
		return result;
		
	}

	@Override
	public T clearCache(T o) {
		levelOne.removeAll(levelOne);
		LevelTwo.removeAll(LevelTwo);
		return o;
	}
	
	public String toString() {
		NH = NH1 + NH2;
		NR = NR1;
		
		DecimalFormat numberFormat = new DecimalFormat("#0.0000");
		HR = (double)NH / NR;
		HR1 = (double)NH1 / NR1;
		HR2 = (double) NH2 / NR2;
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println( "First level cache with " + levelOneSize + " entries has been created");
		System.out.println("Second level cache with "+ levelTwoSize +" entries has been created ");
		System.out.println("................................");
		System.out.println("Total number of references:        " + NR1);
		System.out.println("Total number of cache hits:        " + NH);
		System.out.println(" ");
		System.out.println("The global hit ratio:  " + numberFormat.format(HR));
		System.out.println(" ");
		System.out.println("Number of 1st-level cache references:" + NR1);
		System.out.println("Number of 1st-level cache hits:    " + NH1);
		System.out.println("1st-level cache hit ratio:         " + numberFormat.format(HR1));
		System.out.println();
		System.out.println("Number of 2nd-level cache references:" + NR2);
		System.out.println("Number of 2nd-level cache hits:    " + NH2);
		String last = "2nd-level cache hit ratio:         " + numberFormat.format(HR2);
		return last;
	}
}
