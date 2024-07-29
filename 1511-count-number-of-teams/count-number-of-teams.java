public class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        // Iterate over each soldier's rating
        for (int j = 0; j < n; j++) {
            int leftLess = 0, leftGreater = 0;
            int rightLess = 0, rightGreater = 0;

            // Count soldiers with ratings less and greater on the left side
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftLess++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }

            // Count soldiers with ratings less and greater on the right side
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightLess++;
                } else if (rating[k] > rating[j]) {
                    rightGreater++;
                }
            }

            // Number of increasing teams with j as the middle element
            count += leftLess * rightGreater;
            // Number of decreasing teams with j as the middle element
            count += leftGreater * rightLess;
        }

        return count;
    }
}