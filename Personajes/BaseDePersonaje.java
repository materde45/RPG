package Personajes;

import Objetos.Pocion;
import java.util.ArrayList;
import java.util.List;

public class BaseDePersonaje {

    private String nombre;
    private double vida = 0;
    private double damageMagic = 0;
    private double damageFisic = 0;
    private double defFisica = 0;
    private double defMagic = 0;
    private double mana;
    private double energia;
    private double vidaMax;
    private double manaMax;
    private double energiaMax;
    private List<Ataque> listaAtaques;
    private List<Pocion> inventario;


    public BaseDePersonaje(String nombre, double vida, double defMagic, double defFisica, double damageMagic, double damageFisic,double mana, double energia) {
        this.nombre = nombre;
        this.vida = vida;
        this.defMagic = defMagic;
        this.defFisica = defFisica;
        this.damageMagic = damageMagic;
        this.damageFisic = damageFisic;
        this.mana = mana;
        this.energia = energia;
        this.vidaMax = vida;
        this.manaMax = mana;
        this.energiaMax = energia;

        this.listaAtaques = new ArrayList<>();
        this.inventario = new ArrayList<>();

    }

    public void aprenderAtaque(Ataque nuevoAtaque) {
        this.listaAtaques.add(nuevoAtaque);
    }


    public void recibirDamageMagic(double danoEntrante){

        double danoReal = danoEntrante - this.defMagic;

        if (danoReal > 0) {
            this.vida -= danoReal;
            System.out.println(this.nombre + " ha recibido " + danoReal + " de daño mágico. Vida restante: " + this.vida);
        } else {
            System.out.println("¡El ataque mágico no logró perforar la defensa de " + this.nombre + "!");
        }

    }

    public void recibirDamgeFisico(double danoEntrante){

        double danoReal = danoEntrante - this.defFisica;

        if (danoReal > 0) {
            this.vida -= danoReal;
            System.out.println(this.nombre + " ha recibido " + danoReal + " de daño fisico. Vida restante: " + this.vida);
        } else {
            System.out.println("¡El golpe no logró perforar la defensa de " + this.nombre + "!");
        }

    }


    public void usarAtaque(int indiceAtaque, BaseDePersonaje objetivo) {

        Ataque ataqueElegido = this.listaAtaques.get(indiceAtaque);
        System.out.println("\n ¡" + this.nombre + " usa " + ataqueElegido.getNombre() + "!");
        if(this.mana >= ataqueElegido.getGastoMana() && this.energia >= ataqueElegido.getGastoEnergia()) {

            this.mana -= ataqueElegido.getGastoMana();
            this.energia -= ataqueElegido.getGastoEnergia();


            if (ataqueElegido.getTipo().equals("Magico")) {

                double danoTotal = this.damageMagic + ataqueElegido.getPoder();
                objetivo.recibirDamageMagic(danoTotal);

            } else if (ataqueElegido.getTipo().equals("Fisico")) {

                double danoTotal = this.damageFisic + ataqueElegido.getPoder();
                objetivo.recibirDamgeFisico(danoTotal);
            }
        } else if (this.mana < ataqueElegido.getGastoMana()) {

            System.out.println(this.nombre + " fallo al hacer su ataque, no le queda Maná");

        } else if (this.energia < ataqueElegido.getGastoEnergia()) {

            System.out.println(this.nombre + " fallo su ataque, se ha quedado sin energia");

        }
    }

    public void recogerPocion(Pocion nuevaPocion) {
        this.inventario.add(nuevaPocion);
        System.out.println(this.nombre + " ha guardado " + nuevaPocion.getNombre() + " en su mochila.");
    }

    public void recuperarVida(double cantidad) {
        this.vida += cantidad;
        if (this.vida > this.vidaMax) this.vida = this.vidaMax;
        System.out.println(this.nombre + " recupera vida. Actual: " + this.vida + "/" + this.vidaMax);
    }

    public void recuperarMana(double cantidad) {
        this.mana += cantidad;
        if (this.mana > this.manaMax) this.mana = this.manaMax;
        System.out.println(this.nombre + " recupera Maná. Actual: " + this.mana + "/" + this.manaMax);
    }

    public void recuperarEnergia(double cantidad) {
        this.energia += cantidad;
        if (this.energia > this.energiaMax) this.energia = this.energiaMax;
        System.out.println(this.nombre + " recupera Energía. Actual: " + this.energia + "/" + this.energiaMax);
    }

    public void usarPocion(int indicePocion) {
        if (indicePocion >= 0 && indicePocion < this.inventario.size()) {

            Pocion pocionElegida = this.inventario.get(indicePocion);

            pocionElegida.aplicarEfecto(this);

            this.inventario.remove(indicePocion);

        } else {
            System.out.println("No tienes ninguna poción en ese bolsillo.");
        }
    }

    public String getNombre(){return nombre;}
    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getDamageMagic() {
        return damageMagic;
    }

    public void setDamageMagic(double damageMagic) {
        this.damageMagic = damageMagic;
    }

    public double getDamageFisic() {
        return damageFisic;
    }

    public void setDamageFisic(double damageFisic) {
        this.damageFisic = damageFisic;
    }

    public double getDefFisica() {
        return defFisica;
    }

    public void setDefFisica(double defFisica) {
        this.defFisica = defFisica;
    }

    public double getDefMagic() {
        return defMagic;
    }

    public void setDefMagic(double defMagic) {
        this.defMagic = defMagic;
    }

    public List<Ataque> getListaAtaques() {
        return listaAtaques;
    }
}
