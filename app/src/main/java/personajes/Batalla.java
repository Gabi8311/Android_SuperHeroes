package personajes;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Batalla implements Runnable {

    private ArrayList<SuperHeroe> equipo = new ArrayList<>(4);
    private Villano enemigo;
    private TextView tV;

    public Batalla(Villano enemigo, TextView tV_enemigo, ArrayList<SuperHeroe> equipo) {

        this.enemigo = enemigo;
        this.tV = tV_enemigo;
        this.equipo = equipo;

    }

    public void run() {
        Random r = new Random();

        Integer personaje;

        Integer azar;

        Integer daño;

        tV.append("\nEmpieza la batalla!!");
        tV.append("\n********************");

        tiempo(2);

        do {

            personaje = r.nextInt(this.equipo.size());

            tV.append("\n" + this.equipo.get(personaje) + " VS " + enemigo.getNombre());

            daño = this.equipo.get(personaje).atacar(tV);

            enemigo.setVida(enemigo.getVida() - daño);

            tiempo(2);

            tV.append("\nSu ataque provoca un daño de " + daño);

            tiempo(1);

            if (enemigo.getVida() < 0) {

                enemigo.setVida(0);
            }

            tV.append("\nVida de " + enemigo.getNombre() + ":" + enemigo.getVida());

            tiempo(2);

            tV.append("\n");

            if (enemigo.getVida() <= 0) {

                break;

            } else {
                azar = r.nextInt(equipo.size());

                tV.append("\n" + enemigo + " VS " + this.equipo.get(azar).getNombre());

                daño = enemigo.atacar(tV);

                equipo.get(azar).setVida(this.equipo.get(azar).getVida() - daño);

                tiempo(2);

                if (this.equipo.get(azar).getVida() < 0) {
                    this.equipo.get(azar).setVida(0);
                }
                tV.append("\nVida de " + this.equipo.get(azar).getNombre() + ":" + this.equipo.get(azar).getVida());

                tV.append("\n");
                tiempo(1);
                if (this.equipo.get(azar).getVida() <= 0) {

                    tV.append("\n" + this.equipo.get(azar).getNombre() + " ha muerto!!");
                    tV.append("\n");

                    this.equipo.remove(equipo.get(azar));
                }
            }
        } while (enemigo.getVida() > 0 && this.equipo.size() > 0);

        if (this.equipo.size() == 0) {
            tV.append("\n" + enemigo.getNombre() + " ha ganado la batalla!!");
        } else {
            tV.append("\nLos Vengadores & Liga de la Justicia, han ganado la batalla!!");
        }


    }

    public void pelea() {

    Thread hilo2 = new Thread(this);
    hilo2.start();

    }

    public static void tiempo(int segundos) {

        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception Error) {

        }
    }

    public ArrayList<SuperHeroe> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<SuperHeroe> equipo) {
        this.equipo = equipo;
    }
}
