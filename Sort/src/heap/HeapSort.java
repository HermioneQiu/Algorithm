package heap;

public class HeapSort {
	private int[] sortArray;
	private int[] heapArray;
	private boolean reverse;
	int heapSize;
	public HeapSort(int[] tmpArray, boolean reverse){
//		this.heapArray = this.buidHeap(tmpArray);
//		this.sortArray = this.sortHeap(tmpArray);
//		heapSize = tmpArray.length;
	}
	// do the heapifing of the heap by steps like this.
	// i : count from 1, namely Array[1,2,3,4...] 
	public int[] maxHeapify(int[] tmpArray, int i){
		int left_i = 2*(i+1)-1;
		int right_i = 2*(i+1);
		int max_i = i;
		// if have not exceed the heap, and find the largest, 
		// the termination condition: largest index is i, and the condition of exceed has been consider in it.
//		System.out.println(i + ":" + left_i + ":" + right_i);
		if((left_i < tmpArray.length) && (tmpArray[left_i] > tmpArray[i])){
			max_i = left_i; 
		}
		if((right_i < tmpArray.length) && (tmpArray[right_i] > tmpArray[max_i])){
			max_i = right_i;
		}
		if(max_i != i){
			// exchange the position of largest and i
			int tmp = tmpArray[max_i];
			tmpArray[max_i] = tmpArray[i]; 
			tmpArray[i] = tmp;
			// for the sun tree of current node.
			this.maxHeapify(tmpArray, max_i);
		}
		return tmpArray;
	}
	// build a heap
	public int[] buidHeap(int[] tmpArray){
		int[] heapArray = new int[tmpArray.length];
		//consider the index of Array, so substract 1
		for (int i=tmpArray.length/2-1; i >= 0; i--){
//			System.out.println("build: "+i);
			tmpArray = this.maxHeapify(tmpArray, i);
		}
		return tmpArray;
	}
	// sort heap
	public int[] sortHeap(int[] tmpArray){
		// build a heap
		int[] sortHeap = new int[tmpArray.length];
		sortHeap = this.buidHeap(tmpArray);
		// get one and rebuild again, a easier build procedure completed by max-heap
		// index of Array
		for(int i = sortHeap.length-1; i > 0; i--){
			// exchange A[i] with A[0], and build heap by maxHeap(), because this function builded on the base of heap sub-tree
			int tmp = sortHeap[i];
			sortHeap[i] = sortHeap[0];
			sortHeap[0] = tmp;
			// substract the part that should be rebuild, how to improve this???
			int[] tmpHeap = new int[i];
			for (int t_i=0; t_i <i; t_i++){
				tmpHeap[t_i] = sortHeap[t_i];
			}
			tmpHeap = this.maxHeapify(tmpHeap, 0);
			//update the orginal array
			for(int t_i=0; t_i < i; t_i++){
				sortHeap[t_i] = tmpHeap[t_i];
			}
		}
		return sortHeap;
	}
	// for test
	public static void main(String[] args){
		int[] tmpArray = {3,4,5,1,7};
		boolean reverse = false;
		HeapSort heapSort = new HeapSort(tmpArray, reverse);
		int[] testArray = heapSort.sortHeap(tmpArray);
		for(int i =0; i<testArray.length; i++){
			System.out.print(testArray[i]+",");
		}
	}
}
