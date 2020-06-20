package com.linkedlist.practice;

public class LinkedListTest {

    static class LinkedList {
        static Node head;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static int count(Node node) {

        if (node == null)
            return 0;

        return count(node.next) + 1;
    }

    public static void nthNode(Node node, int index) {

        for (int i = 0; node != null && i <= index - 1; i++) {
            node = node.next;
        }
        if (node == null)
            System.out.println(node);
        else
            System.out.println(node.val);
    }

    public static int pow(int x, int y) {
        if (y == 0)
            return 1;
        int temp = pow(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;

    }

    public static int nthFromLast(Node node, int n) {
        if (node == null)
            return -1;

        Node slow = node;
        int count = 1;

        while (node != null && count == n - 1) {
            node = node.next;
            ++count;
        }
        if (node == null)
            return -1;

        while (node.next != null) {
            slow = slow.next;
            node = node.next;
        }
        return slow.val;
    }

    public static int countFrequency(Node node, int val) {

        if (node == null)
            return 0;
        if (node.val == val)
            return 1 + countFrequency(node.next, val);

        return countFrequency(node.next, val);

    }

    public static void printLL(Node node) {

        if (node != null)
            System.out.print(node.val + " ");
        else
            return;

        printLL(node.next);
    }

    public static void removeDuplicates(Node node) {

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                continue;
            }

            node = node.next;
        }
    }

    public static void removeDuplicatesUsingRecursion(Node node) {

        if (node.next == null)
            return;

        removeDuplicatesUsingRecursion(node.next);

        if (node.val == node.next.val)
            node.next = node.next.next;

    }

    public static void swapNodes(Node node, int key1, int key2) {
        Node p = node, q = node;

        while (p.next != null) {
            if (p.val == key1 || p.next.val == key1)
                break;

            p = p.next;
        }
        while (q.next != null) {
            if (q.val == key2 || q.next.val == key2)
                break;

            q = q.next;
        }

        Node forward = q.next.next;
        Node r = p.next;
        p.next = q.next;
        q.next = r;
        p.next.next = r.next;
        r.next = forward;

    }

    public static Node reverseRecursion(Node node, Node prev) {

        if (node.next == null) {
            node.next = prev;
            LinkedList.head = node;
            return node;
        }

        Node next1 = node.next;
        node.next = prev;

        return reverseRecursion(next1, node);
    }

    public static void main(String[] args) {

        Node node = new Node(2);
        LinkedList.head = node;

        Node secondNode = new Node(3);
        node.next = secondNode;

        Node thirdNode = new Node(4);
        secondNode.next = thirdNode;

        Node forthNode = new Node(5);
        thirdNode.next = forthNode;

        Node fifthNode = new Node(7);
        forthNode.next = fifthNode;


//        System.out.println(count(secondNode));
//        nthNode(node, 3);
//        System.out.println(pow(2, 4));

//        System.out.println(nthFromLast(node, 2));


//        System.out.println(countFrequency(node, 2));

//        removeDuplicates(node);

//        removeDuplicatesUsingRecursion(node);

//        swapNodes(node, 2, 7);


        printLL(reverseRecursion(node, null));
    }
}
