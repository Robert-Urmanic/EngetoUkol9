package cz.vsb.ekf.urm0009;

public class Main {

    public static void main(String[] args) {
        Fork[] fork = new Fork[10];
        for (int i = 0; i < 10; i++) {
            fork[i] = new Fork(i);
        }

        Philosopher[] philosopher = new Philosopher[10];
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                philosopher[9] = new Philosopher(i, fork[0], fork[i]);
            } else {
                philosopher[i] = new Philosopher(i, fork[i], fork[i + 1]);
            }
        }


        philosopher[0].start();
        philosopher[1].start();
        philosopher[2].start();
        philosopher[3].start();
        philosopher[4].start();
        philosopher[5].start();
        philosopher[6].start();
        philosopher[7].start();
        philosopher[8].start();
        philosopher[9].start();


    }
}
