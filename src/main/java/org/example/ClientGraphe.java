package org.example;

public class ClientGraphe {
    public static void main(String[] args) {
        int[][] tab = {
                { 1, 2, 4 },
                { 0, 2 },
                { 0, 1, 3, 4 },
                { 2, 4 },
                { 0, 2, 3 }
        };

        Graphe graphe1 = new Graphe(tab);
        System.out.println(graphe1.toString());

    }
}
