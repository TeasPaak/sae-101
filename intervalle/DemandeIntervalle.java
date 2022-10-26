/*
 * DemandeIntervalle                                                21 oct 2022
 * IUT de Rodez, Tom JAMMES, pas de copyright ni copyleft
 */

package sae101.intervalle;

import java.util.Scanner;

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
 * @version 2.0
 */

public class DemandeIntervalle {

    /**
     * Demande à l'utilisateur de rentrer l'intervalle 2 opérandes 
     * L'algorithme crée lui même l'interval
     * 
     * @param args non utilisé
     */

    public static void main(String[] args) {

        boolean operandeMin,
                operandeMax;

        String variablePoubelle;

        int valeurOperandeMin,
            valeurOperandeMax;
        
        final String ERREUR_MAX_SUPERIEUR_MIN = """         
                                                           ERREUR !        
                                                L'opérande maximum ne peut pas 
                                                   être inférieur ou égal à
                                                     l'opérande minimum.
                                                """;

        final String ERREUR_NOT_ENTIER = """       
                                                   ERREUR !   
                                         L'opérande saisie n'est pas 
                                               un nombre entier
                                         """;
        
        
        Scanner analyseurEntree = new Scanner(System.in);
 

        
        System.out.println("------------------- OBJECTIF -------------------\n"
                           +"|      Vous devez rentrer les bornes d'un      |\n"
                           +"|           intervalle fermé d'entier          |\n"
                           +"|             [minimum, maximum]               |\n"
                           +"------------------------------------------------");


        /* Demande l'opérande 1 */

        System.out.print("Entrez l'opérande minimum :");
        operandeMin = analyseurEntree.hasNextInt();

        while (!operandeMin) {

            System.out.println(ERREUR_NOT_ENTIER);

            variablePoubelle = analyseurEntree.next() 
                               + analyseurEntree.nextLine();

            System.out.print("\nEntrez l'opérande minimum :");
            operandeMin = analyseurEntree.hasNextInt();
        }
        
        valeurOperandeMin = analyseurEntree.nextInt();

        /* Demande l'opérande 2 */

        System.out.print("\nEntrez l'opérande maximum :");
        operandeMax = analyseurEntree.hasNextInt();

        while (!operandeMax) {

            System.out.println(ERREUR_NOT_ENTIER);

            variablePoubelle = analyseurEntree.next() 
                               + analyseurEntree.nextLine();

            System.out.print("\nEntrez l'opérande maximum :");
            operandeMax = analyseurEntree.hasNextInt();
        }

        valeurOperandeMax = analyseurEntree.nextInt();

        /* Comparaison des deux opérandes */

       //TODO comparer les deux opérandes pour déterminer le plus petit et créer l'intervalle en fonction         
        

        /* Message final */
        
        System.out.println("\nVous avez choisi l'interval I=[" 
                           + valeurOperandeMin + "," 
                           + valeurOperandeMax + "]");
     }
 }
