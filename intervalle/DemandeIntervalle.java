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

        boolean operande1,
                operande2;

        String variablePoubelle;

        int valeurOperande1,
            valeurOperande2;
        
        int operandeMin,
            operandeMax;
        
        String reponseUtilisateur;
        
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
        operande1 = analyseurEntree.hasNextInt();

        while (!operande1) {

            System.out.println(ERREUR_NOT_ENTIER);

            variablePoubelle = analyseurEntree.next() 
                               + analyseurEntree.nextLine();

            System.out.print("\nEntrez l'opérande minimum :");
            operande1 = analyseurEntree.hasNextInt();
        }
        
        valeurOperande1 = analyseurEntree.nextInt();

        /* Demande l'opérande 2 */

        System.out.print("\nEntrez l'opérande maximum :");
        operande2 = analyseurEntree.hasNextInt();

        while (!operande2) {

            System.out.println(ERREUR_NOT_ENTIER);

            variablePoubelle = analyseurEntree.next() 
                               + analyseurEntree.nextLine();

            System.out.print("\nEntrez l'opérande maximum :");
            operande2 = analyseurEntree.hasNextInt();
        }

        valeurOperande2 = analyseurEntree.nextInt();


        if (valeurOperande1 <= valeurOperande2) {
            operandeMin = valeurOperande1
            operandeMax = valeurOperande2
        }
        else {
            operandeMin = valeurOperande2
            operandeMax = valeurOperande1
        }

        System.out.print("L'interval [" + operandeMin + "," + operandeMax + "]" 
                         + " est-t-il celui souhaité ? (y/n) : ")
        
        reponseUtilisateur = analyseurEntree.nextLine();

        if (reponseUtilisateur == "y" | reponseUtilisateur == "yes") {
            System.out.println("\nVous avez choisi l'interval I=[" 
                               + operandeMin + "," 
                               + operandeMax + "]");

        // TODO recommencer le programme si l'utilisateur répond non 

        }
     }
 }
