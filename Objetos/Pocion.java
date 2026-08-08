package Objetos;

import Personajes.BaseDePersonaje;

public class Pocion {
    private String nombre;
    private int id;
    private double cura;
    private double regMana;
    private double regEnergia;
    private double debilidad;
    private double veneno;
    private double antidoto;

    public Pocion(int id, String nombre, double cura, double regEnergia, double regMana, double veneno, double antidoto, double debilidad){

        this.id = id;
        this.nombre = nombre;
        this.antidoto = antidoto;
        this.cura = cura;
        this.regEnergia = regEnergia;
        this.regMana = regMana;
        this.veneno = veneno;
        this.debilidad = debilidad;

    }

    public void aplicarEfecto(BaseDePersonaje consumidor) {
        System.out.println("\n ¡" + consumidor.getNombre() + " consume " + this.nombre + "!");

        if (this.cura > 0) {
            consumidor.recuperarVida(this.cura);
        }
        if (this.regMana > 0) {
            consumidor.recuperarMana(this.regMana);
        }
        if (this.regEnergia > 0) {
            consumidor.recuperarEnergia(this.regEnergia);
        }
        if (this.veneno > 0) {
            System.out.println("¡La poción estaba envenenada!");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public double getCura() {
        return cura;
    }

    public double getRegMana() {
        return regMana;
    }

    public double getRegEnergia() {
        return regEnergia;
    }

    public double getDebilidad() {
        return debilidad;
    }

    public double getVeneno() {
        return veneno;
    }

    public double getAntidoto() {
        return antidoto;
    }
}
