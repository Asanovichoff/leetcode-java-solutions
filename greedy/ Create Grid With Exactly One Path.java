class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        StringBuilder firstRow = new StringBuilder();
        for(int i = 0; i < n; i++) {
            firstRow.append('.');
        }
        result[0] = firstRow.toString();

        StringBuilder restRows = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            restRows.append('#');
        }
        restRows.append('.');

        for(int i = 1; i < m; i++) {
            result[i] = restRows.toString();
        }
        return result;

    }
}