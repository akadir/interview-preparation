package io.github.akadir.bogglesolver.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akadir
 * Date: 22.04.2020
 * Time: 21:56
 */
public class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean isEndOfWord = false;

    public TrieNode get(char i) {
        return children.get(i);
    }

    public void add(char c) {
        children.putIfAbsent(c, new TrieNode());
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }
}
