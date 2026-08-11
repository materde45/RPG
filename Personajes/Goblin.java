package Personajes;

public class Goblin extends BaseDePersonaje{

    public Goblin(){
        super("Goblin",150,70,70,0,70,0,150);

        this.aprenderAtaque(new Ataque("Salto y Regreso", 50, "Fisico",0,25));
        this.aprenderAtaque(new Ataque("Sangrado", 40, "Fisico",0,30));

    }


}
