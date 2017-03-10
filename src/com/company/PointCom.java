package com.company;

import java.util.ArrayList;

/**
 * Created by rpage on 06/03/2017.
 */
public class PointCom {

    private ArrayList<String> cellules;
    //int nbTouches = 0;

    public void setCellules(ArrayList<String> plc){
        cellules = plc;
    }

    public String autoVerif(String propoUtil){
        //int propo = Integer.parseInt(stringPropo);
        String resultat = "manqué";

        int indice = cellules.indexOf(propoUtil);

        if (indice >= 0){
            cellules.remove(indice);
            if (cellules.isEmpty()){
                resultat = "coulé";
            } else {
                resultat = "touché";
            }
        }

        /*for (int i = 0; i < cellules.size(); i++){
            if (propo == cellules[i]){
                resultat = "touché";
                nbTouches++;
                break;
            }
        }

        if (nbTouches == cellules.length){
            resultat = "coulé";
        }*/

        System.out.println(resultat);
        return resultat;
    }
}
