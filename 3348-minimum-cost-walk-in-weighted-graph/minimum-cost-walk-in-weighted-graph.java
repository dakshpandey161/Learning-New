import java.util.*;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        
        int[] component = new int[n];
        Arrays.fill(component, -1);
        Map<Integer, Integer> minAndValue = new HashMap<>();
        
        int compId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                component[i] = compId;
                
                int minAnd = -1;
                
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int[] neighbor : graph[node]) {
                        int nextNode = neighbor[0], weight = neighbor[1];
                        if (component[nextNode] == -1) {
                            component[nextNode] = compId;
                            queue.add(nextNode);
                        }
                        if (minAnd == -1) minAnd = weight;
                        else minAnd &= weight;
                    }
                }
                
                minAndValue.put(compId, minAnd);
                compId++;
            }
        }
        
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0], t = query[i][1];
            if (component[s] != component[t]) result[i] = -1;
            else result[i] = minAndValue.get(component[s]);
        }
        
        return result;
    }
}
