package Personajes;

public class Guerrero extends BaseDePersonaje{
    public Guerrero(){
        super("Guerrero",100,100,200,0,70,0,200);

        this.aprenderAtaque(new Ataque("Corte Feroz", 80, "Fisico",0,50));
        this.aprenderAtaque(new Ataque("Golpe de Escudo", 30, "Fisico",0,50));
    }


}
