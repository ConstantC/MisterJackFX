package misterjack.model;

public class Quartier {
    private String name;
    private int rotation;

    public Quartier(String tpName, int tpRotation){
        this.name = tpName;
        this.rotation = tpRotation;
    }

    public String getName(){
        return name;
    }

    public int getRotation() {
        return rotation;
    }
}
