package cn.aprilviolet.fundamentals.datastructure.tree;

import java.util.TreeMap;

/**
 * 字典树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.17 星期六 22:44
 * @since V1.0.0
 */
public class Trie {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 单词数
     */
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    /**
     * 往字典树中添加单词
     *
     * @param word 添加的单词
     */
    public void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (current.next.get(letter) == null) {
                current.next.put(letter, new Node());
            }
            current = current.next.get(letter);
        }

        if (!current.isWord) {
            current.isWord = true;
            size++;
        }
    }

    /**
     * 判断当前字典树中是否存在某个单词
     *
     * @param word 需要判断是否存在的单词
     * @return true:存在
     *         false:不存在
     */
    public boolean contains(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (current.next.get(letter) == null) {
                return false;
            }
            current = current.next.get(letter);
        }
        return current.isWord;
    }

    /**
     * 判断树中是否存在某个前缀的单词
     *
     * @param prefix 前缀
     * @return true:存在
     *         false:不存在
     */
    public boolean isPrefix(String prefix) {
        return judgeExistsWord(prefix, root);
    }

    /**
     * 判断是否存在某个单词前缀
     *
     * @param word 某个单词前缀
     * @param current 根节点
     * @return true:存在
     *         false:不存在
     */
    private boolean judgeExistsWord(String word, Node current) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (current.next.get(letter) == null) {
                return false;
            }
            current = current.next.get(letter);
        }
        return true;
    }

    /**
     * 获得Trie中存储的单词数量
     *
     * @return 单词数
     */
    public int getSize(){
        return size;
    }

    private class Node {
        /**
         * 是否是单词的结尾
         */
        public boolean isWord;

        /**
         * 具体的节点
         */
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }
}
