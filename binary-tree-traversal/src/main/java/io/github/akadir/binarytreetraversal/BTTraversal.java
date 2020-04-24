package io.github.akadir.binarytreetraversal;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 23:47
 */
public class BTTraversal {

    public static void printPreOrder(BinaryTree binaryTree) {
        printPreOrder(binaryTree.root);
    }

    public static void printInOrder(BinaryTree binaryTree) {
        printInOrder(binaryTree.root);
    }

    public static void printPostOrder(BinaryTree binaryTree) {
        printPostOrder(binaryTree.root);
    }

    public static void printPostOrder(Node root) {
        if (root == null) {
            return;
        }

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.key);
    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.key);
        printInOrder(root.right);
    }

    public static void printPreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.key);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        BTTraversal.printPreOrder(tree);

        System.out.println("\nInorder traversal of binary tree is ");
        BTTraversal.printInOrder(tree);

        System.out.println("\nPostorder traversal of binary tree is ");
        BTTraversal.printPostOrder(tree);
    }
}
