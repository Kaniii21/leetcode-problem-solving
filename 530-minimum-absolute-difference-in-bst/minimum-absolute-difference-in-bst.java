class Solution {
    private int minDifference;
    private int previousValue;
    private static final int INFINITY = Integer.MAX_VALUE; 
  
    public int getMinimumDifference(TreeNode root) {
        minDifference = INFINITY; 
        previousValue = INFINITY; 
        inOrderTraversal(root); 
        return minDifference; 
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return; 
        }
        inOrderTraversal(node.left); 
        if (previousValue != INFINITY) {
            minDifference = Math.min(minDifference, Math.abs(node.val - previousValue));
        }
        previousValue = node.val; 
        inOrderTraversal(node.right); 
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}