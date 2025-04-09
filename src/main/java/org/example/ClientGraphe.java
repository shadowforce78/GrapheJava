package org.example;

public class ClientGraphe {
    public static void main(String[] args) {

        int[][] tabVoisinsGrapheTD = {
                { 1, 3 }, // voisins du sommet 0
                { 0, 2, 4 }, // voisins du sommet 1
                { 1, 5 }, // voisins du sommet 2
                { 0, 4, 6 }, // voisins du sommet 3
                { 1, 3, 5, 7 }, // voisins du sommet 4
                { 2, 4, 8 }, // voisins du sommet 5
                { 3, 7 }, // voisins du sommet 6
                { 4, 6, 8 }, // voisins du sommet 7
                { 5, 7 } // voisins du sommet 8
        };

        Graphe grapheTD = new Graphe(tabVoisinsGrapheTD);
        System.out.println(grapheTD.toString());

        // Test du plus court chemin
        System.out.println("Plus court chemin entre 0 et 8 : " + grapheTD.plusCourtChemin(0, 8));
        System.out.println("Plus court chemin entre 0 et 7 : " + grapheTD.plusCourtChemin(0, 7));
    }
}
