import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001]; 
        for (int num : nums1) {
            seen[num] = true;
        }
        List<Integer> intersectionElements = new ArrayList<>();
        for (int num : nums2) {
            if (seen[num]) {
                intersectionElements.add(num); 
                seen[num] = false; 
            }
        }
        int[] result = new int[intersectionElements.size()];
        for (int i = 0; i < intersectionElements.size(); i++) {
            result[i] = intersectionElements.get(i);
        }
        return result;
    }
}