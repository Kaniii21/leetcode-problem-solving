class Solution {
    public String convert(String s, int numRows) {
    if (numRows == 1) {
            return s;
        }
        StringBuilder convertedStringBuilder = new StringBuilder();
        int cycleLength = 2 * numRows - 2;
        for (int row = 0; row < numRows; row++) {
            int interval = (row == numRows - 1) ? cycleLength : 2 * (numRows - row - 1);
            int index = row;
            while (index < s.length()) {
                convertedStringBuilder.append(s.charAt(index));
                index += interval;
                interval = (interval == cycleLength || interval == 0) ? cycleLength : cycleLength - interval;
            }
        }
        return convertedStringBuilder.toString();    
    }
}