package greedy;

import java.util.PriorityQueue;

class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left, right;

    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = right = null;
    }
}

public class HuffmanCoding {

    // Comparator for PriorityQueue
    static class Compare {
        public static int compare(HuffmanNode node1, HuffmanNode node2) {
            return node1.frequency - node2.frequency;
        }
    }

    // Build the Huffman Tree
    public static void buildHuffmanTree(char[] charArray, int[] freqArray) {
        int n = charArray.length;

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(n, Compare::compare);

        // Step 1: Create a priority queue and insert all nodes
        for (int i = 0; i < n; i++) {
            queue.add(new HuffmanNode(charArray[i], freqArray[i]));
        }

        // Step 2: Build the Huffman tree
        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode top = new HuffmanNode('-', left.frequency + right.frequency);
            top.left = left;
            top.right = right;
            queue.add(top);
        }

        // The root of the Huffman tree
        HuffmanNode root = queue.poll();
        printHuffmanCodes(root, "");
    }

    // Print Huffman codes by traversing the tree
    public static void printHuffmanCodes(HuffmanNode root, String code) {
        if (root == null) return;

        // If it's a leaf node, print its code
        if (root.left == null && root.right == null) {
            System.out.println(root.data + ": " + code);
        }

        // Traverse the left and right subtrees
        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqArray = {5, 9, 12, 13, 16, 45};

        buildHuffmanTree(charArray, freqArray);
    }
}
