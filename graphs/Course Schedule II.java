class Solution {
    private ArrayList<ArrayList<Integer>> adjList;
    private boolean[] visited;
    private HashSet<Integer> path;
    private ArrayList<Integer> list;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>();
        adjList = new ArrayList<>();
        visited = new boolean[numCourses];
        path = new HashSet<>();
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());

        for (int[] prereq :prerequisites) {
            int a = prereq[0];
            int b = prereq[1];
            adjList.get(a).add(b);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i) == false) return new int[] {};
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private boolean dfs(int i) {
        if (path.contains(i)) return false;
        if (visited[i]) return true;
        path.add(i);
        for (int j = 0; j < adjList.get(i).size(); j++) {
            int course = adjList.get(i).get(j);
            if (dfs(course) == false) return false;
        }
        visited[i] = true;
        path.remove(i);
        list.add(i);
        return true;
    }
} 