class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i< numCourses; i++) graph.add(new ArrayList<>());
        for(int [] p : prerequisites) graph.get(p[0]).add(p[1]);
        int [] state = new int[numCourses];
        for(int i = 0; i<numCourses;i++)
        if(hasCycle(graph, i, state)) return false;
        return true;

    }
    private boolean hasCycle(List<List<Integer>> graph, int node, int[] state) {
        if(state[node] == 1) return true;
        if(state[node] == 2) return false;
        state[node] = 1;
        for(int next : graph.get(node))
        if (hasCycle(graph, next, state)) return true;
        state[node] = 2;
        return false;
    }
}