import java.lang.reflect.Array;

public class CircularQueue<T> {
	
	//head index and tail index when there is nothing in queue.
	private static final int SPECIAL_EMPTY_VALUE = -1;
	private static int  MAX_SIZE =40;
	
	private T[] elements;
	//intial value before enqueuing any elements
	private int headIndex = SPECIAL_EMPTY_VALUE;
	private int tailIndex = SPECIAL_EMPTY_VALUE;

	@SuppressWarnings("unchecked")
	CircularQueue(Class<T> clazz){
		elements = (T[])Array.newInstance(clazz,MAX_SIZE);
	}
	
	public boolean isEmpty(){
		return headIndex == SPECIAL_EMPTY_VALUE;
	}
	
	public boolean isFull(){
		
		int indexCount = (tailIndex+1) % elements.length;
		return indexCount == headIndex;
	}
}