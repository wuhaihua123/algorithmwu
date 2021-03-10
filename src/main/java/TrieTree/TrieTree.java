package TrieTree;

public class TrieTree {
    public static void main(String[] args) {

    }

    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;


        //tmp-'a'
        public Node1() {
            this.pass = 0;
            this.end = 0;
            nexts = new Node1[26];

        }

    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();

        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] arr = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < arr.length; i++) {
                path = arr[i] - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node1();

                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null) {
                return 0;

            }
            char[] arr = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                index = arr[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;

            }
            char[] arr = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                index = arr[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
