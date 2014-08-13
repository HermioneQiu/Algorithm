package quick;

public class QuickSort {
	private int[] sortArray;
	public QuickSort(){
		
	}
	public int[] sort(int[] tmpArray, int s, int e){
		if(s >= e){
			return tmpArray;
		}else{
			
			int flag_i = this.patition(tmpArray, s, e);
//			// only right
//			if (flag_i < s){
//				tmpArray = this.sort(tmpArray, s+1, e);
//				return tmpArray;
//			}else if (flag_i > e-2){
//				tmpArray = this.sort(tmpArray, s, e-1);
//				return tmpArray;
//			}else{
				tmpArray = this.sort(tmpArray, s, flag_i);
				tmpArray = this.sort(tmpArray, flag_i+2, e);
				return tmpArray;
//			}
		}
		
	}
	public int patition(int[] tmpArray, int s, int e){
		int flag_i = s-1;
		int center = tmpArray[e];
		for(int i=s; i<e-1; i++){
			if(tmpArray[i] < center){
				flag_i++;
				// exchange i with (flag_i+1)
				int tmp = tmpArray[flag_i];
				tmpArray[flag_i] = tmpArray[i];
				tmpArray[i] = tmp;
			}
		}
		// echange i center with flag_i + 1
		System.out.println(s+ " : "+e);

		System.out.println("flag: "+flag_i);
		tmpArray[e] = tmpArray[flag_i+1];
		tmpArray[flag_i+1] = center;		
		return flag_i;
	}
	public static void main(String[] args){
		int[] tmpArray = {3,1,6,7,5};
		QuickSort quickSort = new QuickSort();
		int[] sortArray = quickSort.sort(tmpArray, 0, 4);
		for(int i=0; i<sortArray.length; i++){
			System.out.print(sortArray[i]+",");
		}
		System.out.print("\n");
	}
}

