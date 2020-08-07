import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] A = new int[n];
			for(int i = 0; i<n; i++)
				A[i] = Integer.parseInt(st.nextToken());
			int num_inversions = mergeSortWithCounting(A, 0, A.length-1);
			out.println("Optimal train swapping takes "+num_inversions+" swaps.");
		}
		out.flush();
		out.close();
	}
	public static int mergeAndCount(int[] A, int start, int mid, int end) {
		int p = start, q = mid+1;
		int[] Arr = new int[end-start+1];
		int k =0, count = 0;
		while(k<Arr.length)
			if(p>mid)
				Arr[k++] = A[q++];
			else if(q>end)
				Arr[k++] = A[p++];
			else if(A[p]<A[q])
				Arr[k++] = A[p++];
			else {
				Arr[k++] = A[q++];
				count+=mid-p+1;
			}
		for(int i = 0; i<Arr.length; i++)
			A[start++] = Arr[i];
		return count;
	}
	public static int mergeSortWithCounting(int[] A, int start, int end) {
		int count = 0;
		if(start<end) {
			int mid = (start+end)/2;
			count+=mergeSortWithCounting(A, start, mid);
			count+=mergeSortWithCounting(A, mid+1, end);
			count+=mergeAndCount(A, start, mid, end);		
		}
		return count;
	}
}
	
	
