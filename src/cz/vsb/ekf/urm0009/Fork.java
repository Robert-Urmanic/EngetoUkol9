package cz.vsb.ekf.urm0009;

class Fork {
    private int id;
    private boolean isItFree = true;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getFree() {
        return isItFree;
    }

    public void setItFree(boolean itFree) {
        isItFree = itFree;
    }

    public void isNotFree(){
        isItFree = false;
    }

    public void isFree(){
        isItFree = true;
    }
}