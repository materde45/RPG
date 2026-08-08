package Personajes;

public class Ataque {
    private String nombre;
    private double poder;
    private String tipo;
    private double gastoMana;
    private double gastoEnergia;



    public Ataque(String nombre, double poder, String tipo,double gastoMana,double gastoEnergia) {
            this.nombre = nombre;
            this.poder = poder;
            this.tipo = tipo;
            this.gastoMana = gastoMana;
            this.gastoEnergia = gastoEnergia;
    }

    public String getNombre() {
        return nombre; }
    public double getPoder() {
        return poder; }
    public String getTipo() {
        return tipo; }
    public double getGastoMana() {
        return gastoMana;
    }
    public double getGastoEnergia() {
        return gastoEnergia;
    }
}
