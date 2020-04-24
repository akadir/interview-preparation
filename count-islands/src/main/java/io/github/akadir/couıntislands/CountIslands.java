package io.github.akadir.couıntislands;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 23:03
 */
public class CountIslands {

    public enum Neighbour {
        UPPER_LEFT(-1, -1),
        UP(-1, 0),
        UPPER_RIGHT(-1, 1),
        RIGHT(0, 1),
        RIGHT_DOWN(1, 1),
        DOWN(1, 0),
        DOWN_LEFT(1, -1),
        LEFT(0, -1);

        int x;
        int y;

        Neighbour(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int countIslands(int[][] graph) {
        boolean[][] isVisited = new boolean[graph.length][graph[0].length];

        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && !isVisited[i][j]) {
                    dfs(graph, i, j, isVisited);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] graph, int x, int y, boolean[][] isVisited) {
        if (isVisited[x][y]) {
            return;
        }

        isVisited[x][y] = true;

        for (Neighbour neighbour : Neighbour.values()) {
            int newX = x + neighbour.x;
            int newY = y + neighbour.y;

            if (isInRange(x, y, neighbour, graph) && graph[newX][newY] == 1) {
                dfs(graph, x + neighbour.x, y + neighbour.y, isVisited);
            }
        }
    }

    private boolean isInRange(int x, int y, Neighbour neighbour, int[][] graph) {
        int newX = x + neighbour.x;
        int newY = y + neighbour.y;

        return newX >= 0 && newX < graph.length && newY >= 0 && newY < graph[0].length;
    }
}
