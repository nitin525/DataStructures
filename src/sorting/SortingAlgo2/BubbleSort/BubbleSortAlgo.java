package sorting.SortingAlgo2.BubbleSort;

public class BubbleSortAlgo {

	
	public static void main(String[] args) {
		int[] arr = {-22,-67,45,2,100,45,345,-30,1000};
		System.out.println();
		printNumbers(arr);
		//bubbleSort(arr);
		//selectionSort(arr);
		insertionSort(arr);
		System.out.println();
		printNumbers(arr);
	}
	
	public static void printNumbers(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ "   ");
	}
	
	public static void bubbleSort(int... arr){
		for(int i = 0 ; i < arr.length-1;i++){
			boolean swapped = false;
			for(int j = 0 ; j < arr.length-1-i; j ++){
				if(arr[j]>arr[j+1]){
					swap(arr, j, j+1);
					swapped = true;
				}
			}
			if(swapped == false)
				break;
		}
	}
	
	public static void selectionSort(int... arr){
		for(int i=0 ; i < arr.length; i++){
			int index = i;
			for(int j = i+1 ; j < arr.length-1; j++){
				if(arr[j]<arr[index])
					index = j;
			}
			if(i == index)
				swap(arr, i, index);
		}
	}
	
	public static void insertionSort(int... arr){
		for(int i = 1 ; i < arr.length ; i++){
			int j = i;
			while(j>0 && arr[j-1]>arr[j]){
				swap(arr, j-1, j);
				--j;
			}
		}
	}
	
	public static void swap(int[] arr,int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
