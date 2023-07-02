public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        return dfs(node);
    }

    static graphNode dfs(graphNode node) {
        graphNode dummy = new graphNode(node.data);
        for (graphNode child : node.neighbours) {
            graphNode dummychild = dfs(child);
            dummy.neighbours.add(dummychild);
        }
        return dummy;
    }
}