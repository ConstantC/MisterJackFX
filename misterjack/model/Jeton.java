package misterjack.model;

public abstract class Jeton {
    protected String recto;
    protected String verso;
    protected int position;

    public String getRecto(){
        return recto;
    }
    public String getVerso(){
        return verso;
    }
    public int getPosition(){
        return position;
    }
    public void setPosition(int tpPosition){
        this.position = tpPosition;
    }
}
