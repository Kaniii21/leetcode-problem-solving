class Solution {
    public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparingInt(interval -> interval[1]));
    int arrowCount = 0;
    long lastArrowPosition = Long.MIN_VALUE;
    for (int[] interval : points) {
      int start = interval[0];
      int end = interval[1];
      if (start > lastArrowPosition) {
        arrowCount++;
        lastArrowPosition = end;
      }
    }
    return arrowCount;    
    }
}