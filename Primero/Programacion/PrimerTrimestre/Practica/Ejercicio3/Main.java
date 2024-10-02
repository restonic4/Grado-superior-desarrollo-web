package Primero.Programacion.PrimerTrimestre.Practica.Ejercicio3;

import java.util.Scanner;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;

        System.out.print("Introduza su edad: ");
        age = scanner.nextInt();

        System.out.println("Su edad es: " + age + ", el año que viene tendras " + (age + 1) + " años.");
    }
}
