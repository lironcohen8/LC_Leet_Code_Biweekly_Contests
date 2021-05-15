import java.util.Arrays;
import java.util.HashMap;
public class Biweekly52 {

	public static String sortSentence(String s) {
		StringBuilder result = new StringBuilder();
		String[] arr = s.split(" ");
		String[] arr2 = new String[arr.length+1];
		for (String word : arr) {
			int ind = Integer.parseInt(""+ word.charAt(word.length()-1));
			arr2[ind] = word.substring(0,word.length()-1);
		}
		for (int i = 1; i < arr2.length; i++) { 
			result.append(arr2[i]);
			result.append(" ");
		}
		String results = result.toString();
		return results.substring(0, results.length()-1);
	}
	
	public static int[] memLeak(int memory1, int memory2) {
		int[] result = new int[3];
		int i = 1;
		while (memory1 >= i || memory2 >=i) {
			if (memory1 >= memory2)
				memory1 -= i;
			else
				memory2 -=i;
			i++;
		}
		return new int[]{i, memory1, memory2};
	}
	
	public static char[][] rotateTheBox(char[][] box) {
		char[][] result = new char[box[0].length][box.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = '.';
			}
		}
		for (int i = 0; i < box.length; i++) {
			int j = 0;
			int count = 0;
			while (j < box[0].length) {
				  while (j < box[0].length && box[i][j] != '*') {
					  if (box[i][j] == '#')
						  count++;
					  j++;
				  }
				  if (j < box[0].length)
					  result[j][result[0].length-i-1] = '*';
				  for (int k = 1 ; k <= count; k++)
					  result[j-k][result[0].length-i-1] = '#';
				  j++;
				  count = 0;
			}
		}		
		return result;
	}
	
	public static int sumOfFlooredPairs(int[] nums) {
		int[] counter = new int[100001];
		int[] preCounter = new int[100001];
		int sum = 0;
		for (int num : nums)
			counter[num]++;
		preCounter[0] = counter[0];
		for (int i = 1 ; i < counter.length; i++) 
			preCounter[i] = counter[i] + preCounter[i-1];
		for (int i = 1 ; i < counter.length; i++) {
			for (int j = i ; j < counter.length; j+=i) {
				int x = preCounter[j - 1] - preCounter[Math.abs(j - i - 1)];
				sum += x * (j/i - 1) * counter[i];
			}
		}
		return (int) (sum % (Math.pow(10, 9) + 7));
		/*HashMap<Integer, Integer> counter = new HashMap<>();
		int sum = 0;
		for (int num : nums) {
			if (!counter.containsKey(num))
				counter.put(num, 0);
			counter.put(num, counter.get(num) + 1);
		}
		for (int num1 : counter.keySet()) {
			for (int num2 : counter.keySet()) {
				if (num1 >= num2) {
					sum += (counter.get(num1) * counter.get(num2) * Math.floor(num1 / num2));
				}
			}
		}
		int sum = 0;
		for (int num1 : nums) {
			for (int num2 : nums) {
				if (num1 >= num2)
					sum += Math.floor(num1 / num2);
			}
		}*/
	}
	
	public static void main(String[] args) {
		//String str = "is2 sentence4 This1 a3";
		//System.out.println(sortSentence(str));
		//System.out.println(memLeak(8,11)[0]);
		//System.out.println(memLeak(8,11)[1]);
		//System.out.println(memLeak(8,11)[2]);
		//char[][] box = {{'#','.','#'}};
		//char[][] box = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
		//System.out.println(rotateTheBox(box).toString());
		//int[] nums = {2, 5, 9};
		//int[] nums = {7,7,7,7,7,7,7};
		//System.out.println(sumOfFlooredPairs(nums));
	}

}
