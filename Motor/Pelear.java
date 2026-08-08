package Motor;

import Personajes.BaseDePersonaje;
import Personajes.Guerrero;
import Personajes.Mago;

import java.util.Random;

public class Pelear {

    public void encontrarPelea(BaseDePersonaje Enemigo, BaseDePersonaje p1){

        Random generador = new Random();

        int numeroDel1Al100 = generador.nextInt(100) + 1;

        if( numeroDel1Al100 <= 30){

        }
    }

}
