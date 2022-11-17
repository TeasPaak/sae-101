/*
 * ChoixIntervale.java                                              21 oct. 2022
 * IUT De Rodez, BUT Info1 2022-2023, pas de copyright ni copyleft
 */

package iut.info1.sae101;

import java.util.Scanner;
import static java.lang.System.out;

/**
 *Premiere SAE programmation
 *
 * Concevoir un logiciel d'entrainement au calcul mental
 * Le programme demander à l'utilisateur de rentrer des paramètres
 * (interval opérant, opérateurs utilisé)
 * Le programme envoie une suite de calcul et renvoi le score de l'utilisateur
 * à la fin de la session
 *
 * @author Thomas Lemaire
 * @version 1.0
 */
public class ChoixIntervale {

    /**
     *
     * Demande à l'utilisateur de rentrer l'intervalle des opérandes
     * en vérifiant que les valeures rentré sont bien des entiers 
     * et que l'opérande minimum est bien inférieur à l'opérande maximum
     * 
     * @param args non utilisé
     */
    public static void main(String[] args) {

        int maximumNombre;
        int minimumNombre;

        String reponseUtilisateur;

        int reponseJustes = 0;
        int reponseFausses = 0;

        Scanner analyseurEntree = new Scanner(System.in);

        System.out.println(""" 
                                ------------------- OBJECTIF -------------------
                                |      Vous devez rentrer les bornes d'un      | 
                                | intervalle fermé d'entier [minimum, maximum] | 
                                ------------------------------------------------
                           """);

        minimumNombre = valideBorne(analyseurEntree, "minimum");

        maximumNombre = valideBorne(analyseurEntree, "maximum");

        while(minimumNombre >= maximumNombre) {
            System.out.print("  ERREUR ! Votre minimum est plus grand que votre maximum.\n"
                             + "Voulez vous modifier votre minimum ? (y/n) : ");
            if(reponseDonne(analyseurEntree.nextLine())) {
                minimumNombre = valideBorne(analyseurEntree, "minimum");
            } else {
                maximumNombre = valideBorne(analyseurEntree, "maximum");
            }
        }

        out.printf("\nInterval choisi [%d;%d] \n",minimumNombre, maximumNombre);

        out.println("""
                       ------------------- OBJECTIF -------------------
                       |           Donnez les résultat des            |
                       |               calculs suivants               |
                       ------------------------------------------------
                    """);    

        out.print("\nVoulez-vous continuer ? (y/n) : ");
        reponseUtilisateur = analyseurEntree.next() + analyseurEntree.nextLine();
       
        while (reponseDonne(reponseUtilisateur)) {
            int operateurAleatoire,
                entierAleatoire1,
                entierAleatoire2,
                resultatJoueur;

            final int [] OPERATEURS = {1,2,3,4};

            operateurAleatoire = 1 + ((int)(Math.random()*1.0E09)) % 4;

            /* Si l'opérateur aléatoire est "+" */
            if (operateurAleatoire == 1) {
                entierAleatoire1 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                entierAleatoire2 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                
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
            }
            else if (operateurAleatoire == 2) {
                entierAleatoire1 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                entierAleatoire2 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                
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
            }
            else if (operateurAleatoire == 3) {
                entierAleatoire1 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                entierAleatoire2 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                
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
            }
            else if (operateurAleatoire == 4) {
                entierAleatoire1 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                entierAleatoire2 = minimumNombre + ((int)(Math.random()*1.0E09))%(maximumNombre-minimumNombre+1);
                
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
            }
            out.print("\nVoulez-vous continuer ? (y/n) : ");
            reponseUtilisateur = analyseurEntree.next() + analyseurEntree.nextLine();
        }
        out.printf("""
                       --------------------- SCORE -------------------
                       | Réponses justes  : %d                       |
                       | Réponses fausses : %d                        |
                       -----------------------------------------------\n
                    """, reponseJustes, reponseFausses);
    }

    private static int valideBorne(Scanner analyseurEntree, 
                                   String borne) {
        System.out.print("Entrez la borne " + borne + " : ");
        String entreeBorneActive = analyseurEntree.nextLine();

        while(!(entreeBorneActive != null && entreeBorneActive.matches("[0-9]+"))) {
            System.out.print("  ERREUR ! Valeur non prise en compte veulliez saisir " 
                             + "un entier positif comme " + borne + " : ");
            entreeBorneActive = analyseurEntree.nextLine();
        }
        return Integer.parseInt(entreeBorneActive);
    }

    private static boolean reponseDonne(String res) {
        final String [] LISTE_REPONSES = {"YES","Yes","yes", "Y", "y",
                                          "OUI", "Oui", "oui", "O", "o"};

        for(int i = 0; i < LISTE_REPONSES.length; i++) {
            if(LISTE_REPONSES[i].equals(res)) {
               return true;
            }
        }
        return false;
    }
}