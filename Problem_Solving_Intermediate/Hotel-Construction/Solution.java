class Result {
    public static int numberOfWays(List<List<Integer>> roads) {
        int n = roads.size() + 1;
        Graph g = new Graph(n);
        for (List<Integer> lst : roads) {
            int a = lst.get(0) - 1,
                b = lst.get(1) - 1;
            g.add(a, b);
        }
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] dist = new int[n];
                    Arrays.fill(dist, -1);
                    g.dfs(dist, i, 0);
                    if (dist[j] != dist[k]) continue;
                    dist = new int[n];
                    Arrays.fill(dist, -1);
                    g.dfs(dist, j, 0);
                    if (dist[i] == dist[k])
                        res++;
                }
            }
        }
        return res;
    }

}
class Graph {
    int V;
    LinkedList<Integer>[] adj;
    @SuppressWarnings("unchecked")
    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }
    public void add(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }
    public void dfs(int[] dist, int x, int d) {
        dist[x] = d;
        for (int y : adj[x]) {
            if (dist[y] == -1)
                dfs(dist, y, d + 1);
        }
    }
}