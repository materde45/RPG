package IU;

import Personajes.BaseDePersonaje;
import Personajes.Guerrero;
import Personajes.Mago;
import java.util.Scanner;

public class MenuSeleccion {

    public static BaseDePersonaje iniciarCreacionDePersonaje() {
        Scanner teclado = new Scanner(System.in);
        BaseDePersonaje personajeElegido = null;
        boolean seleccionValida = false;

        System.out.println("===================================");
        System.out.println("    BIENVENIDO A TU AVENTURA RPG   ");
        System.out.println("===================================");
        System.out.println("Elige tu clase inicial:");
        System.out.println("1. ⚔️ Guerrero (Alta resistencia, daño físico)");
        System.out.println("2. 🧙‍♂️ Mago (Alta magia, daño mágico)");

        while (!seleccionValida) {
            System.out.print("\nIngresa el número de tu clase (1 o 2): ");
            int opcion = teclado.nextInt();

            if (opcion == 1) {
                personajeElegido = new Guerrero();
                seleccionValida = true;
            } else if (opcion == 2) {
                personajeElegido = new Mago();
                seleccionValida = true;
            } else {
                System.out.println(" Opción inválida. Por favor, elige 1 o 2.");
            }
        }

        return personajeElegido;
    }
}
