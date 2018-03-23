package Heaps;

public class Heap {
	
	Integer[] heap;
	int size;
	int currentPosition = -1;
	
	public Heap(int size) {
		this.size = size;
		heap = new Integer[size];
	}
	
	public void insert(int data) throws Exception{
		currentPosition++;
		if(isFull())
			throw new Exception("Heap is full.");
		heap[currentPosition] = data;
		fixUp(currentPosition);
	}
	
	/**
	 * This is similar to delete and return; it returns the topmost item.
	 * After removal we need to apply rectification process
	 * @return
	 */
	public int getMax(){
		int max = this.heap[0];
		this.heap[0] = this.heap[currentPosition--];
		this.heap[currentPosition+1] = null; // important as we need to remove the last item
		fixDown(0,-1);
		
		return max;
	}
	
	/**
	 * Rectification of heap if a new element is added
	 * O(log n)
	 * @param index
	 */
	public void fixUp(int index){
		int parentIndex = (index-1)/2;
		while(parentIndex>=0 && heap[index]>heap[parentIndex]){
			//if(heap[index]>heap[parentIndex]){
				int temp = this.heap[parentIndex];
				this.heap[parentIndex] = this.heap[index];
				this.heap[index] = temp;
				index = parentIndex;
			//}
			parentIndex = (index-1)/2;
		}
	}
	
	/**
	 * Rectification of heap after removing the topMost element
	 * O(log N)
	 * @param i
	 * @param currentPosition
	 */
	public void fixDown(int index, int upto){
		
		if(upto<0)
			upto = currentPosition; // last element INDEX of the heap // for heapSort this isn't the case.
		
		while(index <= upto){  
			int leftChildIndex = (2*index) + 1 ;
			int rightChildIndex = (2*index) + 2;
			
			if(leftChildIndex <= upto){
				int swapItemIndex;
				
				if(rightChildIndex > upto)
					swapItemIndex = leftChildIndex; // assigning Index
				else{
					swapItemIndex = (heap[leftChildIndex]>heap[rightChildIndex])? leftChildIndex: rightChildIndex;
				}
				
				//swap the elements only if child is greater than parent
				if(heap[index]< heap[swapItemIndex]){
					int temp = heap[index];
					heap[index] = heap[swapItemIndex];
					heap[swapItemIndex] = temp;
				}
				
				index = swapItemIndex;
				
			}
			else{
				break;
			}
			
		}
	}
	
	public void heapSort(){
		for(int i=0 ; i<=currentPosition;i++){
			int temp = heap[0];
			System.out.println(temp);

			heap[0] = heap[currentPosition-i];
			heap[currentPosition-i] = temp;
			fixDown(0, currentPosition-i-1);
		}
		
	}
	
	public boolean isFull(){
		return this.currentPosition == this.heap.length;
	}

}
