package personajes;

import java.util.ArrayList;
import java.util.Random;

public class Villano extends Personaje {

    private ArrayList<Magia> magias;

    public Villano() {
    }

    public Villano(ArrayList<Magia> magias) {
        this.magias = magias;
    }

    @Override
    public Integer atacar() {

        Random r = new Random();
        Integer ataque;
        Integer golpe = 0;
        Integer indice;

        ataque = r.nextInt(2);
        if (ataque == 0) {
            ataque = r.nextInt(2);
            if (ataque == 0) {
                golpe = this.getFuerza() / 2;
            } else {
                golpe = this.getFuerza() * 2;
            }
            System.out.println("Su ataque provoca un daño de " + golpe);
        } else {
            ataque = r.nextInt(2);
            if (ataque == 1) {
                indice = r.nextInt(this.magias.size());

                switch (indice) {
                    case 0:
                        ataque = r.nextInt(2);
                        if (ataque == 0) {
                            golpe = this.magias.get(0).getPoder() / 2;
                        } else {
                            golpe = this.magias.get(0).getPoder() * 2;
                        }
                        System.out.println("Ataca con " + this.magias.get(0).getNombre() + ",con daño " + golpe);
                        break;

                    case 1:
                        ataque = r.nextInt(2);
                        if (ataque == 0) {
                            golpe = this.magias.get(1).getPoder() / 2;
                        } else {
                            golpe = this.magias.get(1).getPoder() * 2;
                        }
                        System.out.println("Ataca con " + this.magias.get(1).getNombre() + ",con daño " + golpe);
                        break;

                    case 2:
                        ataque = r.nextInt(2);
                        if (ataque == 0) {
                            golpe = this.magias.get(2).getPoder() / 2;
                        } else {
                            golpe = this.magias.get(2).getPoder() * 2;
                        }
                        System.out.println("Ataca con " + this.magias.get(2).getNombre() + ",con daño " + golpe);
                        break;
                }
            }
        }
        return golpe;
    }

    public ArrayList<Magia> getMagias() {
        return magias;
    }

    public void setMagias(ArrayList<Magia> magias) {
        this.magias = magias;
    }

    @Override
    public String toString() {
        return "El Villano:" + super.toString();
    }

}
