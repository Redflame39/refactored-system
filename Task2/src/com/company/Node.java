package com.company;

public class Node {
    private String word;
    private int num;
    public Node next;

    public Node(String word) {
        word = word.trim();
        this.word = word;
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            num += word.charAt(i);
        }
        this.num = num;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

