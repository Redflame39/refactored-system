package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static FileReader fr;

    static {
        try {
            fr = new FileReader("src/com/company/words.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static boolean process = true;

    public static Scanner file = new Scanner(fr);
    static Scanner switchIn = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);

    static HashTable hashTable = new HashTable(100);

    public static void main(String[] args) {

        while (file.hasNextLine()) {
            hashTable.add(new Node(file.nextLine()));
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            printDialogue();
            int k = switchIn.nextInt();
            getSwitch(k);
        } while (process);
    }

    static void getSwitch(int k) {
        switch (k) {
            case 1:
                add(getValue());
                break;

            case 2:
                get(getValue());
                break;

            case 3:
                delete(getValue());
                break;

            case 4:
                printTable();
                break;

            case 5:
                process = false;
                break;
        }
    }

    static String getValue() {
        return input.nextLine();
    }

    static void add(String word) {
        hashTable.add(new Node(word));
    }

    static void get(String word) {
        if (hashTable.get(word) == null) {
            System.out.println("\nNo matches :(\n");
            return;
        }
        String result = hashTable.get(word).getWord();
        System.out.println("[" + hashTable.get(result).getNum() % hashTable.size() + "] = " + hashTable.get(result).getWord());

    }

    static void delete(String word) {
        if (hashTable.get(word) == null) {
            System.out.println("\nNo matches :(\n");
            return;
        }
        hashTable.delete(word);
    }

    static void printTable() {
        if (!hashTable.isEmpty())
            hashTable.print();
        else System.out.println("\nTable is empty\n");
    }

    static void printDialogue() {
        System.out.println("\n1.Add\n2.Search\n3.Delete\n4.Print list\n5.Exit\n");
    }
}
