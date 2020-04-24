package io.github.akadir.binarytreetraversal;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 23:54
 */
public class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
