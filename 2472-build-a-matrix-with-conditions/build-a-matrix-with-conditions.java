import java.util.*;

public class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        
        // Get the topological ordering for rows and columns
        int[] rowOrder = getTopologicalOrder(k, rowConditions);
        int[] colOrder = getTopologicalOrder(k, colConditions);
        
        if (rowOrder == null || colOrder == null) {
            return new int[0][0]; // No valid matrix can be created
        }
        
        // Map rowOrder and colOrder to positions
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder[i]] = i;
            colPos[colOrder[i]] = i;
        }
        
        // Build the matrix
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        
        return matrix;
    }
    
    private int[] getTopologicalOrder(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] inDegree = new int[k + 1];
        
        for (int i = 0; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] order = new int[k];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;
            
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return index == k ? order : null;
    }
}