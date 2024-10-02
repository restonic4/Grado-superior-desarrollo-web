package Primero.Programacion.PrimerTrimestre.Practica.Ejercicio4;

import java.util.Scanner;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;

        System.out.print("Introduce tu edad: ");
        age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("Mayor de edad");
            return;
        }

        System.out.println("Tas chikito");
    }
}
