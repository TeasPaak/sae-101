/*
 * ChoixIntervale.java                                              21 oct. 2022
 * IUT De Rodez, BUT Info1 2022-2023, pas de copyright ni copyleft
 */

package sae101.malin.interact;

import java.util.Scanner;

/**
 *
 *
 *
 */
public class ChoixIntervales {

   /**
    *
    *
    *
    */
   public static void main(String[] args) {

       int maximumNombre;
       int minimumNombre;

       Scanner analyseurEntree = new Scanner(System.in);

       minimumNombre = valideBorne(analyseurEntree, "minimum");

       maximumNombre = valideBorne(analyseurEntree, "maximum");

       while(minimumNombre >= maximumNombre){
           System.out.print("Votre minimum est plus grand que votre maximum.\n"
                            + "Voulez vous modifier votre minimum ? (y/n) : ");
           if(reponseDonne(analyseurEntree.nextLine())){
               minimumNombre = valideBorne(analyseurEntree, "minimum");
           } else {
               maximumNombre = valideBorne(analyseurEntree, "maximum");
           }
       }

       System.out.print("minimum : " + minimumNombre
                        + " / maximum : " + maximumNombre);
   }

   private static int valideBorne(Scanner analyseurEntree, 
                                  String borne){
       System.out.print(borne + " : ");
       String entreeBorneActive = analyseurEntree.nextLine();

       while(!(entreeBorneActive != null && entreeBorneActive.matches("[0-9]+"))){
           System.out.print("Valeur pas prise en compte veulliez saisir " 
                            + "un entier comme " + borne + " : ");
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
