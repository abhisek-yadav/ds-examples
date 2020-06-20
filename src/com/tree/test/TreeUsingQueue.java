package com.tree.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.queue.test.QueueUsingArray;
import com.queue.test.QueueUsingArray.Queue;

public class TreeUsingQueue {

    static TreeNode root;
    static Queue queue = new Queue(50);

    public static class TreeNode {
        TreeNode leftChild;
        int data;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }

    }

    public static void createTree(List<Integer> nodes) {

        if (nodes.isEmpty())
            return;

        root = new TreeNode(nodes.get(0));
        QueueUsingArray.enqueue(queue, root);
        nodes.remove(0);

        ListIterator<Integer> listIterator = nodes.listIterator();

        while (!QueueUsingArray.isEmpty(queue)) {

            TreeNode treeNode = QueueUsingArray.dequeue(queue);

            if (listIterator.hasNext()) {
                treeNode.leftChild = new TreeNode(listIterator.next());
                QueueUsingArray.enqueue(queue, treeNode.leftChild);
            }

            if (listIterator.hasNext()) {
                treeNode.rightChild = new TreeNode(listIterator.next());
                QueueUsingArray.enqueue(queue, treeNode.rightChild);
            }

        }

    }

    public static void preOrder(TreeNode root) {

        if (root != null) {

            System.out.print(root.data + " ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }

    }

    public static void inOrder(TreeNode root) {

        if (root != null) {

            inOrder(root.leftChild);
            System.out.print(root.data + " ");
            inOrder(root.rightChild);
        }

    }

    public static void postOrder(TreeNode root) {

        if (root != null) {

            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.print(root.data + " ");
        }

    }

    public static int count(TreeNode root) {

        if (root == null)
            return 0;

        int x = count(root.leftChild);
        int y = count(root.rightChild);

        return x + y + 1;

    }

    public static int height(TreeNode root) {

        if (root == null)
            return 0;

        int x = height(root.leftChild);
        int y = height(root.rightChild);

        if (x > y)
            return x + 1;
        else
            return y + 1;
    }

    public static void main(String[] args) {

        List<Integer> nodes = new ArrayList<>();
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);
        nodes.add(4);
        nodes.add(5);
        nodes.add(6);
        nodes.add(7);

        createTree(nodes);

        preOrder(root);

        System.out.println();

        inOrder(root);

        System.out.println();

        postOrder(root);

        System.out.println(count(root));

        System.out.println(height(root));
    }
}
