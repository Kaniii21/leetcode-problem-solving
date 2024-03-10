class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int length1=s1.length();
       int length2=s2.length();
       if(length1>length2){
         return false;
       }
       int charCountDiff[]= new int [30];
       for (int i = 0; i < length1; ++i) {
            charCountDiff[s1.charAt(i) - 'a']--;
            charCountDiff[s2.charAt(i) - 'a']++;
        }
        int nonZeroCount = 0;
        for (int count : charCountDiff) {
            if (count != 0) {
                nonZeroCount++;
            }
        }
            if (nonZeroCount == 0) {
            return true;
        }
        for (int i = length1; i < length2; ++i) {
            int charLeft = s2.charAt(i - length1) - 'a';
            int charRight = s2.charAt(i) - 'a'; 
            if (charCountDiff[charRight] == 0) {
                nonZeroCount++;
            }
            charCountDiff[charRight]++;
            if (charCountDiff[charRight] == 0) {
                nonZeroCount--;
            }
            if (charCountDiff[charLeft] == 0) {
                nonZeroCount++;
            }
            charCountDiff[charLeft]--;
            if (charCountDiff[charLeft] == 0) {
                nonZeroCount--;
            }
            if (nonZeroCount == 0) {
                return true;
            }
        }
        return false;
        }

    }
