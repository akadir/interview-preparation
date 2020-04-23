package io.github.akadir.screenlockingpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akadir
 * Date: 23.04.2020
 * Time: 20:59
 */
public class ScreenLock {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point getNeighbourIn(Direction direction) {
            return new Point(this.x + direction.x, this.y + direction.y);
        }
    }

    public enum Direction {
        UP_LEFT(-1, -1),
        UP(-1, 0),
        UP_RIGHT(-1, 1),
        LEFT(0, -1),
        RIGHT(0, 1),
        DOWN_LEFT(1, -1),
        DOWN(1, 0),
        DOWN_RIGHT(1, 1),
        TWO_DOWN_RIGHT(2, 1),
        DOWN_TWO_RIGHT(1, 2),
        TWO_DOWN_LEFT(2, -1),
        DOWN_TWO_LEFT(1, -2),
        TWO_UP_RIGHT(-2, 1),
        TWO_RIGHT_UP(-1, 2),
        TWO_UP_LEFT(-2, -1),
        UP_TWO_LEFT(-1, -2);

        public final int x;
        public final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final char[][] lockScreen = {
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'}
    };

    public int calculateCombinations(char startPosition, int patternLength){
        if(patternLength > 9 || patternLength <= 0) {
            return 0;
        }

        Point start = null;

        outerLoop:
        for(int i = 0; i < lockScreen.length; i++){
            for(int j = 0; j < lockScreen[i].length; j++){
                if(startPosition == lockScreen[i][j]) {
                    start = new Point(i, j);
                    break outerLoop;
                }
            }
        }

        if(start == null) {
            return 0;
        }

        boolean[][] visited = new boolean[lockScreen.length][lockScreen[0].length];

        return dfs(start, visited, "", patternLength, 0);
    }

    private int dfs(Point current, boolean[][] visited, String currentPattern,
                    int targetLength, int count){
        int x = current.x;
        int y = current.y;

        if(visited[x][y]){
            return count;
        }

        currentPattern = currentPattern + lockScreen[x][y];

        if(currentPattern.length() == targetLength) {
            count++;
            return count;
        }

        visited[x][y] = true;

        List<Point> nextLocations = getNextPossibleLocations(current, visited);

        for(Point point : nextLocations){
            count = dfs(point, visited, currentPattern, targetLength, count);
        }

        visited[x][y] = false;

        return count;
    }

    private List<Point> getNextPossibleLocations(Point current, boolean[][] visited) {
        List<Point> nextPossibleLocations = new ArrayList<>();

        for(Direction direction : Direction.values()){
            Point p = current.getNeighbourIn(direction);

            if(isPointInRange(p)) {
                if(!visited[p.x][p.y]) {
                    nextPossibleLocations.add(p);
                } else {
                    p = p.getNeighbourIn(direction);

                    if(isPointInRange(p) && !visited[p.x][p.y]){
                        nextPossibleLocations.add(p);
                    }
                }
            }
        }

        return nextPossibleLocations;
    }

    private boolean isPointInRange(Point point) {
        return point.x < lockScreen.length && point.x >= 0 && point.y < lockScreen[0].length && point.y >= 0;
    }
}