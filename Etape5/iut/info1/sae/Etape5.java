/*
 * Etape5.java                                          JJ mois. AAAA
 * IUT de Rodez, BUT Info1 2022-2023, pas de copyright ni copyleft
 */

package iut.info1.sae101;

import java.util.Scanner;   

/**
 * TODO commenter la responsabilité du programme
 * @author Prenom NOM
 */
public class Etape5 {

    /**
     * TODO commenter les étapes et les ... du script
     * @param args renseigne sur l'usage des paramètres
     */
     public static void main(String[] args) {

        final String MESSAGE_ERREUR_SAISIE
                     = """
                       ERREUR : Veuillez saisir un caractère valide
                       """,
                     MENU_PRESENTATION
                     = """
                       \n
                       > Présentation (P)
                       > Choix intervalle opérandes (I)
                       > Choix opérateur (O)
                       > Choix intervalle entiers possible pour le résultat (E)
                       > Générer une opération (G)
                       > Quitter (Q)
                       """;
        
        final char [] REPONSES_VALIDES = {'P', 'I', 'O', 'E', 'G', 'Q'};

        String reponseUtilisateur;

        char choixMenu = 'Q';

        boolean menuActive = true,
                choixValide;

        Scanner analyseurEntree = new Scanner(System.in);

        System.out.println(MENU_PRESENTATION);

        do {
            choixValide = false;
            System.out.print("Quel est votre choix ? ");
            if (analyseurEntree.hasNextLine()){
                reponseUtilisateur = analyseurEntree.next();
                choixMenu = Character.toUpperCase(reponseUtilisateur.charAt(0));
                for (int i = 0; i < REPONSES_VALIDES.length; i++){
                    if (choixMenu == REPONSES_VALIDES[i]){
                        choixValide = true;
                    }
                }
                if (choixValide){
                    switch (choixMenu){
                    case 'P' :
                        System.out.println("Présentation");
                        // TODO code présentation
                        break;
                    case 'I' :
                        System.out.println("Choix intervalle opérandes");
                        // TODO code choix intervalle opérandes
                        break;
                    case 'O' :
                        System.out.println("Choix opérateur");
                        // TODO code choix opérateur
                        break;
                    case 'E' :
                        System.out.println("Choix intervalle entiers possible pour le résultat");
                        // TODO code choix intervalle entiers possible pour le résultat
                        break;
                    case 'G' :
                        System.out.println("Générer une opération");
                        // TODO générer une opération
                        break;
                    default :
                        System.out.println("Quitter");
                        menuActive = false;
                        break;
                    }
                }
            }
            if (!choixValide){
                System.out.println(MESSAGE_ERREUR_SAISIE);
            }
            analyseurEntree.nextLine();
        } while (menuActive);
     }
}
