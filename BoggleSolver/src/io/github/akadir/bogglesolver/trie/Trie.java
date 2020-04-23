package io.github.akadir.bogglesolver.trie;

/**
 * @author akadir
 * Date: 22.04.2020
 * Time: 21:56
 */
public class Trie {
    public TrieNode root = new TrieNode();

    public void add(String str) {
        TrieNode curr = root;

        for (char c : str.toCharArray()) {
            curr.add(c);
            curr = curr.get(c);
        }

        curr.setEndOfWord();
    }

    public TrieNode getTrieNode(char c) {
        return root.get(c);
    }
}