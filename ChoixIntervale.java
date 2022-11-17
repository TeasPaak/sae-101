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
 * @version 2.2
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

        String variablePoubelle;

        int valeur1,
            valeur2;

        int operandeMin,
            operandeMax;

        int reponseJustes = 0,
            reponseFausses = 0;
        
        String reponseUtilisateur;
        final String OUI = "y";

        final String ERREUR_NOT_ENTIER = """                   
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

            out.println(ERREUR_NOT_ENTIER);

            variablePoubelle = analyseurEntree.next() 
                               + analyseurEntree.nextLine();

            out.print("\nEntrez une valeur :");
            testValeur1 = analyseurEntree.hasNextInt();
        }
        
        valeur1 = analyseurEntree.nextInt();
        analyseurEntree.nextLine();

        /* Demande la demauxième valeur en s'assurant que c'est bien un int */

        out.print("\nEntrez une deuxième valeur :");
        testValeur2 = analyseurEntree.hasNextInt();

        while (!testValeur2) {

            out.println(ERREUR_NOT_ENTIER);

            variablePoubelle = analyseurEntree.next() 
                               + analyseurEntree.nextLine();

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
        
        
        out.print("L'intervalle vous correspont-il ? (y/n) : ");
        reponseUtilisateur = analyseurEntree.next();
        if (!reponseUtilisateur.equals(OUI)) {
            System.exit(1);
        }

        /* Calculs aléatoirs */

        out.println("""
                       ------------------- OBJECTIF -------------------
                       |           Donnez les résultat des            |
                       |               calculs suivants               |
                       ------------------------------------------------
                    """);    

        out.print("\nVoulez-vous continuer ? (y/n) : ");
        reponseUtilisateur = analyseurEntree.next() + analyseurEntree.nextLine();
       
        while (reponseUtilisateur.equals(OUI)) {
            int operateurAleatoire,
                entierAleatoire1,
                entierAleatoire2,
                resultatJoueur;

            final int [] OPERATEURS = {1,2,3,4};

            operateurAleatoire = 1 + ((int)(Math.random()*1.0E09)) % 4;

            /* Si l'opérateur aléatoire est "+" */
            if (operateurAleatoire == 1) {
                entierAleatoire1 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                entierAleatoire2 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                
                out.printf("%d + %d = ", entierAleatoire1, entierAleatoire2);
                resultatJoueur = analyseurEntree.nextInt();

                if (resultatJoueur == (entierAleatoire1 + entierAleatoire2)) {
                    out.println("Bien joué !");
                    reponseJustes ++;
                }
                else {
                    out.println("C'est FAUX !");
                    reponseFausses ++;
                }
                out.print("\nVoulez-vous continuer ? (y/n) : ");
                reponseUtilisateur = analyseurEntree.next() + analyseurEntree.nextLine();
            }
            else if (operateurAleatoire == 2) {
                entierAleatoire1 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                entierAleatoire2 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                
                out.printf("%d - %d = ", entierAleatoire1, entierAleatoire2);
                resultatJoueur = analyseurEntree.nextInt();

                if (resultatJoueur == (entierAleatoire1 - entierAleatoire2)) {
                    out.println("Bien joué !");
                    reponseJustes ++;
                }
                else {
                    out.println("C'est FAUX !");
                    reponseFausses ++;
                }
                out.print("\nVoulez-vous continuer ? (y/n) : ");
                reponseUtilisateur = analyseurEntree.next() + analyseurEntree.nextLine();
            }
            else if (operateurAleatoire == 3) {
                entierAleatoire1 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                entierAleatoire2 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                
                out.printf("%d * %d = ", entierAleatoire1, entierAleatoire2);
                resultatJoueur = analyseurEntree.nextInt();

                if (resultatJoueur == (entierAleatoire1 * entierAleatoire2)) {
                    out.println("Bien joué !");
                    reponseJustes ++;
                }
                else {
                    out.println("C'est FAUX !");
                    reponseFausses ++;
                }
                out.print("\nVoulez-vous continuer ? (y/n) : ");
                reponseUtilisateur = analyseurEntree.next() + analyseurEntree.nextLine();
            }
            else if (operateurAleatoire == 4) {
                if (operandeMin != 0) {
                    entierAleatoire1 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                    entierAleatoire2 = operandeMin + ((int)(Math.random()*1.0E09))%(operandeMax-operandeMin+1);
                
                    out.printf("%d / %d = ", entierAleatoire1, entierAleatoire2);
                    resultatJoueur = analyseurEntree.nextInt();

                    if (resultatJoueur == (entierAleatoire1 / entierAleatoire2)) {
                        out.println("Bien joué !");
                        reponseJustes ++;
                    }
                    else {
                        out.println("C'est FAUX !");
                        reponseFausses ++;
                    }
                    out.print("\nVoulez-vous continuer ? (y/n) : ");
                    reponseUtilisateur = analyseurEntree.next() + analyseurEntree.nextLine();
                }
            }
        }
        out.printf("""
                       --------------------- SCORE -------------------
                       | Réponses justes  : %d                        |
                       | Réponses fausses : %d                        |
                       -----------------------------------------------\n
                    """, reponseJustes, reponseFausses);
    }
}
