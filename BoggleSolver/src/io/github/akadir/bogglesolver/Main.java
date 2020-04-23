package io.github.akadir.bogglesolver;

import io.github.akadir.bogglesolver.trie.Trie;
import io.github.akadir.bogglesolver.trie.TrieNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public enum Direction {
        UP_LEFT(-1, -1, "↖"),
        UP(-1, 0, "↑"),
        UP_RIGHT(-1, 1, "↗"),
        LEFT(0, -1, "←"),
        RIGHT(0, 1, "→"),
        DOWN_LEFT(1, -1, "↙"),
        DOWN(1, 0, "↓"),
        DOWN_RIGHT(1, 1, "↘");

        public final int x;
        public final int y;
        public final String way;

        Direction(int x, int y, String way) {
            this.x = x;
            this.y = y;
            this.way = way;
        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"apple", "pickle", "side", "kick", "sick", "mood", "cat",
                "cats", "man", "super", "antman", "godzilla", "dog", "dot",
                "sine", "cos", "signal", "bitcoin", "cool", "zapper"};

        Character[][] boggle = {
                {'c', 'n', 't', 's', 's'},
                {'d', 'a', 't', 'i', 'n'},
                {'o', 'o', 'm', 'e', 'l'},
                {'s', 'i', 'k', 'n', 'd'},
                {'p', 'i', 'c', 'l', 'e'}
        };

        Trie trie = new Trie();

        for (String s : dictionary) {
            trie.add(s);
        }

        for (int i = 0; i < boggle.length; i++) {
            for (int j = 0; j < boggle[i].length; j++) {
                Pair<Integer, Integer> currentPoint = new Pair<>(i, j);
                Main.dfs(currentPoint, currentPoint, boggle, "", trie.root, new HashSet<>(), new ArrayList<>());
            }
        }

    }

    public static void dfs(Pair<Integer, Integer> startedFrom, Pair<Integer, Integer> currentPoint, Character[][] boggle,
                           String currentWord, TrieNode root, Set<String> visited, List<Direction> directions) {
        int x = currentPoint.getKey();
        int y = currentPoint.getValue();

        char currentCharacter = boggle[x][y];

        TrieNode node = root.get(currentCharacter);

        if (node == null || visited.contains(x + "-" + y)) {
            return;
        }

        currentWord += currentCharacter;

        if (node.isEndOfWord()) {
            StringBuilder sb = new StringBuilder("Found: ").append(currentWord)
                    .append(" | start from: ")
                    .append(startedFrom.getKey()).append("-").append(startedFrom.getValue())
                    .append(" and go: ");
            for (Direction direction : directions) {
                sb.append(direction.way).append(" ");
            }

            System.out.println(sb.toString());
        }

        List<Direction> neighbours = getNeighbours(boggle, x, y);

        visited.add(x + "-" + y);

        for (Direction neighbour : neighbours) {
            Pair<Integer, Integer> newLocation = new Pair<>(x + neighbour.x, y + neighbour.y);
            directions.add(neighbour);
            dfs(startedFrom, newLocation, boggle, currentWord, node, visited, directions);
            directions.remove(neighbour);
        }

        visited.remove(x + "-" + y);
    }

    public static List<Direction> getNeighbours(Character[][] boggle, int x, int y) {
        List<Direction> neighbours = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            int xOfNeighbour = x + direction.x;
            int yOfNeighbour = y + direction.y;
            if (xOfNeighbour >= 0 && xOfNeighbour < boggle.length
                    && yOfNeighbour >= 0 && yOfNeighbour < boggle[x].length) {
                neighbours.add(direction);
            }
        }

        return neighbours;
    }
}
