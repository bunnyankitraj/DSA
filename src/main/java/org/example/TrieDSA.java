package org.example;

import java.util.HashMap;
import java.util.Map;

public class TrieDSA {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("ball");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));

        trie.insert("app");
        System.out.println(trie.search("app"));
        trie.insert("app");
        trie.insert("ank");
        trie.insert("apk");
        trie.printAll();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");

        trie.printAll();  // Output: app, apple, apricot, banana

    }

}
class Trie {
    NodeLists root;

    public Trie() {
        root = new NodeLists();
    }

    public void printAll() {
        printAll(root, new StringBuilder());
    }

    private void printAll(NodeLists currentNode, StringBuilder currentWord) {
        if (currentNode.isEndWord) {
            System.out.println(currentWord.toString());
        }

        for (Map.Entry<Character, NodeLists> entry : currentNode.children.entrySet()) {
            currentWord.append(entry.getKey());
            printAll(entry.getValue(), currentWord);
            currentWord.deleteCharAt(currentWord.length() - 1); // Backtrack
        }
    }


    public void insert(String word) {
        NodeLists currentNode = root;
        for (char c : word.toCharArray()) {
            if (root.children.get(c) == null) {
                NodeLists nodeLists1 = new NodeLists();
                root.children.put(c, nodeLists1);
            }
        }
        currentNode.isEndWord = true;
    }

    public boolean search(String word) {
        NodeLists currentNode = root;
        for(char c : word.toCharArray()){
            if(currentNode.children.get(c)==null){
                return false;
            }
        }
        return currentNode.isEndWord;
    }

    public boolean startsWith(String prefix) {
        NodeLists currentNode = root;
        for(char c : prefix.toCharArray()){
            if(currentNode.children.containsKey(c)){
                return false;
            }
        }
        return true;
    }

    public boolean delete(String delete) {
        NodeLists currentNode = root;
        for(int i =0;i<delete.length();i++){
            if(i==delete.length()-1) {
                if(currentNode.children.containsKey(delete.indexOf(i))){

                }
                else{

                }
            }

            if(currentNode.children.containsKey(delete.indexOf(i))){
                return false;
            }

        }
        currentNode.isEndWord = false;
        return true;
    }

    public static class NodeLists {
        boolean isEndWord;
        Map<Character,NodeLists> children;
        String content;

        public NodeLists() {
            this.children = new HashMap<>();
            this.isEndWord = false;
        }
    }
}
