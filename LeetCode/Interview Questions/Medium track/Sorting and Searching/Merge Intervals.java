class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new ArrayComparator());
        List<int[]> list = new ArrayList();
        for(int i = 0; i < intervals.length; i++) {
            if(list.isEmpty() || list.get(list.size() - 1)[1] < intervals[i][0])
                list.add(intervals[i]);
            else
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
        }
        return list.toArray(new int[list.size()][]);
    }
    
    class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
}