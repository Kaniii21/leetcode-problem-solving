import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int numberOfNodes;
    private int[] distanceSum;
    private int[] subtreeSize;
    private List<Integer>[] graph;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.numberOfNodes = n;
        this.graph = new List[n];
        this.distanceSum = new int[n];
        this.subtreeSize = new int[n];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] edge : edges) {
            int nodeA = edge[0], nodeB = edge[1];
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
        dfsPostOrder(0, -1, 0);
        dfsPreOrder(0, -1, distanceSum[0]);

        return distanceSum;
    }

    private void dfsPostOrder(int node, int parentNode, int depth) {
        distanceSum[0] += depth;
        subtreeSize[node] = 1;

        for (int child : graph[node]) {
            if (child != parentNode) {
                dfsPostOrder(child, node, depth + 1);
                subtreeSize[node] += subtreeSize[child];
            }
        }
    }

    private void dfsPreOrder(int node, int parentNode, int totalDistance) {
        distanceSum[node] = totalDistance;

        for (int child : graph[node]) {
            if (child != parentNode) {
                int childDistance = totalDistance - subtreeSize[child] + numberOfNodes - subtreeSize[child];
                dfsPreOrder(child, node, childDistance);
            }
        }
    }
}