package insert;

public class InsertSort {
	private int[] sortArray;
	public InsertSort(){
	}
	
	public int[] sort(int[] tmpArray){
		for(int i=1; i<tmpArray.length; i++){
			//j is start from 0, this sequence is important
			for(int j=0; j<i; j++){
				if(tmpArray[i] < tmpArray[j]){
//					System.out.println(i+ ":" + j);
					// from j, all tmpArray shift to right by 1 bit
					int tmp = tmpArray[i];
					for (int t_i=i-1; t_i >= j; t_i--){
						tmpArray[t_i+1] = tmpArray[t_i];
					}
					tmpArray[j] = tmp;
					break;
				}
			}
		}
		return tmpArray;
	}
	public static void main(String[] args){
		InsertSort insertSort = new InsertSort();
		int[] tmpArray = {7,4,1,6,3};
		int[] sortArray = insertSort.sort(tmpArray);
		for(int i=0; i<sortArray.length; i++){
			System.out.print(sortArray[i]+",");
		}
	}
}
