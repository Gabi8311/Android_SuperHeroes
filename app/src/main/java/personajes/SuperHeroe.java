package personajes;

import java.util.Random;

public class SuperHeroe extends Personaje{

    public SuperHeroe() {
    }

    public SuperHeroe(String nombre, int fuerza, int vida) {
        super(nombre, fuerza, vida);
    }

    @Override
    public Integer atacar() {

        Random r = new Random();
        Integer ataque;
        Integer golpe = 0;

        ataque = r.nextInt(2);
        if (ataque == 0) {
            golpe = this.getFuerza() / 2;
        } else {
            golpe = this.getFuerza() * 2;
        }
        return golpe;
    }

    @Override
    public String toString() {
        return "El Super Héroe:" + super.toString() + " ataca Físicamente";
    }
}
