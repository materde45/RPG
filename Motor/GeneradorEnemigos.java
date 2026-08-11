package Motor;

import Personajes.BaseDePersonaje;
import Personajes.Goblin;
import Personajes.Guerrero;
import Personajes.Mago;
import Personajes.Orco;
import java.util.ArrayList; // Importante importar esto
import java.util.List;      // Importante importar esto

public class GeneradorEnemigos {

    public static BaseDePersonaje generarEnemigoAleatorio() {
        double probabilidad = Math.random();

        if (probabilidad < 0.40) {
            return new Goblin();
        } else if (probabilidad < 0.70) {
            return new Guerrero();
        } else if (probabilidad < 0.90) {
            return new Mago();
        } else {
            return new Orco();
        }
    }


    public static List<BaseDePersonaje> generarGrupoEnemigos(int cantidad) {


        List<BaseDePersonaje> grupoDeEnemigos = new ArrayList<>();


        for (int i = 0; i < cantidad; i++) {

            grupoDeEnemigos.add(generarEnemigoAleatorio());
        }

        return grupoDeEnemigos;
    }
}