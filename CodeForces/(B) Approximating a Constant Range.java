import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int max = arr[0], min = arr[0], ans = 0;
		HashMap<Integer, Integer> map = new HashMap();
		map.put(arr[0], 1);
		for (int i = 1, j = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				if (max - min > 1) {
					while (j < i && map.containsKey(min)) {
						int x = map.get(arr[j]);
						if (x == 1)
							map.remove(arr[j]);
						else
							map.put(arr[j], x - 1);
						j++;
					}
					min = max - 1;
				}
			} else if (arr[i] < min) {
				min = arr[i];
				if (max - min > 1) {
					while (j < i && map.containsKey(max)) {
						int x = map.get(arr[j]);
						if (x == 1)
							map.remove(arr[j]);
						else
							map.put(arr[j], x - 1);
						j++;
					}
					max = min + 1;
				}
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			ans = Math.max(ans, i - j + 1);
		}
		System.out.println(ans);
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
