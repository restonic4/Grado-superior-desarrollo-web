package Primero.Programacion.PrimerTrimestre.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        int year = 2024;

        // Usando el condicional tipo ? (Siempre se me olvida como se llama)
        System.out.println(
                ((year % 4 == 0) && (year % 100 != 0)) ?
                        (year + " es bisiesto.") : (year + " no es bisiesto.")
        );
    }
}
