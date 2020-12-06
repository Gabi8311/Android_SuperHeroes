package personajes;

public class Magia {

    private String nombre;
    private Integer poder;

    public Magia() {

    }

    public Magia(String nombre, Integer poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {

        return "Mágia:\n" + this.nombre + ", Poder:" + this.poder + "\n";
    }
}

