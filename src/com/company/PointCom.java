package com.company;

import java.util.ArrayList;

/**
 * Created by rpage on 06/03/2017.
 */
public class PointCom {

    private ArrayList<String> cellules;
    private String nom;

    public void setCellules(ArrayList<String> places){
        cellules = places;
    }

    public void setNom(String n){
        nom = n;
    }

    public String autoVerif(String propoUtil){
        String resultat = "manqué";

        int indice = cellules.indexOf(propoUtil);

        if (indice >= 0){
            cellules.remove(indice);
            if (cellules.isEmpty()){
                resultat = "coulé";
                System.out.println("Ouille ! " + nom + " coulé :( ");
            } else {
                resultat = "touché";
            }
        }

        return resultat;
    }
}
