package misterjack.model;

public class Action extends Jeton{
    private final boolean available;

    public boolean isAvailable(){
        return available;
    }

    public Action(String tpRecto, String tpVerso, int tpPosition, boolean tpAvailable){
        this.recto = tpRecto;
        this.verso = tpVerso;
        this.position = tpPosition;
        this.available = tpAvailable;
    }
}
