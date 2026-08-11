package Personajes;

public class Orco extends BaseDePersonaje {

    public Orco(){
        super("Orco",500,100,150,20,60,200,200);

        this.aprenderAtaque(new Ataque("Hachazo", 60, "Fisico",0,70));
        this.aprenderAtaque(new Ataque("Grito de Guerra", 45, "Magico",50,0));

    }



}
