package misterjack.model;

public class Temp extends Jeton {
    private final int hourglass;

    public int getHourglass() {
        return hourglass;
    }

    public Temp(String tpRecto, String tpVerso, int tpPosition, int tpHourglass){
        this.recto = tpRecto;
        this.verso = tpVerso;
        this.position = tpPosition;
        this.hourglass = tpHourglass;
    }
}
