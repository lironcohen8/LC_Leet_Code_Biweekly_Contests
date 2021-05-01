import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.ArrayList;

public class biweekly51 {
	public static char shift(char c, int x) {
		return (char)(c + x);
	}
	public static String replaceDigits(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 1; i < sb.length(); i+=2) {
			char c = shift(sb.charAt(i-1), Integer.parseInt(""+sb.charAt(i)));
			sb.replace(i, i+1, "" + c);
		}
		return sb.toString();
	}
	class SeatManager {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
	    public SeatManager(int n) {
	        for (int i = 1; i <= n; i++)
	        	minHeap.add(i);
	    }
	    
	    public int reserve() {
	        int i = minHeap.poll();
	        return i;
	    }
	    
	    public void unreserve(int seatNumber) {
	        minHeap.add(seatNumber);
	    }
	}
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		if (arr[0] != 1)
			arr[0] = 1;
		int index = 1;
		while (index < arr.length) {
			if (arr[index] - arr[index - 1] > 1)
				arr[index] = arr[index-1] + 1;
			index++;
		}
		return arr[arr.length-1];
	}
	public static int findClosest(HashMap<Integer, ArrayList<Integer>> hm, int preferred, int minSize) {
		if (hm.get(minSize).size() == 0)
			return -1;
		int index = Collections.binarySearch(hm.get(minSize), preferred);
		if (index >= 0)
			return preferred;
		else {
			int realIndex = -1*(index + 1);
			if (realIndex == hm.get(minSize).size())
				realIndex--;
			int result1 = hm.get(minSize).get(realIndex);
			if (realIndex == 0)
                return result1;
			int result2 = hm.get(minSize).get(realIndex - 1);
			return (Math.abs(result1 - preferred)) < (Math.abs(result2 - preferred)) ? result1 : result2;  
		}
	}
	public static int[] closestRoom(int[][] rooms, int[][] queries) {
		int[] result = new int[queries.length];
		Arrays.sort(rooms, (a, b) -> Integer.compare(a[0], b[0]));
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		for (int[] query : queries) {
			if (!hm.containsKey(query[1])) {
				hm.put(query[1], new ArrayList<Integer>());
				for (int[] room : rooms) {
					if (room[1] >= query[1])
						hm.get(query[1]).add(room[0]);
				}	
			}		
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = findClosest(hm, queries[i][0], queries[i][1]);
		}
		return result;
	}
	public static void main(String[] args) {
		//System.out.println(replaceDigits("a1c1e1"));
		//System.out.println(replaceDigits("a1b2c3d4e"));
		//int[] arr = {2,2,1,2,1};
		//System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
		//int[] arr1 = {100,1,1000};
		//System.out.println(maximumElementAfterDecrementingAndRearranging(arr1));
		//int[] arr2 = {1,2,3,4,5};
		//System.out.println(maximumElementAfterDecrementingAndRearranging(arr2));
		//int[][] rooms = {{2,2},{1,2},{3,2}};
		//int[][] queries = {{3,1},{3,3},{5,2}};
		//System.out.println(Arrays.toString(closestRoom(rooms, queries)));
		//int[][] rooms = {{1,4},{2,3},{3,5},{4,1},{5,2}};
		//int[][] queries = {{2,3},{2,4},{2,5}};
		//System.out.println(Arrays.toString(closestRoom(rooms, queries)));
		int[][] rooms = {{23,22},{6,20},{15,6},{22,19},{2,10},{21,4},{10,18},{16,1},{12,7},{5,22}};
		int[][] queries = {{15,15},{15,11},{18,6}};
		System.out.println(Arrays.toString(closestRoom(rooms, queries)));
		}
	}

