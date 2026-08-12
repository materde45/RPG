package Objetos;

public class Arma {

    private String nombre;
    private double bonoDanoFisico;
    private double bonoDanoMagico;
    private String descripcion;

    public Arma(String nombre, double bonoDanoFisico, double bonoDanoMagico, String descripcion) {
        this.nombre = nombre;
        this.bonoDanoFisico = bonoDanoFisico;
        this.bonoDanoMagico = bonoDanoMagico;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getBonoDanoFisico() {
        return bonoDanoFisico;
    }

    public double getBonoDanoMagico() {
        return bonoDanoMagico;
    }

    public String getDescripcion() {
        return descripcion;
    }
}