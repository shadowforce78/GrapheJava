package org.example;

import java.util.*;

public class Graphe {
    private TreeMap<Integer, Set<Integer>> adjacence; // Map des sommets et de leurs voisins
    // Clé = sommets, Valeur = ensemble de voisins du sommet clé

    // Constructeur reçoit un tableau de deux dimensions
    public Graphe(int[][] tab) {
        adjacence = new TreeMap<>();
        // Initialiser tous les sommets avec des ensembles vides
        for (int i = 0; i < tab.length; i++) {
            adjacence.put(i, new HashSet<>());
        }
        // Ajouter les voisins pour chaque sommet
        for (int i = 0; i < tab.length; i++) {
            Set<Integer> voisins = adjacence.get(i);
            for (int voisin : tab[i]) {
                voisins.add(voisin);
            }
        }
    }

    public int getDegreSommet(int sommet) {
        return adjacence.get(sommet).size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ordre : ").append(getOrderGraphe()).append("\n");
        sb.append("taille : ").append(getTaille()).append("\n");
        sb.append("degré min : ").append(getDegreMin()).append("\n");
        sb.append("degré max : ").append(getDegreMax()).append("\n");
        for (Integer sommet : adjacence.keySet()) {
            sb.append("sommet ").append(sommet)
                    .append(" (degré : ").append(getDegreSommet(sommet)).append(") ")
                    .append("voisins : ");
            Set<Integer> voisins = adjacence.get(sommet);
            sb.append(String.join(", ", voisins.stream().map(String::valueOf).toList()));
            sb.append("\n");
        }
        return sb.toString();
    }

    public Set<Integer> getSommets() {
        return adjacence.keySet(); // Retourne les clés de la map (les sommets)
    }

    public int getOrderGraphe() {
        return adjacence.size(); // Retourne la taille de la map (le nombre de sommets)
    }

    public int getDegre() {
        int degre = 0;
        for (Set<Integer> voisins : adjacence.values()) {
            degre += voisins.size(); // Somme des tailles des ensembles de voisins
        }
        return degre; // Retourne le degré total du graphe
    }

    public int getDegreMin() {
        int degreMin = Integer.MAX_VALUE;
        for (Set<Integer> voisins : adjacence.values()) {
            int degre = voisins.size();
            if (degre < degreMin) {
                degreMin = degre; // Met à jour le degré minimum
            }
        }
        return degreMin; // Retourne le degré minimum du graphe
    }

    public int getDegreMax() {
        int degreMax = Integer.MIN_VALUE;
        for (Set<Integer> voisins : adjacence.values()) {
            int degre = voisins.size();
            if (degre > degreMax) {
                degreMax = degre; // Met à jour le degré maximum
            }
        }
        return degreMax; // Retourne le degré maximum du graphe
    }

    public int getTaille() {
        int taille = 0;
        for (Set<Integer> voisins : adjacence.values()) {
            taille += voisins.size(); // Somme des tailles des ensembles de voisins
        }
        return taille / 2; // Retourne la taille du graphe (nombre d'arêtes)
    }
}
