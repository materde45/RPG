package Personajes;

public class Mago extends BaseDePersonaje {


    public Mago(){
        super("Mago",100,200,100,50,10,200,0);

    this.aprenderAtaque(new Ataque("Bola de Fuego", 60, "Magico",50,0));
    this.aprenderAtaque(new Ataque("Rayo de Escarcha", 45, "Magico",50,0));

    }
}
