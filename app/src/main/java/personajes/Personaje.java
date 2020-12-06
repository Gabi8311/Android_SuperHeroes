package personajes;

public abstract class Personaje {
    private String nombre;
    private int fuerza;
    private int vida;

    public Personaje() {
    }

    public Personaje(String nombre, int fuerza, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vida = vida;
    }

    public abstract Integer atacar();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Nombre:" + this.nombre + " con Fuerza:" + this.fuerza + " y Vida:" + this.vida ;
    }
}
