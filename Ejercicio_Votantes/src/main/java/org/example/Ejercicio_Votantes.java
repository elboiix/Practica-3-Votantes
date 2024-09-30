package org.example;
import java.util.Scanner; //Importo Scanner para que el programa pueda leer cosas.
import java.util.InputMismatchException; //Importo InputMismatchException para el try-catch de después.
public class Ejercicio_Votantes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); //Le pongo al scanner el nombre "entrada"
        String nombre;
        while(true) {
           System.out.print("Introduce tu nombre:"); //Hago un bucle donde el bucle se rompe cuando el nombre lleva letras normales para así bloquear numeros, simbolos etc...
           nombre = entrada.next();
           if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚÑñ]+")) {
               break;
           }
           else {
               System.out.println("Error, introduce correctamente tu nombre porfavor.");
           }
       }
        int edad;
        while (true) {
            System.out.print("Hola " + nombre + ". Introduce tu edad:"); //Hago un try-catch por si el usuario pone algo que no sea un numero el programa detecte el error InputMismatchException y haga lo que yo quiera.
            try {
                edad = entrada.nextInt();
                break;
            }
            catch (InputMismatchException err) {
                System.out.println("Error, introduce correctamente tu edad porfavor.");
                entrada.next();
            }
        }
        while(true) { //Hago otro bucle para que te vuelva a pedir la edad si pones menos de 0 años.
            if (edad > 0) {
                break;
            }
            else {
                System.out.println("Error, introduce correctamente tu edad porfavor.");
                System.out.print("Hola " + nombre + ". Introduce tu edad:");
                entrada.next();
                edad = entrada.nextInt();
            }
        }
        if (edad >= 18) {
            System.out.print("Enhorabuena " + nombre + ". Puedes votar."); //Si tienes 18 o mas puedes votar.
        }
        else {
            System.out.println("Lo siento " + nombre + ". No puedes votar."); //Sino no.
            int edadfaltante = 18 - edad;
            System.out.print("Te faltan " + edadfaltante + " años para ser mayor de edad."); //Años que faltan para votar.
        }

    }

}