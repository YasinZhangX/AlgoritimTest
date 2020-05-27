package com.alg.datastructure;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Random;

/**
 * @author Yasin Zhang
 */
public class SkipListV2 {

    private int level = 0;
    private SkipListNode top = null;
    private Random coin = new Random();

    public SkipListV2() {
        this(4);
    }

    public SkipListV2(int level) {
        this.level = level;
        SkipListNode skipListNode = null;
        SkipListNode temp = top;
        SkipListNode tempDown = null;
        SkipListNode tempNextDown = null;
        int tempLevel = level;
        // initialize top and tail
        // from bottom to top
        while (tempLevel != 0) {
            skipListNode = createNode(Integer.MIN_VALUE);
            temp = skipListNode;
            skipListNode = createNode(Integer.MAX_VALUE);
            temp.next = skipListNode;
            temp.down = tempDown;
            temp.next.down = tempNextDown;
            tempDown = temp;
            tempNextDown = temp.next;
            tempLevel--;
        }
        top = temp;
    }

    public int randomLevel() {
        int k = 1;
        while (coin.nextInt() % 2 == 0) {
            k++;
        }
        return Math.min(k, level);
    }

    public SkipListNode find(int value) {
        SkipListNode node = top;
        while (true) {
            // 先向前再向下进行搜索
            while (node.next.value < value) {
                node = node.next;
            }

            if (node.down == null) {
                break;
            }

            node = node.down;
        }

        if (node.next.value != value) {
            return null;
        } else {
            return node.next;
        }
    }

    public boolean delete(int value) {
        SkipListNode startNode = top;
        SkipListNode cur;
        boolean isDone = false;
        while (startNode != null) {
            cur = startNode;
            while (cur.next.value < value) {
                cur = cur.next;
            }

            if (cur.next.value == value) {
                cur.next = cur.next.next;
                isDone = true;
            }

            startNode = startNode.down;
        }

        return isDone;
    }

    public void insert(int value) {
        int k = randomLevel();
        SkipListNode startNode = top;
        int curLevel = level;
        SkipListNode curNode;
        SkipListNode upNode = null;

        while (curLevel != k) {
            startNode = startNode.down;
            curLevel--;
        }

        while (startNode != null) {
            curNode = startNode;
            while (curNode.next.value < value) {
                curNode = curNode.next;
            }
            // 创建新节点
            SkipListNode node = createNode(value);
            // 设置down指针
            if (upNode != null) {
                upNode.down = node;
            }
            upNode = node;
            // 插入新节点
            node.next = curNode.next;
            curNode.next = node;

            // 继续下一层
            startNode = startNode.down;
        }
    }

    private SkipListNode createNode(int value) {
        return new SkipListNode(value);
    }

    static class SkipListNode implements Comparable {
        private Integer value = -1;
        private SkipListNode next = null;
        private SkipListNode down = null;

        SkipListNode() {
        }

        SkipListNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "SkipListNode{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(value, ((SkipListNode) o).value);
        }
    }
}
