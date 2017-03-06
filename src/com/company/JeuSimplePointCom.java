package com.company;

/**
 * Created by rpage on 06/03/2017.
 */
public class JeuSimplePointCom {
    public static void main(String[] args) {

        int nbPropo = 0;
        GameHelper helper = new GameHelper();
        SimplePointCom lePointCom = new SimplePointCom();
        int randomNum = (int) (Math.random() * 5);
        int[] places = {randomNum, randomNum + 1, randomNum +2};
        lePointCom.setCellules(places);
        boolean estVivant = true;

        while (estVivant == true){
            String propo = helper.getPropoUtil("Tapez un chiffre");
            String resultat = lePointCom.autoVerif(propo);
            nbPropo++;

            if (resultat.equals("coulé")){
                estVivant = false;
                System.out.println("En " + nbPropo + " coups");
            }
        }
    }
}
