package merge;

public class MergeSort {
	private int[] sortArray;
	public void printSortArray(){
		for(int i=0; i<this.sortArray.length; i++){
			System.out.print(this.sortArray[i] + ",");
		}
	}
	private boolean reverse;
	public MergeSort(int[] rawArray, boolean reverse){
		this.reverse = reverse;
		this.sortArray = this.sort(rawArray);
	}
	public int[] sort(int[] rawArray){
		if(rawArray.length == 1){
			return rawArray;
		}else{
			int center = rawArray.length/2;
			int[] LArray = new int[center];
			int[] RArray = new int[rawArray.length - center];
			for(int i=0; i<center; i++){
				LArray[i] = rawArray[i];
			}
			for(int i=center; i < rawArray.length; i++){
				RArray[i-center] = rawArray[i];
			}
			int[] sortLArray = sort(LArray);
			int[] sortRArray = sort(RArray); 
//			int[] tmpMergeArray= new int[rawArray.length];
			int[] tmpMergeArray = this.mergeTwo(sortLArray, sortRArray);
			return tmpMergeArray;
		}
	}
	public int[] mergeTwo(int[] LArray, int[] RArray){
		int[] tmpMergeArray = new int[LArray.length + RArray.length];
		int i = 0;
		int j = 0;
		if (this.reverse == false){
			int min = 0;
			int t_i = 0;
			while((i<LArray.length)&(j<RArray.length)){
				min = LArray[i];
				if (RArray[j] < min){
					min = RArray[j];
					j++;
				}else{
					i++;
				}
				tmpMergeArray[t_i] = min;
				t_i++;
			}
			if (i == LArray.length){
				while(j < RArray.length){
					tmpMergeArray[t_i] = RArray[j];
					j++;
					t_i++;
				}
			}else{
				while(i < LArray.length){
					tmpMergeArray[t_i] = LArray[i];
					i++;
					t_i++;
				}
			}
		}else{
			int max = 0;
			int t_i=0;
			while((i < LArray.length)&(j < RArray.length)){
				max = LArray[i];
				if(RArray[j] > max){
					max = RArray[j];
					j++;
				}else{
					i++;
				}
				tmpMergeArray[t_i] = max;
				t_i++;
			}
			if (i == LArray.length){
				while(j < RArray.length){
					tmpMergeArray[t_i] = RArray[j];
					j++;
					t_i++;
				}
			}else{
				while(i < LArray.length){
					tmpMergeArray[t_i] = LArray[i];
					i++;
					t_i++;
				}
			}
		}
		return tmpMergeArray;
	}
	// for test
	public static void main(String[] args){
		int[] testArray = {8,4,3,5,9};
		boolean reverse = true;
		MergeSort mergeSort = new MergeSort(testArray, reverse);
		mergeSort.printSortArray();
	}
}
