package com.linkedlist.practice;

public class LinkedListTest1 {

    static class LinkedList {
        static Node head;
    }

    static class Node {
        char val;
        Node next;

        Node(char val) {
            this.val = val;
        }
    }

    static Node left = LinkedList.head;

    public static boolean isPalindrome(Node node) {

         left = LinkedList.head;

        if (node == null)
            return true;

        boolean ilp = isPalindrome(node.next);
        if (ilp == false)
            return false;

        boolean flag = left.val == node.val;

        left = left.next;

        return flag;
    }

    public static void main(String[] args) {

        LinkedListTest1.Node node = new LinkedListTest1.Node('a');
        LinkedListTest1.LinkedList.head = node;

        LinkedListTest1.Node secondNode = new LinkedListTest1.Node('b');
        node.next = secondNode;

        LinkedListTest1.Node thirdNode = new LinkedListTest1.Node('c');
        secondNode.next = thirdNode;

        LinkedListTest1.Node forthNode = new LinkedListTest1.Node('b');
        thirdNode.next = forthNode;

        LinkedListTest1.Node fifthNode = new LinkedListTest1.Node('a');
        forthNode.next = fifthNode;


        System.out.println(isPalindrome(node));
    }
}
