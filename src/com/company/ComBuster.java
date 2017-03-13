package com.company;

import java.util.ArrayList;

/**
 * Created by rpage on 13/03/2017.
 */
public class ComBuster {

    //Déclarer et initialiser les variables
    private GameHelper helper = new GameHelper();
    private ArrayList<PointCom> listePointComs = new ArrayList<>();
    private int nbPropo = 0;

    private void installerJeu(){
        //Créer 3 objets PointCom, les nommer et les placer dans l'ArrayList
        PointCom un = new PointCom();
        un.setNom("Cats.com");
        PointCom deux = new PointCom();
        deux.setNom("Jouer.com");
        PointCom trois = new PointCom();
        trois.setNom("Go2.com");
        listePointComs.add(un);
        listePointComs.add(deux);
        listePointComs.add(trois);

        //Afficher de brèves instructions à l'utilisateur
        System.out.println("Votre but est de couler trois pointcoms.");
        System.out.println("Cats.com, Jouer.com, Go2.com");
        System.out.println("Essayer de les couler en un minimum de coups.");

        //Répéter pour chaque PointCom de la liste
        for (PointCom pointComAPlacer : listePointComs){
            //Demander au helper une place pour un PointCom
            ArrayList<String> nouvellePlace = helper.placePointCom(3);
            //Appeler la méthode set sur ce PointCom pour l'affecter à l'emplacement que vous venez d'obtenir du helper
            pointComAPlacer.setCellules(nouvellePlace);
        }
    }

    private void commencerJeu(){
        //Tant que la liste de PointCom n'est pas vide
        while (!listePointComs.isEmpty()){
            //Lire ce que tape l'utilisateur
            String propoUtil = helper.getPropoUtil(" Coordonnées ?");
            //Appeler notre propre méthode testerPropoUtil()
            testerPropoUtil(propoUtil);
        }
        //Appeler notre propre méthode terminerJeu()
        terminerJeu();
    }

    private void testerPropoUtil(String propoUtil){
        //Incrémenter le nombre de propositions de l'utilisateur
        nbPropo++;
        //On suppose un manqué sauf indication contraire
        String resultat = "manqué";

        //Répéter pour tous les PointCom de la liste
        for (PointCom pointComATester : listePointComs){
            //demander au PointCom de vérifier la propositio de l'utilisateur (on cherche touché ou coulé)
            resultat = pointComATester.autoVerif(propoUtil);
            if (resultat.equals("touché")){
                //inutile de tester les autres, on sort de la boucle
                break;
            }
            if (resultat.equals("coulé")){
                //celui-ci est fini. On le supprime de la liste des PointComs et on sort de la boucle
                listePointComs.remove(pointComATester);
                break;
            }
        }

        //Afficher le résultat à l'utilisateur
        System.out.printf(resultat);
    }

    private void terminerJeu(){
        //Afficher un message à l'utilisateur en fonction de sa performance
        System.out.println("Tous les PointComs sont morts ! Les actions ne valent plus rien");
        if (nbPropo <= 18){
            System.out.println("Il ne vous a fallu que " + nbPropo + " coups.");
            System.out.printf("Vous vous en êtes sorti à temps");
        } else {
            System.out.println("Trop long." + nbPropo + " coups.");
            System.out.println("Les poissons dévorent vos stock options");
        }
    }

    public static void main(String[] args) {
        //Créer l'objet jeu
        ComBuster jeu = new ComBuster();
        //Dire à l'objet d'installer le jeu
        jeu.installerJeu();
        //Dire à l'objet de lancer la boucle principale (demander des coordonnées à l'utilisateur et les vérifier
        jeu.commencerJeu();
    }
}
