package Primero.Programacion.PrimerTrimestre.EjercicioAEntregar1;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Aqui controlamos que eligas una actividad valida a ejecutar.
     * @param args Argumentos de consola.
     */
    public static void main(String[] args) {
        int activityId;

        // Aqui podria usar \n y usar un solo system.out, pero dependiendo del OS la funcionalidad del \n cambia y hace lo que le da la gana (por experiencia personal)
        System.out.println(".____________________.");
        System.out.println("|                    |");
        System.out.println("|     Actividad 1    |");
        System.out.println("|                    |");
        System.out.println(".____________________.");
        System.out.println("\n");

        System.out.print("Elige que actividad ejecutar (1 a 15): ");
        activityId = Integer.parseInt(scanner.nextLine());

        System.out.println("\n");

        // Esto es horripilante, pero weno, aqui podria usar un for-loop, while loop o mil cosas disintas, pero no quiero complicarlo ya que es un ejercicio basico
        switch (activityId) {
            case 1: act1(); break;
            case 2: act2(); break;
            case 3: act3(); break;
            case 4: act4(); break;
            case 5: act5(); break;
            case 6: act6(); break;
            case 7: act7(); break;
            case 8: act8(); break;
            case 9: act9(); break;
            case 10: act10(); break;
            case 11: act11(); break;
            case 12: act12(); break;
            case 13: act13(); break;
            case 14: act14(); break;
            case 15: act15(); break;
            default: actInv(); break;
        }
    }

    /**
     * Esta funcion se encarga de manejar cuando le indiques un numero de actividad no valido.
     * <br>
     * Se encarga de avisarte y "reiniciar" el programa.
     */
    private static void actInv() {
        System.out.println("Ese numero no es valido, del 1 al 15 pls");
        System.out.println("Pulsa enter para reiniciar");
        scanner.nextLine(); // Hago que pulse enter pero no guardo el dato en ningun lado

        // For-loop clasico para que me ponga 15 saltos de linea para simular un borrado de consola
        for (int i = 0; i < 15; i++) {
            System.out.println("\n");
        }

        main(new String[]{}); // LLamo a main sin argumentos de consola pasando un string array vacio
    }

    private static void act1() {
        int number1, number2;

        System.out.println("Escribe dos numeros para sumarlos: ");
        number1 = Integer.parseInt(scanner.nextLine());
        number2 = Integer.parseInt(scanner.nextLine());

        System.out.println("La suma es: " + (number1 + number2));
    }

    private static void act2() {
        int base, height;

        System.out.print("Escribe la base de un triangulo: ");
        base = Integer.parseInt(scanner.nextLine());

        System.out.print("Escribe la altura de un triangulo: ");
        height = Integer.parseInt(scanner.nextLine());

        System.out.println("El area es: " + ((base * height) / 2));
    }

    private static void act3() {
        // Esto es absolutamente horrible, con un array es un millon de veces mejor
        float mark1, mark2, mark3, mark4;

        System.out.println("Escribe las 4 notas del trimestre: ");
        mark1 = Float.parseFloat(scanner.nextLine());
        mark2 = Float.parseFloat(scanner.nextLine());
        mark3 = Float.parseFloat(scanner.nextLine());
        mark4 = Float.parseFloat(scanner.nextLine());

        System.out.println("La media es: " + ((mark1 + mark2 + mark3 + mark4) / 4));
    }

    private static void act4() {

    }

    private static void act5() {

    }

    private static void act6() {

    }

    private static void act7() {

    }

    private static void act8() {

    }

    private static void act9() {

    }

    private static void act10() {

    }

    private static void act11() {

    }

    private static void act12() {

    }

    private static void act13() {

    }

    private static void act14() {

    }

    private static void act15() {

    }
}
