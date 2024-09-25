package Primero.Programacion.PrimerTrimestre.Ejercicio1;

public class Main {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int year = 2024;

        // Usando el condicional tipo ? (Siempre se me olvida como se llama)
        System.out.println(
                (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ?
                        (year + " es bisiesto.") : (year + " no es bisiesto.")
        );

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
}
