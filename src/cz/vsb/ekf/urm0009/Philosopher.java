package cz.vsb.ekf.urm0009;

class Philosopher extends Thread {
    private String name;
    private int id;
    private int numberOfEats = 0;
    private Fork rightFork;
    private Fork leftFork;
    private boolean hasRightFork = false;
    private boolean hasLeftFork = false;



    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public boolean isHasRightFork() {
        return hasRightFork;
    }

    public void setHasRightFork(boolean hasRightFork) {
        this.hasRightFork = hasRightFork;
    }

    public boolean isHasLeftFork() {
        return hasLeftFork;
    }

    public void setHasLeftFork(boolean hasLeftFork) {
        this.hasLeftFork = hasLeftFork;
    }

    @Override
    public void run() {
        while(numberOfEats < 10000){

            System.out.println("I sleep " + getName());
            if (leftFork.getFree()) {
                grabLeftFork(leftFork);
                this.setHasLeftFork(true);
                System.out.println("Grab left: " + leftFork.getId() + " " + getName());
            }

            if (rightFork.getFree()) {
                grabRightFork(leftFork);
                this.setHasRightFork(true);
                System.out.println("Grab right: " + rightFork.getId() + " " + getName());
            }

            if (isHasLeftFork() && isHasRightFork()) {
                eat();
                releaseFork(rightFork, leftFork);
            }


            if (numberOfEats==10000){
                Counter.counter++;
                System.out.println("Total times eaten: " + Counter.counter);
            }

        }
    }

    public void grabLeftFork(Fork fork) {
        fork.isNotFree();
    }

    public void grabRightFork(Fork fork) {
        fork.isNotFree();
    }

    public void eat() {
        numberOfEats++;
        System.out.println("I, " + getName() + ", have eaten " + numberOfEats + " times.");
    }

    public void releaseFork(Fork fork1, Fork fork2) {
        fork1.isFree();
        fork2.isFree();
        this.setHasRightFork(false);
        this.setHasLeftFork(false);
        System.out.println("Pouštím vidličku: " + fork1.getId() + " " + getName());
        System.out.println("Pouštím vidličku: " + fork2.getId() + " " + getName());
    }


}
