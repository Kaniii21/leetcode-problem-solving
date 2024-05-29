class Solution {
    public int numSteps(String s) {
        int steps = 0;
        while (!s.equals("1")) {
        // If the binary number is even (ends with '0'), divide it by 2 (remove the last '0').
            if (s.endsWith("0")) {
                s = s.substring(0, s.length() - 1);
            } else {
            // If the binary number is odd, add 1 to it.This is done by converting the string to a char array for easier manipulation.
                char[] binary = s.toCharArray();
                int i = binary.length - 1;
                // Flip all the trailing '1's to '0's and if we reach the start of the string, resize it.
                while (i >= 0 && binary[i] == '1') {
                    binary[i] = '0';
                    i--;
                }
                // If we've reached the start of the string after flipping '1's, resize the array.
                if (i < 0) {
                    s = "1" + String.valueOf(binary);
                } else {
                // Otherwise, flip the first '0' to '1'.
                    binary[i] = '1';
                    s = String.valueOf(binary);
                }
            }
            steps++;
        }
        return steps;
    }
}

