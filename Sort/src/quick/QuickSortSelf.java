package quick;

public class QuickSortSelf {
	private int[] sortArray;
	public void printSortArray(){
		for(int i=0; i<sortArray.length; i++){
			System.out.print(sortArray[i]+",");
		}
	}
	public QuickSortSelf(int[] tmpArray){
		sortArray = this.quick(tmpArray);
	}
	public int[] quick(int[] tmpArray){
		// terminate condition
		if (tmpArray.length <= 1){
			return tmpArray;
		}
		// divide, the important part 
		int divide_i = this.divide(tmpArray);
//		for(int i=0; i<tmpArray.length; i++){
//			System.out.print(tmpArray[i]+",");
//		}
//		System.out.print("\n");
//		System.out.println("tmpArrayLen: "+tmpArray.length);
//		System.out.println("divide_i: "+divide_i);
		if(divide_i == -1){
			int[] LArray = new int[tmpArray.length-1];
			for(int i=0; i<LArray.length; i++){
				LArray[i] = tmpArray[i];
			}
			LArray = this.quick(LArray);
			// for update
			for(int i=0; i<LArray.length; i++){
				tmpArray[i] = LArray[i];
			}
		}else if(divide_i == -2){
			int[] RArray = new int[tmpArray.length - 1];
			for(int i=0; i<RArray.length; i++){
				RArray[i] = tmpArray[i];
			}
			RArray = this.quick(RArray);
			// for update
			for(int i=0; i< RArray.length; i++){
				tmpArray[i] = RArray[i];
			}
		}else{
			int[] LArray = new int[divide_i];
			int[] RArray = new int[tmpArray.length - divide_i -1];
			for(int i=0; i<LArray.length; i++){
				LArray[i] = tmpArray[i];
			}
			for(int i=0; i<RArray.length; i++){
				RArray[i] = tmpArray[divide_i + i];
			}
			// recursion
			LArray = this.quick(LArray);
			RArray = this.quick(RArray);
			for(int i=0; i<LArray.length; i++){
				tmpArray[i] = LArray[i];
			}
			tmpArray[divide_i] = tmpArray[tmpArray.length-1];
			for(int i=0; i<RArray.length; i++){
				tmpArray[i+divide_i+1] = RArray[i];
			}
//			for(int i=0; i<tmpArray.length; i++){
//				System.out.print(tmpArray[i]+",");
//			}
//			System.out.print("\n");
		}
		// return 
		return tmpArray;
	}
	public int divide(int[] tmpArray){
		int center = tmpArray[tmpArray.length-1];
		int j;
		int i = 0;
		if(tmpArray.length <= 2){
			if(tmpArray[0] < tmpArray[1]){
				j = -1;
			}else{
				j = -2;
			}
		}else{
			
			while((i < tmpArray.length-2)&&(tmpArray[i] <= center)){
				i++;
			}
			j = i;
			if(i < tmpArray.length-2){
				for(int l_i = i+1; l_i<tmpArray.length; l_i++){
					if(tmpArray[l_i] < center){
						int tmp = tmpArray[l_i];
						tmpArray[l_i] = tmpArray[j];
						tmpArray[j] = tmp;
						j++;
					}
				}
			}
		}
		return j;
	}
	public static void main(String[] args){
		int[] tmpArray = {7,4,1,2,3,8,5};
		QuickSortSelf quickSort = new QuickSortSelf(tmpArray);
		quickSort.printSortArray();
		
	}
}
