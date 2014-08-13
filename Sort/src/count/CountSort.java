package count;

public class CountSort {
	private int[] sortArray;
	public void printSortArray(){
		for(int i=0; i<sortArray.length; i++){
			System.out.print(sortArray[i]+",");
		}
		System.out.print("\n");
	}
	public CountSort(int[] tmpArray){
		sortArray = this.sort(tmpArray);
		this.printSortArray();
	}
	public int[] sort(int[] tmpArray){
		// the c[] is defined by the maximum number among tmpArray
		int[] count = new int[10];
		int[] sortArray = new int[tmpArray.length];
		// count
		for(int i=0; i<tmpArray.length; i++){
			count[tmpArray[i]]+=1;
		}
		// accumulate
		for(int i=0; i<count.length-1; i++){
			count[i+1] += count[i];
		}
		// put number in sortArray
		for(int i=tmpArray.length-1; i>=0; i--){
			sortArray[count[tmpArray[i]]-1] = tmpArray[i];
			count[tmpArray[i]]--;
		}
		return sortArray;
	}
	public static void main(String[] args){
		int[] tmpArray = {7,8,1,2,4,3,3};
		CountSort countSort = new CountSort(tmpArray);
	}
	
}
