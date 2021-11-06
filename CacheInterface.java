
public interface CacheInterface<T> {

	/**
	 * 
	 * @return this method looks throught the cache(s) for the word
	 * if the cach(s) contain the word then it increments the number of hit and refferentces.
	 */
	public T getObject(T T);
	
	/**
	 * 
	 * this adds an objet to the object
	 */
	public void addObject(T T);
	
	/**
	 * this method removes a provided object from the linkist
	 * @return the removed object
	 */
	public T removeObject(T T);
	
	/**
	 * removes all objects from the linklist
	 * @return the removed object
	 */
	public T clearCache(T T);
	
	 /**  
     * Returns a string representation of this list. 
     * @return a string representation of this list
     */
    public String toString();

}
