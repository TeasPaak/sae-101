/*
 * ChoixIntervales.java                                              21 oct. 2022
 * IUT De Rodez, BUT Info1 2022-2023, pas de copyright ni copyleft
 */


 package sae101.malin.interact;

 import java.util.Scanner;

 public class ChoixIntervales {

    public static void main(String[] args) {

        String reponseQuestion;

        int maximumNombre;
        int minimumNombre;

        Scanner analyseurEntree = new Scanner(System.in);

        minimumNombre = valideBorne(analyseurEntree, "minimum");

        maximumNombre = valideBorne(analyseurEntree, "maximum");

        while(minimumNombre >= maximumNombre){
            System.out.print("Votre minimum est plus grand que votre maximum.\n"
                             + "Voulez vous modifier votre minimum ? (y/n) : ");
            reponseQuestion = analyseurEntree.nextLine();
            if(reponseQuestion.equals("y")){
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

        while(true != valideEntier(entreeBorneActive)){
            System.out.print("Valeur pas prise en compte veulliez saisir " 
                             + "un entier comme " + borne + " : ");
            entreeBorneActive = analyseurEntree.nextLine();
        }
        return Integer.parseInt(entreeBorneActive);
    }

    private static boolean valideEntier(String str){
        return str != null && str.matches("[0-9]+");
    }
 }
