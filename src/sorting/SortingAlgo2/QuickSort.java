package sorting.SortingAlgo2;

public class QuickSort {
	
	static int[] num = {234,234,34,32,34,3,1,-34,76};

	public static void main(String[] args) {
		//int[] num = {234,234,34,32,34,3,1,-34,76};
		System.out.println();
		printNum(num);
		System.out.println();
		quickSort(num, 0, num.length-1);
		printNum(num);
	}
	
	public static void quickSort(int[] num, int low, int high){
		if(low>=high)
			return;
		
		int pivotIndex = partition(num, low, high);
		quickSort(num, low, pivotIndex-1); // left sub array
		quickSort(num, pivotIndex+1,high); //right sub array
	}
	
	public static int partition(int[] num, int low, int high){
		
		int pivotIndex = (low+high) /2;
		swap(pivotIndex,high);
		
		int i = low;
		
		for(int j=low ; j<high ; j++){
			if(num[j]<=num[high]){
				swap(i,j);
				i++;
			}
		}
		
		swap(i,high);
		return i;
	}
	
	public static void swap(int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public static void printNum(int... num){
		for(int i = 0 ; i <num.length ; i++){
			System.out.print(num[i]+"   ");
		}
	}
}
