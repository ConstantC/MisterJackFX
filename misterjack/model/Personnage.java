package misterjack.model;

public class Personnage {
    private final String color;
    private final Temp hourglasses;

    public Personnage(String tpColor, Temp tpHourglasses){
        this.color = tpColor;
        this.hourglasses = tpHourglasses;
    }

    public String getColor() {
        return color;
    }

    public Temp getHourglasses() {
        return hourglasses;
    }
}
