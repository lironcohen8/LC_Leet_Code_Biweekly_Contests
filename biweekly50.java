
public class biweekly50 {

	    public static int minOperations(int[] nums) { // easy
	        int count = 0;
	        for (int i = 0 ; i < nums.length-1 ; i++) {
	            if (nums[i] >= nums[i+1]) {
	                count += (nums[i] - nums[i+1] + 1);
	                nums[i+1] = nums[i] + 1;
	            }
	        }
	        return count;
	    }
	    
	    private static double distance(int x1, int y1, int x2, int y2) {
	    	return Math.sqrt((Math.pow(Math.abs(x1-x2), 2)+(Math.pow(Math.abs(y1-y2), 2))));
	    }
	    public static int[] countPoints(int[][] points, int[][] queries) { // medium
	        int[] result = new int[queries.length];
	        for (int i = 0; i < queries.length; i++) {
	        	int[]q = queries[i];
	            for (int[] p : points) {
	                if (distance(p[0],p[1],q[0],q[1]) <= q[2]) {
	                	result[i]++;	                }
	            }
	        }
	        return result;
	    }
	    
	    public static int[] getMaximumXor(int[] nums, int maximumBit) { //medium
	        int[] result = new int[nums.length];
	        int curNum = 0;
	        int maxNum = ((int)Math.pow(2,maximumBit))-1;
	        for(int i = result.length-1; i >= 0; i--) {
	        	curNum = curNum^nums[i];
	        }
	        for (int i = result.length-1; i >= 0; i--) {
	        	result[result.length-1-i] = maxNum^curNum;
	        	curNum = curNum^nums[i];
			}
	        return result;
	    }
	    
	    private static boolean isSorted(char[] arr) {
	    	for (int i = 0; i < arr.length-1; i++) {
				if (arr[i] > arr[i+1])
					return false;
			}
	    	return true;
	    }
	    private static void reverse(char[] arr, int i) {
	    	int num = arr.length-i;
	    	for (int j = i; j <= num/2; j++) {
				char temp = arr[j];
	    		arr[j] = arr[arr.length-j+i-1];
	    		arr[arr.length-j+i-1] = temp;
			}
	    }
	    public static int makeStringSorted(String s) { // hard
	    	char[] arr = s.toCharArray();
	    	int count = 0;
	    	while (!isSorted(arr)) {
		    	int theI = 0;
		    	int theJ = 0;
		        for (int i = s.length()-1; i>=1; i--) {
		        	if (arr[i] < arr[i-1]) {
		        		theI = i;
		        		break;
		        	}
		        }
		        
		        for (int j = s.length()-1; j>=theI; j--) {
		        	boolean flag = false;
		        	for (int k = theI; k <= j; k++) {
		        		if (arr[k] >= arr[theI-1])
		        			flag = true;
		        	}
		        	if (flag == false) {
		        		theJ = j;
		        		break;
		        	}
		        }
		        char temp = arr[theI - 1]; 
		        arr[theI - 1] = arr[theJ];
		        arr[theJ] = temp;
		        reverse(arr, theI);
		        count++;
	    	}
	    	return count%(((int)Math.pow(10, 9))+7);
	    }
	    
	public static void main(String[] args) {
		/*int[] a = {1,5,2,4,1};
		System.out.println(minOperations(a));
		int[][] points = {{1,3},{3,3},{5,3},{2,2}};
		int[][] queries = {{2,3,1},{4,3,1},{1,1,2}};
		int[][] points = {{1,1},{2,2},{3,3},{4,4},{5,5}};
		int[][] queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
		int[] result = countPoints(points, queries);
		for (int i = 0 ; i < result.length; i++)
			System.out.print(result[i] + ",");
		int[] a = {2,3,4,7};
		int m = 3;
		int[] result = getMaximumXor(a,m);
		for (int i = 0 ; i < result.length; i++)
			System.out.print(result[i] + ",");
		System.out.println();
		System.out.println(0^1^1^3);*/
		String s = "cba";
		System.out.println(makeStringSorted(s));
	}

}
