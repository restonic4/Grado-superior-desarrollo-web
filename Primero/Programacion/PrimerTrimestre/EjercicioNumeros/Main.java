package Primero.Programacion.PrimerTrimestre.EjercicioNumeros;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String[] simpleNumberNames = new String[] {
            "Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve"
    };

    private static final String[] complexNumberPrefixNames = new String[] {
            "Dieci", "Veinti", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"
    };

    private static final Map<Integer, String> specialCases = new HashMap<>();
    static {
        specialCases.put(10, "Diez");
        specialCases.put(11, "Once");
        specialCases.put(12, "Doce");
        specialCases.put(13, "Trece");
        specialCases.put(14, "Catorce");
        specialCases.put(15, "Quince");
        specialCases.put(20, "Veinte");
    }

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        System.out.print("Introduce un numero del 0 al 99: ");
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            if (number < 0 || number > 99) {
                throw new IndexOutOfBoundsException();
            }
            System.out.println("El número es: " + getFormattedNumber(number));
        }
        catch (NumberFormatException exception) {
            handleError("Eso no es un numero valido. Debe ser un numero entero.");
        }
        catch (IndexOutOfBoundsException exception) {
            handleError("Eso no es un numero valido. Te has salido de los limites permitidos.");
        }
    }

    private static String getFormattedNumber(int number) {
        if (number < 10) {
            return getSimpleNumberName(number);
        }

        if (specialCases.containsKey(number)) {
            return specialCases.get(number);
        }

        int tens = number / 10;
        int ones = number % 10;

        String prefix = complexNumberPrefixNames[tens - 1];

        if (number < 30) {
            return prefix + (ones > 0 ? simpleNumberNames[ones].toLowerCase() : "");
        } else {
            return prefix + (ones > 0 ? " y " + simpleNumberNames[ones] : "");
        }
    }

    private static String getSimpleNumberName(int number) {
        return simpleNumberNames[number];
    }

    private static void handleError(String message) {
        System.out.println(message);
        System.out.println("Pulsa enter para reiniciar.");

        waitForEnter();
        run();
    }

    private static void waitForEnter() {
        scanner.nextLine();
    }
}
