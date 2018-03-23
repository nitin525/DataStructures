package sorting;

public class SortAlgo {

	public static void main(String[] args) {
		int[] listToSort = {4,6,5,9,7,10,2,8,3,1};
		//selectionSort(listToSort);
		//bubbleSort(listToSort);
		//insertionSort(listToSort);
		mergeSort(listToSort);
	}
	public static void print(int[] listToSort){
		for(int el : listToSort){
			System.out.print(el);
			System.out.print(el!=listToSort[listToSort.length-1]?",":"");
		}
		System.out.println();
	}
	
	public static void swap(int[] listToSort, int iIndex, int jIndex){
		int temp= listToSort[iIndex];
		listToSort[iIndex] = listToSort[jIndex];
		listToSort[jIndex] = temp;
	}
	
	public static void bubbleSort(int[] myList){
		boolean swapped = false;
		for(int i=0; i<myList.length; i ++){
			swapped = false;
			for(int j=myList.length-1; j>i; j--){
				if(myList[j-1]>myList[j]){
					swap(myList, j-1, j);
					swapped = true;
				}
			}
			if(swapped == false)
				break;
			//print(myList);
		}
		print(myList);
	}
	
	public static void selectionSort(int[] listToSort){
		for(int i = 0 ; i < listToSort.length; i ++){
			for(int j = i+1; j < listToSort.length;j++){
				if(listToSort[i]>listToSort[j])
					swap(listToSort, i, j);
			}
			//print(listToSort);
		}
		print(listToSort);
	}

	public static void insertionSort(int[] myList){
		for(int i=0;i<myList.length-1;i++){
			for(int j = i+1; j>0;j--){
				if(myList[j-1]>myList[j]){
					swap(myList, j-1, j);
				}
				else 
					break;
			}
		}
		print(myList);
	} 
	
	public static void shellSort(int[] myList){
	}
	
	//Merge Sort Logic
	
	public static void split(int[] listToSort, int[] fHalf, int[] sHalf){
		for(int i=0;i<listToSort.length;i++){
			if(i<fHalf.length)
				fHalf[i] = listToSort[i];
			else
				sHalf[i-fHalf.length] = listToSort[i];			
		}
	}
	
	public static void merge(int[] listToSort, int[]fHalf, int[] sHalf){
		int fIndex=0, sIndex = 0, mergerIndex = 0;
		while(fIndex < fHalf.length && sIndex < sHalf.length){
			if(fHalf[fIndex]<sHalf[sIndex])
				listToSort[mergerIndex++] = fHalf[fIndex++];
			else
				listToSort[mergerIndex++] = sHalf[sIndex++];
		}
		while(fIndex<fHalf.length)
			listToSort[mergerIndex++] = fHalf[fIndex++];
		
		while(sIndex<sHalf.length)
			listToSort[mergerIndex++] = sHalf[sIndex++];
	}
	
	public static void mergeSort(int[] listToSort){
		
		if(listToSort.length==1)
			return;
		
		int midLength = listToSort.length/2 + listToSort.length%2 ;
		int[] fHalf = new int[midLength];
		int[] sHalf = new int[listToSort.length - midLength];
		split(listToSort, fHalf, sHalf);
		mergeSort(fHalf);
		mergeSort(sHalf);
		merge(listToSort,fHalf,sHalf);
		print(listToSort);
	}
}
