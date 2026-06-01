import java.util.Arrays;
class DA {
    private static final int besk = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] graph = {
                {0,   7,  9,  besk, besk, 14},
                {7,   0,  10, 15, besk, besk},
                {9,   10, 0,  11, besk, 2},
                {besk, 15, 11, 0,   6,  besk},
                {besk, besk, besk, 6,   0,  9},
                {14,  besk, 2,  besk, 9,   0}
        };
        int nv = graph.length;
        int[] dist = new int[nv];
        Arrays.fill(dist, besk);
        dist[0] = 0;
        boolean[] visited = new boolean[nv];
        for (int count = 0; count < nv; count++) {
            int u = f(dist, visited);
            if (u == -1 || dist[u] == besk) {
                break;
            }
            visited[u] = true;
            for (int v = 0; v < nv; v++) {
                if (!visited[v] && graph[u][v] != besk && dist[u] != besk && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        System.out.println("минимальное расстояния от стартовой вершины A:");
        for (int i = 0; i < nv; i++) {
            char vertexName = (char) ('A' + i);
            if (dist[i] == besk) {
                System.out.println(vertexName + ": ∞");
            } else {
                System.out.println(vertexName + ": " + dist[i]);
            }
        }
    }
    private static int f(int[] dist, boolean[] visited) {
        int min = besk;
        int minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
