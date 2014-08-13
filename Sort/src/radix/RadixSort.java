package radix;
// for every bit in an decimal number, sort the array with countSort methods,
// and the sequence is from high to low order.
public class RadixSort {
	private int[] sortArray;
	private int order;
	public void prinrSortArray(){
		for(int i=0; i<sortArray.length; i++){
			System.out.print(sortArray[i]+",");
		}
		System.out.print("\n");
	}
	public RadixSort(int[] tmpArray,int order){
		this.order = order;
		sortArray = this.sort(tmpArray);
		this.prinrSortArray();
		
	}
	public int[] sort(int[] tmpArray){
		// judge the order? have not
		int tmp,tmpRem;
		int[] sortArray = new int[tmpArray.length];
		int[] tmpRems = new int[tmpArray.length];
		for(int i=0; i<order; i++){
			for(int t_i=0; t_i<tmpArray.length; t_i++){
				tmp = (int) (tmpArray[t_i]/Math.pow(10, i));
				tmpRem = tmp%10;
				tmpRems[t_i] = tmpRem;
			}
			sortArray = this.countSort(tmpArray, tmpRems);
		}
		return sortArray;
	}
	public int[] countSort(int[] tmpArray, int[] tmpRems){
		// the c[] is defined by the maximum number among tmpArray
		int[] count = new int[10];
		int[] sortArray = new int[tmpArray.length];
		// count
		for(int i=0; i<tmpRems.length; i++){
			count[tmpRems[i]]+=1;
		}
		// accumulate
		for(int i=0; i<count.length-1; i++){
			count[i+1] += count[i];
		}
		// put number in sortArray
		for(int i=tmpRems.length-1; i>=0; i--){
			sortArray[count[tmpRems[i]]-1] = tmpArray[i];
			count[tmpRems[i]]--;
		}
		return sortArray;
	}
	public static void main(String[] args){
		int[] tmpArray = {11,35,81,45,22};
		int order = 2;
		RadixSort radixSort = new RadixSort(tmpArray, order);
		int[] tmpArray2 = {11,81,22,35,45};
		int[] tmpRems = {1,8,2,3,4};
		int[] sortArray = radixSort.countSort(tmpArray2, tmpRems);
		
	}
}
