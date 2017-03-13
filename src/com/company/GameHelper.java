package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by rpage on 06/03/2017.
 */
public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int tailleLigne = 7;
    private int tailleGrille = 49;
    private int[] grille = new int[tailleGrille];
    private int nbPtCom = 0;

    public String getPropoUtil(String prompt) {
        String inputLine = null;
        System.out.print(prompt + "");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placePointCom(int taillePtCom) {
        ArrayList<String> cellAlpha = new ArrayList<String>();
        String[] coordAlpha = new String[taillePtCom]; // contient des coordonnées comme "F6"
        String temp = null; // temporaire pour la concaténation
        int[] coords = new int[taillePtCom]; // coordonnées candidates actuelles
        int essais = 0; // nombre d’essais actuel
        boolean succes = false; // flag = trouvé une bonne place ?
        int place = 0; // place de départ actuelle
        nbPtCom++; // nième pointcom à placer
        int incr = 1; // incrément horizontal
        if ((nbPtCom % 2) == 1) { // si impair (placer verticalement)
            incr = tailleLigne; // incrément vertical
        }
        while (!succes & essais++ < 200) { // boucle principale (32)
            place = (int) (Math.random() * tailleGrille); // obtenir point de départ aléatoire
            //System.out.print(“essayé ” + place);
            int x = 0; // nième position des pointcom à placer
            succes = true; // supposer le succès
            while (succes && x < taillePtCom) { // chercher les adjacences inutilisées
                if (grille[place] == 0) { // si non déjà utilisée
                    coords[x++] = place; // sauvegarder l’emplacement
                    place += incr; // essayer adjacence "suivante"
                    if (place >= tailleGrille) { // dépassement des bornes - "bas"
                        succes = false; // échec
                    }
                    if (x > 0 && (place % tailleLigne == 0)) { // dépassement des bornes - bord droit
                        succes = false; // échec
                    }
                } else { // place déjà occupée
                // System.out.print(“ utilisé“ + place);
                    succes = false; // échec
                }
            }
        } // fin du while
        int x = 0; // transformer en coordonnées alpha
        int ligne = 0;
        int colonne = 0;
        // System.out.println(“\n”);
        while (x < taillePtCom) {
            grille[coords[x]] = 1; // marquer les points "utilisés"
            ligne = (int) (coords[x] / tailleLigne); // obtenir la valeur de la ligne
            colonne = coords[x] % tailleLigne; // et la valeur numérique de la colonne
            temp = String.valueOf(alphabet.charAt(colonne)); // convertir en alpha
            cellAlpha.add(temp.concat(Integer.toString(ligne)));
            x++;
            // System.out.print(“ coord “+x+” = “ + cellAlpha.get(x-1));
        }
        // System.out.println(“\n”);
        return cellAlpha;
    }
}
