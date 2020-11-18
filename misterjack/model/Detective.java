package misterjack.model;

public class Detective {
    private final String name;
    private int position;

    public Detective(String tpName, int tpPosition){
        this.name = tpName;
        this.position = tpPosition;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
