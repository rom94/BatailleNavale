package com.company;

/**
 * Created by rpage on 02/03/2017.
 */
public class SimplePointComTestDrive {

    public static void main(String[] args) {

        SimplePointCom spc = new SimplePointCom();

        int[] places = {2, 3, 4};
        spc.setCellules(places);

        String propopUtil = "2";

        String resultat = spc.AutoVerif(propopUtil);

        String resultatTest = "raté";

        if (resultat.equals("touché")){
            resultatTest = "réussi"
        }

        System.out.println(resultatTest);
    }
}
