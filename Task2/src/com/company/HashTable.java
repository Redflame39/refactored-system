package com.company;

public class HashTable {

    private LinkedList[] segmentArray;

    private final int size;

    private boolean empty;

    public HashTable(int size) {
        this.size = size;
        segmentArray = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            segmentArray[i] = new LinkedList();
        }
        empty = true;
    }

    public int hashCode(int value){
        return value % size;
    }

    public int toValue(String word) {
        word = word.trim();
        int value = 0;
        for (int i = 0; i < word.length(); i++) {
            value += word.charAt(i);
        }
        return value;
    }

    public void add(Node node) {
        int key = hashCode(node.getNum());
        segmentArray[key].add(node);
        empty = false;
    }

    public void delete(String word) {
        int value = toValue(word);
        int key = hashCode(value);
        segmentArray[key].delete(value);
    }

    public Node get(String word) {
        int value = toValue(word);
        int key = hashCode(value);
        return segmentArray[key].find(value);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d] = ", i);
            segmentArray[i].print();
            System.out.println();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return empty;
    }

}
