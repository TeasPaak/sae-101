/*
 * CalculsAleatoires                                            21 oct 2022
 * IUT de Rodez, Tom JAMMES, pas de copyright ni de copyleft
 */

package iut.info1.sae101;

import java.util.Scanner;
import static java.lang.System.out;

/**
 * Premiere SAE programmation
 *
 * Concevoir un logiciel d'entrainement au calcul mental
 * Le programme demander à l'utilisateur de rentrer des paramètres
 * (interval opérant, opérateurs utilisé)
 * Le programme envoie une suite de calcul et renvoi le score de l'utilisateur
 * à la fin de la session
 *
 * @author Tom Jammes
 * @version 1.0
 */

public class CalculsAleatoires {

    /**
     * Demande à l'utilisateur de rentrer l'intervalle des opérandes
     * Donne un calcul aléatoire
     * 
     * @param args non utilisé
     */

    public static void main(String[] args) {

        boolean testValeur1,
                testValeur2;

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


        /* Demande la première valeur en s'assurant que c'est bien un int */

        out.print("Entrez une valeur:");
        testValeur1 = analyseurEntree.hasNextInt();

        while (!testValeur1) {

            out.println(ERREUR_PAS_ENTIER);
            analyseurEntree.nextLine();

            out.print("\nEntrez une valeur :");
            testValeur1 = analyseurEntree.hasNextInt();
        }
        
        valeur1 = analyseurEntree.nextInt();
        analyseurEntree.nextLine();

        /* Demande la demauxième valeur en s'assurant que c'est bien un int */

        out.print("\nEntrez une deuxième valeur :");
        testValeur2 = analyseurEntree.hasNextInt();

        while (!testValeur2) {

            out.println(ERREUR_PAS_ENTIER);
            analyseurEntree.nextLine();

            out.print("\nEntrez la deuxième valeur :");
            testValeur2 = analyseurEntree.hasNextInt();
        }

        valeur2 = analyseurEntree.nextInt();
        analyseurEntree.nextLine();

        /* Créer l'intervalle en fonction de la valeur minimale */

        if (valeur1 < valeur2) {
            operandeMin = valeur1;
            operandeMax = valeur2;
        }
        else {
            operandeMin = valeur2;
            operandeMax = valeur1;
        }

        out.println("\nVous avez choisi l'interval I=[" 
                           + operandeMin + "," 
                           + operandeMax + "]");
        }
    }
}
