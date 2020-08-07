import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class BadNeighbors {	
	public static int maxDonations(int[] arr) {
		int[] sol = new int[arr.length];
		sol[0] = arr[0];
		sol[1] = Math.max(arr[0], arr[1]);
		for(int i  = 2; i < arr.length-1; i++) {
			sol[i] = Math.max(sol[i-1], Math.max(sol[i-2]+arr[i], i-3>=0?sol[i-3]+arr[i]:0));
		}
		int ans = sol[arr.length-2];
		sol = new int[arr.length];
		sol[1] = arr[1];
		for(int i  = 2; i < arr.length; i++) {
			sol[i] = Math.max(sol[i-1], Math.max(sol[i-2]+arr[i], (i-3>=0?sol[i-3]+arr[i]:0)));
		}
		ans = Math.max(ans, sol[arr.length-1]);
		return ans;
	}
}