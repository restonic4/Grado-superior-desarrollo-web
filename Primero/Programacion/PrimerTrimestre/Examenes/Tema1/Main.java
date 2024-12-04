package Primero.Programacion.PrimerTrimestre.Examenes.Tema1;

import java.util.Scanner;

/**
 * Examen del tema 1
 * Se ha usado java 17 y Intellij
 * @author restonic4 (Marcos Ruiz Lerma)
 */

/*
    SuppressWarnings es una anotacion que viene del package de java. Cada IDE interpreta esta anotacion de forma
    diferente, por lo que el tipo SpellCheckingInspection puede que no funcione en todos los IDE.
 */
@SuppressWarnings("SpellCheckingInspection")
public class Main {
    // Constantes
    public static final String END_KEYWORD = "fin";
    public static final long REQUIRED_PEOPLE = 15000000;

    // Scanner accesible en toda la clase por si es necesario en otro metodo. (Aunque de momento solo usamos main)
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Las variables han sido inicializadas con 0, Strings vacios o numeros limite (Float.MAX_VALUE)

        int biggerStates = 0;
        long totalVotesVerdes = 0;

        String republicanoVSdemocrataState = "";
        long republicanoVSdemocrataDifference = 0;

        float lowestVotePercentage = Float.MAX_VALUE;
        String lowestVotePercentageState = "";

        int statesMostlyDemocratas = 0;

        long firstBiggestState = 0, secondBiggestState = 0, thirdBiggestState = 0;
        String firstBiggestStateName = "", secondBiggestStateName = "", thirdBiggestStateName = "";

        System.out.print("Introduzca el nombre del estado o 'fin' para terminar: ");
        String state = scanner.nextLine();

        while (!state.equals(END_KEYWORD)) {
            long totalStateVotes = 0;

            System.out.print("Introduzca el numero de habitantes: ");
            long people = Long.parseLong(scanner.nextLine());

            System.out.print("Introduzca el numero de votos para Demócratas: ");
            long votesDemocratas = Long.parseLong(scanner.nextLine());

            System.out.print("Introduzca el numero de votos para Republicanos: ");
            long votesRepublicanos = Long.parseLong(scanner.nextLine());

            if (votesRepublicanos > votesDemocratas) {
                long difference = votesRepublicanos - votesDemocratas;

                if (difference > republicanoVSdemocrataDifference) {
                    republicanoVSdemocrataDifference = difference;
                    republicanoVSdemocrataState = state;
                }
            }

            totalStateVotes += votesDemocratas;
            totalStateVotes += votesRepublicanos;

            if (people > REQUIRED_PEOPLE) {
                System.out.print("Introduzca el numero de votos para Libertarios: ");
                long votesLibertarios= Long.parseLong(scanner.nextLine());

                System.out.print("Introduzca el numero de votos para Verdes: ");
                long votesVerdes = Long.parseLong(scanner.nextLine());

                biggerStates++;
                totalVotesVerdes += votesVerdes;

                totalStateVotes += votesLibertarios;
                totalStateVotes += votesVerdes;
            }

            // Calculos adicionales

            float votePercentage = ((float) totalStateVotes / people) * 100;

            if (votePercentage < lowestVotePercentage) {
                lowestVotePercentage = votePercentage;
                lowestVotePercentageState = state;
            }

            if (votesDemocratas >= totalStateVotes / 2) {
                statesMostlyDemocratas++;
            }

            /*
                Comparacion de estados con mayor cantidad de habitantes.
                Se comprueba y luego, si se cambia por ejemplo el state qua va primero,
                ebtonces se "mueve" hacia abajo, modificando el segundo y tercero.
             */

            if (people > firstBiggestState) {
                thirdBiggestState = secondBiggestState;
                thirdBiggestStateName = secondBiggestStateName;

                secondBiggestState = firstBiggestState;
                secondBiggestStateName = firstBiggestStateName;

                firstBiggestState = people;
                firstBiggestStateName = state;
            } else if (people > secondBiggestState) {
                thirdBiggestState = secondBiggestState;
                thirdBiggestStateName = secondBiggestStateName;

                secondBiggestState = people;
                secondBiggestStateName = state;
            } else if (people > thirdBiggestState) {
                thirdBiggestState = people;
                thirdBiggestStateName = state;
            }

            System.out.print("Introduzca el nombre del estado o 'fin' para terminar: ");
            state = scanner.nextLine();
        }

        // Se muestran los datos

        System.out.println("El promedio de votos Verdes es: " + totalVotesVerdes / biggerStates);
        System.out.println("Estado donde el Republicano ha sacado más votos de diferencia sobre el Demócrata: " + republicanoVSdemocrataState + " con " + republicanoVSdemocrataDifference + " votos de diferencia.");
        System.out.println("Estado con menor participación: " + lowestVotePercentageState + " con un " + lowestVotePercentage + "% de participacion.");
        System.out.println("Número de estados donde los Demócratas suponen más del 50% de votos: " + statesMostlyDemocratas);
        System.out.println(" Los tres estados con más habitantes son: " + firstBiggestStateName + ", " + secondBiggestStateName + " y " + thirdBiggestStateName);
    }
}
