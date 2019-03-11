package org.alg.leetcode;

import java.util.HashMap;

public class LRUCache146 {
    static class Node {
        Node before;
        Node after;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.after = tail;
        tail.before = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.before.after = cur.after;
            cur.after.before = cur.before;
            cur.before = head;
            cur.after = head.after;
            head.after.before = cur;
            head.after = cur;
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) { // 易错！当遇到 put 的 key 已经存在时要修改 value，并把它移到链表最前端
            map.get(key).val = value;
            get(key);
            return;
        }
        if (map.size() == capacity) {
            map.remove(tail.before.key);
            tail.before = tail.before.before;
            tail.before.after = tail;
        }
        Node newNode = new Node(key, value);
        newNode.before = head;
        newNode.after = head.after;
        head.after.before = newNode;
        head.after = newNode;
        map.put(key, newNode);
    }
}
