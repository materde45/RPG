import IU.MenuSeleccion; // Importamos nuestro nuevo menú
import Personajes.BaseDePersonaje;

public class Main{

    public static void main(String[] args) {

        BaseDePersonaje miJugador = MenuSeleccion.iniciarCreacionDePersonaje();

        System.out.println("\n--- RESUMEN DE TU PERSONAJE ---");
        System.out.println("Clase: " + miJugador.getNombre());
        System.out.println("Vida Máxima: " + miJugador.getVida());
        System.out.println("Ataques disponibles: " + miJugador.getListaAtaques().size());

        // El siguiente paso aquí será llamar a Pelear.iniciarCombate(...)
    }
}