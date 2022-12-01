/*
 * EntierAleatoireV3                                          01 dec. 2022
 * IUT de Rodez, Tom JAMMES, Tony LAPEYRE, Thomas LEMAIRE, Thomas IZARD, 
 * pas de copyright ni de copyleft
 */

package iut.info1.sae.etapes;

import java.util.Scanner;
import static java.lang.System.out;

/**
 * SAE 101
 * Etape 3
 *
 * Concevoir un logiciel d'entrainement au calcul mental
 * Le programme demande à l'utilisateur de rentrer des paramètres
 * (interval opérant, opérateurs utilisé)
 * Le programme envoie une suite de calcul et renvoi le score de l'utilisateur
 * à la fin de la session
 *
 * @author Tom JAMMES, Tony LAPEYRE, Thomas LEMAIRE, Thomas IZARD
 * @version 1.0
 */

public class EntierAleatoireV3 {

    /**
     * Demande à l'utilisateur de rentrer l'intervalle des opérandes
     * et tire un entier aléatoire dans l'interval des opérandes
     * 
     * @param args non utilisé
     */

    public static void main(String[] args) {

        boolean testValeur;

        int borneMin, borneMax;

        int borneMinResult, borneMaxResult;
        
        int operandeGauche, operandeDroit, operateur, resultat;

        String operateurResult = "+";

        final String ERREUR_SAISIE_PAS_ENTIER ="""                   
                                                        ERREUR !        
                                        Vous n'avez pas saisis un nombre entier
                                        """;
        
        
        Scanner analyseurEntree = new Scanner(System.in);
 
        out.println(""" 
                        ------------------- OBJECTIF -------------------
                        |      Vous devez rentrer les bornes d'un      | 
                        | intervalle fermé d'entier [minimum, maximum] | 
                        -----------------------------------------------
                    """);

        
        /* Demande deux valeurs en s'assurant que c'est bien un int */
        borneMin = 0;    // contrer erreur d'initialisation à la compilation
        out.print("Entrez une première valeur : ");
        testValeur = analyseurEntree.hasNextInt();
        if (testValeur) {            
            borneMin = analyseurEntree.nextInt();
            analyseurEntree.nextLine();

            out.print("\nEntrez une deuxième valeur : ");
            testValeur = analyseurEntree.hasNextInt();
        }
        if (testValeur) {
            borneMax = analyseurEntree.nextInt();
            analyseurEntree.nextLine();
            
            if (borneMin > borneMax) {
                int permuter;
                permuter = borneMax;
                borneMax = borneMin;
                borneMin = permuter;
            }

            out.printf("\nVous avez choisi l'interval I=[%d;%d]\n"
                        , borneMin, borneMax); 

            out.println(""" 
                            ------------------- OBJECTIF -------------------
                            |    Vous devez maintenantrentrer les bornes   | 
                            | de l'intervalle dans lequel le résultat doit |
                            |                  se trouver.                 |
                            ------------------------------------------------
                        """);

            borneMinResult = 0;    // contrer erreur d'initialisation à la compilation
            borneMaxResult = 0;    // contrer erreur d'initialisation à la compilation
            out.print("Entrez une première valeur : ");
            testValeur = analyseurEntree.hasNextInt();
            if (testValeur) {            
                borneMinResult = analyseurEntree.nextInt();
                analyseurEntree.nextLine();

                out.print("\nEntrez une deuxième valeur : ");
                testValeur = analyseurEntree.hasNextInt();
            }
            if (testValeur) {
                borneMaxResult = analyseurEntree.nextInt();
                analyseurEntree.nextLine();
            
                if (borneMinResult > borneMaxResult) {
                    int permuter;
                    permuter = borneMaxResult;
                    borneMaxResult = borneMinResult;
                    borneMinResult = permuter;
                }
            }

            out.printf("\nVous avez choisi l'interval I=[%d;%d]\n"
                        , borneMinResult, borneMaxResult); 

            do {
                /* Tirage au sort des deux operandes */
                operandeGauche = borneMin + (int)(Math.random() * ((borneMax - borneMin) + 1));
                operandeDroit = borneMin + (int)(Math.random() * ((borneMax - borneMin) + 1));

                /* Génération du calcul avec opérateur aléatoire */
                operateur = (int)(Math.random() * 5);


                switch (operateur) {  // FIXME probleme de compilation
                case  1 :
                    operateurResult = "-";
                    resultat = operandeGauche - operandeDroit;
                    break;

                case  2 :
                    operateurResult = "*";
                    resultat = operandeGauche * operandeDroit;
                    break;

                case  3 :
                    /* Gestion du cas de la division par 0 */
                    while (operandeDroit == 0) {
                        operandeDroit = borneMin + (int)(Math.random() * ((borneMax - borneMin) + 1));
                    }
                    operateurResult = "/";
                    resultat = operandeGauche / operandeDroit;
                    break;

                case  4 :
                    /* Gestion du cas de la division par 0 */
                    while (operandeDroit == 0) {
                        operandeDroit = borneMin + (int)(Math.random() * ((borneMax - borneMin) + 1));
                    }
                    operateurResult = "%";
                    resultat = operandeGauche % operandeDroit;
                    break;

                default :
                    operateurResult = "+";
                    resultat = operandeGauche + operandeDroit;
                    break;
                 }     
            } while (resultat < borneMinResult || resultat > borneMaxResult);
            out.printf("%d %s %d = %d\n", operandeGauche, operateurResult, operandeDroit, resultat);     
        } else {
            out.println(ERREUR_SAISIE_PAS_ENTIER);
        }
    }
}
