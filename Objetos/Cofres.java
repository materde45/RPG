package Objetos;

import Personajes.BaseDePersonaje;
import java.util.ArrayList;
import java.util.List;

public class Cofres {

    private String color;
    private List<Pocion> contenido;

    // Ya no pedimos el color aquí. El cofre se genera solo.
    public Cofres() {
        this.contenido = new ArrayList<>();
        generarCofreAleatorio();
    }

    private void generarCofreAleatorio() {
        double probabilidad = Math.random();

        if (probabilidad < 0.50) {
            // 50% de probabilidad (Cofre Común)
            this.color = "Madera";
            contenidoCofreMadera();

        } else if (probabilidad < 0.85) {
            // 35% de probabilidad (Cofre Raro)
            this.color = "Plata";
            contenidoCofrePlata();

        } else {
            // 15% de probabilidad (Cofre Épico)
            this.color = "Oro";
            contenidoCofreOro();
        }
    }

    public void contenidoCofreMadera(){
        double probabilidad = Math.random();
        if (probabilidad < 0.20) {
            this.contenido.add(new Pocion(3, "Antídoto", 0, 0, 0, false, true, 0));
        } else if (probabilidad < 0.50){ // Ajustado para que fluya la probabilidad
            this.contenido.add(new Pocion(2, "Agua Refrescante", 0, 20, 20, false, false, 0));
        } else {
            this.contenido.add(new Pocion(1, "Poción Menor de Vida", 30, 0, 0, false, false, 0));
        }
    }

    public void contenidoCofrePlata(){
        double probabilidad = Math.random();
        if (probabilidad < 0.40) {
            this.contenido.add(new Pocion(4, "Elixir de Maná", 0, 0, 50, false, false, 0));
        } else if (probabilidad < 0.70) { // CORRECCIÓN: Estaba en 0.30, lo que bloqueaba este premio
            this.contenido.add(new Pocion(5, "Poción Mediana de Vida", 75, 0, 0, false, false, 0));
        } else {
            this.contenido.add(new Pocion(5, "Bebida Energética", 0, 60, 0, false, false, 0));
        }
    }

    public void contenidoCofreOro(){
        double probabilidad = Math.random();

        this.contenido.add(new Pocion(5, "Poción Mayor de Vida", 150, 0, 0, false, false, 0));
        this.contenido.add(new Pocion(6, "Brebaje del Campeón", 0, 100, 100, false, false, 0));

        // 20% de probabilidad de trampa
        if (probabilidad > 0.80) {
            // CORRECCIÓN: Se cambió a 'true' en el parámetro de veneno
            this.contenido.add(new Pocion(7, "Poción Sospechosa", 0, 0, 0, true, false, 0));
        }
    }

    public void saquearCofre(BaseDePersonaje jugador) {
        System.out.println("\n📦 ¡Has encontrado un Cofre de " + this.color + "!");

        if (this.contenido.isEmpty()) {
            System.out.println("El cofre solo tiene polvo... Está vacío.");
        } else {
            for (int i = 0; i < this.contenido.size(); i++) {
                Pocion botin = this.contenido.get(i);
                jugador.recogerPocion(botin);
            }
            this.contenido.clear();
        }
    }
}