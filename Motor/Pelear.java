package Motor;

import Personajes.BaseDePersonaje;
import java.util.Scanner;
import java.util.Random;

public class Pelear {

    public void encontrarPelea(BaseDePersonaje jugador) {
        Random generador = new Random();
        int numeroDel1Al100 = generador.nextInt(100) + 1;

        if (numeroDel1Al100 <= 30) {
            BaseDePersonaje enemigo = GeneradorEnemigos.generarEnemigoAleatorio();
            System.out.println("\n ⚠️ ¡Cuidado, " + jugador.getNombre() + "! Un " + enemigo.getNombre() + " salvaje ha aparecido.");

            iniciarCombate(jugador, enemigo);
        } else {
            System.out.println("\n El camino está despejado. Continúas tu aventura sin problemas.");
        }
    }

    private void iniciarCombate(BaseDePersonaje jugador, BaseDePersonaje enemigo) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("        ¡INICIA EL COMBATE!        ");
        System.out.println("===================================");

        while (jugador.getVida() > 0 && enemigo.getVida() > 0) {

            // --- 1. TURNO DEL JUGADOR ---
            boolean turnoJugadorCompletado = false; // Controla si ya gastamos el turno

            while (!turnoJugadorCompletado) {
                System.out.println("\n--- TU TURNO ---");
                System.out.println("Tu Vida: " + jugador.getVida() + " | Maná: " + jugador.getMana() + " | Energía: " + jugador.getEnergia());
                System.out.println("Vida del " + enemigo.getNombre() + ": " + enemigo.getVida());
                System.out.println("\n¿Qué deseas hacer?");
                System.out.println("1. Atacar");
                System.out.println("2. Abrir Mochila");

                System.out.print("Elige una opción: ");
                int opcion = teclado.nextInt();

                if (opcion == 1) {
                    System.out.println("\nTus ataques:");
                    for (int i = 0; i < jugador.getListaAtaques().size(); i++) {
                        System.out.println((i + 1) + ". " + jugador.getListaAtaques().get(i).getNombre() +
                                " (Maná: " + jugador.getListaAtaques().get(i).getGastoMana() +
                                ", Energía: " + jugador.getListaAtaques().get(i).getGastoEnergia() + ")");
                    }
                    System.out.print("Elige tu ataque: ");
                    int indiceAtaque = teclado.nextInt() - 1;

                    jugador.usarAtaque(indiceAtaque, enemigo);
                    turnoJugadorCompletado = true; // ¡El ataque gasta el turno!

                } else if (opcion == 2) {
                    System.out.println("\n--- MOCHILA ---");
                    if (jugador.getInventario().isEmpty()) {
                        System.out.println("¡Tu mochila está vacía! Cierras la bolsa rápidamente para pensar en otra cosa.");
                        // NO ponemos turnoJugadorCompletado = true; por lo que el menú vuelve a aparecer
                    } else {
                        for (int i = 0; i < jugador.getInventario().size(); i++) {
                            System.out.println((i + 1) + ". " + jugador.getInventario().get(i).getNombre());
                        }

                        // Añadimos una opción extra para cancelar y volver atrás
                        int opcionCancelar = jugador.getInventario().size() + 1;
                        System.out.println(opcionCancelar + ". Cancelar y volver");

                        System.out.print("Elige la poción a usar: ");
                        int indicePocion = teclado.nextInt() - 1;

                        if (indicePocion == opcionCancelar - 1) {
                            System.out.println("Cierras la mochila.");
                            // NO gasta el turno, el bucle se repite
                        } else {
                            jugador.usarPocion(indicePocion);
                            turnoJugadorCompletado = true; // ¡Beber la poción SÍ gasta el turno!
                        }
                    }
                } else {
                    System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } // Fin del while del turno del jugador

            if (enemigo.getVida() <= 0) {
                System.out.println("\n🏆 ¡Has derrotado al " + enemigo.getNombre() + "!");
                break;
            }

            // --- 2. TURNO DEL ENEMIGO ---
            System.out.println("\n--- TURNO DEL ENEMIGO ---");

            Random IA = new Random();
            int ataqueEnemigo = IA.nextInt(enemigo.getListaAtaques().size());

            enemigo.usarAtaque(ataqueEnemigo, jugador);

            if (jugador.getVida() <= 0) {
                System.out.println("\n💀 Has caído en batalla... FIN DEL JUEGO.");
                break;
            }
        }
    }
}