/*
 * DemandeInterval                                            21 oct 2022
 * IUT de Rodez, Tom JAMMES, Tony LAPEYRE, Thomas LEMAIRE, Thomas IZARD, pas de copyright ni de copyleft
 */

package iut.info1.sae101;

import java.util.Scanner;
import static java.lang.System.out;

/**
 * SAE 101
 * Etape 1
 *
 * Concevoir un logiciel d'entrainement au calcul mental
 * Le programme demander à l'utilisateur de rentrer des paramètres
 * (interval opérant, opérateurs utilisé)
 * Le programme envoie une suite de calcul et renvoi le score de l'utilisateur
 * à la fin de la session
 *
 * @author Tom JAMMES, Tony LAPEYRE, Thomas LEMAIRE, Thomas IZARD
 * @version 1.0
 */

public class DemandeInterval {

    /**
     * Demande à l'utilisateur de rentrer l'intervalle des opérandes
     * Donne un calcul aléatoire
     * 
     * @param args non utilisé
     */

    public static void main(String[] args) {

        boolean testValeur;

        int valeur1,
            valeur2;

        int operandeMin,
            operandeMax;

        final String ERREUR_PAS_ENTIER = """                   
                                                                 ERREUR !        
                                             L'opérande saisie n'est pas un nombre entier
                                         """;
        
        
        Scanner analyseurEntree = new Scanner(System.in);
 

        
        out.println(""" 
                        ------------------- OBJECTIF -------------------
                        |      Vous devez rentrer les bornes d'un      | 
                        | intervalle fermé d'entier [minimum, maximum] | 
                        -----------------------------------------------
                    """);


        /* Demande deux valeurs en s'assurant que c'est bien un int */
        out.print("Entrez une première valeur:");
        testValeur = analyseurEntree.hasNextInt();
        if (testValeur) {
            valeur1 = analyseurEntree.nextInt();
            analyseurEntree.nextLine();
            
            out.print("\nEntrez une deuxième valeur :");
            testValeur = analyseurEntree.hasNextInt();
        }
        if (testValeur) {
            valeur2 = analyseurEntree.nextInt();
            analyseurEntree.nextLine();
            
            /* Créer l'intervalle en fonction de la valeur minimale */
            if (valeur1 < valeur2) {
                operandeMin = valeur1;
                operandeMax = valeur2;
            } else {
                operandeMin = valeur2;
                operandeMax = valeur1;
            }

            out.printf("\nVous avez choisi l'interval I=[%d;%d]\n", operandeMin, operandeMax); 
        } 
        if (!testValeur) {
            out.println(ERREUR_PAS_ENTIER);
        }
    }
}
