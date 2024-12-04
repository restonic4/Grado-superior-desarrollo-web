package Primero.Programacion.PrimerTrimestre.Tarea.Trabajo1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * This project has been coded using Java 17 and IntelliJ
 * @author restonic4 (Marcos)
 */
@SuppressWarnings("SpellCheckingInspection")
public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce el texto a analizar: ");
        String text = sanitize(scanner.nextLine());

        String[] textParts = text.split(" ");
        List<String> words = Arrays.asList(textParts);

        /*
        Comparator.comparingInt(String::length).reversed() is used to tell the sort system what and how to sort the array.

        String::length tells what to sort, in this case the length of the Strings. :: is used to call a method.

        Comparator.comparingInt will give of -1 if the first String is lower that the seconds String, 1 the other way around,
        and 0 if both are equal.

        .reversed() does what it says.
         */
        words.sort(Comparator.comparingInt(String::length).reversed());

        System.out.println("Las tres palabras mas largas son:");
        for (int i = 0; i < Math.min(3, words.size()); i++) {
            System.out.println(words.get(i) + " (" + words.get(i).length() + ")");
        }
    }

    /**
     * Sanitizes the input, removing some characters using a regex.
     * @param text Input text.
     * @return Sanitized text.
     * @author restonic4 (Marcos)
     */
    public static String sanitize(String text) {
        /*
        We use a regex to only allow some characters.

        The ^ operator negates the regex, now it's reversed.

        It checks for characters from a to z, then A to Z and then 0 to 9. So now we have all characters and numbers,
        except the ñ, so we add it next.

        The last part \\s allows white-spaces and tabulations.
         */
        return text.replaceAll("[^a-zA-Z0-9ñ\\s]", "");
    }
}
