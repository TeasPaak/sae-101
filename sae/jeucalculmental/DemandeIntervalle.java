/*
 * DemandeIntervalle.java                21 oct 2022
 * INFO1 2021-2022, pas de copyright ni droits d'auteurs
 */

package info1.sae.jeucalculmental;

import java.util.Scanner;
/**
 * Demande les bornes minimum et maximum d'un intervalle fermé d'entiers 
 * sur la console texte
 * @author Tony Lapeyre
 */

public class DemandeIntervalle {
    /**
     * <p>
     * Le programme doit:
     * <ul><li>Présenter l'objectif sur la console texte; </li>
     *     <li>Demander la borne minimum de l'intervalle sur la console texte</li>
     *     <li>Demander la borne maximum de l'intervalle sur la console texte</li>
     *     <li>Gérer les erreurs de saisie, assurer que le maximum 
     *         est supérieur au minimum...</li>
     * </p>
     * @param args non utilisés
     * @version 0.1
     */
    
    public static void main(String[] args) {

        int intervalleMin,
            intervalleMax;

        boolean operandeMin,
                operandeMax;

        String varBin;
        Scanner analyseurEntree = new Scanner(System.in);

        System.out.println("Bonjour et bienvenue sur le logiciel de calcul mental!");

        System.out.print("\nVeuillez entrer l'intervalle minimum: ");
        operandeMin = analyseurEntree.hasNextInt();

        /* Vérification de l'opérande minimum */
        while (!operandeMin) {
            
            varBin = analyseurEntree.next() + analyseurEntree.nextLine();
            System.out.print("Nombre demandé. Veuillez retaper l'opérande minimum: ");
            operandeMin = analyseurEntree.hasNextInt();

        }
        intervalleMin = analyseurEntree.nextInt();

        System.out.print("Veuillez entrer l'intervalle maximum: ");
        operandeMax = analyseurEntree.hasNextInt();

        /* Vérification de l'opérande maximum */
        while (!operandeMax) {
            
            varBin = analyseurEntree.next() + analyseurEntree.nextLine();
            System.out.print("Nombre demandé. Veuillez retaper l'opérande maximum: ");
            operandeMax = analyseurEntree.hasNextInt();

        }
        intervalleMax = analyseurEntree.nextInt();

        /* Vérification de la supériorité de l'intervalle maximum par rapport à l'intervalle minimum */
        while (intervalleMax <= intervalleMin) {

            System.out.println("\nATTENTION !!\nL'intervalle d'entiers entré est "
                               + "invalide. Veuillez réessayer.");
        
             System.out.print("Veuillez entrer l'intervalle minimum: ");
            intervalleMin = analyseurEntree.nextInt();
            analyseurEntree.nextLine();
            
             System.out.print("Veuillez entrer l'intervalle maximum: ");
            intervalleMax = analyseurEntree.nextInt();
            analyseurEntree.nextLine();

        }
        
        System.out.printf("\nLes chiffres utilisés sont compris dans l'intervalle "
                          + "[%d,%d]",intervalleMin, intervalleMax);
    }
}
