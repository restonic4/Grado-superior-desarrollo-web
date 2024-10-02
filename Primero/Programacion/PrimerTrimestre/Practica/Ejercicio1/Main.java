package Primero.Programacion.PrimerTrimestre.Practica.Ejercicio1;

import java.util.Scanner;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        bisiesto();
        mayorDeEdad();
        parsers();
        promts();
    }

    public static void bisiesto() {
        int year = 2024;

        // Usando el condicional tipo ? (Siempre se me olvida como se llama)
        System.out.println(
                (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ?
                        (year + " es bisiesto.") : (year + " no es bisiesto.")
        );
    }

    public static void mayorDeEdad() {
        /*
            Se podria mejorar usando el Date de java, arrays o creando una clase custom que tenga como
            constructor el dia, mes y año.
        */
        int currentDay = 24;
        int currentMonth = 9;
        int currentYear = 2024;

        int birthdayDay = 24;
        int birthdayMonth = 9;
        int birthdayYear = 2006;

        System.out.println(
                (currentDay == birthdayDay && currentMonth == birthdayMonth && currentYear > birthdayYear) ?
                        "Feliz cumple" : "No es tu cumple"
        );

        System.out.println(
                (
                        (currentYear - birthdayYear > 18) ||
                                (currentYear - birthdayYear == 18 && currentMonth > birthdayMonth) ||
                                (currentYear - birthdayYear == 18 && currentMonth == birthdayMonth && currentDay >= birthdayDay)
                ) ?
                        "Soy mayor de edad" : "Tas chikito"
        );
    }

    public static void parsers() {
        String text = "749";

        int numInt = Integer.parseInt(text) + 1;
        long numLong = Long.parseLong(text) + 2;
        short numShort = (short) (Short.parseShort(text) + 3);

        System.out.println("Integer: " + numInt);
        System.out.println("Long: " + numLong);
        System.out.println("Short: " + numShort);
    }

    public static void promts() {
        Scanner scanner = new Scanner(System.in);
        String nombre, apellido;

        System.out.println("Nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        apellido = scanner.nextLine();
    }
}
