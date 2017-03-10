package com.company;

/**
 * Created by rpage on 02/03/2017.
 */
public class PointComTestDrive {

    public static void main(String[] args) {

        PointCom spc = new PointCom();

        /*int[] places = {2, 3, 4};
        spc.setCellules(places);*/

        String propopUtil = "2";

        String resultat = spc.autoVerif(propopUtil);

        String resultatTest = "raté";

        if (resultat.equals("touché")){
            resultatTest = "réussi";
        }

        System.out.println(resultatTest);
    }


}
