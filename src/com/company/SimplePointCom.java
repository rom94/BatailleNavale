package com.company;

/**
 * Created by rpage on 06/03/2017.
 */
public class SimplePointCom {

    int [] cellules;
    int nbTouches = 0;

    public void setCellules(int[] plc){
        cellules = plc;
    }

    public String autoVerif(String stringPropo){
        int propo = Integer.parseInt(stringPropo);
        String resultat = "manqué";

        for (int i = 0; i < cellules.length; i++){
            if (propo == cellules[i]){
                resultat = "touché";
                nbTouches++;
                break;
            }
        }

        if (nbTouches == cellules.length){
            resultat = "coulé";
        }

        System.out.println(resultat);
        return resultat;
    }
}
