class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<double[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new double[]{v, succProb[i]});
            graph[v].add(new double[]{u, succProb[i]});
        }

        double[] prob = new double[n];
        prob[start] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[1], a[1]));

        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {

            double[] cur = pq.poll();

            int node = (int) cur[0];
            double p = cur[1];

            if (node == end)
                return p;

            if (p < prob[node])
                continue;

            for (double[] next : graph[node]) {

                int nei = (int) next[0];
                double newProb = p * next[1];

                if (newProb > prob[nei]) {
                    prob[nei] = newProb;
                    pq.offer(new double[]{nei, newProb});
                }
            }
        }

        return 0.0;
    }
}