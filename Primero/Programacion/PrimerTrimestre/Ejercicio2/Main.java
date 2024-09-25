package Primero.Programacion.PrimerTrimestre.Ejercicio2;

import java.util.Scanner;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre, primerApellido, segundoApellido;

        System.out.print("Introduzca su nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Introduzca su primer apellido: ");
        primerApellido = scanner.nextLine();

        System.out.print("Introduzca su segundo apellido: ");
        segundoApellido = scanner.nextLine();

        System.out.println("Sus nombre completo es: " + nombre + " " + primerApellido + " " + segundoApellido);
    }
}
