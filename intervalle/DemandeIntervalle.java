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
     * Demande à l'utilisateur de rentrer l'intervalle des opérandes
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


        /* Demande l'opérande Min */

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

        /* Demande l'opérande Max */

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

        
        /* Verifie Max > Min */

        while (valeurOperandeMax <= valeurOperandeMin) {
            
            String reponse;

            System.out.println("\n" + ERREUR_MAX_SUPERIEUR_MIN);

            System.out.print("Voulez vous ressaisir l'opérande minimum ? (y/n) : ");
            reponse = analyseurEntree.next();

            if (reponse.equals("y")) {
                /* Redemande l'opérande Min */
                
                System.out.print("\nEntrez l'opérande minimum :");
                operandeMin = analyseurEntree.hasNextInt();
                
                while (!operandeMin) {

                    System.out.println(ERREUR_NOT_ENTIER);

                    variablePoubelle = analyseurEntree.next() 
                                + analyseurEntree.nextLine();

                    System.out.print("\nEntrez l'opérande minimum :");
                    operandeMin = analyseurEntree.hasNextInt();
                }

                valeurOperandeMin = analyseurEntree.nextInt();

                /* Redemande l'opérande Max */

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

            }
            else {
                /* Redemande l'opérande Max */

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
            }            
        }

        /* Message final */
        
        System.out.println("\nVous avez choisi l'interval I=[" 
                           + valeurOperandeMin + "," 
                           + valeurOperandeMax + "]");
     }
 }
