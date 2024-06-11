class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] frequency = new int[1001];
        for (int num : arr1) {
            frequency[num]++;
        }

        int[] sortedArray = new int[arr1.length];
        int index = 0;

        for (int num : arr2) {
            while (frequency[num] > 0) {
                sortedArray[index++] = num;
                frequency[num]--;
            }
        }

        for (int num = 0; num < frequency.length; num++) {
            while (frequency[num] > 0) {
                sortedArray[index++] = num;
                frequency[num]--;
            }
        }
        return sortedArray;
    }
}
